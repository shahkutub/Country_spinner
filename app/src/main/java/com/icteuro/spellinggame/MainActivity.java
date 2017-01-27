package com.icteuro.spellinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] countryNames={"India","China","Australia","Portugle","America","New Zealand"};
    int flags[] = {R.drawable.india, R.drawable.china, R.drawable.australia, R.drawable.portugle, R.drawable.america, R.drawable.new_zealand};
    Spinner spin;
    private TextView tvAnswer;
    private EditText tvMe;
    String spell = "",spinSpell = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMe = (EditText) findViewById(R.id.tvMe);
        tvAnswer = (TextView)findViewById(R.id.tvAnswer);
        tvAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMe.setText(spinSpell);
            }
        });

        spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),flags,countryNames);
        spin.setAdapter(customAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
       // Toast.makeText(getApplicationContext(), countryNames[position], Toast.LENGTH_LONG).show();
        spinSpell = countryNames[position];
        tvMe.setText("");

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
