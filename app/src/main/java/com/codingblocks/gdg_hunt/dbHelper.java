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
    String question="Decode the given code to guess the Location !";
    public void createDummydb(Context context)
    {
        pathPref = new PathPref(context);
        current=pathPref.getPath();
        scorePref = new ScorePref(context);
        score = scorePref.getScore();

        db = new ArrayList<>();
//
        db.add(new TreasureLocation("G-9",question,"Description for this question", "G-9", 0));

        db.add(new TreasureLocation("Gate-1",question,"int main()\n" +
                "               {\n" +
                "                   printf(“71”);\n" +
                "                   printf(“65”);\n" +
                "                   printf(“84”);\n" +
                "                   printf(“69”);\n" +
                "                   printf(“49”);\n" +
                "return 0;\n" +
                "               }", "Gate 1", 6));
        db.add(new TreasureLocation("Gate-2",question,"int main()\n" +
                "               {\n" +
                "                   printf(“71”);\n" +
                "                   printf(“65”);\n" +
                "                   printf(“84”);\n" +
                "                   printf(“69”);\n" +
                "                   printf(“50”);\n" +
                "return 0;\n" +
                "               }", "Gate 2", 6));
        db.add(new TreasureLocation("Gate-3",question,"int main()\n" +
                "               {\n" +
                "                   printf(“71”);\n" +
                "                   printf(“65”);\n" +
                "                   printf(“84”);\n" +
                "                   printf(“69”);\n" +
                "                   printf(“51”);\n" +
                "return 0;\n" +
                "               }", "Gate 3", 7));
        db.add(new TreasureLocation("Audi",question,"int main()\n" +
                "{\n" +
                "printf(“65”);\n" +
                "printf(“85”);\n" +
                "printf(“68”);\n" +
                "printf(“73”);\n" +
                "return 0;\n" +
                "}\n", "Audi", 7));

        db.add(new TreasureLocation("Hogwards",question,"Near photocopy shop, You'll find a gate to Hogwards. Find a ride to the next spot.", "Hogwards", 8));
        db.add(new TreasureLocation("Ambulance",question,"#include<conio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "  int i;\n" +
                "  clrscr();\n" +
                "   for(i=6;i<=30;i+=2)\n" +
                "  {\n" +
                "    gotoxy(i,10);\n" +
                "    printf(\"*\");\n" +
                "  }\n" +
                "  for(i=10;i>=6;i--)\n" +
                "  {\n" +
                "    gotoxy(30,i);\n" +
                "    printf(\"*\");\n" +
                "  }\n" +
                "   for(i=30;i>=6;i-=2)\n" +
                "  {\n" +
                "    gotoxy(i,6);\n" +
                "    printf(\"*\");\n" +
                "  }\n" +
                "    for(i=6;i<=10;i++)\n" +
                "  {\n" +
                "    gotoxy(6,i);\n" +
                "    printf(\"*\");\n" +
                "  }\n" +
                "    for(i=6;i<=15;i+=2)\n" +
                "  {\n" +
                "    gotoxy(i,10);\n" +
                "    printf(\"*\");\n" +
                "  }\n"+
                "for(i=10;i<=15;i++)\n" +
                "    {\n" +
                "     gotoxy(15,i);\n" +
                "     printf(\"*\");\n" +
                "    }\n" +
                "     for(i=15;i<=22;i++)\n" +
                "    {\n" +
                "     gotoxy(i,15);\n" +
                "     printf(\"*\");\n" +
                "    }\n" +
                "   for(i=15;i>=2;i--)\n" +
                "    {\n" +
                "     gotoxy(22,i);\n" +
                "     printf(\"*\");\n" +
                "    }\n" +
                "    for(i=22;i>=15;i--)\n" +
                "    {\n" +
                "     gotoxy(i,2);\n" +
                "     printf(\"*\");\n" +
                "    }\n" +
                "    for(i=2;i<=10;i++)\n" +
                "    {\n" +
                "     gotoxy(15,i);\n" +
                "     printf(\"*\");\n" +
                "    }\n" +
                "\n" +
                "  getch();\n" +
                "  return 0;\n" +
                "}\n", "Ambulance", 8));

        db.add(new TreasureLocation("cafe k neeche",question,"Find this location in our campus:\n" +
                "https://github.com/GDGJIITNOIDA/CodeHunt/blob/master/GDG.png", "Underground Staircase", 0));  // todo : add image

        db.add(new TreasureLocation("Laundry",question,"I am not a gossip but I get involved in everyone's dirty business. What am I?", "Laundry", 11));
        db.add(new TreasureLocation("CL-4",question,"In the memory of John McCarthy..", "CL-4", 12));   //todo : add name of scintist

        db.add(new TreasureLocation("F10","Calculate the number of errors and find the location","function(a,b){\n" +
                "int a=324,b=93;\n" +
                "const int f=10;\n" +
                "char h[10]; int c=12,d=90000;\n" +
                "char _q=‘a’;\n" +
                "long long int g[10000000000000000000]={0};\n" +
                "int e[]={35,36,37,38};\n" +
                "int g=++a+b++;\n" +
                "char -w=‘b’; char a=‘q’;\n" +
                "printf(“%c”,e[0]);\n" +
                "printf(“%d”,e[1]);\n" +
                "printf(“%d”,e[4]);\n" +
                "printf(“%d”,e[3])\n" +
                "printf(“%d”,e[2]);\n" +
                "scanf(“%s”,h);\n" +
                "for( ; ; ){f++;break;}\n" +
                "if(c>10)\n" +
                "{  if(d>50)\n" +
                "       {c++;}\n" +
                "   else\n" +
                "      {++c;}\n" +
                "  else\n" +
                "      {++d;}\n" +
                "}\n" +
                "if(d>>c)\n" +
                "d++;\n" +
                "return o;\n" +
                "}\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "int Marilyn=80;\n" +
                "int ruby; //This value is equal to number of errors in function()\n" +
                "printf(“%c”,Marilyn-ruby);\n" +
                "printf(“%d”,ruby);\n" +
                "return 0;\n" +
                "}\n", "F-10", 16));
        db.add(new TreasureLocation("RAKSHAK",question,"Yeh Ghar Hai Veer Jawano Ka\n" +
                "Albelon Ka Mastaano Ka\n" +
                "In veero Ka Yaaron…. Hoy!\n" +
                "In veero Ka Yaaron Kya Kehna\n" +
                "Yeh veer Hai College Ka Gehna\n", "Rakshak Bhawan", 13));

        db.add(new TreasureLocation("OAT",question,"One and only Oasis of Love in JIIT", "OAT", 0));

        db.add(new TreasureLocation("MANDIR",question,"#include<stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                " char s[10][10];\n" +
                " int i,j;\n" +
                "\n" +
                " for(i=0;i<9;i++)\n" +
                " {\n" +
                "   for(j=0;j<9;j++)\n" +
                "   {\n" +
                "   s[i][j]='*';\n" +
                "   }\n" +
                " }\n" +
                " for(i=0;i<4;i++){\n" +
                "   for(j=1;j<4;j++)\n" +
                "   {\n" +
                "   s[i][j]=' ';\n" +
                "   }\n" +
                " }\n" +
                " for(i=1;i<4;i++)\n" +
                " {\n" +
                "   for(j=5;j<9;j++)\n" +
                "   {\n" +
                "   s[i][j]=' ';\n" +
                "   }\n" +
                " }\n" +
                " for(i=5;i<8;i++)\n" +
                " {\n" +
                "   for(j=0;j<4;j++)\n" +
                "   {\n" +
                "   s[i][j]=' ';\n" +
                "   }\n" +
                " }\n" +
                "for(i=5;i<9;i++) {\n" +
                "   for(j=5;j<8;j++)\n" +
                "   {\n" +
                "   s[i][j]=' ';\n" +
                "   }\n" +
                " }\n" +
                " for(i=0;i<9;i++)\n" +
                " {\n" +
                "   for(j=0;j<9;j++)\n" +
                "   {\n" +
                "     printf(\"%c  \",s[i][j]);\n" +
                "   }\n" +
                "   printf(\"\\n\");\n" +
                " }\n" +
                "\n" +
                " getch();\n" +
                " return 0;\n" +
                "}\n", "Temple", 16));
        db.add(new TreasureLocation("MISSION VISION",question,"#include <stdio.h>\n" +
                "\n" +
                "int main() {\n" +
                "\tint i,j;\n" +
                "\tint letters[5][5]={{75,79,32,65,74},\n" +
                "\t\t\t   {67,82,87,73,66},\n" +
                "\t\t\t   {72,88,69,10,83},\n" +
                "\t\t\t   {68,86,80,78,89},\n" +
                "\t\t\t   {70,77,84,76,53}};\n" +
                "\t\n" +
                "    printf(\"%c\", letters[1][3]+5);\n" +
                "    printf(\"%c\", letters[0][4]-1);\n" +
                "    printf(\"%c\", letters[4][4]+30);\n" +
                "    printf(\"%c\", letters[4][3]+1);\n" +
                "    printf(\"%c\", letters[2][2]+10);\n" +
                "    printf(\"%c\", letters[2][1]-5);\n" +
                "    printf(\"%c\", letters[1][3]);\n" +
                "    printf(\"%c\", letters[0][2]);\n" +
                "    printf(\"%c\", letters[1][3]);\n" +
                "    printf(\"%c\", letters[3][4]-6);\n" +
                "    printf(\"%c\", letters[3][4]-11);\n" +
                "    printf(\"%c\", letters[1][3]);\n" +
                "    printf(\"%c\", letters[0][1]);\n" +
                "    printf(\"%c\", letters[3][2]+6);\n" +
                "    \n" +
                "    // rearrange the output to get the next location\n" +
                "\n" +
                "    return 0;\n" +
                "}\n", "Mission Vission", 16));

        db.add(new TreasureLocation("COPAC",question,"Is desh ke graduates jab apni 9-5 jobs se bore hone lagte hain ,\n" +
                "toh bahar nikalne ke liye keval 3 raste dikhte hain..... What’s the way other than MBA and IAS?\n", "COPAC", 17));

        db.add(new TreasureLocation("FLEX",question,"FINAL PROBLEM: An anomaly that was intentional, shall guide you the way", "G-9", 100));
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
                Log.e("tag",val+" ");
                break;
            case 8:
                val = 9 + rn.nextInt(2);
                Log.e("tag",val+" ");
                break;
            case 13:
                val = 14 + rn.nextInt(2);
                Log.e("tag",val+" ");
                break;
            default:
                val = -1;
        }
        Log.d("gdg_hunt","After dynamic rotation=" + val);
        pathPref.setPath(val);
        return val;
    }
}
