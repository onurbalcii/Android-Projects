package com.onurbalci.miniproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    SharedPreferences sharedPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.onurbalci.storingdata" , Context.MODE_PRIVATE);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        sharedPreferences.edit().putString("storedResult", result).apply();

        String storedResult = sharedPreferences.getString("storedResult2", result);


        if(result.isEmpty()){
            textView.setText(storedResult);
        }else {
            textView.setText(result);
        }


    }

    public void back (View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void save (View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = getIntent();
                String result = intent.getStringExtra("result");
                sharedPreferences.edit().putString("storedResult2", result).apply();
                textView.setText(result);


                Toast.makeText(MainActivity2.this, "Saved", Toast.LENGTH_LONG).show();
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity2.this, "Not Saved", Toast.LENGTH_LONG).show();
            }
        });

        alert.show();
    }
}