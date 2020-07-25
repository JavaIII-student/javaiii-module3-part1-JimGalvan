/**
 * 
 */
package linkedlist;

/**
 * @author jimmy
 *
 */
public class LinkedList<T> implements LinkedListInterface<T> {

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
	public void addFirst(T data) {

		if (isEmpty()) {
			firstNode = lastNode = new Node<T>(data);
		} else {
			firstNode = new Node<T>(data, firstNode);
		}
	}

	@Override
	public void addLast(T data) {

		if (isEmpty()) {
			firstNode = lastNode = new Node<T>(data);
		} else {
			lastNode.setNext(new Node<T>(data));
			lastNode = lastNode.getNext();
		}
	}

	@Override
	public void add(T data, int index) throws IndexOutOfBoundsException {

		// Variable to check index of the current node
		int elementNum = 0;

		Node<T> currentNode = firstNode;

		while (currentNode != null) {

			elementNum++;

			if (index == 1) {
				firstNode = new Node<T>(data, firstNode);
				return;
			}

			if (elementNum == index) {
				currentNode.setNext(new Node<T>(data, currentNode.getNext()));
				return;
			}

			// This allows to set a reference to the first node in the list after first
			// iteration
			if (elementNum > 1) {
				currentNode = currentNode.getNext();
			}

			// Custom exception if an inputed index cannot reach a node's reference
			if (currentNode.getNext() == null & index > elementNum + 1) {

				System.err.println("Error: index: " + index + " is out of bounds");
				throw new IndexOutOfBoundsException();

			}
		}
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {

		// Variable to check index of the current node
		int elementNum = 0;
		Node<T> currentNode = firstNode;

		while (currentNode != null) {
			
			elementNum++;
			
			if (index == 1 & elementNum == 1) {

				firstNode.setNext(firstNode.getNext());

				firstNode.setData(firstNode.getNext().getData());
			}
			
			
			if (index == 1 & currentNode.getNext() != null) {
				
				currentNode.setNext(currentNode.getNext());
				currentNode.setData(currentNode.getNext().getData());
			}
			
			currentNode = currentNode.getNext();

		}

		
		// This part of code moves the items when you insert an elements that is not at
		// first node
		
//		if (elementNum == index -1) {
//			
//			currentNode.setNext(currentNode.getNext().getNext());
//			currentNode.getNext().setData(currentNode.getNext().getData());
//		}
		
		
		// The following code deletes the last element in the list

		currentNode = firstNode; // Set current node to first node
		
		// This part counts the number of elements in the list
		int numOfElements = 0;

		while (currentNode != null) {
			numOfElements++;
			currentNode = currentNode.getNext();
		}

		currentNode = firstNode;

		for (int i = 0; i < numOfElements - 2; i++) {
			currentNode = currentNode.getNext();
		}
		
		currentNode.setNext(null);
		lastNode.setNext(currentNode);

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
