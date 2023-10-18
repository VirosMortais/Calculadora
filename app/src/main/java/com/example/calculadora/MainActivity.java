package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza las operaciones de la calculadora
 * @version 2.0
 * @since 2.0
 * @see MainActivity
 * @see Calculator
 *
 * @date 12/03/2021
 * @author Charles Arruda Santos
 *
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Lista que almacena los números y operadores ingresados por el usuario
     */
    private final List<String> calc = new ArrayList<>();

    /**
     * Instancia de la clase Calculator
     */
    private final Calculator calculator = new Calculator();

    /**
     * Variable que almacena el número ingresado por el usuario
     */
    private String valueNumber = "";

    /**
     * TextView que muestra el resultado de las operaciones
     */
    private TextView resultView;

    /**
     * Called when the activity is starting.  This is where most initialization
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     * @see Calculator
     * @see #onNumberButtonClick(View)
     * @see #onOperationButtonClick(View)
     * @see #isOperator(String)
     * @see #onCreate(Bundle)
     */
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

    /**
     * Método para manejar la entrada de números en la calculadora y mostrarlos en la pantalla
     * Si el número es 0, el método no hace nada
     * Si el número no es 0, el método agrega el número a la lista y lo muestra en la pantalla
     * Si el número es 0 y la pantalla no está vacía, el método agrega el número a la lista y lo
     * muestra en la pantalla (esto es para que el usuario pueda ingresar números como 10, 100, etc.)
     *
     * @param view vista del botón presionado
     */
    @SuppressLint("SetTextI18n")
    public void onNumberButtonClick(View view) {
        Button btn = (Button) view;
        if (!resultView.getText().toString().equals("0")) {
            resultView.setText(resultView.getText().toString() + btn.getText().toString());
        } else {
            resultView.setText(btn.getText().toString());
        }
        valueNumber += btn.getText().toString();
    }


    /**
     * Método para manejar la entrada de operadores
     * El método verifica si el usuario está ingresando un nuevo operador o si está ingresando
     * un operador después de un número
     * Si el usuario está ingresando un nuevo operador, el método agrega el operador a la lista
     * Si el usuario está ingresando un operador después de un número, el método agrega el número
     * a la lista y luego agrega el operador
     * Si el usuario está ingresando un operador después de un operador, el método no hace nada
     *
     * @param view vista del botón presionado
     * @see #isOperator(String)
     * @see #onNumberButtonClick(View)
     */
    @SuppressLint("SetTextI18n")
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

    /**
     * Método para verificar si un texto es un operador
     *
     * @param text texto a verificar
     * @return boolean true si es un operador, false si no
     */
    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }

}