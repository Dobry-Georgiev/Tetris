package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import builders.FrameBuilder;
import builders.GameBuilder;

public class MainMenu
{
	JLabel gameNameLbl;
	JPanel mainMenuPanel;
	JButton startButton;
	
	public MainMenu()
	{
		frameNameBuilder();
		panelBuilder();	
		startButtonBuilder();
	}
	private void frameNameBuilder()
	{
		gameNameLbl = new JLabel("Tetris");
		gameNameLbl.setBounds(125, 40, 100, 100);
		gameNameLbl.setVisible(true);
	}
	private void panelBuilder()
	{
		mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(FrameBuilder.mainFrame.getBounds());
		mainMenuPanel.setLayout(null);
		FrameBuilder.mainFrame.add(mainMenuPanel);
		mainMenuPanel.add(gameNameLbl);
	}
	private void startButtonBuilder()
	{
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
