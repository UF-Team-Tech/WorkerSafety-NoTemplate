package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Robin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin);

        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, value1, Toast.LENGTH_SHORT);
        toast.show();

        configureBackButton();
    }

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backtomainrobin);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view ){
                finish();
            }
        });

    }
}
