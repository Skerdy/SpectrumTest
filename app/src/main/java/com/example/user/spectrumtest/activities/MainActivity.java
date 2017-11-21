package com.example.user.spectrumtest.activities;

import android.graphics.Path;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.spectrumtest.R;
import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends Base_Nav_Activity {
    private List<Date> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dates=new ArrayList<Date>();



        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        Date today = new Date();

        gjeneroDate("30/11/2017");
        gjeneroDate("01/12/2017");
        gjeneroDate("02/12/2017");


        calendar.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE);
        calendar.highlightDates(dates);


    }

    private void gjeneroDate(String data){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(data);
            long startDate = date.getTime();
            dates.add(new Date(startDate));

        } catch (ParseException e) {
            e.printStackTrace();

        }


    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }
}
