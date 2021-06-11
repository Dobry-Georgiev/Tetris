package menus;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import builders.FrameBuilder;
import controller.GameController;

public class SettingsMenu
{
	private JButton musicButton;
	public SettingsMenu()
	{
		FrameBuilder.mainFrame.getContentPane().removeAll();
		FrameBuilder.mainFrame.getContentPane().repaint();
		FrameBuilder.mainFrame.dispose();
		FrameBuilder.mainFrame = new JFrame();
		FrameBuilder.mainFrame.setVisible(true);
		FrameBuilder.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameBuilder.mainFrame.setBounds(600, 0, 300, 1000);
		FrameBuilder.mainFrame.getContentPane().setLayout(null);
		JLabel testLabel = new JLabel("Settings");
		testLabel.setBounds(125, 40, 100, 100);
		FrameBuilder.mainFrame.getContentPane().add(testLabel);
		musicButtonBuilder();
	}
	private void musicButtonBuilder()
	{
		musicButton = new JButton("Music");
		musicButton.setBounds(110, 320, 80, 20);
		musicButton.setVisible(true);
		FrameBuilder.mainFrame.getContentPane().add(musicButton);

	}
}
