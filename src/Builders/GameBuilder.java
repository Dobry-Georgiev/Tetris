package Builders;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;

public class GameBuilder 
{
	static JPanel gamePanel;
	public static void buildField()
	{
		
		FrameBuilder.mainFrame.getContentPane().removeAll();
		FrameBuilder.mainFrame.getContentPane().repaint();
		FrameBuilder.mainFrame.dispose();
		FrameBuilder.mainFrame = new JFrame();
		FrameBuilder.mainFrame.setVisible(true);
		FrameBuilder.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameBuilder.mainFrame.setBounds(600, 0, 300, 1000);
		FrameBuilder.mainFrame.getContentPane().setLayout(null);
		JLabel testLabel = new JLabel("Game test");
		testLabel.setBounds(125, 40, 100, 100);
		FrameBuilder.mainFrame.getContentPane().add(testLabel);
		GameController.gameStart();
	}
	
}
