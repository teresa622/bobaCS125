package com.example.boba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DrinkLogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drink_log);
        ArrayList drinks = getIntent().getStringArrayListExtra("drinkLog");
        TextView displayDrinks = findViewById(R.id.drinks);
        String string = "";
        for (int x = 0; x < drinks.size(); x++) {
            string = string + drinks.get(x);
        }
        displayDrinks.setText(string);
        Button home = findViewById(R.id.home);
        final Intent homeIntent = new Intent(this, MainActivity.class);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(homeIntent);
            }
        });
    }
}
