//Created by Terry Dorsey//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//I considered using the someJFrame.dispose(); method instead of opening a new window.
//Not sure if one way is "better" in terms of modern design, or resources but it seems arbitrary.

public class HangmanStartMenu extends JFrame
{
	private static final long serialVersionUID = 1L;//suggested code by eclipse. 
	
	JButton playGameButton,
			optionsButton;
	private JLabel mainLabel;
	
	public static void main(String[] args) 
	{
		HangmanStartMenu theStartMenu = new HangmanStartMenu();
	}

	public HangmanStartMenu()
	{
		this.setSize(800,700);//doesn't really matter because this.pack //only changes spawn location
		this.setLocationRelativeTo(null);//these just set up the window
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("geekTechnique Hangman");
		this.setResizable(false);
		
		playGameButton = new JButton("Start Game");
		optionsButton = new JButton("Options");
		mainLabel = new JLabel();
		
		mainLabel.setIcon
		(
			new ImageIcon(getClass().getResource("/ImageAssets/hangman8.png"))
		);
		
		JPanel somePanel = new JPanel();
		somePanel.setLayout(new BorderLayout());
		somePanel.add(playGameButton, BorderLayout.WEST);
		somePanel.add(optionsButton, BorderLayout.EAST);
		somePanel.add(mainLabel, BorderLayout.CENTER);
		
		this.add(somePanel);
		this.pack();
		this.validate();//perhaps unnecessary
		
		ListenForButton someButtonListener = new ListenForButton();
		
		playGameButton.addActionListener(someButtonListener);
		optionsButton.addActionListener(someButtonListener);
	}
	
	private class ListenForButton implements ActionListener//can I implement more than one interface on the same class? 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == playGameButton)
			{
				int xLocation = HangmanStartMenu.super.getX();//ugh, these feel like bad form. I want something
				int yLocation = HangmanStartMenu.super.getY();//... more like theStartMenu.getX();
				ActualGame theGameWindow = new ActualGame(xLocation, yLocation);
				//theStartMenu.dispose();//why can't I call this instead?
				HangmanStartMenu.super.dispose();
				
			}
			else if(e.getSource() == optionsButton)
			{
				int xLocation = HangmanStartMenu.super.getX();
				int yLocation = HangmanStartMenu.super.getY();
				new OptionsMenu(xLocation, yLocation);
				HangmanStartMenu.super.setVisible(false);
			}
		}
	}
}