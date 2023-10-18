package com.example.calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    @DisplayName("Testar la funcion calcular")
    @ParameterizedTest
    @CsvSource({
            "2 * 3,6",
            "1 * 2 * 8,16",
            "2 * 2 + 3,7",
            "3 + 2 * 2,7",
            "3 + 2 * 2 + 4,11",
    })
    void testCalcular(String input, int expectedResult) {
        Calculator calc = new Calculator();
        List<String> lista = new ArrayList<>(Arrays.asList(input.split(" "))); // Convert the input to a mutable list
        int result = calc.calcular(lista);
        assertEquals(expectedResult, result);
    }

    }

