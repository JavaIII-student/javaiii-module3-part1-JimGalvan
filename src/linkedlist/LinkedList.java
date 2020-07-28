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
		// returnElement stores the element that will be deleted
		Node<T> returnElement = null;
		
		while (currentNode != null) {
			elementNum++;
			// This removes first item in the list
			if (index == 1) {
				returnElement = new Node<T>(firstNode.getData());
				firstNode = firstNode.getNext();
				return returnElement.getData();
			}
			// This removes last item in the list
			if (currentNode.getNext().getNext() == null) {
				returnElement = new Node<T>(lastNode.getData());
				lastNode = currentNode;
				currentNode.setNext(null);
				return returnElement.getData();
			}
			// This removes any item between firstNode and lastNode
			if (elementNum == index -1) {
				returnElement = new Node<T>(currentNode.getNext().getData());
				currentNode.setNext(currentNode.getNext().getNext());
				return returnElement.getData();
			}
			currentNode = currentNode.getNext();
		}
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
