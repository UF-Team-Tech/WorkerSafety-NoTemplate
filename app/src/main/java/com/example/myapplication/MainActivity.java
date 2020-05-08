package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter adapter;
    //menu buttons
/*
home == has alerts and such
employee list == when you click on an employee-> shows detailed status
register device
my account == update password and update profile
help
logout
 */
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //this is our listview
        listView = (ListView)findViewById(R.id.list_view);

        list.add("burrito1");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");


        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, list.get(position), Toast.LENGTH_SHORT).show();
                Intent rob = new Intent(MainActivity.this, Robin.class);
                rob.putExtra("Value1", list.get(position));
                startActivity(rob);
            }
        });


        //this is the navigation drawer menu
        /*
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();*/

        //these are the buttons
        configureNextButton();
        configureRobinButton();
    }

    private void configureNextButton(){
        Button nextButton = (Button) findViewById(R.id.nextscreen);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    private void configureRobinButton(){
        Button nextButton = (Button) findViewById(R.id.robin);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Robin.class));
            }
        });
    }


}
