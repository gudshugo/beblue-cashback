package br.com.project.rest.cashback.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class UtilMethods {

    public static double randomPriceGenerator() {
        double min = 20.0;
        double max = 50.0;
        double range = max - min;
        return min + Math.random() * range;
    }

    public static LocalDate toLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
