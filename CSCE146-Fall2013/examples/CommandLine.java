/* The following program just prints what ever was passed via command line
 * back out to console. If nothing was passed in, it informs the user of that.
 * For example, running the following program using 
 * "java CommandLine Hello World" would result in a the words "Hello" and "World" 
 * appearing on two separate lines. 
 * 
 * In Eclipse, you can test this by selecting from the menu Run > Run Configurations.
 * Next click on the Arguments tab in the middle and type in "Hello World" (without 
 * the quotes). You should test the program without setting the arguments first.
 */
public class CommandLine {
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			for(int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}	
		}
		else {
			System.out.println("No arguments were passed via command line.");
		}
		
	}

}
