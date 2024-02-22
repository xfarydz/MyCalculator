package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //declare component and variable
    EditText noOne,noTwo;
    Button add,minus,multiply,divide,clear;
    TextView result;
    int no1=0,no2=0,tot=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bind component
        noOne=findViewById(R.id.etFirstNo);
        noTwo=findViewById(R.id.etSecondNo);
        add=findViewById(R.id.btnAdd);
        minus=findViewById(R.id.btnMinus);
        multiply=findViewById(R.id.btnMultiply);
        divide=findViewById(R.id.btnDivide);
        result=findViewById(R.id.tvResult);
        clear=findViewById(R.id.btnClear);
        //register listener and event handler
        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        no1=Integer.parseInt(noOne.getText().toString());
        no2=Integer.parseInt(noTwo.getText().toString());
        if(view.getId() == R.id.btnAdd){
            tot=no1+no2;
            result.setText(String.valueOf(tot));
        } else if(view.getId() == R.id.btnMinus){
            tot=no1-no2;
            result.setText(String.valueOf(tot));
        } else if(view.getId() == R.id.btnDivide){
            //exception handling
            try {
                tot = no1 / no2;
                result.setText(String.valueOf(tot));
            }catch (ArithmeticException ae){
                result.setText("ERROR: "+ae.getMessage());
            }
        } else if(view.getId() == R.id.btnMultiply){
            tot=no1*no2;
            result.setText(String.valueOf(tot));
        } else if(view.getId() == R.id.btnClear){
            noOne.setText(""); //clear value
            noTwo.setText(""); //clear value
            result.setText("0"); //set default value to "0"
            noOne.requestFocus();//set cursor focus on noOne EditText
        }
    }

}