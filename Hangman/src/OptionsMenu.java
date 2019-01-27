//Created by Terry Dorsey//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OptionsMenu extends JFrame
{
	JButton mainMenuButton = new JButton();
	JButton addWordButton = new JButton();
	JButton deleteWordButton = new JButton();
	JTextField addWordField = new JTextField();
	
	public OptionsMenu(int xLocation, int yLocation)
	{
		JPanel overGrid = new JPanel();		
		JPanel mainGrid = new JPanel();
		JPanel returnButtonPanel = new JPanel();
		
		JPanel topLeft = new JPanel();
		JPanel topRight = new JPanel();
		JPanel bottomLeft = new JPanel();
		JPanel bottomRight = new JPanel();
		
		
		//create elements
		
		//JButton mainMenuButton = new JButton();
		//JList wordBank = new JList(GameLogic.wordBank);
		
		
		//define attributes
		addWordField.setPreferredSize(new Dimension(150, 20));
		addWordButton.setText("Add a word >");
		deleteWordButton.setText("Delete a word >");
		
		mainMenuButton.setText("Main Menu");
		
		//add elements to panels
		topLeft.add(addWordButton);
		topRight.add(addWordField);
		bottomLeft.add(deleteWordButton);
		//bottomRight.add(wordBank);
		returnButtonPanel.add(mainMenuButton); 
		
		//adding the 4 panels to the main layout
		mainGrid.setLayout(new GridLayout(2, 2, 3, 3));
		mainGrid.add(topLeft);
		mainGrid.add(topRight);
		mainGrid.add(bottomLeft);
		mainGrid.add(bottomRight);
		
		overGrid.setLayout(new GridLayout(0, 1, 3, 3));
		overGrid.add(mainGrid);
		overGrid.add(returnButtonPanel);
		
		
		this.setSize(500, 250);
		this.setResizable(false);
		this.setLocation(xLocation + 100, yLocation + 300);
		this.setVisible(true);
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(overGrid);
	
		//this.add(mainMenuButton);
		//this.add(filler);	
		
		ListenForButton someButtonListener = new ListenForButton();
		
		mainMenuButton.addActionListener(someButtonListener);
		addWordButton.addActionListener(someButtonListener);
		deleteWordButton.addActionListener(someButtonListener);
		addWordField.addActionListener(someButtonListener);
	}	
	
	private class ListenForButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == mainMenuButton)
			{
				int xLocation = OptionsMenu.super.getX();
				int yLocation = OptionsMenu.super.getY();
				new StartMenu(xLocation - 100, yLocation - 300);
				OptionsMenu.super.dispose();
				
			}
			else if (e.getSource() == addWordButton)
			{
				FileInstantiation.writeNewWord(addWordField.getText());
			}
			else if (e.getSource() == deleteWordButton)
			{
				
			}
		}
	}
	
}
