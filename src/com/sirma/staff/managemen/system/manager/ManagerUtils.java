package com.sirma.staff.managemen.system.manager;

import com.sirma.staff.managemen.system.services.DateParser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ManagerUtils {

    public static double readDoubleFromConsole(Scanner scanner, String label) {
        System.out.println("Enter employee " + label + ": ");
        try {
            double value = Double.parseDouble(scanner.nextLine());
            return value;
        } catch (NumberFormatException nfe) {
            return readDoubleFromConsole(scanner, label);
        }
    }

    public static LocalDate readLocalDate(Scanner scanner, String datePattern, String label) {

        while (true) {
            try {
                System.out.println("Enter " + label + " in the format " + datePattern + ": ");
                LocalDate startDate = DateParser.parseLocalDate(scanner.nextLine());
                return startDate;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Date format should be dd/MM/yyyy");
            }
        }
    }

}
