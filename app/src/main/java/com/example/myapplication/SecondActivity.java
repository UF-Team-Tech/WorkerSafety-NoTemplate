package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        configureBackButton();
    }

    //back to main menu
    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backsecondmenu);
        backButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View view ){
            finish();
        }
    });

    }
}
