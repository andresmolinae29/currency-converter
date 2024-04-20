package com.tacky.main;

import com.tacky.apicurrency.Client;
import com.tacky.apicurrency.Converter;
import com.tacky.models.Currency;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    *****************************
                    Welcome to the exchange rate
                    
                    1) Dollar - Argentine peso
                    2) Argentine peso - Dollar
                    3) Dollar - Brazilian real
                    4) Brazilian real - Dollar
                    5) Dollar - Colombian peso
                    6) Colombian peso - Dollar
                    7) Dollar - Canadian Dollar
                    8) Canadian Dollar - Dollar
                    0) Quit
                    Chose a valid option:
                    *****************************
                    """);

            int option;
            double amount;

            try {
            option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!");
                continue;
            }

            if (option == 0) {
                System.out.println("Thank you!");
                break;
            } else if (option < 0 || option > 8) {
                System.out.println("Please enter a valid option!");
                continue;
            }

            Scanner scannerAmount = new Scanner(System.in);

            System.out.println("Enter the amount to exchange: ");

            try {
                amount = scannerAmount.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                continue;
            }

            switch (option) {
                case 1:
                    Client client = new Client("USD", "ARS", amount);
                    Converter converter = new Converter(client.getResponse(), amount);
                    Currency currency = converter.getCurrency();
                    System.out.println(currency);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 5:
                    System.out.println(5);
                    break;
                case 6:
                    System.out.println(6);
                    break;
                case 7:
                    System.out.println(7);
                    break;
                case 8:
                    System.out.println(8);
                    break;
            }

        }

    }
}
