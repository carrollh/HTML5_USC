/* The following program shows an example of both
 * constants in Java, named MAX_GHOSTS with syntax:
 * "public static final <type> <identifier> = <value>;"
 * and a class-level variable, named Ghost.num_ghosts,
 * declared in a nested class.
 * 
 * This program specifically tries to create as many 
 * instances of the Ghost class as possible. It is limited
 * by the MAX_GHOSTS constant, in conjunction with a public 
 * static int Ghost.num_ghosts which is updated every time
 * a Ghost instance is created. One possible reason for this
 * would be to limit the amount of memory actually used by
 * a program. Other context sensitive reasons exist as well.
 * 
 * The point of this example would be to cap the possible 
 * number of Ghost class instances we could create with
 * our program. For more advanced versions of this you
 * can lookup the Factory and Singleton Design Patterns.
 * 
 * Note: The nested class Ghost could just as easily be 
 * turned into another normal class by cutting and pasting
 * it into another file, as was done in class. 
 * It is included here as a nested class so that this 
 * example can be given as a single java file.
 */
public class StaticKeyword1 {

	public static final int MAX_GHOSTS = 4;
	
	public static void main(String[] args) {
		
		while(true) {
			if(Ghost.num_ghosts < MAX_GHOSTS) {
				Ghost g = new Ghost();
			}
			else {
				break;
			}
		}
		
		System.out.println(Ghost.num_ghosts);
	}
	
	
	// Example of a static nested class. This was done to
	// save from needing to include multiple files for 
	// this example. 
	public static class Ghost {
		public static int num_ghosts = 0;
		
		public Ghost() {
			num_ghosts++;
		}
	}

}
