package com.codingblocks.gdg_hunt;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Random;

/**
 * Created by DravitLochan on 07-02-2017.
 */

public class PathPref {
    SharedPreferences pref;
    Context context;
    SharedPreferences.Editor editor;

    int PRIVATE_MODE=0;
    private static final String PREF_NAME="gdg-hunt";
    private static final String PATH_NUMBER="pathNumber";
    private static final String IS_PATH_SET="IsPathSet";

    public PathPref(Context context)
    {
        this.context=context;
        pref=context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor=pref.edit();
    }

    public void setPath()
    {
        Random random = new Random();
        int x=random.nextInt(4);
        editor.putInt(PATH_NUMBER,x);
        editor.putBoolean(IS_PATH_SET,true);
        editor.commit();
    }

    public int getPath()
    {
        return pref.getInt(PATH_NUMBER,0);
    }

    public boolean isPathSet()
    {
        return pref.getBoolean(IS_PATH_SET,false);
    }
}
