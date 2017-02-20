package com.codingblocks.gdg_hunt;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Naman on 18-02-2017.
 */

public class dbHelper {
    ArrayList<TreasureLocation> db;
    PathPref pathPref;
    ScorePref scorePref;
    int current, score ;

    public void createDummydb(Context context)
    {
        pathPref = new PathPref(context);
        current=pathPref.getPath();
        scorePref = new ScorePref(context);
        score = scorePref.getScore();

        db = new ArrayList<>();

        db.add(new TreasureLocation("LT-3","What's my name?", 123, 0)); //rand 2,3,4,5

        db.add(new TreasureLocation("Gate 1","Address?", 123, 6));
        db.add(new TreasureLocation("Gate 2","email?", 123, 6));
        db.add(new TreasureLocation("Gate 3","location?", 123, 7));
        db.add(new TreasureLocation("Audi","crap?", 123, 7));

        db.add(new TreasureLocation("Rakshak Bhawan","running out of ideas?", 123, 8));
        db.add(new TreasureLocation("Cafe","Long way?", 123, 8));

        db.add(new TreasureLocation("Rajiv Chowk","what does the fox say?", 123, 0)); //rand 9,10

        db.add(new TreasureLocation("A2Z","shhhhhh?", 123, 11));
        db.add(new TreasureLocation("Temple","omega gamma?", 123, 12));
        db.add(new TreasureLocation("Mission Vision","doraemom?", 123, 13));
        db.add(new TreasureLocation("Firehose Cabinet","kiteretsu?", 123, 13));

        db.add(new TreasureLocation("Bike no","pokemon?", 123, 0)); //rand 14,15

        db.add(new TreasureLocation("G11","DBZ?", 123, 16));
        db.add(new TreasureLocation("TS9","beyblade?", 123, 16));

        db.add(new TreasureLocation("COPAC","chota bheem?", 123, 17));

        db.add(new TreasureLocation("CL-1","pingu?", 123, 100));
    }

    public TreasureLocation get()
    {
        return db.get(current-1);
    }

    public int moveToNext()
    {
        //Record last location
        int temp = current;
        //Get the next location
        current = get().getNext();

        //Check if we need randomize
        if(current == 0)
            current = random(temp);

        Log.d("gdg_hunt", "Moving to=" + current);
        pathPref.setPath(current);
        scorePref.setScore(++score);
        return current;
    }

    private int random(int type)
    {
        //type indicates the level

        Random rn = new Random();
        int val;
        switch(type)
        {
            case 1:
                val = 2 + rn.nextInt(4);
                break;
            case 8:
                val = 9 + rn.nextInt(2);
                break;
            case 13:
                val = 14 + rn.nextInt(2);
                break;
            default:
                val = -1;
        }
        Log.d("gdg_hunt","After dynamic rotation=" + val);
        pathPref.setPath(val);
        return val;
    }
}
