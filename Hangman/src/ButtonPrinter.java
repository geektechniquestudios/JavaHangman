//Created by Terry Dorsey//
public class ButtonPrinter {
	//this will make my life easier by generating code related to my keyboard buttons
	public static void main(String[] args) 
	{
		char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		for(int x = 0; x < 26; x++)//tried the enhanced for and it printed out numbers? Too busy to mess with it
		{
			//System.out.println("but" + alphabet[x] + " = new JButton(\"" + alphabet[x] + "\");");
			//System.out.println("but" + alphabet[x] + ".addActionListener(keyboardListener);");
			//System.out.println("case \"but" + alphabet[x] + "\":\n\tbut" + alphabet[x] + ".setEnabled(false);\n\tbreak;");
		}	
	}
}
