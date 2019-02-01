package Menus;
//Created by Terry Dorsey//
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOver extends JFrame
{
	private static final long serialVersionUID = 1L;
	JButton gameOverButton;
	GridBagConstraints gbc = new GridBagConstraints();

	
	public GameOver(int xLocation, int yLocation, String gameOverStatement)
	{
		this.setSize(800, 150);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocation(xLocation - 150, yLocation + 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("geekTechnique Hangman");
		this.validate();
		
		JPanel gameOverPanel = new JPanel();
		JLabel messageToSay = new JLabel();
		gameOverButton = new JButton("Play Again");

		Font gameOverFont = new Font("Helvetica", Font.PLAIN, 30);
	
		gameOverPanel.setLayout(new GridBagLayout());//will make pretty later when I work on options menu: gridbag
		messageToSay.setText(gameOverStatement);
		messageToSay.setFont(gameOverFont);
		
		ListenForButton someButtonListener = new ListenForButton();
		gameOverButton.addActionListener(someButtonListener);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gameOverPanel.add(messageToSay, gbc);//populating panel
		gbc.gridx = 0;
		gbc.gridy = 1;
		gameOverPanel.add(gameOverButton, gbc);
		
		this.add(gameOverPanel);
	}
	
	private class ListenForButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{////////////////////////////////////////////////////////////////////////////////////////////////
			int xLocation = GameOver.super.getX();
			int yLocation = GameOver.super.getY();
			new StartMenu(xLocation + 125, yLocation - 100);
			GameOver.super.dispose();
		}
	}
}