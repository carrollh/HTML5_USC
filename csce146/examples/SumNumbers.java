import java.util.Scanner;

public class SumNumbers {
	public static final int arraySize = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		int[] myNumbers = new int[arraySize];
		Scanner Keyboard = new Scanner(System.in);

		for (int i = 0; i < arraySize; i++) {
			myNumbers[i] = Keyboard.nextInt();
		}
		PrintSum(myNumbers);
	}
	public static void PrintSum(int[] myLocalArray){
		int sum = 0;
		for (int i = 0; i < myLocalArray.length; i++) {
			sum += myLocalArray[i];
		}
		System.out.println("Sum = " + sum);
	}
}
