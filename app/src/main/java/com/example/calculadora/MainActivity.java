package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private double firstNumber;

    private String operation;


    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonPlus;
    private Button buttonSub;

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

        buttonSub = findViewById(R.id.buttonSimbolSubtract);
        Button buttonEqual = findViewById(R.id.buttonSimbolEqual);
        buttonPlus = findViewById(R.id.buttonSimbolPlus);
        Button buttonClen = findViewById(R.id.buttonSimbolClean);

        resultView = findViewById(R.id.resultView);

        List<Button> nums = new ArrayList<Button>() {{
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


        for (Button n : nums) {
            n.setOnClickListener(view -> {
                if (!resultView.getText().toString().equals("0") && firstNumber == 0) {
                    resultView.setText(resultView.getText().toString() + n.getText().toString());
                } else {
                    resultView.setText(n.getText().toString());
                }
            });
        }


        List<Button> simbols = new ArrayList<Button>() {{
            add(buttonPlus);
            add(buttonSub);
        }};

        for (Button s : simbols) {
            s.setOnClickListener(view -> {

                if (firstNumber == 0) {
                    firstNumber = Integer.parseInt(resultView.getText().toString());
                    operation = s.getText().toString();
                    resultView.setText("0");
                }else{
                    operation();
                    operation = s.getText().toString();
                    resultView.setText("0");
                }


            });
        }

        buttonClen.setOnClickListener(view -> {
            firstNumber = 0;
            resultView.setText("0");
        });

        buttonEqual.setOnClickListener(view -> {
            operation();
            resultView.setText(String.valueOf(firstNumber));
        });

    }

    private void operation() {
        double secondNumber = Double.parseDouble(resultView.getText().toString());
        double result = 0;
        switch (operation) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            default -> result = firstNumber;
        }
        operation = "";
        firstNumber = result;
    }


}