import java.util.Scanner;
import java.util.Random;

public class Loops {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int NumberOfTimes = 0;
		double MyRand = 0.0;
		Scanner Keyboard = new Scanner(System.in);
		Random MyRandomGenerator = new Random();

		System.out
				.print("Enter the number of random numbers to be generated: ");
		NumberOfTimes = Keyboard.nextInt();

		int i =0;
		while(i < NumberOfTimes){
			MyRand = MyRandomGenerator.nextDouble()*10-5;
			System.out.println(i + ":" + MyRand);
			i--;
		}
	
		System.out.println(i);
	}

}
