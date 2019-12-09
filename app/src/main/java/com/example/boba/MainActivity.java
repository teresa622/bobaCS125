package com.example.boba;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int toppingsNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button kftButton = findViewById(R.id.kftButton);
        Button drinkLog = findViewById(R.id.drinkLog);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_toppings, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                toppingsNum = Integer.parseInt(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        int receivedNum = getIntent().getIntExtra("toppings", 0);
        spinner.setSelection(receivedNum);
        final Intent kftIntent = new Intent(this, KFTActivity.class);
        final Intent drinkLogIntent = new Intent(this, DrinkLogActivity.class);
        kftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                kftIntent.putExtra("toppings", toppingsNum);
                startActivity(kftIntent);
            }
        });
        drinkLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ArrayList drinks = getIntent().getStringArrayListExtra("drinkLog");
                drinkLogIntent.putExtra("toppings", toppingsNum);
                drinkLogIntent.putStringArrayListExtra("drinkLog", drinks);
                startActivity(drinkLogIntent);
            }
        });
    }

}
