package program.status;	

public class GameStatus 
{
	public static boolean gameStarted;
	public static int[][] field = new int[20][10];
	public static boolean musicStatus = false;

	public static void generateField()
	{
		for(int i = 0; i< field.length; i++) 
		{
			for(int j= 0; j< field[0].length; j++) 
			{
				field[i][j] = 0;
			}
			
		}
	}
	
	public static boolean checkFullColumn() {
		for(int i = 0; i < 10;i++)
		{
			if (field[2][i] == 1)
			{
				return true;
			}
		}
		return false;
	}
}
