package com.tacky.apicurrency;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    private String baseCode;
    private String targetCode;
    private double amount;
    private String url;

    public Client(String baseCode, String targetCode, double amount) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
    }

    public void createUrl() {
        this.url = "https://v6.exchangerate-api.com/v6/c69cd4df23d6fd25119d9c1f/pair/"+this.baseCode+"/"+this.targetCode+"/"+this.amount;
    }

    public String getUrl() {
        return url;
    }

    public HttpResponse<String> getResponse() throws IOException, InterruptedException {
        this.createUrl();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.getUrl()))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
