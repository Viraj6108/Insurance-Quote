package com.quote.mapper;

import com.quote.dto.QuoteAccepted;
import com.quote.entity.Quote;

public class Mapper {

    public QuoteAccepted toDTO(Quote quote)
    {
        QuoteAccepted quoteAccepted = new QuoteAccepted();
        quoteAccepted.setQuoteId(quote.getQuoteId());
        quoteAccepted.setUserId(quote.getUserId());
        quoteAccepted.setSumInsured(quote.getSumInsured());
        quoteAccepted.setPremiumAmount(quote.getPremiumAmount());
        quoteAccepted.setQuoteStatus(quote.getQuoteStatus());
        quoteAccepted.setPurchaseDate(quote.getVehicleDetails().getPurchaseDate());
        quoteAccepted.setRegistrationNumber(quote.getVehicleDetails().getRegistrationNumber());
        quoteAccepted.setShowroomPrice(quote.getVehicleDetails().getShowroomPrice());
        quoteAccepted.setModel(quote.getVehicleDetails().getModel());
        quoteAccepted.setEngineCapacity(quote.getVehicleDetails().getEngineCapacity());
        quoteAccepted.setCoverageType(quote.getCoverageType());
        quoteAccepted.setChassisNumber(quote.getVehicleDetails().getChassisNumber());
        quoteAccepted.setManufacturer(quote.getVehicleDetails().getManufacturer());
        quoteAccepted.setYearOfManufacture(quote.getVehicleDetails().getYearOfManufacture());

        return quoteAccepted;
    }
}
