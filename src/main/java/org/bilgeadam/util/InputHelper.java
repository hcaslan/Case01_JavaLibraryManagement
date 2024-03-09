package org.bilgeadam.util;

import org.bilgeadam.constant.OutputMessage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static Scanner sc = new Scanner(System.in);

    public static String getStringInput(String message) {
        System.out.println(message);
        return sc.nextLine();
    }

    public static int getIntegerInput(String message) {
        System.out.println(message);
        int input;
        while (true) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                sc.nextLine();
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_INTEGER.getMessage());
            }
        }
        return input;
    }

    public static LocalDate getLocalDateInput() {
        LocalDate localDate;
            try {
                localDate = LocalDate.parse(
                        getIntegerInput(OutputMessage.GET_YEAR_FROM_USER.getMessage()) + "-" +
                                getIntegerInput(OutputMessage.GET_MONTH_FROM_USER.getMessage()) + "-" +
                                getIntegerInput(OutputMessage.GET_DAY_FROM_USER.getMessage()));
                return localDate;
            } catch (DateTimeParseException e) {
                OutputHelper.errorMessage(OutputMessage.INPUT_MISMATCH_LOCAL_DATE.getMessage());
                getLocalDateInput();
            }
            return null;
    }
}
