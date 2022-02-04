package com.example.currencyexchangeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.linkage);
        EditText leb=findViewById(R.id.lebanese);
        EditText dol=findViewById(R.id.dollar);
        Button button = findViewById(R.id.convertbutt);



}
public void buttonClick(View v){

    TextView text = findViewById(R.id.linkage);
    EditText leb=findViewById(R.id.lebanese);
    String lebaneseText=leb.getText().toString();
    text.setText(String.valueOf(Float.parseFloat(lebaneseText)/22000));

    }
public void conv(View v){
    EditText dol=findViewById(R.id.dollar);
    TextView text2 = findViewById(R.id.link);
    String dollarText=dol.getText().toString();
    text2.setText(String.valueOf(Float.parseFloat(dollarText)*22000));


}

}