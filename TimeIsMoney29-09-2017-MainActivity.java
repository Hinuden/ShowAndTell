package com.example.android.timeismoney;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Method for @setToday_startDate_button
    public void setToday_StartDate(View view) {
        //Focusing on @getStartDate_editText
        EditText startDateEditText = (EditText) findViewById(R.id.getStartDate_editText);
        //Declaring date format to use it later
        DateFormat declareDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Making a calendar "myCalendar"
        Calendar myCalendar = Calendar.getInstance();
        //Left-to-right: getting time fom myCalendar; applying format to that time;
        //using that formated time as String; ordering setText into view
        startDateEditText.setText(declareDateFormat.format(myCalendar.getTime()));
    }

    //Method for @setYesterday_startDate_button
    public void setYesterday_StartDate(View view) {
        //Focusing on @getStartDate_editText
        EditText startDateEditText = (EditText) findViewById(R.id.getStartDate_editText);
        //Declaring date format to use it later
        DateFormat declareDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Making a calendar "myCalendar"
        Calendar myCalendar = Calendar.getInstance();
        //Setting myCalendar to yesterday. Changing DATE, by adding -1 days
        myCalendar.add(Calendar.DATE, -1);
        //Left-to-right: getting time fom myCalendar; applying format to that time;
        //using that formated time as String; ordering setText into view
        startDateEditText.setText(declareDateFormat.format(myCalendar.getTime()));
    }

    //Method for @setToday_startDate_button
    public void setToday_EndDate(View view) {
        //Focusing on @getStartDate_editText
        EditText EndDateEditText = (EditText) findViewById(R.id.getEndDate_editText);
        //Declaring date format to use it later
        DateFormat declareDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Making a calendar "myCalendar"
        Calendar myCalendar = Calendar.getInstance();
        //Left-to-right: getting time fom myCalendar; applying format to that time;
        //using that formated time as String; ordering setText into view
        EndDateEditText.setText(declareDateFormat.format(myCalendar.getTime()));
    }

    //Method for @setYesterday_startDate_button
    public void setYesterday_EndDate(View view) {
        //Focusing on @getStartDate_editText
        EditText EndDateEditText = (EditText) findViewById(R.id.getEndDate_editText);
        //Declaring date format to use it later
        DateFormat declareDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Making a calendar "myCalendar"
        Calendar myCalendar = Calendar.getInstance();
        //Setting myCalendar to yesterday. Changing DATE, by adding -1 days
        myCalendar.add(Calendar.DATE, -1);
        //Left-to-right: getting time fom myCalendar; applying format to that time;
        //using that formated time as String; ordering setText into view
        EndDateEditText.setText(declareDateFormat.format(myCalendar.getTime()));
    }

    public void cosa(View view) {

        EditText StartDateEditText = (EditText) findViewById(R.id.getStartDate_editText);
        EditText EndDateEditText = (EditText) findViewById(R.id.getEndDate_editText);
        EditText StartHourEditText = (EditText) findViewById(R.id.getStartHour_editText);
        EditText StartMinuteEditText = (EditText) findViewById(R.id.getStartMinute_editText);
        EditText EndHourEditText = (EditText) findViewById(R.id.getEndHour_editText);
        EditText EndMinuteEditText = (EditText) findViewById(R.id.getEndMinute_editText);
        String StartDateToString = StartDateEditText.getText().toString();
        String StartTimeToString = StartHourEditText.getText().toString() +
                ":" + StartHourEditText.getText().toString();
        String EndDateToString = EndDateEditText.getText().toString();
        String EndTimeToString = EndHourEditText.getText().toString() +
                ":" + EndHourEditText.getText().toString();

        SimpleDateFormat StartFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String StartAssembled = StartDateToString + " " + StartTimeToString;
        Date StartMoment = null;
        try {
            StartMoment = StartFormat.parse(StartAssembled);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat EndFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String EndAssembled = EndDateToString + " " + EndTimeToString;
        Date EndMoment = null;
        try {
            EndMoment = EndFormat.parse(EndAssembled);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long difference = StartMoment.getTime() - EndMoment.getTime();
        long differenceSeconds = difference / 1000;
        long differenceMinutes = difference / (60 * 1000);
        long differenceHours = difference / (1000 * 60 * 60);
        String differenceToString = "Hours: " + String.valueOf(differenceHours) +
                " Minutes: " + String.valueOf(differenceMinutes) +
                " Seconds: " + String.valueOf(differenceSeconds);
        Log.v("MainActivity:cosa()", differenceToString);


    }



}
