package com.onurbalci.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Switch manAutoSwitch;
    CheckBox driverBox;
    EditText dayText;
    RadioButton bmwRadio;
    RadioButton bnzRadio;
    RadioButton kiaRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manAutoSwitch = findViewById(R.id.manAutoSwitch);
        driverBox = findViewById(R.id.driverBox);
        dayText = findViewById(R.id.dayText);
        bmwRadio = findViewById(R.id.bmwRadio);
        bnzRadio = findViewById(R.id.bnzRadio);
        kiaRadio = findViewById(R.id.kiaRadio);
    }

    public void send (View view) {
        int price = 0;

        if (manAutoSwitch.isChecked()){
            price+=50;
        }
        if (driverBox.isChecked()){
            price+=100;
        }
        if (bmwRadio.isChecked()){
            price+=500;
        }
        if (bnzRadio.isChecked()){
            price+=400;
        }
        if (kiaRadio.isChecked()){
            price+=200;
        }
        price*=Integer.parseInt(dayText.getText().toString());
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("Price", price);
        startActivity(intent);
    }
}