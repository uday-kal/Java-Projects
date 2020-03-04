/**
 *Creates a dynamic array.
 * @param <T> generic object type.
 */
public class MyArray<T> {

	/**
	 * The default capacity of a myArray.
	 */
	private static final int DEFAULT_CAPACITY = 2; //default initial capacity / minimum capacity
	/**
	 * A default empty array.
	 */
	private T[] data; //underlying array, you MUST use this for full credit

	/**
	 * Creates a new dynamic array with the initial capacity.
	 */
	@SuppressWarnings("unchecked")
	public MyArray() {

		this.data = (T[]) new Object[DEFAULT_CAPACITY];

	}

	/**
	 * Creates a new dynamic array that has the values of the inputed array.
	 * @param inputArray the array to be stored in the dynamic array.
	 */
	public MyArray(T[] inputArray) {

		this.data = inputArray;

	}

	/**
	 * Creates a new dynamic array with an inputed capacity.
	 * @param initialCapacity the inputed capacity and max values the array can have.
	 */
	@SuppressWarnings("unchecked")
	public MyArray(int initialCapacity) {

		//Checks if capacity is valid
		if (initialCapacity < 1)
			throw new IllegalArgumentException();
		else
		{
			this.data = (T[]) new Object[initialCapacity];
		}

	}

	/**
	 * The total amount of values filled within the array.
	 * @return the counted values of the array.
	 */
	public int size() {

		//counts values
		int count = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data[i] != null)
				count++;
		}

		return count;
	}


	/**
	 * The maximum amount of values of the array.
	 * @return the length of the array, the max values.
	 */
	public int capacity() {

		return data.length;

	}

	/**
	 * Adds a value to the end of the array, increasing the array size if filled.
	 * @param value the value to be appended to the array.
	 * @return the operation was completed successfully.
	 */
	@SuppressWarnings("unchecked")
	public boolean append(T value) {

		//expands array if necessary
		if (size() == capacity())
		{
			T[] copy = (T[]) new Object[capacity()*2];
			for (int i = 0; i < data.length; i++)
			{
				copy[i] = data[i];
			}
			data = copy;
		}

		data[size()] = value;

		return true;

	}

	/**
	 * Switches the values at the two indexes given within the array.
	 * @param index1 the index of the first value.
	 * @param index2 the index of the second value.
	 * @return the operation was completed successfully.
	 */
	@SuppressWarnings("unchecked")
	public boolean swap(int index1, int index2) {

		//copy
		T[] copy = (T[]) new Object[capacity()];
		for (int i = 0; i < data.length; i++)
		{
			copy[i] = data[i];
		}

		//swaps using copy as a reference
		try
		{
			data[index1] = copy[index2];
			data[index2] = copy[index1];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}

		return true;

	}

	/**
	 * Inserts a value into the array at the given index.
	 * @param index the place the value should be inserted at.
	 * @param value the value to be inputed into the string.
	 */
	@SuppressWarnings("unchecked")
	public void add(int index, T value) {
		try
		{
			//changes capacity if necessary
			if (size() == capacity())
			{
				T[] resized = (T[]) new Object[capacity()*2];
				for (int i = 0; i < data.length; i++)
				{
					resized[i] = data[i];
				}
				data = resized;
			}

			T[] copy = (T[]) new Object[capacity()];

			//adds values normally until the its the index of the value
			//it inserts the value then continues
			for (int i = 0; i < data.length; i++)
			{
				if (i < index)
				{
					copy[i] = data[i];
				}
				else if (i == index)
				{
					copy[i] = value;
				}
				else
				{
					copy[i] = data[i-1];
				}
			}
			data = copy;  

		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * retrieves the value at the given index of the array.
	 * @param index the index at which to retrive the value.
	 * @return the value found at the index.
	 */
	public T get(int index) {

		try
		{
			return data[index];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}

	}

	/**
	 * Replaces the value at the given index.
	 * @param index the index of the array.
	 * @param value the value to be placed into the array.
	 * @return the original value at the index.
	 */
	public T replace(int index, T value) {

		try
		{
			T val = data[index];
			data[index] = value;
			return val;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}

	}

	/**
	 * removes the value at the index.
	 * @param index the index of the value to be removed.
	 * @return the value originally at the index.
	 */
	@SuppressWarnings("unchecked")
	public T delete(int index) {

		try
		{
			//adds everything but the value at the index to the copy
			T val = data[index];
			T[] copy = (T[]) new Object[capacity()];
			for (int i = 0; i < data.length; i++)
			{
				if (i < index)
				{
					copy[i] = data[i];
				}
				else if(i > index)
				{
					copy[i-1] = data[i];
				}
			}
			data = copy;

			//resizes capacity if necessary
			if (size() < capacity()/4 && capacity()/4 >= DEFAULT_CAPACITY)
			{
				T[] resized = (T[]) new Object[capacity()/2];
				for (int i = 0; i < resized.length; i++)
				{
					resized[i] = data[i];
				}
				data = resized;
			} 

			return val;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			throw new IndexOutOfBoundsException();
		}

	}

	/**
	 * Finds the first occurrence of a value.
	 * @param value the value to look for.
	 * @return the index of the value, or -1 if not found.
	 */
	public int firstIndexOf(T value) {

		for (int i = 0; i < data.length; i++)
		{
			if(data[i] == (value))
				return i;
		}

		return -1;
	}

	/**
	 * Gives the array a new capacity to be set to.
	 * @param newCapacity the new capacity of the array.
	 * @return true if change, false if not.
	 */
	@SuppressWarnings("unchecked")
	public boolean ensureCapacity(int newCapacity) {

		//checks if capacity is greater then min and can hold all values
		if (newCapacity > DEFAULT_CAPACITY && newCapacity > size())
		{
			T[] resized = (T[]) new Object[newCapacity];
			for (int i = 0; i < data.length; i++)
			{
				resized[i] = data[i];
			}
			data = resized;
			return true;
		}
		return false;

	}

	/**
	 *Creates an entirely new non-alias copy of the array.
	 * @return the copy of the array.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyArray<T> clone() {

		MyArray<T> copy = new MyArray(capacity());

		for (int i = 0; i < data.length; i++)
		{
			copy.append(data[i]);
		}

		return copy;
	}

	/**
	 * A custom method meant to help for testing.
	 * Prints out all the values in the array.
	 */
	public void show()
	{
		System.out.println();
		System.out.print("[");

		for (int i = 0; i < data.length-1; i++)
		{
			System.out.print(data[i] + " ,");
		}

		System.out.print(data[data.length-1] + "] " + size() + " , " + capacity());
		System.out.println();
	}

	// --------------------------------------------------------
	// example testing code... edit this as much as you want!
	// --------------------------------------------------------
	/**
	 * Main.
	 * @param args inputed arguments
	 */
	public static void main(String args[]) {
		//create a MyArray of integers
		MyArray<Integer> nums = new MyArray<> ();
		if ((nums.size() == 0) && (nums.capacity() == 2)) {
			System.out.println("Passed Test 1");
		}

		//append some numbers 
		for (int i = 0; i < 3; i++) {
			nums.add(i, i * 2);
		}

		if (nums.size() == 3 && nums.get(2) == 4 && nums.capacity() == 4) {
			System.out.println("Passed Test 2");
		}

		//create a myArray of strings
		MyArray<String> msg = new MyArray<>();

		//insert some strings
		msg.add(0, "Structures");
		msg.add(0, "Data");
		msg.add(1, "new");
		msg.append("!");

		//replace and checking
		if (msg.get(0).equals("Data") && msg.replace(1, "beautiful").equals("new") &&
				msg.size() == 4 && msg.capacity() == 4) {
			System.out.println("Passed Test 3");
		}

		//change capacity
		if (!msg.ensureCapacity(0) && !msg.ensureCapacity(3) && msg.ensureCapacity(20) &&
				msg.capacity() == 20) {
			System.out.println("Passed Test 4");
		}

		//delete and shrinking
		if (msg.delete(1).equals("beautiful") && msg.get(1).equals("Structures") &&
				msg.size() == 3 && msg.capacity() == 10) {
			System.out.println("Passed Test 5");
		}

		//firstIndexOf and clone
		//remember what == does on objects... not the same as .equals()
		MyArray<String> msgClone = msg.clone();
		if (msgClone != msg && msgClone.get(1) == msg.get(1) &&
				msgClone.size() == msg.size() &&
				msgClone.capacity() == msg.capacity() &&
				msgClone.firstIndexOf("Structures") == 1 &&
				msgClone.firstIndexOf("beautiful") == -1) {
			System.out.println("Passed Test 6");
		}
		//swap
		msgClone.swap(0, 1);
		if (msgClone.get(0) == "Structures" && msgClone.get(1) == "Data") {
			System.out.println("Passed Test 7");
		}

	}


	/**
	 * Print format.
	 * @return String format
	 */
	public String toString() {
		if (size() == 0) {
			return "";
		}

		StringBuffer sb = new StringBuffer();
		sb.append(get(0));
		for (int i = 1; i < size(); i++) {
			sb.append(", ");
			sb.append(get(i));
		}
		return sb.toString();
	}
}