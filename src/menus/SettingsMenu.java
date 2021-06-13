package menus;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import builders.FrameBuilder;
import controller.GameController;
import program.status.GameStatus;

public class SettingsMenu
{
	private JButton musicButton;
	private JLabel musicCheckBox;
	private JButton closeSettingsMenu;
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
		JLabel settingsLbl = new JLabel("Settings");
		settingsLbl.setBounds(125, 40, 100, 100);
		FrameBuilder.mainFrame.getContentPane().add(settingsLbl);
		closeSettingsMenuButtonBuilder();
		musicButtonBuilder();
		musicCheckBoxBuilder();
	}
	private void closeSettingsMenuButtonBuilder()
	{
		closeSettingsMenu = new JButton("Close");
		closeSettingsMenu.setBounds(100, 500, 80, 20);
		closeSettingsMenu.setVisible(true);
		FrameBuilder.mainFrame.getContentPane().add(closeSettingsMenu);
		closeSettingsMenuPressedCheck();
	}
	private void musicButtonBuilder()
	{
		musicButton = new JButton("Music");
		musicButton.setBounds(60, 200, 80, 20);
		musicButton.setVisible(true);
		FrameBuilder.mainFrame.getContentPane().add(musicButton);
		musicButtonPressedCheck();
	}
	
	private void musicCheckBoxBuilder()
	{
		if (musicCheckBox != null)
		{
			FrameBuilder.mainFrame.getContentPane().remove(musicCheckBox);
		}
		musicCheckBox = new JLabel();
		musicCheckBox.setBounds(180, 185, 130, 50);
		musicCheckBox.setVisible(true);
		FrameBuilder.mainFrame.getContentPane().add(musicCheckBox);
		String path;
		if (GameStatus.musicStatus)
		{
			path = "Images/checkboxFilled.png";
		}
		else
		{
			path = "Images/checkboxEmpty.png";
		}
		ImageIcon iconLogo = new ImageIcon(path);
		Image image = iconLogo.getImage();
		Image newimg = image.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
		iconLogo = new ImageIcon(newimg);
		musicCheckBox.setIcon(iconLogo);
	}
	
	public void musicButtonPressedCheck()
	{
		musicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GameStatus.musicStatus)
				{
					GameStatus.musicStatus = false;
					System.out.println("Music Off");
					musicCheckBoxBuilder();
				}
				else
				{
					GameStatus.musicStatus = true;
					System.out.println("Music On");
					musicCheckBoxBuilder();
				}
			}});
	}
	
	public void closeSettingsMenuPressedCheck()
	{
		closeSettingsMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				FrameBuilder.mainFrame.getContentPane().removeAll();
				FrameBuilder.mainFrame.getContentPane().repaint();
				FrameBuilder.mainFrame.dispose();
				FrameBuilder.buildFrame();
				MainMenu mainMenu = new MainMenu();
			}});
	}
}
