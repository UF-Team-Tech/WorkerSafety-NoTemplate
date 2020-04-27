package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Robin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin);

        configureBackButton();
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        /*Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/

        Bundle extras = getIntent().getExtras();
        String user_name = extras.getString("USER_NAME");
        Integer user_id = extras.getInt("USER_ID");
        if (extras == null) {
            return;
        }
        else
        {
            CharSequence text3 = "nothing yet";
            if(user_id == 21)
            {
                text3 = "goood";
            }
            else
            {
               text3 = "empty toast";
            }


            Toast toast = Toast.makeText(context, text3, duration);
            toast.show();
        }
        //String value1 = extras.getString("Value1");
        //Integer value1 = extras.get("Value2");
        /*Integer value1 = extras.getInt("Value2");
        if (value1 != null) {
            // do something with the data
            Toast toast = Toast.makeText(context, "hi", duration);
            toast.show();
        }
        else
        {
            CharSequence text2 = "bad toast";

            Toast toast = Toast.makeText(context, text2, duration);
            //toast.show();
        }*/
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
