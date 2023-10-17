package com.example.calculadora;

import java.util.List;

public class Calculator {

   public double calcular(List<String> oper){

       for(int i = 0; i < oper.size(); i++) {
           if (oper.contains("*") || oper.contains("/")) {
               if (oper.get(i).equals("*") || oper.get(i).equals("/")) {
                   String sw = oper.get(i);
                   switch (sw) {
                       case "*":
                           oper.set(i - 1, Integer.toString(Integer.parseInt(oper.get(i - 1)) * Integer.parseInt(oper.get(i + 1))));
                           oper.remove(i);
                           oper.remove(i);
                           break;
                       case "/":
                           oper.add(String.valueOf(div(oper.get(i - 1), oper.get(i + 1))));
                           oper.remove(i);
                           oper.remove(i);
                           break;
                   }
               }
           }
       }
       for(int i = 0; i < oper.size(); i++) {
                   String sw = oper.get(i);
                   switch (sw) {
                       case "+":
                           oper.set(i - 1, Integer.toString(Integer.parseInt(oper.get(i - 1)) * Integer.parseInt(oper.get(i + 1))));
                           oper.remove(i);
                           oper.remove(i);
                           break;
                       case "-":
                           oper.add(String.valueOf(div(oper.get(i - 1), oper.get(i + 1))));
                           oper.remove(i);
                           oper.remove(i);
                           break;

           }
       }

       return 0;
   }
   public double multi(String n1, String n2){
       return Double.parseDouble(n1) * Double.parseDouble(n2);
   }

   public double div(String n1, String n2){
       return Double.parseDouble(n1) / Double.parseDouble(n2);
   }
}
