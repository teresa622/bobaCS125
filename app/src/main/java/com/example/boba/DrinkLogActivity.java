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
        if (drinks == null) {
            displayDrinks.setText("There are no past drinks :(");
            return;
        }
        for (int x = 0; x < drinks.size(); x++) {
            if (x == drinks.size() - 1) {
                string = string + drinks.get(x);
                continue;
            }
            string = string + drinks.get(x) +
                    "-------------------------------------------------------------------------\n";
        }
        displayDrinks.setText(string);
        Button home = findViewById(R.id.home);
        final Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.putStringArrayListExtra("drinkLog", drinks);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(homeIntent);
            }
        });
    }
}
