package com.example.qedquestioneveryday;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button GetAnswerButton;
    Button GetQuestionButton;
    TextView RandNumTextView;
    ImageView QuestionPic;

    //BlockNumber function
    public static Integer RandomNumberRange(int max, int min, int block)
    {
        Random rand = new Random();
        int randomNum;

        do {
            randomNum = rand.nextInt((max - min) + 1) + min;
        } while (randomNum == block);

        return randomNum;
    }

    public class ImageSelector{


        public void SetCurrentImageNumber(int CurrentImageNumber)
        {
            mCurrentImageNumber=CurrentImageNumber;
        }
        public int GetCurrentImageNumber()
        {
            return mCurrentImageNumber;
        }

        int mCurrentImageNumber;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        GetAnswerButton=findViewById(R.id.CheckAnswerButton);
        GetQuestionButton=findViewById(R.id.GetQuestionButton);
        RandNumTextView=findViewById(R.id.RandomNumTextView);
        QuestionPic=findViewById(R.id.QuestionPic);

        QuestionPic.setImageResource(getResources().getIdentifier("@drawable/test_img",null,this.getPackageName()));

       final ImageSelector imgselector= new ImageSelector();
        imgselector.SetCurrentImageNumber(0);



        GetQuestionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Get picture
                int NewImagenum=RandomNumberRange(3,1,imgselector.GetCurrentImageNumber());
                RandNumTextView.setText(Integer.toString(NewImagenum));
                String ImageString="@drawable/aqa_h_jun_2017_1_q"+Integer.toString(NewImagenum);
                int Imageint=getResources().getIdentifier(ImageString,null,"com.example.qedquestioneveryday");
                QuestionPic.setImageResource(Imageint);
                imgselector.SetCurrentImageNumber(NewImagenum);



            }
        });

        GetAnswerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String ImageString="@drawable/aqa_h_jun_2017_1_a"+Integer.toString(imgselector.GetCurrentImageNumber());
                int Imageint=getResources().getIdentifier(ImageString,null,"com.example.qedquestioneveryday");
                QuestionPic.setImageResource(Imageint);

            }


        });

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
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
