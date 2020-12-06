package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    String[] arithmetical = { "+", "-", "*", "/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.MainSelectSpinner);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,arithmetical);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),arithmetical[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



    public void Calculate(View view) {
        EditText n1= findViewById(R.id.MainFirstEditText);
        EditText n2 = findViewById(R.id.MainSecondEditText);
        String nr1 = n1.getText().toString();
        String nr2 = n2.getText().toString();
        Spinner sp = findViewById(R.id.MainSelectSpinner);
        String op = (String) sp.getSelectedItem();
        double res = 0;

        switch(op)
        {
            case "+":
                res = Double.parseDouble(nr1) + Double.parseDouble(nr2);
                break;
            case "-":
                res = Double.parseDouble(nr1) - Double.parseDouble(nr2);
                break;
            case "*":
                res = Double.parseDouble(nr1) * Double.parseDouble(nr2);
                break;
            case "/":
                res = Double.parseDouble(nr1) / Double.parseDouble(nr2);
                break;
        }

        TextView result = findViewById(R.id.MainResultTextView);
        result.setText(Double.toString(res));
    }
}