package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KFTActivity extends AppCompatActivity {
    private static ArrayList drinkLog = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kft);
        TextView drinkDisplay = findViewById(R.id.drinkDisplay);

        String[] yogurtDrinks = {"Yogurt Green Tea", "Yogurt Grapefruit Tea", "Yogurt Orange Tea"};
        String[] classicDrinks = {"Winter Melon Green Tea", "Honey Black Tea",
        "Honey Green Tea", "Honey Oolong Tea", "Longan Jujube Tea", "KungFu Black Tea",
        "KungFu Green Tea", "KungFu Oolong Tea", "KungFu Honey Tea", "Winter Melon Tea"};
        String[] toppings = {"Pudding", "Tapioca", "Nata Jelly", "Red Bean", "Coffee Popping Bubbles",
        "Herbal Jelly", "Grape Popping Bubbles", "Fig Jelly", "Mango Popping Bubbles", "Aloe Jelly"};
        int length = 0;
        int toppingsNum = getIntent().getIntExtra("toppings", 0);
        String selectedDrink = "";
        int drinkGroup = getRandomNumberInRange(0, 1);
        if (drinkGroup == 0) {
            length = yogurtDrinks.length;
            selectedDrink = yogurtDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 1) {
            length = classicDrinks.length;
            selectedDrink = classicDrinks[getRandomNumberInRange(0, length - 1)];
        }
        String tops = "";
        Integer[] topsIndex = new Integer[toppingsNum];
        if (toppingsNum == 10) {
            for (int x = 0; x < toppings.length; x++) {
                if (x == toppings.length - 1) {
                    tops += toppings[x];
                } else {
                    tops += toppings[x] + " and ";
                }
            }
        } else {
            for (int x = 0; x < toppingsNum; x++) {
                Integer generateRandom = getRandomNumberInRange(0, toppings.length - 1);
                while(Arrays.asList(topsIndex).contains(generateRandom)) {
                    generateRandom = getRandomNumberInRange(0, toppings.length - 1);
                }
                topsIndex[x] = generateRandom;
                if (x == toppingsNum - 1) {
                    tops += toppings[x];
                } else {
                    tops += toppings[generateRandom] + " and ";
                }
            }

        }
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
        if (toppingsNum != 0) {
            drinkDisplay.setText(selectedDrink + " with " + tops);
        } else {
            drinkDisplay.setText(selectedDrink);
        }
        drinkLog.add(selectedDrink + ": " + formattedDate + "\n");
        Button geneButton = findViewById(R.id.geneButton);
        Button returnHome = findViewById(R.id.home);

        final Intent kftIntent = new Intent(this, KFTActivity.class);
        final Intent homeIntent = new Intent(this, MainActivity.class);
        geneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(kftIntent);
            }
        });
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                homeIntent.putStringArrayListExtra("drinkLog", drinkLog);
                startActivity(homeIntent);
            }
        });
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
