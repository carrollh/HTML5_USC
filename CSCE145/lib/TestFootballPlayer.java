
// This file should NOT be changed.  If you see an error in this file,
// you need to alter one of your other Java classes

public class TestFootballPlayer {
	public static void main(String[] args) {
		System.out.println("Welcome to the Football Player Program \n");
		
// First set of tests
		System.out.print("Creating FootballPlayer...");
		FootballPlayer player1 = new FootballPlayer("Bob", 6, 8);
		System.out.println("Passed");
	
		System.out.print("Creating OffensivePlayer...");
		OffensivePlayer player2 = new OffensivePlayer("Sue", 128, 3, 88, 14);
		System.out.println("Passed");

		System.out.print("Creating DefensivePlayer...");
		DefensivePlayer player3 = new DefensivePlayer("Jill", 56, 2, 3, 4567);
		System.out.println("Passed");

		System.out.print("Creating QuarterBack...");
		QuarterBack player4 = new QuarterBack("Pat", 336, 13, 1300, 14, 555, 54.5);
		System.out.println("Passed");

// Second set of tests
		System.out.println("");
		
		System.out.print("Changing name of player1...");
		player1.setName("Jim");
		if((player1.getName()).equals("Jim"))
			System.out.println("Passed");
		else
			System.out.println("Failed");
			
		System.out.print("Changing name of player2...");
		player2.setName("John");
		if((player2.getName()).equals("John"))
			System.out.println("Passed");
		else
			System.out.println("Failed");
			
		System.out.print("Changing name of player3...");
		player3.setName("Jack");
		if((player3.getName()).equals("Jack"))
			System.out.println("Passed");
		else
			System.out.println("Failed");
			
		System.out.print("Changing name of player4...");
		player4.setName("Bert");
		if((player4.getName()).equals("Bert"))
			System.out.println("Passed");
		else
			System.out.println("Failed");
			
// Third set of tests
		System.out.println("");
		
		System.out.print("Changing games played of player1...");
		player1.setGamesPlayed(234);
		if(player1.getGamesPlayed() == 234)
			System.out.println("Passed");
		else
			System.out.println("Failed");
				
		System.out.print("Changing total yards of player2...");
		player2.setTotalYards(1300);
		if(player2.getTotalYards() == 1300)
			System.out.println("Passed");
		else
			System.out.println("Failed");		
		
		System.out.print("Changing number of tackles of player3...");
		player3.setNumberOfTackles(71);
		if(player3.getNumberOfTackles() == 71)
			System.out.println("Passed");
		else
			System.out.println("Failed");		
		
		System.out.print("Changing number of Interceptions thrown of player4...");
		player4.setInterceptionsThrown(29);
		if(player4.getInterceptionsThrown() == 29)
			System.out.println("Passed");
		else
			System.out.println("Failed");
			
// Printing out all player information
		System.out.println("\nPrinting Player Information");

		player1.display();
		System.out.println("");
		player2.display();
		System.out.println("");
		player3.display();
		System.out.println("");
		player4.display();
		System.out.println("");
			
		System.out.println("Thank you for using this program. Goodbye.");
	}
} // end of tester class