/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    private static int score;
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		displayScore(121214);
	}
	
	public static void parseScore(String input)
	{
	    char[] scorers = input.toCharArray();
	    for(char scorer : scorers)
	    {
	        if(!updateScore(scorer))
	        {
	            displayScore(score);
	        }
	    }
	    System.out.println("Final Score");
	    displayScore(score);
	}
	
	public static void displayScore(int inputScore)
	{
	    String[] points = {"0","15","30","40","A"};
	    int setScoreA = inputScore/100000;
	    inputScore=inputScore%100000;
	    int setScoreB = inputScore/10000;
	    inputScore = inputScore%10000;
	    int gameScoreA = inputScore/1000;
	    inputScore = inputScore%1000;
	    int gameScoreB = inputScore/100;
	    inputScore = inputScore%100;
	    String pointsA = points[inputScore/10];
	    inputScore = inputScore%10;
	    String pointsB = points[inputScore];
	    System.out.println("  Set   Game   Points");
	    System.out.println("A  "+setScoreA+"      "+gameScoreA+"      "+pointsA);
	    System.out.println("B  "+setScoreB+"      "+gameScoreB+"      "+pointsB);
	    
	    
	}
}