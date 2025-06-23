package com.quote.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quote.dto.QuoteDTO;
import com.quote.entity.Quote;
import com.quote.exception.QuoteException;

import java.util.UUID;

public interface QuoteService {

    public Quote createQuote(QuoteDTO quote) throws QuoteException, JsonProcessingException;
    public String acceptQuote(UUID quoteId) throws QuoteException, JsonProcessingException;
}
