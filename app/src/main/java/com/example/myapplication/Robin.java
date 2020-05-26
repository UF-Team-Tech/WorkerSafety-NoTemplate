package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Robin extends AppCompatActivity {

    public TextView message;
    public Connection con;
    public Button run;
    ListView listView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> list = new ArrayList<String>();

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robin);

        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        list.add("bur");
        list.add("bur1");
        list.add("bur2");
        list.add("bur3");
        list.add("bur4");


        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(list);
        recyclerView.setAdapter(mAdapter);

        //listView = (ListView)findViewById(R.id.list_view);
        //recycle_view

        //adapter = new ArrayAdapter(Robin.this, android.R.layout.simple_list_item_1, list);
        //listView.setAdapter(adapter);

        configureBackButton();

    run = (Button) findViewById(R.id.button);
    run.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckLogin checkLogin = new CheckLogin();
            checkLogin.execute("");
        }
    });
    }

    public class CheckLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;
        //String name1 = "";
        //private ArrayList<String> tables = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            //something
        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(Robin.this, r, Toast.LENGTH_LONG).show();
            if (isSuccess) {
                //message = (TextView) findViewById(R.id.textView2);
                //message.setText(name1);
                adapter.notifyDataSetChanged();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                con = connectionClass();
                if (con == null) {
                    z = "internet access might be rough rn buddy";
                } else {
                    String query = "Select * from SalesLT.Address";
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        //name1 = rs.getString("City");
                        while (rs.next())
                        {
                            list.add(rs.getString("City"));
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

    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backtomainrobin);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view ){
                finish();
            }
        });

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
            ConnURL = "jdbc:jtds:sqlserver://teamtech-sqlserver.database.windows.net:1433;DatabaseName=TeamTechSqlDatabase;user=teamtech@teamtech-sqlserver;password=Zxcv4321;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

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
