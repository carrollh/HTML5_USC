import java.util.Scanner;


public class Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a, b;
		a = b = 0.0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Please enter two real numbers: ");
		a = keyboard.nextDouble();
		b = keyboard.nextDouble();
		
		System.out.println(a + " + " + b + " = " + (a+b));

	}

}
