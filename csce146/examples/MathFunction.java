import java.util.Scanner;

public class MathFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double A_Number = 0.0;
		double Result = 0.0;

		Scanner Keyboard = new Scanner(System.in);

		System.out.print("Please enter a real number: ");
		A_Number = Keyboard.nextDouble();

		Result = Math.pow(A_Number, 2);
		System.out.println("Result = " + Result);

		Result = Math.sqrt(A_Number);
		if (A_Number >= 0) {
			System.out.println("Result = " + Result);
		}
		else {
			System.out.println("The number you entered is negative!");
		}
		System.out.println(A_Number >= 0);
	}
}
