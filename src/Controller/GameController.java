package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JLabel;

import builders.FrameBuilder;

public class GameController
{
	private static int currentObjectY = 0;
	private static JLabel currentObject = new JLabel();
	private static LinkedList<JLabel> objects = new LinkedList<>();
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
		currentObject.setBounds(20, 5, 100, 100);
		FrameBuilder.mainFrame.getContentPane().add(currentObject);
		objects.add(currentObject);
	}
	
	private static void objectStartFalling()
	{
		ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	                System.out.println("Cube Down!!");
	                currentObjectY+=35;
	    			currentObject.setBounds(20, currentObjectY, 100, 100);
	    			currentObject.repaint();
	                FrameBuilder.mainFrame.repaint();
	                FrameBuilder.mainFrame.getContentPane().repaint();

	        }
	    };
	    javax.swing.Timer t = new javax.swing.Timer(1* 900, taskPerformer);
		for(int i = 0; i < 20; i++)
		{
			currentObject.repaint();
		    t.start();
		}
	}
	
	
}
