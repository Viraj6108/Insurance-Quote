package com.quote.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.quote.dto.QuoteAccepted;
import com.quote.dto.QuoteDTO;
import com.quote.entity.Quote;
import com.quote.exception.QuoteException;
import com.quote.mapper.Mapper;
import com.quote.repository.QuoteRepository;
import com.quote.service.QuoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.UUID;

@Service
public class QuoteServiceImpl implements QuoteService {
    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private KafkaTemplate kafkaTemplate;
    ModelMapper modelMapper = new ModelMapper();
    Gson gson = new Gson();
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Quote createQuote(QuoteDTO quote) throws QuoteException, JsonProcessingException {
    Quote newQuote = modelMapper.map(quote, Quote.class);
    newQuote.setCreatedAt(LocalDateTime.now());
    newQuote.setSumInsured(calculateSumInsured(quote.getVehicleDetails().getShowroomPrice(),quote.getVehicleDetails().getPurchaseDate()));
    newQuote.setPremiumAmount(calculatePremium(quote.getSumInsured(),quote.getVehicleDetails().getEngineCapacity(),quote.getCoverageType()));
    objectMapper.registerModule(new JavaTimeModule());
    newQuote.setQuoteStatus(Quote.QUOTE_STATUS.PENDING);
        return quoteRepository.save(newQuote);
    }

    Mapper mapper = new Mapper();
    @Override
    public String acceptQuote(UUID quoteId) throws QuoteException, JsonProcessingException {
        Quote existingQuote = quoteRepository.findById(quoteId).
                orElseThrow(()-> new QuoteException("Quote does not exist.Create new quote"));
        if(existingQuote.getQuoteStatus().equals(Quote.QUOTE_STATUS.ACCEPTED)){
            throw new QuoteException("Quote already accepted");
        }
        existingQuote.setQuoteStatus(Quote.QUOTE_STATUS.ACCEPTED);
        quoteRepository.save(existingQuote);
        objectMapper.disable(MapperFeature.REQUIRE_HANDLERS_FOR_JAVA8_TIMES);
        //TYpe map for dto
        QuoteAccepted quoteAccepted = mapper.toDTO(existingQuote);
        String quote = objectMapper.writeValueAsString(quoteAccepted);
        kafkaTemplate.send("quote-accepted",quote);
        return "ACCEPTED";
    }

    
    public Integer calculateSumInsured(double showroomPrice, LocalDate purchaseYear)
    {
        double depreciation = CalculateDepreciation(purchaseYear);
        double sumInsured = showroomPrice * (1 - depreciation);
        return (int) sumInsured; // Rounded to nearest integer
    }
    
    
    
    //Calculate premium and return the premium
    public double calculatePremium(double sumInsured,int engineCapacity,String coverageType)
    {
        if(coverageType.equals("OPP"))
        {
            return sumInsured * 0.02;
        }else if (coverageType.equals("TPP"))
        {
            if(engineCapacity <= 75)
                    return 538.0;
            else if(engineCapacity <= 150)
                return 714;
            else if(engineCapacity <= 350)
                return 1366;
            else if(engineCapacity >=350)
                return 2804;

        }
        return 0;
    }

    public double CalculateDepreciation(LocalDate purchaseYear)
    {

        int years = Period.between(purchaseYear, LocalDate.now()).getYears();

        if (years < 1) return 0.05;
        else if (years < 2) return 0.20;
        else if (years < 3) return 0.30;
        else if (years < 4) return 0.40;
        else if (years < 5) return 0.50;
        else return 0.60; // Negotiable or max depreciation

    }
}
