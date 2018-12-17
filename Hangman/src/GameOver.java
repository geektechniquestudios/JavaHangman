//Created by Terry Dorsey//
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOver extends JFrame
{
	private static final long serialVersionUID = 1L;
	JButton gameOverButton;

	public GameOver(int xLocation, int yLocation, String gameOverStatement)
	{
		this.setSize(800, 150);
		this.setResizable(true);
		this.setVisible(true);
		this.setLocation(xLocation + 100, yLocation + 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("geekTechnique Hangman");
		this.validate();
		
		JPanel gameOverPanel = new JPanel();
		JLabel messageToSay = new JLabel();
		gameOverButton = new JButton("Play Again");

		Font gameOverFont = new Font("Helvetica", Font.PLAIN, 30);
	
		gameOverPanel.setLayout(new FlowLayout());//will make pretty later when I work on options menu: gridbag
		messageToSay.setText(gameOverStatement);
		messageToSay.setFont(gameOverFont);
		
		ListenForButton someButtonListener = new ListenForButton();
		gameOverButton.addActionListener(someButtonListener);
		
		gameOverPanel.add(messageToSay);//populating panel
		gameOverPanel.add(gameOverButton);
		this.add(gameOverPanel);
	}
	
	private class ListenForButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{////////////////////////////////////////////////////////////////////////////////////////////////
			new StartMenu();
			GameOver.super.dispose();
		}
	}
}