/**
 * TestDie.java
 *
 *
 * Created: Wednesday September 19 15:27:28 2012
 *
 * @author <a href="mailto:huhns@CSE-ANGUILLA"></a>
 * @version
 */

public class TestDie{
    public TestDie() {
    }
    
    public static void main(String[] args) {
		System.out.println("Testing the Die Class");
		Die d1 = new Die();
		Die d2 = new Die();
		int r1 = d1.roll();
		int r2 = d2.roll();
		System.out.println("You rolled a " + r1 + " and a " + r2);
		ShowDie sd1 = d1.display(0, 0);
		ShowDie sd2 = d2.display(110, 0);
		int total = r1 + r2;
		if (total == 7) System.out.println("You win!");
		else if (total == 2) System.out.println("Snake eyes");
		else System.out.println("Try again");
    }
} // TestDie
