package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    InputFilter ipt = new InputFilter() {
        @Override
        public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
            for (int m = i; m<i1; m++){
                char c = charSequence.charAt(m);
                if(!Character.isDigit(c) && c != '-'){
                    return "";
                }
            }
            return null;
        }
    };
    public void addition(View view){
        EditText number1 = (EditText) findViewById(R.id.editTextText);
        number1.setFilters(new InputFilter[]{ipt});
        EditText number2 = (EditText) findViewById(R.id.editTextText2);
        number2.setFilters(new InputFilter[]{ipt});
        Integer number = Integer.valueOf(number1.getText().toString()) + Integer.valueOf(number2.getText().toString());
        goToActivity(number);
    }
    public void subtraction(View view){
        EditText number1 = (EditText) findViewById(R.id.editTextText);
        number1.setFilters(new InputFilter[]{ipt});
        EditText number2 = (EditText) findViewById(R.id.editTextText2);
        number2.setFilters(new InputFilter[]{ipt});
        Integer number = Integer.valueOf(number1.getText().toString()) - Integer.valueOf(number2.getText().toString());
        goToActivity(number);
    }
    public void multiplication(View view){
        EditText number1 = (EditText) findViewById(R.id.editTextText);
        number1.setFilters(new InputFilter[]{ipt});
        EditText number2 = (EditText) findViewById(R.id.editTextText2);
        number2.setFilters(new InputFilter[]{ipt});
        Integer number = Integer.valueOf(number1.getText().toString()) * Integer.valueOf(number2.getText().toString());
        goToActivity(number);
    }
    public void division(View view){
        EditText number1 = (EditText) findViewById(R.id.editTextText);
        number1.setFilters(new InputFilter[]{ipt});
        EditText number2 = (EditText) findViewById(R.id.editTextText2);
        number2.setFilters(new InputFilter[]{ipt});
        if (Integer.valueOf(number2.getText().toString())!=0){
            Integer number = Integer.valueOf(number1.getText().toString()) / Integer.valueOf(number2.getText().toString());
            goToActivity(number);
        }
    }
    public void goToActivity(Integer number){
        Intent intent = new Intent(this, result.class);
        if(number==null){
            intent.putExtra("message","error occurred");
        }
        else{
            intent.putExtra("message",number.toString());
        }
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText number1 = (EditText) findViewById(R.id.editTextText);
        number1.setFilters(new InputFilter[]{ipt});
        EditText number2 = (EditText) findViewById(R.id.editTextText2);
        number2.setFilters(new InputFilter[]{ipt});
    }
}