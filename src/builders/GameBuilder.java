package builders;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GameController;

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
		FrameBuilder.mainFrame.setBounds(600, 0, 315, 1000);
		FrameBuilder.mainFrame.getContentPane().setLayout(null);
		GameController.gameStart();
	}
	
}
