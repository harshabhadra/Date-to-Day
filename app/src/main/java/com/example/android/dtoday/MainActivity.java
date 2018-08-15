package com.example.android.dtoday;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    int date, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void submit(View view) {

        EditText eDate = (EditText) findViewById(R.id.date);
        EditText eMonth = (EditText) findViewById(R.id.month);
        EditText eYear = (EditText) findViewById(R.id.year);

        date = Integer.parseInt(eDate.getText().toString());
        month = (Integer.parseInt(eMonth.getText().toString()) - 1);
        year = Integer.parseInt(eYear.getText().toString());

        String day = calculateDay(date, month, year);
        printDate(day);

    }

    private String calculateDay(int dd, int mm, int yyyy) {

        Date date = (new GregorianCalendar(yyyy, mm, dd)).getTime();


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        String day = sdf.format(date);

        return day;
    }

    private void printDate (String s){
        TextView textView = (TextView) findViewById(R.id.printDate);
        textView.setText(s);
        textView.animate().rotationX(360).setDuration(1000);
    }


}