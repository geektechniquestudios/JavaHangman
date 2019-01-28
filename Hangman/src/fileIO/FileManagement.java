package fileIO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManagement 
{
	private Scanner someScanner;
	
	public void openFile()
	{
		try
		{
			someScanner = new Scanner
				(
					new File
					(
						"WordBank.txt"
						//System.getProperty("user.dir") + "/WordBank.txt"
					)
				);
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong!");
		}
	}
	
	public ArrayList<String> readFile()
	{
//		while(someScanner.hasNext())
//		{
//			String a = someScanner.nextLine();
//			//System.out.println(a);
//		}
		
		ArrayList<String> someList = new ArrayList<String>();
		while (someScanner.hasNext())
		{
		    someList.add(someScanner.nextLine());    
		}
		
		return someList;
	}
	
	public void closeFile()
	{
		someScanner.close();
	}
	
	public void writeToFile(String newWord)
	{
		try
		{
			BufferedWriter someWriter = new BufferedWriter
				(
					new FileWriter
						(
							"WordBank.txt", true
						)
				);
			someWriter.append("\n" + newWord);
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong!");
		}
	}
	public static void main(String[] args) 
	{
		//compiler threw errors without main. Why?
	}
}
