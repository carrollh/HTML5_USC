/********* SLList.java ************************************************************ 
 * The following class is as simple an implementation of a Singly Linked List
 * data structure as I can muster, while still being moderately safe. This version
 * stores Object instances, and does NOT use the power of Generics.
 * It requires the use of a private inner SLLNode class, which it uses to store 
 *vdata and provide basic data structure capability. 
 * A .main method is included at the bottom and acts as a driver for the only
 * implemented methods - .add() and .toString().
 */

public class SLList {
	SLLNode head = null;	// pointer to the head Node, oce it exists
	
	// No-arg constructor (not technically needed...)
	public SLList() {
		
	}
	
	/**
	 * Method used to add a new Node to the end of the list. It 
	 * makes that new Node the first node if head is null, otherwise
	 * it adds it to the end.
	 * @param o
	 */
	public void add(Object o) {
		SLLNode temp = new SLLNode(o);
		if(head != null) {
			this.lastNode().next = temp;
		}
		else {
			head = temp;
		}
	}
	
	/**
	 * Helper method that walks the entire data structure from the
	 * head Node to the end Node and returns that Node. 
	 * Note: this method returns null if the SLList has not had any
	 * data added to it.
	 * Called by the .add method so that the added Node can become the
	 * last Node's "next" node.
	 * @return
	 */
	private SLLNode lastNode() {
		if(head != null) {
			SLLNode temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			
			return temp;
		}
		
		return null;
	}
	
	/**
	 * Returns a String consisting of "SLList: [ item0, item1, ... ]"
	 */
	@Override
	public String toString() {
		String output = "SLList: [ ";
			
		if(head != null) {
			SLLNode temp = head;
			output += temp.data.toString();
			
			while(temp.next != null) {
				temp = temp.next;
				output += ", " + temp.data.toString();
			}
		}
		output += " ]";
		return output;
	}
	
	/**
	 * Node class for the SLList class above. It stores whatever 
	 * data is needed stored, and has a SLLNode pointer to the 
	 * next node in the data structure.
	 * @author carro_000
	 *
	 */
	private class SLLNode {
		
		Object data = null;
		SLLNode next = null;
		
		private SLLNode(Object data) {
			this.data = data;
		}
	}

	/**
	 * Driver for our SLList class.
	 * @param args Command line arguments. We don't use these 
	 * for this example
	 */
	public static void main(String[] args) {
		
		SLList sll = new SLList();
		
		sll.add("foo");
		sll.add("bar");
		
		System.out.println(sll);
	}
}
