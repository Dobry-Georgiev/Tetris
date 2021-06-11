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
	JButton settingsMenuButton;
	JButton exitButton;
	
	public MainMenu()
	{
		frameNameBuilder();
		panelBuilder();	
		startButtonBuilder();
		settingsMenuButtonBuilder();
		exitButtonBuilder();
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
	private void settingsMenuButtonBuilder()
	{
		settingsMenuButton = new JButton("Settings");
		settingsMenuButton.setBounds(105, 260, 90, 20);
		settingsMenuButton.setVisible(true);
		mainMenuPanel.add(settingsMenuButton);
		settingsMenuButtonPressedCheck();
	}
	private void exitButtonBuilder()
	{
		exitButton = new JButton("Exit");
		exitButton.setBounds(110, 320, 80, 20);
		exitButton.setVisible(true);
		mainMenuPanel.add(exitButton);
		exitButtonPressedCheck();
	}
	public void startButtonPressedCheck()
	{
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GameBuilder.buildField();
				
			}
		});
		
	}
	public void exitButtonPressedCheck()
	{
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}});
		
	}
	public void settingsMenuButtonPressedCheck()
	{
		settingsMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SettingsMenu settignsMenu = new SettingsMenu();
				
			}
		});
		
	}

}
