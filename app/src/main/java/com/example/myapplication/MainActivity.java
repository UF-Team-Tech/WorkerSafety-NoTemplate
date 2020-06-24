package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

//    ListView listView;
//    ArrayList<String> list = new ArrayList<String>();
//    ArrayAdapter adapter;

    ArrayList<ListStuff> mainlist = new ArrayList<ListStuff>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public TextView message;
    public Connection con;
    public Button run;
    public ArrayList<Worker> workers = new ArrayList<Worker>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        mainlist.add(new ListStuff("asdf", "eqwr"));
        mainlist.add(new ListStuff("asdf", "eqwr"));
        mainlist.add(new ListStuff("asdf", "eqwr"));
        mainlist.add(new ListStuff("asdf", "eqwr"));



// use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
// specify an adapter (see also next example)
        mAdapter = new MyAdapter(mainlist);
        recyclerView.setAdapter(mAdapter);

        run = (Button) findViewById(R.id.recyclebutton);
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.CheckLogin checkLogin = new MainActivity.CheckLogin();
                checkLogin.execute("");
            }
        });

       /* listView = (ListView)findViewById(R.id.list_view);
        list.add("burrito1");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
        list.add("burrito");
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
    */

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

    public class CheckLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;
        String name1 = "";
        @Override
        protected void onPreExecute() {
            //something
        }
        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_LONG).show();
            if (isSuccess) {
                //message = (TextView) findViewById(R.id.textView2);
                //message.setText(name1);
                mAdapter.notifyDataSetChanged();
            }
        }
        @Override
        protected String doInBackground(String... params) {
            try {
                con = connectionClass();
                if (con == null) {
                    z = "internet access might be rough rn buddy";
                } else {
                    String query = "Select * from dbo.DimDate2";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        //name1 = rs.getString("City");
                        while (rs.next())
                        {
                            ListStuff row = new ListStuff(rs.getString("WorkerID"), rs.getString("Propane"));
                            mainlist.add(row);
                            AirQuality cond = new AirQuality();
                            for(Gas g : cond.gases){
                                g.lastTenReadings.add(rs.getDouble(g.getName()));
                            }
                            Acceleration a = new Acceleration(rs.getDouble("Acceleration"));
                            Worker friend = new Worker(rs.getString("WorkerID"), "a", "a", 0, 0, cond, a);
                            workers.add(friend);
                            Log.d("hi", workers.toString());
                            System.out.println("adding to list");
                        }
                        z = "query successful good job";
                        isSuccess = true;
                        con.close();
                    } else {
                        z = "invalid query :(";
                        isSuccess = false;
                    }
                }
            } catch (Exception ex) {
                isSuccess = false;
                z = ex.getMessage();
                Log.d("sql error oof", z);
            }
            return z;
        }
    }

    @SuppressLint("NewApi")
    public Connection connectionClass()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection conn = null;
        String ConnURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://teamtechsql.database.windows.net:1433;DatabaseName=TeamTechDB2;user=ravin@teamtechsql;password=;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            conn = DriverManager.getConnection(ConnURL);
        }catch (SQLException se){
            Log.e("ERROR", se.getMessage());
        }catch (ClassNotFoundException e){
            Log.e("ERROR", e.getMessage());
        }catch(Exception e){
            Log.e("ERROR", e.getMessage());
        }
        //Log.d("conn",conn.toString());
        return conn;
    }



}
