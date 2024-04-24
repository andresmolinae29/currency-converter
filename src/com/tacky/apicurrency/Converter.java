package com.tacky.apicurrency;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.tacky.models.Currency;
import com.tacky.models.CurrencyOmdb;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.http.HttpResponse;

public class Converter {

    Currency currency;
    Gson gson;

    public Currency getCurrency() {
        return currency;
    }

    public Gson getGson() {
        return gson;
    }

    private void setGson() {
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();;
    }

    public Converter(HttpResponse<String> response, double amount) {
        this.setGson();
        gson = this.getGson();
        CurrencyOmdb tempCurrency = gson.fromJson(response.body(), CurrencyOmdb.class);
        this.currency = new Currency(tempCurrency, amount);
    }
}
