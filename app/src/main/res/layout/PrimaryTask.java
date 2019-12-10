package com.example.cmsc434_ga06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class PrimaryTask extends AppCompatActivity implements View.OnClickListener{
    //ConstraintLayout alarm_foreground = findViewById(R.id.alarm_view);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_task);
    }

    @Override
    public void onClick(View v) {
    }

    // pop up window when hit SET button
    //Source: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
    public void set_alarm(View v){

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
                startActivity(new Intent(getApplicationContext(), activity_primary_task_12.class));
            }
        });
    }

    //change to following when the other activities are written
    //public void time_format(View v){} // change to 12 hours format
    public void toinfo(View v){}
    public void tonights(View v){}
}
