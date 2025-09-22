package org.api.firststeps.controllers;

import org.api.firststeps.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/math")
public class MathController {

    // http://localhost:8080/math/sum/3/5

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) {

        checkIfIsNumeric(isNumeric(numberOne), isNumeric(numberTwo));
        return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne,
                           @PathVariable("numberTwo") String numberTwo
    ) {
        checkIfIsNumeric(isNumeric(numberOne), isNumeric(numberTwo));
        return Double.parseDouble(numberOne) / Double.parseDouble(numberTwo);
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo
    ) {
        checkIfIsNumeric(isNumeric(numberOne), isNumeric(numberTwo));
        return Double.parseDouble(numberOne) - Double.parseDouble(numberTwo);
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne,
                              @PathVariable("numberTwo") String numberTwo
    ) {
        checkIfIsNumeric(isNumeric(numberOne), isNumeric(numberTwo));
        return Double.parseDouble(numberOne) * Double.parseDouble(numberTwo);
    }

    @GetMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable("numberOne") String numberOne,
                          @PathVariable("numberTwo") String numberTwo
    ) {
        checkIfIsNumeric(isNumeric(numberOne), isNumeric(numberTwo));

        return ( Double.parseDouble(numberOne) + Double.parseDouble(numberTwo) ) / 2.0;
    }

    private void checkIfIsNumeric(boolean numberOne, boolean numberTwo) {
        if (numberOne || numberTwo)
            throw new UnsupportedMathOperationException("Not a numeric value");
    }

    private boolean isNumeric(String strNumber) {

        assert strNumber != null;
        checkIfIsNumeric(false, strNumber.isEmpty());
        String number = strNumber.replace(",", "."); // R$15,56 reais | $15.56 dollars

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
