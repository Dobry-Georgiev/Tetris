package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
	private static int currentObjectColumn = 0;
	private static int currentObjectX = 0;
	private static int currentObjectY = 0;
	static boolean closeT = false;
	static boolean hasMovedLeft = false;
	static boolean hasMovedRight = false;
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
	        	keyPressEvent();
	        	fieldUpdate();
	        	if(currentObjectRow >= 19 || currentObjectHasCollided())
	        	{
	        		createRandomObject();
	        		currentObjectRow = 0;
	        		currentObjectColumn = 8;
	        		currentObjectX = 240;
	        		currentObjectY = 0;
	        		printFieldOnConsole();
	        	}
	        }
	    };
	    javax.swing.Timer t = new javax.swing.Timer(1* 200, objectsDropper);
	    t.start();
		 
	}
	private static void dropObjectOneRowDown()
	{
		
		
		currentObjectY += 39;
		currentObject.setBounds(currentObjectX, currentObjectY, 100, 100);
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
		
		//GameStatus.field[currentObjectRow][currentObjectColumn] = 1;
		
		if(hasMovedLeft && currentObjectColumn-1 >=0)
		{
			if(currentObjectColumn+1 <= 9)
				GameStatus.field[currentObjectRow][currentObjectColumn+1] = 0;
			
		//	GameStatus.field[currentObjectRow][currentObjectColumn-1] = 1;
			hasMovedLeft = false;
			currentObjectX -= 30;
			currentObjectColumn --;
			System.out.println("left");
		}else
		if(hasMovedRight&& currentObjectColumn+1 <= 9)
		{
			if(currentObjectColumn-1 >= 0)
				GameStatus.field[currentObjectRow][currentObjectColumn-1] = 0;
			
			//GameStatus.field[currentObjectRow][currentObjectColumn+1] = 1;
			hasMovedRight = false;
			currentObjectX += 30;
			currentObjectColumn ++;
			System.out.println("right");
		}else 
		{
			GameStatus.field[currentObjectRow][currentObjectColumn] = 1;
			
		}
		
		
	}
	
	 private static void keyPressEvent() 
	 {
		 FrameBuilder.mainFrame.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {
             }

             @Override
             public void keyPressed(KeyEvent e)
             {
        		 	if(e.getKeyCode() == 37)
        		 		hasMovedLeft = true;
        		 	
        		 	if(e.getKeyCode() == 39)
        		 		hasMovedRight = true;
             }

             @Override
             public void keyReleased(KeyEvent e) {
             }
         });

		
	 }

	}
