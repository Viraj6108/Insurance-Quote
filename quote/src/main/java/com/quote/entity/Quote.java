package com.quote.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID quoteId;
    private UUID userId;
    private double sumInsured;
    private double premiumAmount;
    private LocalDateTime createdAt;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_details")
    private VehicleDetails vehicleDetails;
    public  enum QUOTE_STATUS{
        PENDING, ACCEPTED, REJECTED
    }
    private QUOTE_STATUS quoteStatus;
    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    private String coverageType;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public QUOTE_STATUS getQuoteStatus() {
        return quoteStatus;
    }

    public void setQuoteStatus(QUOTE_STATUS quoteStatus) {
        this.quoteStatus = quoteStatus;
    }
}
