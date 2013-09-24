import java.util.Scanner;

public class Conditional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i = 0, j = 0;

		Scanner Keyboard = new Scanner(System.in);

		i = Keyboard.nextInt();
		j = Keyboard.nextInt();
//
//		if ((i < 5) && (j > 20)) {
//			System.out.println("Conditions satisfied");
//		}

//		if ((i < 5) && (j > 20)) {
//			System.out.println("Conditions satisfied");
//		} else {
//			System.out.println("Conditions not satisfied");
//		}
//		if (i < 0) {
//			System.out.println("i < 0");
//		} else if (i < 10) {
//			System.out.println("i >= 0 and i < 10");
//		} else {
//			System.out.println("i >= 10");
//		}
//
		switch (i) {
		case 1:
			System.out.println("i = 1");
		case 2:
			System.out.println("i = 2");
			break;
		case 3:
			break;
		case 4:
			System.out.println("i = 3 or i = 4");
			break;
		default:
			System.out.println("Something here");
			break;
		}
	}

}
