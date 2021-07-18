package com.vimit.interview.paypay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;

public class ChangeCurrency {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = line.split(";");
            double price = Double.parseDouble(strs[0]);
            double change = Double.parseDouble(strs[1]);
            if(price>change) System.out.println("ERROR");
            else if(price == change) System.out.println("ZERO");
            else{
                List<Currency> currencies = getCurrencies();
                List<String> changes = new ArrayList<>();
                int index = 0;
                double difference = getDifference(change, price);
                while(difference>0 && index<currencies.size()){
                    Currency currentCurrency = currencies.get(index);
                    if(currentCurrency.price>difference){
                        index++;
                    }else{
                        changes.add(currentCurrency.name);
                        difference = getDifference(difference, currentCurrency.price);
                    }
                }
                if(difference>0){
                    System.out.println("ZERO");
                } else{
                    String changeCurrencies = String.join(",", changes);
                    System.out.println(changeCurrencies);
                }
            }


        }
    }

    public static double getDifference(double first, double second){
        return Double.valueOf(decimalFormat.format(first - second));
    }
    public static List<Currency> getCurrencies(){
        List<Currency> currencies = Arrays.asList(new Currency(100.00, "ONE HUNDRED"),
                new Currency(50.00, "FIFTY"),
                new Currency(20.00, "TWENTY"),
                new Currency(10.00, "TEN"),
                new Currency(5.00, "FIVE"),
                new Currency(2.00, "TWO"),
                new Currency(1.00, "ONE"),
                new Currency(.50, "HALF DOLLAR"),
                new Currency(.25, "QUARTER"),
                new Currency(.10, "DIME"),
                new Currency(.05, "NICKEL"),
                new Currency(.01, "PENNY")
        );
        return currencies;
    }
}

class Currency{
    Double price;
    String name;
    Currency(Double price, String name){
        this.price = price;
        this.name = name;
    }
}
