
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* The following program opens a file, reads from it, then closes the stream
 * and prints whatever was found on the first line of the file.
 * 
 * It uses the Scanner class to do all file parsing, so the commands should 
 * be familiar to you. This program assumes a file with the name "input.txt"
 * exists in the same folder as the compiled executable. It also assumes that 
 * this file contains at least some contents. If it does not a 
 * NoSuchElementException will be thrown. That Exception has not been handled in 
 * the code below, to keep this example cleaner.
 * 
 * Note: whenever you create a new File class object you must be prepared to 
 * handle a FileNotFoundException using a try/catch[/finally] statement as shown.
 */
public class FileInput {
	
	public static void main(String[] args) {
		
		try {
			Scanner file = new Scanner(new File("input.txt"));
			String input = file.nextLine();
			file.close();
			
			System.out.println(input);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
