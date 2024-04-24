package com.tacky.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tacky.apicurrency.Client;
import com.tacky.apicurrency.Converter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Currencies {
    List<Currency> currencies = new ArrayList<>();

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void addCurrencyByClient(Client client, double amount) throws IOException, InterruptedException {
        Converter converter = new Converter(client.getResponse(), amount);
        Currency currency = converter.getCurrency();
        System.out.println(currency);
        this.getCurrencies().add(currency);
    }

    public void printLastFive() {
        List<Currency> sub = this.getCurrencies().subList(Math.max(this.getCurrencies().size() - 5, 0), this.getCurrencies().size());

        for (Currency currency : sub) {
            System.out.println(currency);
        }
    }

    public void createLogFile() throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        FileWriter fileWriter = new FileWriter(timestamp+"-log-file.json");
        fileWriter.write(gson.toJson(currencies));
        fileWriter.close();
    }
}
