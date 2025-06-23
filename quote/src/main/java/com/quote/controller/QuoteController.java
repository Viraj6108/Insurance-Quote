package com.quote.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quote.dto.QuoteDTO;
import com.quote.entity.Quote;
import com.quote.exception.QuoteException;
import com.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @PostMapping("/create")
    public Quote createQuote(@RequestBody QuoteDTO quote) throws QuoteException, JsonProcessingException {
       return quoteService.createQuote(quote);
    }

    @PutMapping("/accept")
    public String AcceptQuote(@RequestParam("quoteId")UUID quoteId)throws QuoteException, JsonProcessingException
    {
        quoteService.acceptQuote(quoteId);
        return "Quote Accepted policy will be crated and saved ";
    }
}
