package org.api.firststeps.request.converters;

import org.api.firststeps.exception.UnsupportedMathOperationException;

public class NumberConverter {


    public static double getParseDouble(String numberOne) {
        return Double.parseDouble(numberOne);
    }

    public static boolean isNumeric(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Not a numeric value");
        String number = strNumber.replace(",", "."); // R$15,56 reais | $15.56 dollars

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
