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

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView text = findViewById(R.id.linkage);
        EditText leb=findViewById(R.id.lebanese);
        EditText dol=findViewById(R.id.dollar);
        Button button = findViewById(R.id.convertbutt);



    }

    class RequestTask extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... uri) {
            try{
                URL url = new URL(uri[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.connect();

                if(conn.getResponseCode() != conn.HTTP_OK)
                {
                    //Error message for user
                    //Toast t = Toast.makeText(getApplicationContext(),"Error reading API",Toast.LENGTH_SHORT);
                    //t.show();
                }
                else{
                    //Parse JSON
                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }

                    //Close the scanner
                    scanner.close();

                    //Using the JSON simple library parse the string into a json object
                    JSONObject obj = new JSONObject(inline);
                    JSONArray buy = obj.getJSONArray("buy");
                    int arrayLength = buy.length();
                    JSONArray latestArray = buy.getJSONArray(arrayLength-1);
                    return latestArray.getString(1);

                }


            }
            catch (Exception e){
                //return e.getMessage().toString();

            }
            return "Error";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            EditText leb=findViewById(R.id.lebanese);
            //leb.setText(result);
            resultReady(result);
        }
    }


    public void resultReady(String rate){

        int intRate = Integer.parseInt(rate);
        EditText leb=findViewById(R.id.lebanese);
        EditText dol=findViewById(R.id.dollar);

        if(leb.getText().toString().compareTo("") != 0 && dol.getText().toString().compareTo("")==0)
        {
            double result = Integer.parseInt(leb.getText().toString())/intRate;
            dol.setText(result+"");
        }
        else if(leb.getText().toString().compareTo("") == 0 && dol.getText().toString().compareTo("")!=0){
            double result = Integer.parseInt(dol.getText().toString())*intRate;
            leb.setText(result+"");
        }
        else if(leb.getText().toString().compareTo("") == 0 && dol.getText().toString().compareTo("")==0){
            leb.setText(intRate+"");
            dol.setText("1");
        }
        else{
            Toast t = Toast.makeText(getApplicationContext(),"Error Invalid input",Toast.LENGTH_SHORT);
            t.show();

        }



//        EditText leb=findViewById(R.id.lebanese);
//        leb.setText(intRate);
//        EditText leb=findViewById(R.id.lebanese);


    }

    public void buttonClick(View v){

        new MainActivity2.RequestTask().execute("https://lirarate.org/wp-json/lirarate/v2/rates?currency=LBP");


        //TextView text = findViewById(R.id.linkage);
        //EditText leb=findViewById(R.id.lebanese);
        //String lebaneseText=leb.getText().toString();
        //text.setText(String.valueOf(Float.parseFloat(lebaneseText)/22000));

    }
//public void conv(View v){
//    EditText dol=findViewById(R.id.dollar);
//    TextView text2 = findViewById(R.id.link);
//    String dollarText=dol.getText().toString();
//    text2.setText(String.valueOf(Float.parseFloat(dollarText)*22000));
//
//
//}
}