import java.util.Arrays;

/** ListArray.java
 * A simplified implementation of the java.util.ArrayList class
 * that only allows 2byte or smaller integer values to be stored. 
 * 
 * @author Heath Carroll
 * @email carrollh@email.sc.edu
 * @date 10/15/2013
 */
public class ListArray {
	private short [] data;
	
	private int size = 0;
	
	/**
	 * Returns the number of elements in this list.
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public ListArray() {
		data = new short[10];
	}
	
	/**
	 * Constructs an new ListArray with data that is equivalent to an 
	 * array that is passed to the constructor
	 * @param data
	 */
	public ListArray(short[] data) {
		this.data = data;
		size = data.length; // this assumes your array is full when passed in...
	}
	
	/**
	 * Constructs an new ListArray that is a deep copy of a passed
	 * in ListArray
	 * @param that
	 */
	public ListArray(ListArray that) {
		data = new short[that.size()];
		size = that.size();
		for(int i = 0; i < that.size(); i++){
			data[i] = that.get(i);
		}
	}
	
	/**
	 * Appends the specified value to the end of this list.
	 * @param value
	 */
	public void add(short value) {
		if(data.length >= size) resizeUp();
		
		data[size++] = value;
	}
	
	/**
	 * Inserts the specified value at the specified position in this list.
	 * @param index
	 * @param value
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, short value) throws IndexOutOfBoundsException {
		
		// if we try to insert outside the end of the array, break
		if(index >= size) throw new IndexOutOfBoundsException();
		else {
			// check to see if we need to expand the array in 
			// order to insert a single element
			short[] temp; 
			if(data.length <= size) temp = new short[data.length * 2];
			else temp = new short[data.length];
			
			// copy over up to index - 1
			for(int i = 0; i < index; i++) 
				temp[i] = data[i];
			
			// insert the new value at index
			temp[index] = value;
				
			// copy over the remaining elements in data from 
			// data[index] onward
			for(int j = index; j < size + 1; j++) 
				temp[j + 1] = data[j];
			
			size++;
			data = temp;
		}
	}
	
	/**
	 * Returns the value at the specified position in this list.
	 * @param index
	 * @return
	 */
	public short get(int index) {
		return data[index];
	}
	
	/**
	 * Private helper method to resize the data array whenever the
	 * max capacity is reached.
	 */
	private void resizeUp() {
		short[] temp = new short[data.length * 2];
		
		for(int i = 0; i < data.length; i++)
			temp[i] = data[i];
		
		data = temp;
	}
	
	/**
	 * Removes the value at the specified position in this list.
	 * @param index
	 * @return
	 */
	public short remove(int index) {
		short[] temp;
		if(size - 1 <= data.length / 4) 
			temp = new short[data.length / 2];
		else temp = new short[data.length];
		
		// copy over up to index
		for(int i = 0; i < index; i++) 
			temp[i] = data[i];
		
		short removed = data[index];
		
		// copy over the remaining elements in data from 
		// data[index + 1] onward
		for(int j = index; j < size - 1; j++) 
			temp[j] = data[j + 1];
		
		data = temp;
		size--;
		return removed;
	}
	
	/**
	 * Returns true if this list contains the specified value.
	 * @param value
	 * @return
	 */
	public boolean contains(short value) {
		for(short element : data) {
			if(element == value) return true;
		}
		return false;
	}
	
	/**
	 * Returns the index of the first occurrence of the specified 
	 * value in this list, or -1 if this list does not contain that value.
	 * @param value
	 * @return
	 */
	public int indexOf(short value) {
		for(int i = 0; i < size; i++) {
			if(data[i] == value) return i;
		}
		return -1;
	}
	
	/**
	 * Returns true if this list contains no values.
	 * @return
	 */
	public boolean isEmpty() {
		if(size() == 0) return true;
		return false;
	}
	
	@Override
	/**
	 * Returns a string representation of this ListArray
	 */
	public String toString() {
		String output = "";
		for(int i = 0; i < size; i++) 
			output += data[i] + " ";
		return output;
	}
	
	@Override
	/**
	 * Compares the specified object with this list for 
	 * equality. Returns true if and only if both lists 
	 * have the same size, and all corresponding pairs of 
	 * values in the two lists are equal.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListArray other = (ListArray) obj;
		if (!Arrays.equals(data, other.data))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
}
