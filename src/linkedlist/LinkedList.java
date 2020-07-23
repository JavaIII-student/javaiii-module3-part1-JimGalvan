/**
 * 
 */
package linkedlist;

/**
 * @author jimmy
 *
 */
public class LinkedList<T> implements LinkedListInterface<T>{
	
	Node<T> firstNode;
	Node<T> lastNode;

	@Override
	public boolean isEmpty() {
		
		if (firstNode == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public int size() {
		
		Node<T> currentNode = firstNode;
		int counter = 0;
		
		while (currentNode != null) {
			counter++;
			currentNode = currentNode.getNext();
		}
		
		return counter;
	}

	@Override
	public void addFirst(T object) {
		
		if(isEmpty()) {
			firstNode = lastNode = new Node<T>(object);
		}
		else {
			firstNode = new Node<T>(object, firstNode);
		}
	}

	@Override
	public void addLast(T object) {
		
		if(isEmpty()) {
			firstNode = lastNode = new Node<T>(object);
		}
		else {
			lastNode.setNext(new Node<T>(object));
			lastNode = lastNode.getNext();
		}
	}

	@Override
	public void add(T data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void print() {
	
		if (isEmpty()) {
			
			System.out.println("List is empty");
			return;
		}
		
		Node<T> currentNode = firstNode;
		
		while (currentNode != null) {
			System.out.println(currentNode.getData());
			currentNode = currentNode.getNext();
		}
	}
}
