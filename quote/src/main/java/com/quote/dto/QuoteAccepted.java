package com.quote.dto;

import com.quote.entity.Quote;
import java.time.LocalDate;
import java.util.UUID;

public class QuoteAccepted {


    private UUID quoteId;
    private UUID userId;
    private double sumInsured;
    private double premiumAmount;
    private VehicleDetailsDTO vehicleDetailsDTO;
    public  enum QUOTE_STATUS{
        PENDING, ACCEPTED, REJECTED
    }
    private Quote.QUOTE_STATUS quoteStatus;

    public UUID getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(UUID quoteId) {
        this.quoteId = quoteId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
    public Quote.QUOTE_STATUS getQuoteStatus() {
        return quoteStatus;
    }

    public void setQuoteStatus(Quote.QUOTE_STATUS quoteStatus) {
        this.quoteStatus = quoteStatus;
    }

    public VehicleDetailsDTO getVehicleDetailsDTO() {
        return vehicleDetailsDTO;
    }

    public void setVehicleDetailsDTO(VehicleDetailsDTO vehicleDetailsDTO) {
        this.vehicleDetailsDTO = vehicleDetailsDTO;
    }
}
