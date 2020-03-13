package com.example.android.reportcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String toString(String name, String english, String history, String math) {
        return "" + name + english + history + math;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Grade> grade = new ArrayList<>();
        grade.add(new Grade("Peter", "B-", "C+", "A0"));
        grade.add(new Grade("Angelic", "C0", "A-", "A+"));
        grade.add(new Grade("Eliot", "A-", "B+", "B0"));
        grade.add(new Grade("Anna", "C-", "C-", "C0"));
        grade.add(new Grade("Kristine", "C+", "A+", "D0"));

        for(int index = 0; index < grade.size(); index++){
            Log.v("MainActivity", toString((grade.get(index)).getName(), (grade.get(index)).getEnglishGrade(),
                    (grade.get(index)).getHistoryGrade(), (grade.get(index)).getMathGrade()));
        }

    }

}

