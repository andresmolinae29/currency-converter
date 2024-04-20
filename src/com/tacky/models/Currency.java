package com.tacky.models;

public class Currency {

    String baseCode;
    String targetCode;
    Double amount;
    Double convertedAmount;
    Double rate;

    public Currency(String baseCode, String targetCode, Double amount, Double convertedAmount, Double rate) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
        this.rate = rate;
    }

    public Currency(CurrencyOmdb tempCurrency, double amount) {
        this.baseCode = tempCurrency.base_code();
        this.targetCode = tempCurrency.target_code();
        this.amount = amount;
        this.convertedAmount = tempCurrency.conversion_result();
        this.rate = tempCurrency.conversion_rate();
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "The value " + this.getAmount() + " [" + this.getBaseCode() + "] is equal to: " + this.getConvertedAmount() + " [" + this.getTargetCode() + "]\n";
    }
}
