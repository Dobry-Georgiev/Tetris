package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JLabel;

import builders.FrameBuilder;
import models.ObjectTypes;
import models.objectModels;
import program.status.GameStatus;

public class GameController
{
	private static JLabel currentObject = new JLabel();
	private static LinkedList<JLabel> objects = new LinkedList<>();
	private final static int objectStartY = -30;
	private static int currentObjectRow = 0;
	private static int currentObjectColumn = 0;
	private static int currentObjectX = 0;
	private static int currentObjectY = -30;
	static boolean hasMovedLeft = false;
	static boolean hasMovedRight = false;
	private static ObjectTypes objectType;
	private static javax.swing.Timer t;
	private static JLabel score = new JLabel("0");
	private static JLabel name = new JLabel("nickname");
	
	public static void gameStart()
	{
		startDropping();
	}
	private static void startDropping()
	{
		if(GameStatus.checkFullColumn()) {
			gameOver();
		}
		
		createRandomObject();

		objectStartFalling();
		
	}
	private static void createRandomObject()
	{
		objectSetRandomX();
		currentObjectRow = 0;
		currentObjectY = objectStartY;
		currentObject = new JLabel(objectModels.Cube);
		currentObject.setFont(new Font("Serif", Font.PLAIN, 30));
		currentObject.setBorder(null);
		currentObject.setBounds(currentObjectX, objectStartY, 500, 100);
		currentObject.setSize(10,200);
		
		name.setBounds(20, 800, 100, 20);
		name.setBorder(null);
		
		JLabel textScore = new JLabel("Score: ");
		textScore.setBounds(20, 830, 50, 20);
		textScore.setBorder(null);
		
		score.setBounds(70, 830, 30, 20);
		score.setBorder(null);
		
		FrameBuilder.mainFrame.getContentPane().add(currentObject);
		FrameBuilder.mainFrame.getContentPane().add(name);
		FrameBuilder.mainFrame.getContentPane().add(textScore);
		FrameBuilder.mainFrame.getContentPane().add(score);
		
		objects.add(currentObject);
		objectSetRandomColor();
		hasMovedLeft = false;
		hasMovedRight = false;
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
	        		printFieldOnConsole();
	        		scoreChange();
	        	}
	        	if(200 - objects.size()*2>=100)
	        	t.setDelay(200 - objects.size()*2);
	        	
	        }
	    };
	    t	= new javax.swing.Timer(1* 200, objectsDropper);
	    t.start();
		 
	}
	
	private static void scoreChange() {
		int temp = Integer.parseInt(score.getText())+2;
		score.setText(Integer.toString(temp));
	}
	
	private static void dropObjectOneRowDown()
	{
		currentObjectY += 30;
		currentObject.setBounds(currentObjectX, currentObjectY, 500, 100);
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
		}
		else
		if(hasMovedRight&& currentObjectColumn+1 <= 9)
		{
			if(currentObjectColumn-1 >= 0)
				GameStatus.field[currentObjectRow][currentObjectColumn-1] = 0;
			
			//GameStatus.field[currentObjectRow][currentObjectColumn+1] = 1;
			hasMovedRight = false;
			currentObjectX += 30;
			currentObjectColumn ++;
			System.out.println("right");
		}
		else 
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
	 private static void objectSetRandomX()
	 {
		 int randX = (int)Math.floor(Math.random()*(9+1)+0);
			switch(randX)
			{
			case 0:
				currentObjectX = 0;
				currentObjectColumn = 0;
				break;
			case 1:
				currentObjectX = 30;
				currentObjectColumn = 1;
				break;
			case 2:
				currentObjectX = 60;
				currentObjectColumn = 2;
				break;
			case 3:
				currentObjectX = 90;
				currentObjectColumn = 3;
				break;
			case 4:
				currentObjectX =120;
				currentObjectColumn = 4;
				break;
			case 5:
				currentObjectX = 150;
				currentObjectColumn = 5;
				break;
			case 6:
				currentObjectX = 180;
				currentObjectColumn = 6;
				break;
			case 7:
				currentObjectX = 210;
				currentObjectColumn = 7;
				break;
			case 8:
				currentObjectX = 240;
				currentObjectColumn = 8;
				break;
			case 9:
				currentObjectX = 270;
				currentObjectColumn= 9;
				break;
			
			}
	 }
	 private static void objectSetRandomColor() 
	 {
		 int randColor = (int)Math.floor(Math.random()*(7+1)+0);
			switch(randColor)
			{
			case 0:
				currentObject.setForeground(Color.GREEN);
				break;
			case 1:
				currentObject.setForeground(Color.RED);
				break;
			case 2:
				currentObject.setForeground(Color.YELLOW);
				break;
			case 3:
				currentObject.setForeground(Color.BLUE);
				break;
			case 4:
				currentObject.setForeground(Color.ORANGE);
				break;
			case 5:
				currentObject.setForeground(Color.pink);
				break;
			case 6:
				currentObject.setForeground(Color.BLACK);
				break;
			case 7:
				currentObject.setForeground(Color.LIGHT_GRAY);
				break;

			}
	 }
	 
	 private static void gameOver() {
		 System.out.println("end");
	 }
	 
	}
