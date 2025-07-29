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

        if (isNumeric(numberOne) || isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Not a numeric value");
        return Double.parseDouble(numberOne) + Double.parseDouble(numberTwo);
    }

    private boolean isNumeric(String strNumber) {

        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Not a numeric value");
        String number = strNumber.replace(",", "."); // R$15,56 reais | $15.56 dollars

        return !number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // http://localhost:8080/math/dividion/3/5
    // http://localhost:8080/math/subtraction/3/5


}
