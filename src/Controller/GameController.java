package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JLabel;

import builders.FrameBuilder;
import program.status.GameStatus;

public class GameController
{
	private static JLabel currentObject = new JLabel();
	private static LinkedList<JLabel> objects = new LinkedList<>();
	private static int currentObjectRow = 0;
	private static int currentObjectColumn;
	static boolean closeT = false;
	public static void gameStart()
	{
		startDropping();
	}
	private static void startDropping()
	{
		createRandomObject();

		objectStartFalling();
	}
	private static void createRandomObject()
	{
		//Creates only one type for now
		currentObject = new JLabel("█");
		currentObject.setFont(new Font("Serif", Font.PLAIN, 40));
		currentObject.setBounds(20, -200, 40, 40);
		FrameBuilder.mainFrame.getContentPane().add(currentObject);
		objects.add(currentObject);
	}
	
	private static void objectStartFalling()
	{
		
		ActionListener objectsDropper = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	
	        	
	        	dropObjectOneRowDown();
	        	printFieldOnConsole();
	        	fieldUpdate();
	        	if(currentObjectRow >= 19 || currentObjectHasCollided())
	        	{
	        		createRandomObject();
	        		currentObjectRow = 0;
	        	}
	                
	        }
	    };
	    javax.swing.Timer t = new javax.swing.Timer(1* 200, objectsDropper);
	    t.start();
		 
	}
	private static void dropObjectOneRowDown()
	{
		currentObjectColumn = getCurrentObjectColumn();
		
		
		currentObject.setBounds(20, currentObjectRow*39, 100, 100);
		
		currentObject.repaint();
        FrameBuilder.mainFrame.repaint();
        FrameBuilder.mainFrame.getContentPane().repaint();
        currentObjectRow ++;
		
	}
	private static void printFieldOnConsole()
	{
		for(int k = 0; k< GameStatus.field.length; k++) 
		{
			for(int j= 0; j< GameStatus.field[0].length; j++) 
			{
				System.out.print(GameStatus.field[k][j]);
			}
			System.out.println();
		}
        System.out.println();
        System.out.println();
        System.out.println();
	}
	private static boolean currentObjectHasCollided()
	{
		if(GameStatus.field[currentObjectRow+1][currentObjectColumn] == 1)
			return true;
		if(currentObjectRow >= 19)
			return true;
		
		return false;
	}
	private static void fieldUpdate()
	{
		if(currentObjectRow - 1 >=0)
			GameStatus.field[currentObjectRow-1][currentObjectColumn] = 0;
		
		GameStatus.field[currentObjectRow][currentObjectColumn] = 1;
		
	}
	
	private static int getCurrentObjectColumn()
	{
		int x = currentObject.getX();
		if(x >=0 && x <30)
		{
			return 0;
		}else if(x >=30&& x <60)
		{
			return 1;
		}else if(x >=30&& x <60)
		{
			return 2;
		}else if(x >=60&& x <90)
		{
			return 3;
		}else if(x >=90&& x <120)
		{
			return 4;
		}else if(x >=120&& x <150)
		{
			return 5;
		}else if(x >=150&& x <180)
		{
			return 6;
		}else if(x >=180&& x <210)
		{
			return 7;
		}else if(x >=210&& x <240)
		{
			return 8;
		}else if(x >=240&& x <270)
		{
			return 9;
		}else if(x >=270)
		{
			return 10;
		}
		return -1;
	}
}
