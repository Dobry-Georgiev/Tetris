package Builders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu
{
	JLabel gameNameLbl;
	JPanel mainMenuPanel;
	JButton startButton;
	
	public MainMenu()
	{
		gameNameLbl = new JLabel("Tetris");
		gameNameLbl.setBounds(125, 40, 100, 100);
		gameNameLbl.setVisible(true);
		
		mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(FrameBuilder.mainFrame.getBounds());
		mainMenuPanel.setLayout(null);
		FrameBuilder.mainFrame.add(mainMenuPanel);
		mainMenuPanel.add(gameNameLbl);
		
		startButton = new JButton("Start Game");
		startButton.setBounds(100, 200, 100, 20);
		startButton.setVisible(true);
		mainMenuPanel.add(startButton);
		
		startButtonPressedCheck();
	}
	
	public void startButtonPressedCheck()
	{
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GameBuilder.buildField();
				
			}
		});
		
	}

}
