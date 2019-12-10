package com.example.cmsc434_ga06;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import static android.net.Uri.encode;


public class ThirdTask extends AppCompatActivity {

    private FirebaseFirestore db;
    private Button saveButton;
    private Button alarmButton;
    private Button nightsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_task);

        db = FirebaseFirestore.getInstance();

        saveButton = findViewById(R.id.infosave);
        alarmButton = findViewById(R.id.info2alarm);
        nightsButton = findViewById(R.id.info2night);


        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarmIntent = new Intent(getApplicationContext(), PrimaryTask24Hour.class);
                startActivity(alarmIntent);
            }
        });

        nightsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nightsIntent = new Intent(getApplicationContext(), SecondTask.class);
                startActivity(nightsIntent);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarmIntent = new Intent(getApplicationContext(), PrimaryTask24Hour.class);
                startActivity(alarmIntent);
            }
        });
    }

    public void saveInfo() {
        String name = ((EditText) (findViewById(R.id.name))).getText().toString();
        String age = ((EditText) (findViewById(R.id.age))).getText().toString();
        RadioGroup radioGender = findViewById(R.id.radioGroup);
        String gender = ((RadioButton)findViewById(radioGender.getCheckedRadioButtonId())).getText().toString();
        RadioGroup radioStudent = findViewById(R.id.studentGroup);
        String student = ((RadioButton)findViewById(radioStudent.getCheckedRadioButtonId())).getText().toString();
        String conditions = "";
        String id = encode(name);

        if (((CheckBox)findViewById(R.id.check1)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check1)).toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check1)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check1)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check2)).toString();
            } else {
                conditions += ", " + ((CheckBox) findViewById(R.id.check2)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check3)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check3)).toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check3)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check4)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check4)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check4)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check5)).isChecked()) {
            if (conditions.equals("")) {
                conditions = (findViewById(R.id.check5)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check5)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check6)).isChecked()) {
            if (conditions.equals("")) {
                conditions = (findViewById(R.id.check6)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check6)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check7)).isChecked()) {
            if (conditions.equals("")) {
                conditions = (findViewById(R.id.check7)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check7)).toString();
            }
        } else if (((CheckBox)findViewById(R.id.check8)).isChecked()) {
            if (conditions.equals("")) {
                conditions = (findViewById(R.id.check8)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check8)).toString();
            }
        } else {
            if (conditions.equals("")) {
                conditions = (findViewById(R.id.check9)).toString();
            } else {
                conditions += ", " + (findViewById(R.id.check9)).toString();
            }
        }


        if (!TextUtils.isEmpty(name)) {
            UserInfo user = new UserInfo(name, age, gender, student, conditions);
            db.collection("users_info").document(id).set(user);

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

            Toast.makeText(this, "User info added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter in field", Toast.LENGTH_LONG).show();
        }


    }
}
