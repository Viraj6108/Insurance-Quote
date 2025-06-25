package com.quote.dto;

import com.quote.entity.Quote;
import java.time.LocalDate;
import java.util.UUID;

public class QuoteAccepted {


    private UUID quoteId;
    private UUID userId;
    private double sumInsured;
    private double premiumAmount;
    public  enum QUOTE_STATUS{
        PENDING, ACCEPTED, REJECTED
    }
    private Quote.QUOTE_STATUS quoteStatus;
    private String model;
    private LocalDate purchaseDate;
    private String registrationNumber;
    private double showroomPrice;
    private int engineCapacity;
    private String coverageType;
    private String manufacturer;
    private int yearOfManufacture;
    private String chassisNumber;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getShowroomPrice() {
        return showroomPrice;
    }

    public void setShowroomPrice(double showroomPrice) {
        this.showroomPrice = showroomPrice;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }
}
