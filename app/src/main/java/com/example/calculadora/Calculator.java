package com.example.calculadora;

import java.util.List;

/**
 * Clase que realiza las operaciones de la calculadora
 *
 * @version 1.0
 * @since 2.0
 * @see MainActivity
 *
 * @author Charles Arruda Santos
 * @date 12/03/2021
 *
 */
public class Calculator {

    /**
     * Método que realiza las operaciones de la calculadora
     * Comprueba si hay multiplicación o división, si hay, realiza la operación primero
     * y elimina los elementos de la lista, dejando solo el resultado de la operación.
     * Después comprueba si hay suma o resta, si hay, realiza la operación después de la
     * multiplicación o división
     *
     * @param oper lista de operaciones
     * @return int resultado de la operación
     */
    public int calcular(List<String> oper) {
        // Comprueba si hay multiplicación o división
        if (oper.contains("*") || oper.contains("/")) {
            for (int i = 0; i < oper.size(); i++) {

                if (oper.get(i).equals("*") || oper.get(i).equals("/")) {
                    String sw = oper.get(i);
                    switch (sw) {
                        case "*" -> {
                            oper.set(i - 1, Integer.toString(multi(oper.get(i - 1), oper.get(i + 1))));
                            oper.remove(i);
                            oper.remove(i);
                            i--;
                        }
                        case "/" -> {
                            oper.set(i - 1, Integer.toString(div(oper.get(i - 1), oper.get(i + 1))));
                            oper.remove(i);
                            oper.remove(i);
                            i--;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < oper.size(); i++) {
            String sw = oper.get(i);
            switch (sw) {
                case "+" -> {
                    oper.set(i - 1, Integer.toString(sum(oper.get(i - 1), oper.get(i + 1))));
                    oper.remove(i);
                    oper.remove(i);
                    i--;
                }
                case "-" -> {
                    oper.set(i - 1, Integer.toString(res(oper.get(i - 1), oper.get(i + 1))));
                    oper.remove(i);
                    oper.remove(i);
                    i--;
                }
            }
        }
        // Devuelve el resultado de la operación
        return Integer.parseInt(oper.get(0));
    }

    /**
     * Método que realiza la multiplicación
     * @param n1 String con los números a multiplicar
     * @param n2 String con los números a multiplicar
     * @return int resultado de la multiplicación
     */
    public int multi(String n1, String n2) {
        return Integer.parseInt(n1) * Integer.parseInt(n2);
    }

    /**
     * Método que realiza la división
     * @param n1 String con los números a dividir
     * @param n2 String con los números a dividir
     * @return int resultado de la división
     */
    public int div(String n1, String n2) {
        return Integer.parseInt(n1) / Integer.parseInt(n2);
    }

    /**
     * Método que realiza la suma
     * @param n1 String con los números a sumar
     * @param n2 String con los números a sumar
     * @return int resultado de la suma
     */
    public int sum(String n1, String n2) {
        return Integer.parseInt(n1) + Integer.parseInt(n2);
    }

    /**
     * Método que realiza la resta
     * @param n1 String con los números a restar
     * @param n2 String con los números a restar
     * @return int resultado de la resta
     */
    public int res(String n1, String n2) {
        return Integer.parseInt(n1) - Integer.parseInt(n2);
    }
}
