package com.example.android.menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        String message1 =  ((TextView) findViewById(R.id.menu_item_1)).getText().toString();
        Log.v("MainActivity", message1);

        // Find second menu item TextView and print the text to the logs
        String message2 = (String) ((TextView) findViewById(R.id.menu_item_2)).getText().toString();
        Log.v("MainActivity", message2);

        // Find third menu item TextView and print the text to the logs
        String message3 = (String) ((TextView) findViewById(R.id.menu_item_3)).getText().toString();
        Log.v("MainActivity", message3);
    }
}