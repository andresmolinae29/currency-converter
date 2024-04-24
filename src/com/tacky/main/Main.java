package com.tacky.main;

import com.tacky.apicurrency.Client;
import com.tacky.models.Currencies;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Currencies currencies = new Currencies();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    *****************************
                    Welcome to the exchange rate
                   \s
                    1) Dollar - Argentine peso
                    2) Argentine peso - Dollar
                    3) Dollar - Brazilian real
                    4) Brazilian real - Dollar
                    5) Dollar - Colombian peso
                    6) Colombian peso - Dollar
                    7) Dollar - Canadian Dollar
                    8) Canadian Dollar - Dollar
                    99) Show the 5 last exchanges\s
                    0) Quit
                    Chose a valid option:
                    *****************************
                   \s""");

            int option;
            double amount = 0;

            try {
            option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!");
                continue;
            }

            if (option == 0) {
                System.out.println("Thank you!");
                break;
            } else if (option < 0 || option > 8 && option != 99) {
                System.out.println("Please enter a valid option!");
                continue;
            }

            Scanner scannerAmount = new Scanner(System.in);

            if (option != 99) {
                System.out.println("Enter the amount to exchange: ");
                try {
                    amount = scannerAmount.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number");
                    continue;
                }
            }

            Client client;

            switch (option) {
                case 1:
                    client = new Client("USD", "ARS", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 2:
                    client = new Client("ARS", "USD", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 3:
                    client = new Client("USD", "BRL", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 4:
                    client = new Client("BRL", "USD", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 5:
                    client = new Client("USD", "COP", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 6:
                    client = new Client("COP", "USD", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 7:
                    client = new Client("USD", "CAD", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 8:
                    client = new Client("CAD", "USD", amount);
                    currencies.addCurrencyByClient(client, amount);
                    break;
                case 99:
                    currencies.printLastFive();
                    break;
            }
        }
        currencies.createLogFile();
    }
}
