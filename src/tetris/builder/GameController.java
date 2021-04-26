package tetris.builder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;

public class GameController
{
	private static int y = 0;
	public static void gameStart()
	{
		startDropping();
	}
	
	private static void startDropping()
	{
		JLabel object = new JLabel("█");

		object.setFont(new Font("Serif", Font.PLAIN, 40));
		object.setBounds(20, 5, 100, 100);
		FrameBuilder.mainFrame.getContentPane().add(object);

		ActionListener taskPerformer = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	                System.out.println("Hello!");
	                y+=35;
	    			object.setBounds(20, y, 100, 100);
	                object.repaint();
	                FrameBuilder.mainFrame.repaint();
	                FrameBuilder.mainFrame.getContentPane().repaint();

	        }
	    };
	    javax.swing.Timer t = new javax.swing.Timer(1* 900, taskPerformer);
		for(int i = 0; i < 20; i++)
		{
			
			object.repaint();
		    t.setRepeats(true);
		    t.start();
		    t.restart();
		}
	}
	
	
}
