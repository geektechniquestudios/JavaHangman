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
		ArrayList<String> arrayListToReturn = someFileManagement.readFile();
		someFileManagement.closeFile();
		
			return arrayListToReturn;
	}
	
	public static void deleteSomeWord(int indexOfWordToDelete)
	{
		ArrayList<String> listForNewFile = new ArrayList<String>();
		FileManagement someFileManagement = new FileManagement();
		someFileManagement.openFile();
		ArrayList<String> listOfCurrentFile = someFileManagement.readFile();
		
		listOfCurrentFile.remove(indexOfWordToDelete);
		
		//System.out.println(wordToDelete);
//		String y;
//		for (int x = 0; x < listOfCurrentFile.size(); x++)
//		{
//			String[] a = listOfCurrentFile.toArray(new String[0]);
//			//y = listOfCurrentFile.get(x);
//			if(a[x] != wordToDelete)
//			{
//				System.out.println(a[x]);
//				System.out.println(listOfCurrentFile.get(x));
//				System.out.println(wordToDelete);
//				listForNewFile.add(listOfCurrentFile.get(x));
//			}
//			if(a[x] == wordToDelete)
//			{
//				System.out.println("go to bed");
//			}
//		}
		
		
		
		
//		int z = 0;
//		for(String x : listOfCurrentFile.toArray(new String[0]))
//		{
//			z++;
//			if(x != wordToDelete)
//			{
//				listForNewFile.add(listOfCurrentFile.get(z));
//			}
//		}
		
		
		someFileManagement.writeCleanToFile(listOfCurrentFile);
	}
}