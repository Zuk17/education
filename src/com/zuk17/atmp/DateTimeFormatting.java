package com.zuk17.atmp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateTimeFormatting {
    private static final String DESIRED_FORMAT = "MM/dd/yyyy"; // avoid magic string warnings

    public static void main(String[] args) {
        // use try-catch incase wrong invalid date gets passed in
        try (Scanner scanner = new Scanner(System.in)) { // use try with resources to autoclose Scanner object
            LocalDate date = LocalDate.parse(scanner.nextLine()); // parse the date if valid
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DESIRED_FORMAT); // describe desired pattern
            System.out.println(date.format(formatter)); // format the parsed date using pre-set format
        } catch (DateTimeParseException e) { // extends RunTimeException for failure to parse date
            System.out.println("Invalid date format.");
        }
    }
}
