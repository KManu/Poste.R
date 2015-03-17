package com.migh.poster.Activities;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.migh.poster.Fragments.EventsGridFragment;
import com.migh.poster.Fragments.FeedsGridFragment;
import com.migh.poster.R;
import com.migh.poster.ServicesAndTasks.EndpointsAsyncTask;

public class MainActivity extends ActionBarActivity {
    ActionBar actionBar;
    View actionView;
    FragmentManager fManager = getSupportFragmentManager();
    Fragment fragment;


    Button manageFeedsButton;
    Button manageEventsButton;
    Button createFeedButton;
    LinearLayout mainLinLayout;

    Typeface quicksandRegular;
    //Typeface quicksandLight;
    //Typeface poiretOne;

    String currentFrag= new String(); //Semaphore to denote the current occupant of the Activity space

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentFrag = "Main";
        init();
        setupActionBar();
        new EndpointsAsyncTask().execute(new Pair<Context, String>(this, "Kobby"));
    }

    private void init() {
        manageFeedsButton = (Button) findViewById(R.id.Main_manageFeedButton);
        manageEventsButton = (Button) findViewById(R.id.Main_manageEventsButton);
        createFeedButton = (Button) findViewById(R.id.Main_createFeedButton);
        mainLinLayout = (LinearLayout) findViewById(R.id.Main_LinearLayout);

        //Font declarations
        quicksandRegular = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Regular.otf");
        //poiretOne = Typeface.createFromAsset(getAssets(), "fonts/PoiretOne-Regular.ttf");
        //quicksandLight = Typeface.createFromAsset(getAssets(), "fonts/Quicksand-Light.otf");

        //Set up the button on clicks
        manageFeedsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFrag = "FeedsGrid";
                fragment=new FeedsGridFragment();
                fManager
                .beginTransaction()
                .replace(R.id.Main_frameLayout, fragment)
                .addToBackStack("")
                .commit();
            }
        });

        manageEventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentFrag = "EventsGrid";
                fragment = new EventsGridFragment();
                fManager
                .beginTransaction()
                .replace(R.id.Main_frameLayout, fragment)
                .addToBackStack("")
                .commit();
            }
        });

        createFeedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start up the feed creation activity.
                Toast.makeText(getApplicationContext(), "Create feed button clicked", Toast.LENGTH_SHORT).show();

            }
        });




    }


    public void setupActionBar(){
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setIcon(new ColorDrawable(getResources().getColor(android.R.color.transparent)));



        LayoutInflater inflater = LayoutInflater.from(this);
        actionView = inflater.inflate(R.layout.custom_actionbar_title, null);
        ((TextView)actionView.findViewById(R.id.custom_actionBar_text)).setText(R.string.app_name);
        ((TextView)actionView.findViewById(R.id.custom_actionBar_text)).setTypeface(quicksandRegular);
        actionBar.setCustomView(actionView);
    }

    public void setActionBarText(String title){
        //Mainly used as a way for fragments to change the action bar title
        ((TextView)actionView.findViewById(R.id.custom_actionBar_text)).setText(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
