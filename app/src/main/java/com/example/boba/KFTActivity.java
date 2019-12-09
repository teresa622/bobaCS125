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
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

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
        ArrayList topsIndex = new ArrayList<Integer>();
        TextView toppingsDisplay = findViewById(R.id.toppingsDisplay);
        if (toppingsNum == 0) {
            toppingsDisplay.setVisibility(View.INVISIBLE);
            TextView withText = findViewById(R.id.withText);
            withText.setVisibility(View.INVISIBLE);
        } else {
            for (int x = 0; x < toppingsNum; x++) {
                Integer generateRandom = getRandomNumberInRange(0, toppings.length - 1);
                while(topsIndex.contains(generateRandom)) {
                    generateRandom = getRandomNumberInRange(0, toppings.length - 1);
                }
                topsIndex.add(generateRandom);
                if (x == toppingsNum - 1) {
                    tops += toppings[generateRandom];
                } else {
                    tops += toppings[generateRandom] + "\n";
                }
            }

        }
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        // formattedDate have current date/time
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();
        String displayText = "";
        if (toppingsNum != 0) {
            displayText = selectedDrink + " with " + tops;
        } else {
           displayText = selectedDrink;
        }
        drinkDisplay.setText(selectedDrink);
        toppingsDisplay.setText(tops);
        drinkLog.add(displayText + ": " + formattedDate + "\n");
        Button geneButton = findViewById(R.id.geneButton);
        Button returnHome = findViewById(R.id.home);

        final Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.putExtra("toppings", toppingsNum);
        homeIntent.putStringArrayListExtra("drinkLog", drinkLog);
        final Intent generateIntent = new Intent(this, KFTActivity.class);
        generateIntent.putExtra("toppings", toppingsNum);
        generateIntent.putStringArrayListExtra("drinkLog", drinkLog);
        geneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(generateIntent);
            }
        });
        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(homeIntent);
            }
        });
        Picasso.get().setLoggingEnabled(true);
        showDoggo();
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    private void showDoggo() {
        String url = "https://random.dog/woof.json";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        String link = "";
                        try {
                            link = response.getString("url");
                        } catch (Exception e) {
                            Log.e("errors", "Error!");
                        }
                        String type = link.substring(link.length() - 3);
                        while(!type.equals("jpg")) {
                            showDoggo();
                            return;
                        }
                        ImageView doggo = findViewById(R.id.doggo);
                        Picasso.get().load(link).into(doggo);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Log.d("errors", "Request Error!");
                    }
                });
        queue.add(jsonObjectRequest);
    }
}
