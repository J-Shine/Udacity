package com.example.android.reportcard;

import androidx.annotation.NonNull;

public class Grade {
    private String mName; private String mEnglish; private String mHistory;
    private String mMath;

    public Grade(String name, String english, String history, String math){
        mName = name; mEnglish = english; mHistory = history;
        mMath = math;
    }
    public String getName(){
        return mName;
    }
    public void setName(String name){
        mName = name;
    }
    public String getEnglishGrade(){
        return mEnglish;
    }
    public void setEnglishGrade(String grade){
        mEnglish = grade;
    }
    public String getHistoryGrade(){
        return mHistory;
    }
    public void setHistoryGrade(String grade){
        mHistory = grade;
    }
    public String getMathGrade(){
        return mMath;
    }
    public void setMathGrade(String grade){
        mMath = grade;
    }

}
