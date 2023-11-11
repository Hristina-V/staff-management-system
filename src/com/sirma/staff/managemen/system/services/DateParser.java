package com.sirma.staff.managemen.system.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

    public static final String DATE_FORMAT_STRING = "dd/MM/yyyy";

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, formatter);
    }

    public static String formatLocalDateAsString(LocalDate date) {
        return date.format(formatter);
    }
}
