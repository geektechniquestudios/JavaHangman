import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class TestClass 
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
			System.out.println("Well fuck");
		}
	}
	
	public void readFile()
	{
		while(someScanner.hasNext())
		{
			String a = someScanner.next();
			System.out.println(a);
		}
	}
	
	public void cloesFile()
	{
		someScanner.close();
	}
	
	public void writeToFile()
	{
		String someString = "Well Fuck";
		try
		{
			BufferedWriter someWriter = new BufferedWriter
				(
					new FileWriter
						(
							"WordBank.txt", true
						)
				);
			someWriter.append(" " + someString);
			someWriter.close();
		}
		catch(Exception e)
		{
			System.out.println(someString);
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
