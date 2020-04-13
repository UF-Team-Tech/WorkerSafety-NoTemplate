package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button log;
    private TextView info;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = (EditText)findViewById(R.id.etUsername);
        pass = (EditText)findViewById(R.id.etPassword);
        info = (TextView)findViewById(R.id.attempts);
        log = (Button)findViewById(R.id.login);

        info.setText("Attempts remaining: " + String.valueOf(counter));

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), pass.getText().toString());
            }
        });
    }

    private void validate(String u, String p){
        if((u.equals("Admin")) && (p.equals("1234"))){
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            counter--;

            info.setText("Attempts remaining: " + String.valueOf(counter));

            if(counter == 0)
                log.setEnabled(false);
        }
    }

}
