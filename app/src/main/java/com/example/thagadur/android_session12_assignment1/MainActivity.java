package com.example.thagadur.android_session12_assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declaring the objects for button and textView
    Button openSettings, showSettings;
    TextView textViewSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initialising the Objects with ID
        openSettings = (Button) findViewById(R.id.open_settings);
        showSettings = (Button) findViewById(R.id.show_settings);
        textViewSettings = (TextView) findViewById(R.id.textViewSettings);
        //to open settings page
        openSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSettings();
            }
        });
        //to show the saved settings
        showSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSettings();
            }
        });
    }

    //getting the details of all items from the prefrence page though shared prefrences page
    private void showSettings() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String settings = "";
        settings = settings + "Password " + sharedPreferences.getString("prefUserPassword", "NO PASSWORD");
        settings = settings + "Remind me for update " + sharedPreferences.getBoolean("PrefLoackScreen", false);
        settings = settings + "\n Update frequency " + sharedPreferences.getString("prefUpdateFrequency", "NO UPDATE");
        textViewSettings.setText(settings);
    }

    //starting the the Settings activity
    public void openSettings() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}