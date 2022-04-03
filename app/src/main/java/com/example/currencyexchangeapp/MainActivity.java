package com.example.currencyexchangeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;
import org.json.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button refButton=findViewById(R.id.change_page);
        EditText newestRate1;
        new MainActivity.RequestTask().execute("https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP");



    }
    public void changePage(View view){
        Intent intent =new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
    class RequestTask extends AsyncTask<String, String, String> {








}