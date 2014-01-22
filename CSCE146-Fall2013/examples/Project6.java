
public class Project6 {

	public static void main(String[] args) {
		ListArray list1 = new ListArray();
		
		short[] array = { 7, 26, 15, 236, 27, 995 };
		ListArray list2 = new ListArray(array);
		System.out.println(list2);				// should print 7 26 15 27 995
		
		System.out.println(list2.equals(list1)); // should return false
		
		ListArray list3 = new ListArray(list2);
		System.out.println(list3.equals(list2)); // should return true
		System.out.println(list2.equals(list3)); // should return true
		
		System.out.println(list2.get(2));		// should print 15
		System.out.println(list3.get(2));		// should print 15
		
		System.out.println(list3.size());		// should print 6
		
		if(list1.isEmpty()) {
			for(int i = 0; i < list2.size(); i++) {
				list1.add(list2.get(i));
			}
		}
		
		System.out.println(list2.equals(list1)); // should return true
		System.out.println(list1);	// should print 7 26 15 236 27 995
		list1.remove(3);
		System.out.println(list1); // should print 7 26 15 27 995

		list2.remove(2);
		System.out.println(list2); // should print 7 26 236 27 995
		
		list3.remove(1);
		System.out.println(list3); // should print 7 15 236 27 995
		
		list1.add(list1.indexOf((short)995), (short)-1); 
		System.out.println(list1); // should print 7 26 15 27 -1 995
		
		if(list1.contains((short)-1)) 
			System.out.println("list1 does not contain all positive numbers");
		else 
			System.out.println("list1 contains all positive numbers");
	}
}
