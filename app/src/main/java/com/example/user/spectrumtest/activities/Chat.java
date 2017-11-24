package com.example.user.spectrumtest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.user.spectrumtest.ChatFunctionality.DemoDialogsActivity;
import com.example.user.spectrumtest.ChatFunctionality.DialogsFixtures;
import com.example.user.spectrumtest.ChatFunctionality.Modelet.Dialog;
import com.example.user.spectrumtest.ChatFunctionality.Modelet.Message;
import com.example.user.spectrumtest.R;
import com.stfalcon.chatkit.dialogs.DialogsList;
import com.stfalcon.chatkit.dialogs.DialogsListAdapter;

import java.util.ArrayList;

/**
 * Created by W2020 Android on 11/20/2017.
 */

public class Chat extends DemoDialogsActivity {
        private  DrawerLayout drawer;
        private NavigationView navigationView;
        private  ActionBarDrawerToggle toggle;

        private ArrayList<Dialog> dialogs;

    public static void open(Context context) {
        context.startActivity(new Intent(context, Chat.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getActionBarToolbar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        setToolbar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/
        dialogsList = (DialogsList) findViewById(R.id.dialogs);

        initAdapter();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, MainMenu.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


   /* @Override
    public boolean providesActivityToolbar() {
        return true;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Kalendar) {
            Log.d("Skerdi", " Kalendar");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation__drawer, menu);
        return true;
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            finish();
        }
    }
    */

    @Override
    public void onDialogClick(Dialog dialog) {
        Toast.makeText(this, "Mesazhi nuk ekziston!", Toast.LENGTH_SHORT).show();
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());
        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);
        dialogsList.setAdapter(super.dialogsAdapter);
    }


    private void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }

    //for example
    private void onNewDialog(Dialog dialog) {
        dialogsAdapter.addItem(dialog);
    }

}
