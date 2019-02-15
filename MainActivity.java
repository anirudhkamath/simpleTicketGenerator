package com.example.mahe.lab5q2_ticketbooking;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    String status = "";
    Boolean bool;

    Spinner sourceSpinner,destSpinner;
    Button s,c,x;
    DialogFragment f1,f2;
    ToggleButton t;
    Bundle b;
    //Intent i = new Intent(this, Main2Activity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sourceSpinner = findViewById(R.id.spinner1);
        destSpinner = findViewById(R.id.spinner2);
        t = findViewById(R.id.toggle1);
        x = findViewById(R.id.invisibleButton);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.places, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(adapter);
        destSpinner.setAdapter(adapter);

        s = findViewById(R.id.buttonSubmit);
        c = findViewById(R.id.buttonClear);

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent i = new Intent(v.getContext(), Main2Activity.class);
                /*DialogFragment f = new DatePickerFragment();
                f.show(getSupportFragmentManager(), "Departure Date");*/
                b = new Bundle();
                b.putString("Source", sourceSpinner.getSelectedItem().toString());
                b.putString("Destination", destSpinner.getSelectedItem().toString());
                b.putString("Status", status);

                b.putInt("Year1", ((DatePickerFragment) f1).year);
                b.putInt("Month1", ((DatePickerFragment) f1).month);
                b.putInt("Day1", ((DatePickerFragment) f1).day);

               if(bool){
                   b.putInt("Year2", ((DatePickerFragment) f2).year);
                   b.putInt("Month2", ((DatePickerFragment) f2).month);
                   b.putInt("Day2", ((DatePickerFragment) f2).day);
               }

               b.putBoolean("Two-way-check", bool);

                i.putExtras(b);
                startActivity(i);
            }
        });

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sourceSpinner.setAdapter(adapter);
                destSpinner.setAdapter(adapter);
                f1 = new DatePickerFragment();
                f2 = new DatePickerFragment();
            }
        });

        //String status = "";

        t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Two-way
                    bool=true;
                    x.setVisibility(View.VISIBLE);
                    status = "TWO-WAY";
                }
                else{ //One-way
                    x.setVisibility(View.INVISIBLE);
                    bool=false;
                    status = "ONE-WAY";
                }
            }
        });
    }

    public void showDatePickerDialog1(View v){
        f1 = new DatePickerFragment();
        f1.show(getSupportFragmentManager(), "datePicker");
    }

    public void showDatePickerDialog2(View v){
        f2 = new DatePickerFragment();
        f2.show(getSupportFragmentManager(), "datePicker");
    }
}
