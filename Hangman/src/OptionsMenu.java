//Created by Terry Dorsey//
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OptionsMenu extends JFrame
{
	public OptionsMenu(int xLocation, int yLocation)
	{
		this.setSize(500, 250);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		JLabel filler = new JLabel("I'll do this in an update.");
		this.add(filler);
	}	
}
