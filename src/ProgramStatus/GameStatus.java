package ProgramStatus;

public class GameStatus 
{
	public static boolean gameStarted;
	public static int[][] field = new int[20][5];
	
	
	public static void generateField()
	{
		for(int i = 0; i<= field[0].length; i++) 
		{
			for(int j= 0; j<= field[1].length; j++) 
			{
				field[i][j] = 0;
			}
			
		}
	}
}
