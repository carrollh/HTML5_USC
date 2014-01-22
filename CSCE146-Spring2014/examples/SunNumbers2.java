import java.util.Scanner;


public class SunNumbers2 {
	public static final int Size = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] myNumber1;
		int[] myNumber2;
		
		int sum = 0;
		Scanner Keyboard = new Scanner (System.in);
		myNumber1 = new int[Size];
		myNumber2 = new int[Size];
		
		for(int i=0; i < myNumber1.length; i++) {
			myNumber1[i] = i;
		}
		
		for(int i=0; i < myNumber2.length; i++) {
			myNumber2[i] = 9 - i;
		}
		
		PrintArray(myNumber1);
//		for(int i=0; i < myNumber1.length; i++){
//			System.out.print(myNumber1[i] + " ");
//		}
//		System.out.println();
		
		PrintArray(myNumber2);
//		for(int i=0; i < myNumber2.length; i++){
//			System.out.print(myNumber2[i] + " ");
//		}
//		System.out.println();
		
		myNumber2 = myNumber1;
		
		PrintArray(myNumber1);
		System.out.println("After assignment");
//		for(int i=0; i < myNumber1.length; i++){
//			System.out.print(myNumber1[i] + " ");
//		}
//		System.out.println();
		
		PrintArray(myNumber1);
//		for(int i=0; i < myNumber2.length; i++){
//			System.out.print(myNumber2[i] + " ");
//		}
//		System.out.println();		
//		
		
		System.out.println("After -200");
		
		PrintArray(myNumber1);
		myNumber1[4] = -200;
//		for(int i=0; i < myNumber1.length; i++){
//			System.out.print(myNumber1[i] + " ");
//		}
//		System.out.println();
		
		for(int i=0; i < myNumber2.length; i++){
			System.out.print(myNumber2[i] + " ");
		}
		System.out.println();		
		
		
	}
	public static void PrintArray(int[] localArray){
		for(int i=0; i < localArray.length; i++){
			System.out.print(localArray[i] + " ");
		}
		System.out.println();
	}

}
