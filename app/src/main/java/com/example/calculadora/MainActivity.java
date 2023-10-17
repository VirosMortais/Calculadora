package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<String> calc = new ArrayList<>();

    private String operation;
    private TextView resultView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button    buttonOne = findViewById(R.id.buttonNumberOne);
        Button    buttonTwo = findViewById(R.id.buttonNumberTwo);
        Button    buttonThree = findViewById(R.id.buttonNumberThree);
        Button    buttonFour = findViewById(R.id.buttonNumberFour);
        Button    buttonFive = findViewById(R.id.buttonNumberFive);
        Button    buttonSix = findViewById(R.id.buttonNumberSix);
        Button    buttonSeven = findViewById(R.id.buttonNumberSeven);
        Button    buttonEight = findViewById(R.id.buttonNumberEight);
        Button    buttonNine = findViewById(R.id.buttonNumberNine);
        Button    buttonZero = findViewById(R.id.buttonNumberZero);

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
            n.setOnClickListener(view -> {
                if (!resultView.getText().toString().equals("0")) {
                    resultView.setText(resultView.getText().toString() + n.getText().toString());
                } else {
                    resultView.setText(n.getText().toString());
                }
            });
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
            s.setOnClickListener(view -> {

                calc.add(resultView.getText().toString());


                calc.add(s.getText().toString());

                resultView.setText("0");

            });
        }


        //Limpia la pantalla y la variable firstNumber
        buttonClen.setOnClickListener(view -> {
            calc.clear();
            resultView.setText("0");
        });

        //Llama a la funcion operation() y muestra el resultado en pantalla
        buttonEqual.setOnClickListener(view -> {

            resultView.setText(String.valueOf(calc));
        });

    }

    /**
     * Realiza la operacion correspondiente
     */

}