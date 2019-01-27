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
	
	public void readFile()
	{
		//while(someScanner.hasNext())
		//{
			String a = someScanner.nextLine();
			System.out.println(a);
		//}
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
		
//		try
//		{
//			Scanner s = new Scanner(new File("WordBank.txt"));
//			ArrayList<String> list = new ArrayList<String>();
//			while (s.hasNext())
//			{
//			    list.add(s.next());
//			}
//			s.close();
//			System.out.println(list.get(0));
//		}
//		catch (Exception e)
//		{
//			System.out.println("shit");
//		}
//		
		//List<String> lines = FileUtils.readLines(new File("/path/to/file.txt"), "utf-8");
		
	}
	
}
