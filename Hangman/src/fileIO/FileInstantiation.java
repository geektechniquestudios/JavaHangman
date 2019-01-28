package fileIO;

import java.util.ArrayList;

public class FileInstantiation 
{
	FileManagement someFileManagement;
	
	public static void writeNewWord(String wordToAdd)
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.writeToFile(wordToAdd);
	}
	
	public static ArrayList<String> getRandomWordArrList()
	{
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openFile();
		return someFileManagement.readFile();
	}
	
//	public static void main(String[] args)
//	{
//		FileManagement r = new FileManagement();
//		
//		r.readFile();r.openFile();
//		r.closeFile();
//		r.writeToFile("hope this works");
//	}
}
