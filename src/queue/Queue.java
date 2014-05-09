package queue;

public class Queue<E> {
	private class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}

		public String toString() {
			if (next == null)
				return data.toString();
			return data.toString() + ", " + next.toString();
		}
	}

	Node<E> first, last;

	public boolean isEmpty() {
		return (first == null);
	}

	public E getFront() throws Underflow {
		if (isEmpty())
			throw new Underflow();
		return first.data;
	}

	public Queue<E> enqueue(E element) {
		Node<E> newNode = new Node<>(element);
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		return this;
	}

	public Queue<E> dequeue() throws Underflow {
		if (isEmpty())
			throw new Underflow();
		first = first.next;
		return this;
	}

	public String toString() {
		if (first == null)
			return "";
		return first.toString();

	}
}
