package com.example.cmsc434_ga06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class PrimaryTask12Hour extends AppCompatActivity implements View.OnClickListener{

    private Button infoButton;
    private Button nightsButton;
    private Button formatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_task12);

        infoButton = findViewById(R.id.alarm2info);
        nightsButton = findViewById(R.id.alarm2night);
        formatButton = findViewById(R.id.time_format);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(getApplicationContext(), ThirdTask.class);
                startActivity(infoIntent);
            }
        });

        nightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nightsIntent = new Intent(getApplicationContext(), SecondTask.class);
                startActivity(nightsIntent);
            }
        });

        formatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hourIntent = new Intent(getApplicationContext(), PrimaryTask24Hour.class);
                startActivity(hourIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {
    }

    // pop up window when hit SET button
    //Source: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
    public void set_alarm(View v) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);
        final RelativeLayout dim_layout = (RelativeLayout) findViewById(R.id.dim_layout);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);
        //alarm_foreground.getForeground().setAlpha(220);
        //dim_layout.setVisibility(View.VISIBLE);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            //@Override
            public boolean onTouch(View v, MotionEvent event) {
                //dim_layout.setVisibility(View.GONE);
                popupWindow.dismiss();
                //alarm_foreground.getForeground().setAlpha(0);
                return true;
            }
        });

        Button btn = (Button)findViewById(R.id.time_format);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PrimaryTask24Hour.class));
            }
        });
    }
}