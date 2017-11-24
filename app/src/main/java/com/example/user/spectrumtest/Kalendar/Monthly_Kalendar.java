package com.example.user.spectrumtest.Kalendar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Path;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.spectrumtest.CustomListeners.OnSwipeTouchListener;
import com.example.user.spectrumtest.R;
import com.example.user.spectrumtest.activities.Base_Nav_Activity;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.squareup.timessquare.CalendarPickerView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



public class Monthly_Kalendar extends Base_Nav_Activity {
    private List<Date> dates;
    private List<Fragment> fragments = new ArrayList<>();
    private int actual_position=0, scrollPosition=0;
    private ImageButton prev, next;
    private FrameLayout frameLayout;
    private final int ROLL_CALENDAR_UP=1;
    private final int ROLL_CALENDAR_DOWN=2;


    //kalendar stuff
    private Calendar kalendar_android;
    private Date today;
    private CalendarPickerView calendar;
    private int CurrentMonth, todayMonth, CurrentYear, todayYear;
    private Date lastGeneratedDate;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout =(FrameLayout) findViewById(R.id.canvasMonth);
        dates = new ArrayList<Date>();


        prev = (ImageButton) findViewById(R.id.buton_prev);
        next = (ImageButton) findViewById(R.id.buton_next);


        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);

        initCalendarToday();

        /*
        gjeneroDate("30/11/2017");
        gjeneroDate("01/12/2017");
        gjeneroDate("02/12/2017");
        */

        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Log.d("Skerdi", "Klik done");
                Intent intent = new Intent(Monthly_Kalendar.this, KalendarActivity.class);
                intent.putExtra("ViewMode", 1);
                startActivity(intent);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });


        calendar.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                Log.d("DetajetScroll", "" + firstVisibleItem + visibleItemCount + " Total " + totalItemCount + " Scroll X = " + calendar.getScrollX() + " Scroll Y = " + calendar.getScrollY());
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollCalendar(ROLL_CALENDAR_DOWN, lastGeneratedDate);
               /* if(actual_position==0)
                    scrollPosition=0;
                else
                    scrollPosition=actual_position-1;
                calendar.smoothScrollToPositionFromTop(scrollPosition,2);
                actual_position--;
                */
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollCalendar(ROLL_CALENDAR_UP, lastGeneratedDate);

               /* if(actual_position==12)
                    scrollPosition=12;
                else
                    scrollPosition=actual_position+1;
                calendar.smoothScrollToPositionFromTop(scrollPosition,2);
                actual_position++;
                */
            }
        });


        calendar.setOnTouchListener(new OnSwipeTouchListener(Monthly_Kalendar.this) {
            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                rollCalendar(ROLL_CALENDAR_DOWN, lastGeneratedDate);
            }
            public void onSwipeLeft() {
                rollCalendar(ROLL_CALENDAR_UP, lastGeneratedDate);
            }
            public void onSwipeBottom() {
            }

        });


        frameLayout.setOnTouchListener(new OnSwipeTouchListener(Monthly_Kalendar.this) {
            public void onSwipeTop() {
            }
            public void onSwipeRight() {
                rollCalendar(ROLL_CALENDAR_DOWN, lastGeneratedDate);
            }
            public void onSwipeLeft() {
                rollCalendar(ROLL_CALENDAR_UP, lastGeneratedDate);
            }
            public void onSwipeBottom() {
            }

        });





        final FloatingActionMenu fabMenu = (FloatingActionMenu) findViewById(R.id.fabmenu);
        fabMenu.setClosedOnTouchOutside(true);
        final FloatingActionButton fabBtnScanner = (FloatingActionButton) findViewById(R.id.kalendar_javor);
        fabBtnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(Monthly_Kalendar.this, KalendarActivity.class);
                startActivity(intent);
            }
        });
        FloatingActionButton fabBtnAdd = (FloatingActionButton) findViewById(R.id.kalendar_ditor);

        fabBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabMenu.close(true);
                Intent intent = new Intent(Monthly_Kalendar.this, KalendarActivity.class);
                intent.putExtra("ViewMode" ,1);
                startActivity(intent);
            }
        });


    }



    private  void gjeneroDate(String data){

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(data);
            long startDate = date.getTime();
            dates.add(new Date(startDate));

        } catch (ParseException e) {
            e.printStackTrace();
        }
   }

    private void displayCurrentMonth(Date startingDate, Calendar month_time){
        calendar.init(startingDate, month_time.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE);
        calendar.highlightDates(dates);
    }

    private Calendar fetchCalendarDates(Date startingDay){
        Calendar kalendar = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        kalendar.setTime(startingDay);
        cal.setTime(startingDay);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int deltaDate = kalendar.getActualMaximum(Calendar.DAY_OF_MONTH)-day + 1 ;

        Log.d("Data Sot", " "+ day +" "+ year + " delta Date = "+ deltaDate);
        kalendar.add(Calendar.DATE,deltaDate);
        return kalendar;
    }

    private int getMonthFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return month;
    }

    private int getYearFromDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return year;
    }


    private void rollCalendar(int parameterRollCalendar, Date lastGeneratedDate){
        Calendar cal = Calendar.getInstance();

        cal.setTime(lastGeneratedDate);
        int year = cal.get(Calendar.YEAR);
        CurrentYear = year;
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        if(parameterRollCalendar==ROLL_CALENDAR_UP){
           // kalendar_android = Calendar.getInstance()
            if(CurrentMonth+1!=todayMonth){
                simulateMoveMonth(parameterRollCalendar);
            }
            else{
                if( CurrentYear != todayYear){
                    simulateMoveMonth(parameterRollCalendar);
                }
                else {
                    initCalendarToday();
                }

            }
        }
        else{
            if(CurrentMonth-1!=todayMonth){
                simulateMoveMonth(parameterRollCalendar);
            }
            else{
                if(CurrentYear != todayYear){
                    simulateMoveMonth(parameterRollCalendar);
                }
                else{
                    initCalendarToday();
                }
            }


        }
    }


    private Date krijoDate (int Viti, int muaji, int dita){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Viti);
        calendar.set(Calendar.MONTH, muaji);
        calendar.set(Calendar.DATE, dita);
        Date date = calendar.getTime();
        return date;

    }

    private void simulateMoveMonth(int param){
        Calendar workingCal;
        if(param==ROLL_CALENDAR_UP) {
            if (CurrentMonth == 11) {
                ++CurrentYear;
                CurrentMonth = -1;
            }
            Date nextMonthFirstDate = krijoDate(CurrentYear, CurrentMonth + 1, 1);
            lastGeneratedDate = nextMonthFirstDate;
            Log.d("Data e muajit tjeter", nextMonthFirstDate.toString());
            workingCal = fetchCalendarDates(nextMonthFirstDate);
            displayCurrentMonth(nextMonthFirstDate, workingCal);
            CurrentMonth++;
        }
        else {
            if(CurrentMonth==0){
                --CurrentYear;
                CurrentMonth=12;
            }
            Date nextMonthFirstDate = krijoDate(CurrentYear,CurrentMonth-1,1);
            lastGeneratedDate= nextMonthFirstDate;
            Log.d("Data e muajit tjeter" , nextMonthFirstDate.toString());
            workingCal = fetchCalendarDates(nextMonthFirstDate);
            displayCurrentMonth(nextMonthFirstDate,workingCal);
            CurrentMonth--;

        }
    }

    private void initCalendarToday(){
        today = new Date();
        lastGeneratedDate=today;
        todayMonth = getMonthFromDate(today);
        CurrentMonth=todayMonth;
        todayYear = getYearFromDate(today);

        Log.d("Current Month ", " "+CurrentMonth);

        kalendar_android = fetchCalendarDates(today);
        displayCurrentMonth(today, kalendar_android);
    }



    @Override
    public boolean providesActivityToolbar() {
        return true;
    }
}
