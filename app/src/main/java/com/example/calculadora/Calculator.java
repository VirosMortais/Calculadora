package com.example.calculadora;

import java.util.List;

public class Calculator {

    public int calcular(List<String> oper) {
        if (oper.contains("*") || oper.contains("/")) {
            for (int i = 0; i < oper.size(); i++) {

                if (oper.get(i).equals("*") || oper.get(i).equals("/")) {
                    String sw = oper.get(i);
                    switch (sw) {
                        case "*":
                            oper.set(i - 1, Integer.toString(multi(oper.get(i - 1), oper.get(i + 1))));
                            oper.remove(i);
                            oper.remove(i);
                            i--;
                            continue;
                        case "/":
                            oper.set(i - 1, Integer.toString(div(oper.get(i - 1), oper.get(i + 1))));
                            oper.remove(i);
                            oper.remove(i);
                            i--;
                    }
                }
            }
        }

        for (int i = 0; i < oper.size(); i++) {
            String sw = oper.get(i);
            switch (sw) {
                case "+":
                    oper.set(i - 1, Integer.toString(sum(oper.get(i - 1), oper.get(i + 1))));
                    oper.remove(i);
                    oper.remove(i);
                    i--;
                    continue;
                case "-":
                    oper.set(i - 1, Integer.toString(res(oper.get(i - 1), oper.get(i + 1))));
                    oper.remove(i);
                    oper.remove(i);
                    i--;
            }
        }

        return Integer.parseInt(oper.get(0));
    }

    public int multi(String n1, String n2) {
        return Integer.parseInt(n1) * Integer.parseInt(n2);
    }

    public int div(String n1, String n2) {
        return Integer.parseInt(n1) / Integer.parseInt(n2);
    }

    public int sum(String n1, String n2) {
        return Integer.parseInt(n1) + Integer.parseInt(n2);
    }

    public int res(String n1, String n2) {
        return Integer.parseInt(n1) - Integer.parseInt(n2);
    }
}
