package com.codingblocks.gdg_hunt;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DravitLochan on 07-02-2017.
 */

public class PathPref {
    SharedPreferences pref;
    Context context;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE=0;
    private static final String PREF_NAME="gdg-hunt-path";
    private static final String PATH_NUMBER="pathNumber";
    private static final String IS_PATH_SET="IsPathSet";
    private static final String QUESTION="Question";

    public PathPref(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }

    public void setPath(int  p)
    {
        int x=p;
        editor.putInt(PATH_NUMBER,x);
        editor.putBoolean(IS_PATH_SET,true);
        editor.commit();
    }

    public int getPath()
    {
        return pref.getInt(PATH_NUMBER,1);
    }

    public boolean isPathSet()
    {
        return pref.getBoolean(IS_PATH_SET,false);
    }

    public void setQuestion(String question)
    {
        editor.putString(QUESTION,question);
        editor.commit();
    }


    public String getQuestion()
    {
        return pref.getString(QUESTION," ");
    }

}
