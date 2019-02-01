//Created by Terry Dorsey//
package Menus;

import fileIO.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OptionsMenu extends JFrame
{
	private static final long serialVersionUID = 1L;
	JButton mainMenuButton = new JButton();
	JButton addWordButton = new JButton();
	JButton deleteWordButton = new JButton();
	JTextField addWordField = new JTextField();
	JPanel bottomRight;
	
	JScrollPane someScrollPane = new JScrollPane();
		JList wordBank = new JList(FileInstantiation.getRandomWordArrList().toArray());//////////////////////////////
		
	GridBagConstraints gbc = new GridBagConstraints();
	
	public OptionsMenu(int xLocation, int yLocation)
	{
		//@todo: fix this
		this.setFocusable(false);///////////////////////////////////////
		JPanel overGrid = new JPanel();		
		JPanel mainGrid = new JPanel();
		JPanel returnButtonPanel = new JPanel();
		
		JPanel topLeft = new JPanel();
		JPanel topRight = new JPanel();
		JPanel bottomLeft = new JPanel();
		JPanel bottomRight = new JPanel();
	
		
		//define attributes
		addWordField.setPreferredSize(new Dimension(150, 20));
		addWordButton.setText("Add a word or phrase >");
		deleteWordButton.setText("Delete a word >");
		returnButtonPanel.setPreferredSize(new Dimension(500, 100));
		mainMenuButton.setText("Main Menu");
		
		//add elements to panels
		someScrollPane.getViewport().add(wordBank);
		wordBank.setFixedCellHeight(20);
		wordBank.setFixedCellWidth(200);
		
		//Layouts
		topLeft.setLayout(new GridBagLayout());
		topRight.setLayout(new GridBagLayout());
		bottomLeft.setLayout(new GridBagLayout());
		returnButtonPanel.setLayout(new GridBagLayout());
		
		topLeft.add(addWordButton);
		topRight.add(addWordField);
		bottomLeft.add(deleteWordButton);
		bottomRight.add(someScrollPane);
		returnButtonPanel.add(mainMenuButton); 
		
		//adding the 4 panels to the main layout
		mainGrid.setLayout(new GridLayout(2, 2, 3, 3));
		mainGrid.add(topLeft);
		mainGrid.add(topRight);
		mainGrid.add(bottomLeft);
		mainGrid.add(bottomRight);
		
		overGrid.setLayout(new GridBagLayout());
			gbc.gridx = 0;
			gbc.gridy = 0;
		overGrid.add(mainGrid, gbc);
			gbc.gridx = 0;
			gbc.gridy = 1;
		overGrid.add(returnButtonPanel, gbc);
		
		
		//this.setSize(500, 650);
		this.setResizable(false);
		this.setLocation(xLocation + 100, yLocation + 300);
		this.setVisible(true);
		
		//this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(overGrid);
		this.setTitle("Options");

		ListenForButton someButtonListener = new ListenForButton();
		
		mainMenuButton.addActionListener(someButtonListener);
		addWordButton.addActionListener(someButtonListener);
		deleteWordButton.addActionListener(someButtonListener);
		addWordField.addActionListener(someButtonListener);
		this.pack();
		
		
		//JRootPane someRootPane = new JRootPane();
		JRootPane someRootPane = this.getRootPane();
		//JRootPane someRootPane = SwingUtilities.getRootPane(this.addWordButton);
		someRootPane.setDefaultButton(this.addWordButton);
		System.out.println(someRootPane.getDefaultButton());
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
				new StartMenu(xLocation - 75, yLocation - 100);
				OptionsMenu.super.dispose();
				
			}
			else if (e.getSource() == addWordButton)
			{
				if(!(addWordField.getText().matches("[a-zA-Z ]*")))
				{
					JOptionPane.showMessageDialog(
						StartMenu.getOptionsMenuRef(),
						"Only Enter Letters", 
						"Warning", 
						JOptionPane.WARNING_MESSAGE);
					//System.out.println("Only use the Alphabet!\n Try again.");
				}
				else if(addWordField.getText().length() > 15)
				{
					JOptionPane.showMessageDialog(
						StartMenu.getOptionsMenuRef(),
						"Keep your word under 15 characters", 
						"Warning", 
						JOptionPane.WARNING_MESSAGE);
				}
					//if it dosn't contain letters
				else if((!(addWordField.getText().matches("[a-zA-Z].*"))))
				{
					JOptionPane.showMessageDialog(
						StartMenu.getOptionsMenuRef(),
						"Don't start your phrases with spaces, \nor leave the field blank", 
						"Warning", 
						JOptionPane.WARNING_MESSAGE);
				}
				else if(FileInstantiation.getRandomWordArrList().contains(addWordField.getText()))
				{
					JOptionPane.showMessageDialog(
						StartMenu.getOptionsMenuRef(),
						"You already have that word", 
						"Warning", 
						JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					FileInstantiation.writeNewWord(addWordField.getText());
					addWordField.setText("");
					
					wordBank = new JList(FileInstantiation.getRandomWordArrList().toArray());
					someScrollPane.getViewport().add(wordBank);//redraws list
				}
			}
			else if (e.getSource() == deleteWordButton)
			{
				int someIndex = wordBank.getSelectedIndex();
				String stringToDelete = (String) wordBank.getSelectedValue();
				FileInstantiation.deleteSomeWord(someIndex);
				wordBank = new JList(FileInstantiation.getRandomWordArrList().toArray());
				someScrollPane.getViewport().add(wordBank);//redraws list
			}
		}
	}
}
