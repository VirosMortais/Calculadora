package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int numberOne = 0, numberTwo, result;


    private Button buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine, buttonZero, buttonEqual, buttonPlus, buttonClen;

    private TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.buttonNumberOne);
        buttonTwo = findViewById(R.id.buttonNumberTwo);
        buttonThree = findViewById(R.id.buttonNumberThree);
        buttonFour = findViewById(R.id.buttonNumberFour);
        buttonFive = findViewById(R.id.buttonNumberFive);
        buttonSix = findViewById(R.id.buttonNumberSix);
        buttonSeven = findViewById(R.id.buttonNumberSeven);
        buttonEight = findViewById(R.id.buttonNumberEight);
        buttonNine = findViewById(R.id.buttonNumberNine);
        buttonZero = findViewById(R.id.buttonNumberZero);
        buttonEqual = findViewById(R.id.buttonSimbolEqual);
        buttonPlus = findViewById(R.id.buttonSimbolPlus);
        buttonClen = findViewById(R.id.buttonSimbolClean);

        resultView = findViewById(R.id.resultView);


        buttonOne.setOnClickListener(v -> {
            if(numberOne == 0 ){
                numberOne = 1;
                resultView.setText(R.string.NumberOne);

            }else{
                numberTwo = 1;
                //resultView.setText(resultView.getText(), R.string.SimbolPlus, R.string.NumberOne);
            }

        });

        buttonTwo.setOnClickListener(v -> {
            numberOne = 2;
        });

        buttonThree.setOnClickListener(v -> {
            numberOne = 3;
        });

        buttonFour.setOnClickListener(v -> {
            numberOne = 4;
        });

        buttonFive.setOnClickListener(v -> {
            numberOne = 5;
        });

        buttonSix.setOnClickListener(v -> {
            numberOne = 6;
        });

        buttonSeven.setOnClickListener(v -> {
            numberOne = 7;
        });

        buttonEight.setOnClickListener(v -> {
            numberOne = 8;
        });

        buttonNine.setOnClickListener(v -> {
            numberOne = 9;
        });

        buttonZero.setOnClickListener(v -> {
            numberOne = 0;
        });

        buttonEqual.setOnClickListener(v -> {
            resultView.setText(result);
        });

        buttonClen.setOnClickListener(v -> {
            clean();
        });

        buttonPlus.setOnClickListener(v -> {
            plusMethod();
        });
    }



    private void plusMethod(){
        result = numberOne + numberTwo;
    }

    private void clean(){
        numberOne = 0;
        numberTwo = 0;
        result = 0;
        resultView.setText("");
    }


}