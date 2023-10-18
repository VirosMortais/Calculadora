package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<String> calc = new ArrayList<>();
    private final Calculator calculator = new Calculator();

    private String valueNumber = "";

    private TextView resultView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.buttonNumberOne);
        Button buttonTwo = findViewById(R.id.buttonNumberTwo);
        Button buttonThree = findViewById(R.id.buttonNumberThree);
        Button buttonFour = findViewById(R.id.buttonNumberFour);
        Button buttonFive = findViewById(R.id.buttonNumberFive);
        Button buttonSix = findViewById(R.id.buttonNumberSix);
        Button buttonSeven = findViewById(R.id.buttonNumberSeven);
        Button buttonEight = findViewById(R.id.buttonNumberEight);
        Button buttonNine = findViewById(R.id.buttonNumberNine);
        Button buttonZero = findViewById(R.id.buttonNumberZero);

        Button buttonSub = findViewById(R.id.buttonSimbolSubtract);
        Button buttonEqual = findViewById(R.id.buttonSimbolEqual);
        Button buttonPlus = findViewById(R.id.buttonSimbolPlus);
        Button buttonClen = findViewById(R.id.buttonSimbolClean);
        Button buttonMult = findViewById(R.id.buttonSimbolMultiply);

        resultView = findViewById(R.id.resultView);

        //Creacion de una lista con los numeros
        List<Button> nums = new ArrayList<>() {{
            add(buttonOne);
            add(buttonTwo);
            add(buttonThree);
            add(buttonFour);
            add(buttonFive);
            add(buttonSix);
            add(buttonSeven);
            add(buttonEight);
            add(buttonNine);
            add(buttonZero);
        }};

        //Agrega el numero a la pantalla
        for (Button n : nums) {
            n.setOnClickListener(this::onNumberButtonClick);
        }

        //Creacion de una lista con los simbolos
        List<Button> simbols = new ArrayList<>() {{
            add(buttonPlus);
            add(buttonSub);
            add(buttonMult);
        }};

        //Hago la operacion correspondiente si se presiona un simbolo y el primer numero es diferente de 0
        //Si el primer numero es 0, se guarda el numero en la variable firstNumber
        for (Button s : simbols) {
            s.setOnClickListener(this::onOperationButtonClick);
        }


        //Limpia la pantalla y la variable firstNumber
        buttonClen.setOnClickListener(view -> {
            calc.clear();
            valueNumber = "";
            resultView.setText("0");
        });

        //Llama a la funcion operation() y muestra el resultado en pantalla
        buttonEqual.setOnClickListener(view -> {
            calc.add(valueNumber);
            valueNumber = "";
            resultView.setText(String.valueOf(calculator.calcular(calc)));

        });

    }

    // Método para manejar la entrada de números
    public void onNumberButtonClick(View view) {
        Button btn = (Button) view;
        if (!resultView.getText().toString().equals("0")) {
            resultView.setText(resultView.getText().toString() + btn.getText().toString());
        } else {
            resultView.setText(btn.getText().toString());
        }
        valueNumber += btn.getText().toString();
    }

    public void onOperationButtonClick(View view) {
        Button button = (Button) view;
        String operante = button.getText().toString();
        boolean invalid = false;

        if (calc.isEmpty()) {
            // Si la lista está vacía, agrega el número seguido del operador
            calc.add(valueNumber);
            calc.add(operante);
        } else if (!valueNumber.equals("")) {
            String lastItem = calc.get(calc.size() - 1);
            if (isOperator(lastItem)) {
                calc.add(valueNumber);
                calc.add(operante);
            } else {
                // El último elemento no es un operador, por lo que el usuario debe estar ingresando un nuevo operador
                calc.add(operante);
                calc.add(valueNumber);
            }
        } else {
            // Verifica si el último elemento de la lista es un operador
            String lastItem = calc.get(calc.size() - 1);
            if (isOperator(lastItem)) {
                // El operador es inválido
                invalid = true;
            } else {
                // Agrega el operador
                calc.add(operante);
            }
        }

        if (!invalid) {
            resultView.setText(resultView.getText().toString() + operante); // Limpia la pantalla
        }

        valueNumber = "";
    }

    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }

}