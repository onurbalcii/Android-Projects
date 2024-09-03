package com.onurbalci.interestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText priceText;
    EditText yearText;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        priceText = findViewById(R.id.priceText);
        yearText = findViewById(R.id.yearText);
        resultText = findViewById(R.id.resultText);
    }

    public void calculate (View view) {

        if(priceText.getText().toString().matches("") || yearText.getText().toString().matches("")) {

            resultText.setText("Enter Number!");

        }else {

            double price = Double.parseDouble(priceText.getText().toString());
            double year = Double.parseDouble(yearText.getText().toString());

            if (price == 0 || year == 0) {

                resultText.setText("Enter different Number");

            } else {

                double result = (price * 5 * year) / 100;

                resultText.setText("Result: " + result);

            }
        }
    }
}