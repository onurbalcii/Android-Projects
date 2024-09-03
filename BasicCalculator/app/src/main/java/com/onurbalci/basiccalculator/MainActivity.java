package com.onurbalci.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1Text;
    EditText number2Text;
    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Text = findViewById(R.id.number1Text);
        number2Text = findViewById(R.id.number2Text);
        resultText = findViewById(R.id.resultText);
    }

    public void sum(View view) {

        if (number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")) {

            resultText.setText("Enter Number!");

        } else {
            Double number1 = Double.parseDouble(number1Text.getText().toString());
            Double number2 = Double.parseDouble(number2Text.getText().toString());

            Double result = number1 + number2;

            resultText.setText("Result: " + result);
        }
    }

    public void sub(View view) {

        if (number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")) {

            resultText.setText("Enter Number!");

        } else {
            Double number1 = Double.parseDouble(number1Text.getText().toString());
            Double number2 = Double.parseDouble(number2Text.getText().toString());

            Double result = number1 - number2;

            resultText.setText("Result: " + result);
        }

    }

    public void multi(View view) {

        if (number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")) {

            resultText.setText("Enter Number!");

        } else {
            double number1 = Double.parseDouble(number1Text.getText().toString());
            double number2 = Double.parseDouble(number2Text.getText().toString());

            double result = number1 * number2;

            resultText.setText("Result: " + result);
        }

    }

    public void div(View view) {

        if (number1Text.getText().toString().matches("") || number2Text.getText().toString().matches("")) {

            resultText.setText("Enter Number!");

        } else {

            double number1 = Double.parseDouble(number1Text.getText().toString());
            double number2 = Double.parseDouble(number2Text.getText().toString());

            if (number1 == 0 || number2 == 0) {

                resultText.setText("Enter different Number!");

            } else {

                double result = number1 / number2;

                resultText.setText("Result: " + result);
            }

        }

    }
}