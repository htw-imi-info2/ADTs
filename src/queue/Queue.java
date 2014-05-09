package queue;

public class Queue<E> {
	class Node<T> {
		T data;
		Node<T> next;
	}

	Node<E> first, last;

}
