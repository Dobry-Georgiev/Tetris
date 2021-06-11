package builders;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameBuilder 
{
	public static JFrame mainFrame;
	public static void buildFrame()
	{
		mainFrame = new JFrame("Tetris");
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(600, 0, 300, 1000);
	}

}
