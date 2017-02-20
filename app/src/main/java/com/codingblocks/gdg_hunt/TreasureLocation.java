package com.codingblocks.gdg_hunt;

/**
 * Created by Naman on 18-02-2017.
 */

public class TreasureLocation {
    String location;
    String question;
    int pass;
    int next;

    public TreasureLocation(String location, String question, int pass, int next)
    {
        this.location = location;
        this.question = question;
        this.pass = pass;
        this.next = next;
    }

    public int getNext()
    {
        return next;
    }

    public int getPass()
    {
        return pass;
    }

    public String getQ()
    {
        return question;
    }

}
