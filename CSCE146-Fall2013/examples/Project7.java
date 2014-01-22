
public class Project7 {
	/**
	 * Driver for our DLList class.
	 * @param args Command line arguments. We don't use these 
	 * for this example
	 */
	public static void main(String[] args) {
		
		DLList dll = new DLList();
		
		dll.add("foo"); System.out.println(dll);
		System.out.println("contains \"foo\"? " + dll.contains("foo"));
		dll.add("bar"); System.out.println(dll);
		dll.add("blah"); System.out.println(dll);
		dll.add(1, "Hello"); System.out.println(dll);
		dll.add(2, "World"); System.out.println(dll);
		
		System.out.println("dll: " + dll);
		DLList other = new DLList();
		other.add("foo");
		other.add("Hello");
		other.add("World");
		other.add("bar");
		other.add("blah");
		
		System.out.println("other: " + other);
		
		System.out.println("dll == other? " + dll.equals(other));
		
		other.remove(); System.out.println("remove()");
		System.out.println("dll: " + dll);
		System.out.println("other: " + other);
		System.out.println("dll == other? " + dll.equals(other));
		
		dll.remove(); System.out.println(dll);
		dll.remove(2); System.out.println(dll);
	}
}
