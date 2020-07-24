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

		// This is declared as -1 instead of 0 in order to follow list index convention
		int elementNum = 0; // This equals to index 0

		Node<T> currentNode = firstNode; // D

		while (currentNode != null) {

			elementNum++;

//			if (elementNum == 1) {
//				firstNode = new Node<T>(data, firstNode);
//				return;
//			}

			 if (elementNum == index) {
				
//				System.out.println(currentNode.getData());
				
				currentNode = new Node<T>(data, currentNode);
				currentNode.setData(data);
				
//				System.out.println(currentNode.getData());

//				currentNode.setNext(new Node<T>(data, currentNode.getNext()));
				
//				return;

			}

			currentNode = currentNode.getNext(); // assign the reference to the following node, this case node 'B'
		}
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
