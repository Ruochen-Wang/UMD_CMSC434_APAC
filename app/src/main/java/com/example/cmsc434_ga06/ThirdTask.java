package com.example.cmsc434_ga06;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        retrieve();

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
                saveInfo();
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
                conditions = ((CheckBox)findViewById(R.id.check1)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check1)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check2)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check2)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox) findViewById(R.id.check2)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check3)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check3)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check3)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check4)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check4)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox) findViewById(R.id.check4)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check5)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox) findViewById(R.id.check5)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check5)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check6)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox) findViewById(R.id.check6)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check6)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check7)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox) findViewById(R.id.check7)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox) findViewById(R.id.check7)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check8)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check8)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check8)).getText().toString();
            }
        }

        if (((CheckBox)findViewById(R.id.check9)).isChecked()) {
            if (conditions.equals("")) {
                conditions = ((CheckBox)findViewById(R.id.check9)).getText().toString();
            } else {
                conditions += ", " + ((CheckBox)findViewById(R.id.check9)).getText().toString();
            }
        }


        if (!TextUtils.isEmpty(name)) {
            UserInfo user = new UserInfo(name, age, gender, student, conditions);
            db.collection("users_id").document(id).set(user);

            String STORAGE_NAME = "mySharedPreferences";
            SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("name", name);
            editor.putString("age", age);
            editor.putString("gender", gender);
            editor.putString("student", student);
            editor.putString("conditions", conditions);

            editor.apply();

            Toast.makeText(this, "User info added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter in field", Toast.LENGTH_LONG).show();
        }


    }

    public void retrieve() {
        String STORAGE_NAME = "mySharedPreferences";
        SharedPreferences sharedPreferences = getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "");
        String age = sharedPreferences.getString("age", "");
        String gender = sharedPreferences.getString("gender", "");
        String student = sharedPreferences.getString("student", "");
        String conds = sharedPreferences.getString("conditions", "");

        setupUI(name, age, gender, student, conds);
    }

    protected void setupUI(String name, String age, String gender, String student, String conds) {
        EditText nameText = (EditText)findViewById(R.id.name);
        EditText ageText = (EditText)findViewById(R.id.age);
        RadioButton male = (RadioButton) findViewById(R.id.radio1);
        RadioButton female = (RadioButton) findViewById(R.id.radio2);
        RadioButton other = (RadioButton) findViewById(R.id.radio3);
        RadioButton prefer = (RadioButton) findViewById(R.id.radio4);
        CheckBox check1 = (CheckBox)findViewById(R.id.check1);
        CheckBox check2 = (CheckBox)findViewById(R.id.check2);
        CheckBox check3 = (CheckBox)findViewById(R.id.check3);
        CheckBox check4 = (CheckBox)findViewById(R.id.check4);
        CheckBox check5 = (CheckBox)findViewById(R.id.check5);
        CheckBox check6 = (CheckBox)findViewById(R.id.check6);
        CheckBox check7 = (CheckBox)findViewById(R.id.check7);
        CheckBox check8 = (CheckBox)findViewById(R.id.check8);
        CheckBox check9 = (CheckBox)findViewById(R.id.check9);


        RadioButton yes = (RadioButton) findViewById(R.id.yes);
        RadioButton no = (RadioButton) findViewById(R.id.no);

        nameText.setText(name);
        ageText.setText(age);

        // check if radio is checked for gender question
        if (gender.contains("Male")) {
            male.setChecked(true);
        } else if (gender.contains("Female")) {
            female.setChecked(true);
        } else if (gender.contains("Other")) {
            other.setChecked(true);
        } else if (gender.contains("Prefer Not To Say")){
            prefer.setChecked(true);
        } else {
            male.setChecked(true);
            female.setChecked(true);
            other.setChecked(true);
            prefer.setChecked(true);
        }

        // check if radio is checked for student question
        if (student.contains("Yes")) {
            yes.setChecked(true);
        } else if (student.contains("No")) {
            no.setChecked(true);
        } else {
            yes.setChecked(false);
            no.setChecked(false);
        }

        // check if checkbutton is checked for conditions
        check1.setChecked(false);
        check2.setChecked(false);
        check3.setChecked(false);
        check4.setChecked(false);
        check5.setChecked(false);
        check6.setChecked(false);
        check7.setChecked(false);
        check8.setChecked(false);
        check9.setChecked(false);

        if (conds.contains("Snoring")) {
            check1.setChecked(true);
        }

        if (conds.contains("Sleep Apnea")) {
            check2.setChecked(true);
        }

        if (conds.contains("Insomnia")) {
            check3.setChecked(true);
        }

        if (conds.contains("Restless Leg Syndrome (RLS)")) {
            check4.setChecked(true);
        }

        if (conds.contains("Narcolepsy")) {
            check5.setChecked(true);
        }

        if (conds.contains("Circadian Rhythm Disorders")) {
            check6.setChecked(true);
        }

        if (conds.contains("Chronic Fatigue Syndrome")) {
            check7.setChecked(true);
        }

        if (conds.contains("Night Terrors")) {
            check8.setChecked(true);
        }

        if (conds.contains("Other")) {
            check9.setChecked(true);
        }

    }
}
