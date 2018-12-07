//Created by Terry Dorsey//
import java.util.ArrayList;
import java.util.Random;

public class GameLogic 
{
	static ArrayList<String> wordBank = new ArrayList<String>();
	
	public static String getRandomWord()
	//will add the ability to add words in options once I get the file object down,
	{	
		wordBank.add("Apple");
		wordBank.add("Fish");
		wordBank.add("Shirt");
		wordBank.add("Mississippi");
		wordBank.add("using spaces");
		wordBank.add("Software");
		//wordBank.remove(#); is how you delete stuff
		//will make a Jtextfield to accept input in options
		//will use file object or servlet to store words
		Random randomNumGen = new Random();
		int randomWordIndex = randomNumGen.nextInt(wordBank.size()) + 0;
		String randomWord = wordBank.get(randomWordIndex);// maybe just put return on the left side of this statement
		
		return randomWord;
	}
	
	public static boolean[] checkArrayForMatches(String currentWord, char charToTest)//this generates a boolean array in response to the user's guess against the current word
	{
	
		String upperCaseCurretWord = currentWord.toUpperCase();
		char[] currentWordArray = upperCaseCurretWord.toCharArray();
		boolean[] returnArray = new boolean[currentWordArray.length];
		
		for(int x = 0; x < returnArray.length; x++)
		{
			char characterInArray = currentWordArray[x];
			if(characterInArray == charToTest)
			{
				returnArray[x] = true;
			}
			else 
			{
				returnArray[x] = false;
			}		
		}
 		return returnArray;
	}
	
	public static boolean doesArrayContainATrue(boolean[] someBoolArray)
	{
		for (boolean x : someBoolArray)
		{
			if(x == true) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean doesArrayContainUnderscores(char[] someCharArray)
	{
		for(char x : someCharArray)
		{
			if(x == '_')
			{
				return true;
			}	
		}
		return false;
	}
}