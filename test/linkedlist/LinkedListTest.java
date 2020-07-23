/**
 * 
 */
package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jimmy
 *
 */
public class LinkedListTest {
	
	
	@Test
	public void isEmptyTest() {
	
		LinkedList<String> list = new LinkedList<>();
		
		list.addFirst("Juan");
		list.addFirst("John");
		list.addFirst("Lennon");
		assertFalse(list.isEmpty());

		// Create a new list to test false return value
		LinkedList<Integer> list2 = new LinkedList<>();
		assertTrue(list2.isEmpty());
	}

	@Test
	public void sizeTest() {
		
		LinkedList<String> list = new LinkedList<>();
		list.addLast("Juan");
		list.addLast("John");
		list.addLast("Lennon");

		assertEquals(3, list.size());
		
		list.addLast("Jimmy");
		list.addLast("Galvan");
//		list.print();
		
		assertEquals(5, list.size());
	}

	@Test
	public void addFirstTest() {

		LinkedList<Integer> list = new LinkedList<>();
		
		// List uses class wrapper Integer, so use this type of object to test values
		Integer number4 = 4;
		Integer number1 = 1;
		
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		
		assertEquals(number4, list.firstNode.getData());
		assertEquals(number1, list.lastNode.getData());
	}

	@Test
	public void addLastTest() {
		LinkedList<Double> list = new LinkedList<>();
		
		Double double3 = 3.0;
		
		list.addLast(1.0);
		list.addLast(2.0);
		list.addLast(3.0);
		
		assertEquals(double3, list.lastNode.getData());
		
		LinkedList<String> list2 = new LinkedList<>();
		
		list2.addLast("Juan");
		list2.addLast("Jim");
		list2.addLast("Perez");
		list2.addLast("Jimmy");
		
		assertEquals("Jimmy", list2.lastNode.getData());
	}

	@Test
	public void addTest() throws IndexOutOfBoundsException {
		fail("Not yet implemented");		
	}

	@Test
	public void removeTest() throws IndexOutOfBoundsException {
		fail("Not yet implemented");
	}

	@Test
	public void printTest() {
		
		LinkedList<String> list = new LinkedList<>();
		
		list.addLast("John");
		list.addLast("Yenna");
		list.addLast("Maria");
		list.addLast("Will");
	
		list.print();
		
		
	}

}
