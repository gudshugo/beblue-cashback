package br.com.project.rest.cashback.utils;

public class UtilMethods {

    public static double randomPriceGenerator() {
        double min = 20.0;
        double max = 50.0;
        double range = max - min;
        return min + Math.random() * range;
    }
}
