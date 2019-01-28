
public class FileInstantiation {

	public static void writeNewWord(String wordToAdd)
	{
		FileManagement r = new FileManagement();
		r.writeToFile(wordToAdd);
	}
	
	public static void main(String[] args)
	{
		FileManagement r = new FileManagement();
		r.openFile();
		r.readFile();
		r.closeFile();
		r.writeToFile("hope this works");
	}
}
