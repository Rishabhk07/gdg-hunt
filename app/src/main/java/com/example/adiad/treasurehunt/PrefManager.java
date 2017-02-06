package com.example.adiad.treasurehunt;


import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;


    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "TREASURE HUNT DATA";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String DISPLAY_CODE=" ";
    private static final String QUESTION_NUMBER="question_number";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setQuestionNumber(int qn)
    {
        editor.putInt(QUESTION_NUMBER,qn);
        editor.commit();
    }

    public int getQuestionNumber()
    {
        return pref.getInt(QUESTION_NUMBER,1);
    }

    public String getDisplayCode()
    {
        return pref.getString(DISPLAY_CODE, "bhakk bc");
    }

    public void setDisplayCode(String code)
    {
        editor.putString(DISPLAY_CODE,code);
        editor.commit();
    }
}
