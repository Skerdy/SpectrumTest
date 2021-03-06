package com.example.user.spectrumtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.user.spectrumtest.Kalendar.KalendarActivity;
import com.example.user.spectrumtest.Kalendar.Monthly_Kalendar;
import com.example.user.spectrumtest.R;

public class Navigation_Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{



    private CardView menu_kalendar, menu_trips, menu_chat,menu_travel_area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Intent-i per chat
        final Intent intent = new Intent(this, Chat.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        menu_kalendar = (CardView) findViewById(R.id.menu_kalendar);
        menu_chat = (CardView) findViewById(R.id.menu_chat);
        menu_trips = (CardView) findViewById(R.id.menu_trips);
        menu_travel_area = (CardView) findViewById(R.id.menu_travel);
        setupMenuButtonColors();
        menu_kalendar.setOnClickListener(this);
        menu_chat.setOnClickListener(this);
        menu_trips.setOnClickListener(this);
        menu_travel_area.setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();
        setupMenuButtonColors();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation__drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Kalendar) {
            menu_kalendar.setCardBackgroundColor(getResources().getColor(R.color.menu_calendar_pressed));
            Intent intent = new Intent(this, Monthly_Kalendar.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_kalendar:
                menu_kalendar.setCardBackgroundColor(getResources().getColor(R.color. menu_calendar_pressed));
                Intent intent = new Intent(this, Monthly_Kalendar.class);
                startActivity(intent);
                break;
            case R.id.menu_chat:
                Intent intent1= new Intent(this, Chat.class);
                startActivity(intent1);
                break;
        }
    }


    public void setupMenuButtonColors(){
        menu_kalendar.setCardBackgroundColor(getResources().getColor(R.color.menu_calendar));
        menu_chat.setCardBackgroundColor(getResources().getColor(R.color.menu_chat));
        menu_trips.setCardBackgroundColor(getResources().getColor(R.color.menu_trips));
        menu_travel_area.setCardBackgroundColor(getResources().getColor(R.color.menu_travel_area));
    }
}
