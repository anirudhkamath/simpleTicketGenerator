package com.example.mahe.lab5q2_ticketbooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    Integer day2,month2,year2;
    String date1,date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle b = getIntent().getExtras();
        String s = b.getString("Source");
        String d = b.getString("Destination");
        Integer day1 = b.getInt("Day1");
        Integer month1 = b.getInt("Month1");
        Integer year1 = b.getInt("Year1");
        String status1 = b.getString("Status");
        Boolean bool = b.getBoolean("Two-way-check");

        if(bool){
            day2 = b.getInt("Day2");
            month2 = b.getInt("Month2");
            month2=month2+1;
            year2 = b.getInt("Year2");
            date2 = day2.toString() +"-" + month2.toString() +"-"+ year2.toString();
        }
        else{
            date2 = "N/A"; //not applicable
        }

        month1 = month1 +1;
        date1 = day1.toString() +"-" + month1.toString() +"-"+ year1.toString();
        t1 = findViewById(R.id.src);
        t2 = findViewById(R.id.dest);
        t3 = findViewById(R.id.date);
        t4 = findViewById(R.id.date2);
        t5 = findViewById(R.id.status);
        t1.setText(s);
        t2.setText(d);
        t3.setText(date1);
        t4.setText(date2);
        t5.setText(status1);
    }
}
