package com.example.user.spectrumtest.Kalendar;

import android.content.Intent;
import android.graphics.Path;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.TextView;
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
    private Button prev, next;

    //kalendar stuff
    private Calendar kalendar_android;
    private Date today;
    private CalendarPickerView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dates=new ArrayList<Date>();


        prev= (Button) findViewById(R.id.buton_prev);
        next = (Button) findViewById(R.id.buton_next);


        calendar = (CalendarPickerView) findViewById(R.id.calendar_view);
        today = new Date();

        kalendar_android = Calendar.getInstance();
       // kalendar_android.add(Calendar.MONTH,0);
        Log.d("Maksimum",""+ kalendar_android.getActualMaximum(Calendar.JULY));



        displayCurrentMonth(kalendar_android);

        /*
        gjeneroDate("30/11/2017");
        gjeneroDate("01/12/2017");
        gjeneroDate("02/12/2017");
        */

        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                Log.d("Skerdi","Klik done");
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

                Log.d("DetajetScroll", ""+firstVisibleItem+visibleItemCount+ " Total " +totalItemCount + " Scroll X = " + calendar.getScrollX()+ " Scroll Y = "+calendar.getScrollY() );
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual_position==0)
                    scrollPosition=0;
                else
                    scrollPosition=actual_position-1;
                calendar.smoothScrollToPositionFromTop(scrollPosition,2);
                actual_position--;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(actual_position==12)
                    scrollPosition=12;
                else
                    scrollPosition=actual_position+1;
                calendar.smoothScrollToPositionFromTop(scrollPosition,2);
                actual_position++;
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

    private void displayCurrentMonth(Calendar month_time){
        calendar.init(today, month_time.getTime())
                .inMode(CalendarPickerView.SelectionMode.SINGLE);
        calendar.highlightDates(dates);
    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }
}
