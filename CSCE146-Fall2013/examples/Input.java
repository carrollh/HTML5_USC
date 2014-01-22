import java.util.Scanner;


public class Input {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int MyInt=0;
		double MyDouble=0.0;
		
		Scanner Keyboard = new Scanner (System.in);
		
		System.out.print("Please enter an Int and a Double:");
		
		MyInt = Keyboard.nextInt();
		MyDouble = Keyboard.nextDouble();
		
		System.out.println("You entered: " + MyInt + " " + MyDouble);

	}

}
