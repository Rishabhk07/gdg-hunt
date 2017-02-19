package com.codingblocks.gdg_hunt;

import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.WebView;

/**
 * Created by DravitLochan on 19-02-2017.
 */

public class ScorePref {

    SharedPreferences pref;
    Context context;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE=1;
    final String prefName = "gdg-hunt-score";
    final String SCORE = "score";

    ScorePref(Context context)
    {
        this.context = context;
        pref = context.getSharedPreferences(prefName,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setScore(int score)
    {
        editor.putInt(SCORE,score);
        editor.commit();
    }

    public int getScore()
    {
        return pref.getInt(SCORE,0);
    }

}
