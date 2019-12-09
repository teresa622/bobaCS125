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
        String[] milkTeaDrinks = {"KungFu Milk Green Tea", "Oolong Milk Tea", "Taro Milk Green Tea",
        "Coffee Milk Tea", "Almond Milk Tea", "Coconut Milk Tea", "Honey Milk Tea",
        "Honey Milk Green Tea", "KungFu Milk Tea", "Taro Milk Tea", "Honey Oolong Milk Tea",
        "Winter Melon Milk Green Tea", "Rosehip Milk Tea"};
        String[] punchDrinks = {"Honey Lemonade", "Grapefruit Green Tea", "Lychee Black Tea",
        "Lychee Punch", "Mango Green Tea", "Orange Green Tea", "Passion Fruit Green Tea",
        "Peach Oolong Tea", "Rosehip Lemonade", "Strawberry Lemon Green Tea", "Strawberry Lemonade",
        "Sunshine Pineapple Tea"};
        String[] milkCapDrinks = {"Winter Melon Tea Milk Cap", "Honey Black Tea Cap",
        "Honey Oolong Tea Cap", "Honey Green Tea Cap", "Jujube Tea Milk Cap",
        "Sunshine Pineapple Tea Cap", "Matcha Milk Cap", "Cocoa Cream Wow Milk Cap"};
        String[] slushDrinks = {"Passion Fruit Slush", "Matcha Red Bean Slush",
        "Strawberry Milk Slush", "Milk Slush", "Coffee Slush", "Italian Mocha Slush",
        "Caramel Macchiato Slush", "Taro Slush", "Red Bean Slush", "Mango Slush",
                "Mango Snow Slush", "Pineapple Slush", "Pina Colada Slush", "Oreo Slush"};
        String[] milkStrikeDrinks = {"Cocoa Cream Wow Milk Strike", "Oreo Wow Milk Strike",
        "Red Bean Wow Milk Strike", "Herbal Jelly Wow Milk Strike", "Chai Milk Strike",
        "Ginger Milk Strike", "Matcha Milk Strike", "Sesame Matcha Strike"};
        String[] espressoDrinks = {"Signature Coffee", "Latte", "Mocha", "Cappucino",
        "Caramel Macchiato"};
        String[] seasonalDrinks = {"Pumpkin Oolong Milk Tea", "Brown Sugar Ginger"};
        String[] newDrinks = {"Strawberry Yogurt Lemonade", "Winter Melon Coconut Milk Tea",
        "Winter Melon Lemonade", "Strawberry Cream", "Grape Cream", "Kiwi Apple Kale Slush",
        "Caribbean Breeze"};
        String[] toppings = {"Pudding", "Tapioca", "Nata Jelly", "Red Bean", "Coffee Popping Bubbles",
        "Herbal Jelly", "Grape Popping Bubbles", "Fig Jelly", "Mango Popping Bubbles", "Aloe Jelly"};
        int length = 0;
        int toppingsNum = getIntent().getIntExtra("toppings", 0);
        String selectedDrink = "";
        int drinkGroup = getRandomNumberInRange(0, 9);
        if (drinkGroup == 0) {
            length = yogurtDrinks.length;
            selectedDrink = yogurtDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 1) {
            length = classicDrinks.length;
            selectedDrink = classicDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 2) {
            length = milkTeaDrinks.length;
            selectedDrink = milkTeaDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 3) {
            length = punchDrinks.length;
            selectedDrink = punchDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 4) {
            length = milkCapDrinks.length;
            selectedDrink = milkCapDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 5) {
            length = slushDrinks.length;
            selectedDrink = slushDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 6) {
            length = milkStrikeDrinks.length;
            selectedDrink = milkStrikeDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 7) {
            length = espressoDrinks.length;
            selectedDrink = espressoDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 8) {
            length = seasonalDrinks.length;
            selectedDrink = seasonalDrinks[getRandomNumberInRange(0, length - 1)];
        } else if (drinkGroup == 9) {
            length = newDrinks.length;
            selectedDrink = newDrinks[getRandomNumberInRange(0, length - 1)];
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
