package builders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameOverFrame
{
	private static JFrame gameOverFrame;
	private static JLabel gameOverLbl;
	private static JButton exitButton;
	private static JButton playAgainButton;
	public static void gameOverFrameBuilder()
	{
		gameOverFrame = new JFrame();
		gameOverFrame.setVisible(true);
		gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameOverFrame.setBounds(600, 300, 315, 350);
		gameOverFrame.getContentPane().setLayout(null);
		
		gameOverLbl = new JLabel("Game Over");
		gameOverLbl.setBounds(125, 40, 100, 100);
		gameOverLbl.setVisible(true);
		gameOverFrame.getContentPane().add(gameOverLbl);
		
		playAgainButton = new JButton("Play Again");
		playAgainButton.setBounds(110, 150, 100, 50);
		playAgainButton.setVisible(true);
		gameOverFrame.getContentPane().add(playAgainButton);
		playAgainButtonPressedCheck();
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(120, 250, 75, 50);
		exitButton.setVisible(true);
		gameOverFrame.getContentPane().add(exitButton);
		exitButtonPressedCheck();
	}
	
	public static void exitButtonPressedCheck()
	{
		exitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}});
	
	}
	
	public static void playAgainButtonPressedCheck()
	{
		playAgainButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			gameOverFrame.dispose();
			GameBuilder.buildField();
		}});
	
	}
}
