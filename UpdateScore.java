package wordsFreq;

public class UpdateScore {
	
	//score format - gameAgameBsetAsetBmatchAmatchB
	//eg-114531 where 31 indicates 40-15 
	static int score = 0;
	static boolean cont_game = true;
	public static void parseScore(String input)
	{
	    char[] scorers = input.toCharArray();
	    for(char scorer : scorers)
	    {
	        if(updateScore(scorer))
	        {
	            displayScore(score);
	        }
	        else
	        {
	        	System.out.println("Final Score");
	        	displayScore(score);
	        	break;
	        	
	        }
	        	
	        
	    }
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
	public static boolean updateScore(char winner)
	{
		incrementScore(winner);
		validateScore();
		validateGameScore();
		validateSetScore();
		return cont_game;
	}
	public static void incrementScore(char winner)
	{
		if(winner == 'A')
			score +=10;
		else
			score +=1;	
					
	}
	public static void validateScore()
	{
		
		int a_score= (score/10)%10;
		int b_score = score%10;
		
		if(a_score >= 4 && a_score-b_score>=2)			
		{
			score = (score/100)*100;
			score = score+1000;
			validateGameScore();
		}
		else if(b_score>=4 && b_score-a_score>=2)
		{
			score = (score/100)*100;
			score = score+100;
			validateGameScore();
		}
		else if(a_score==4 && b_score == 4)
		{	
			score = (score/100)*100;
			score += 33;
		}
			
	}
	public static void validateSetScore()
	{
		int a_set_score= (score/100000)%10;
		int b_set_score = (score/10000)%10;
		
		if(a_set_score >= 2 )			
		{
			cont_game = false;
		}
		else if(b_set_score>=2)
		{
			cont_game = false;
		}
	}
	public static void validateGameScore()
	{
		int a_game_score = (score/1000)%10;
		int b_game_score = (score/100)%10;
		
		if(a_game_score >=  6 && a_game_score-b_game_score>=2)			
		{
			score = (score/10000)*10000;
			score = score+100000;
			validateSetScore();
		}
		else if(b_game_score >= 6 && b_game_score-a_game_score>=2)
		{
			score = (score/10000)*10000;
			score = score+10000;
			validateSetScore();
		}
		else if(a_game_score==6 && b_game_score == 6)
		{	
			score = (score/10000)*10000;
			score += 5500;
		}
	}
	
	
	public static void main(String[] args) {
		String INPUT= "ABAAABBBABABAABBA";
		parseScore(INPUT);
		//System.out.println(score);
		//displayScore(score);
		//boolean a= updateScore('A');
		//System.out.println(score);
		//displayScore(score);
		//a= updateScore('B');
		//displayScore(score);
		//System.out.println(score);
		//a= updateScore('A');
		//displayScore(score);
		//System.out.println(score);
	}

}
