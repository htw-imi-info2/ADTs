package queue;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue<String> queue;

	@Before
	public void createQueue() {
		queue = new Queue<>();
	}

	/**
	 * simple tests
	 */
	@Test
	public void testEnque1() {
		queue.enqueue("a");
		assertEquals("a", queue.toString());
	}

	@Test
	public void testEnque2() {
		queue.enqueue("a");
		queue.enqueue("b");
		assertEquals("a, b", queue.toString());
	}

	@Test
	public void testDequeue() throws Underflow {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.dequeue();
		assertEquals("b", queue.toString());
	}

	/**
	 * Axiom 1: isEmpty(new Queue()) = true
	 */
	@Test
	public void axiom1() {
		assertEquals(true, queue.isEmpty());
	}

	/**
	 * Axiom 2: isEmpty(enqueue(q,x)) = false
	 */
	@Test
	public void axiom2() {
		queue.enqueue("A");
		assertEquals(false, queue.isEmpty());
	}

	/**
	 * Axiom 3: dequeue(new Queue()) = error
	 * 
	 * @throws Underflow
	 */
	@Test(expected = Underflow.class)
	public void axiom3() throws Underflow {
		queue.dequeue();
	}

	/**
	 * Axiom 4: getFront(new Queue()) = error
	 */
	@Test(expected = Underflow.class)
	public void axiom4() throws Underflow {
		queue.getFront();
	}

	/**
	 * Axiom 5: dequeue(enqueue(q,x)) = if isEmpty (q) then q else
	 * enqueue(dequeue(q),x)
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom5if() throws Underflow {
		String before = queue.toString();
		queue.enqueue("huhu");
		queue.dequeue();
		assertEquals(before, queue.toString());
	}

	/**
	 * Axiom 5: dequeue(enqueue(q,x)) = if isEmpty (q) then q else
	 * enqueue(dequeue(q),x)
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom5else() throws Underflow {
		// as enqueue and dequeue change the queue itself
		// rather than returning a different new queue;
		// we need to make sure to have two distinct instances of
		// queue
		Queue<String> q1 = new Queue<>();
		Queue<String> q2 = new Queue<>();
		q1.enqueue("a");
		q1.enqueue("b");
		q2.enqueue("a");
		q2.enqueue("b");
		String x = "hullu";
		String left = q1.enqueue(x).dequeue().toString();
		String right = q2.dequeue().enqueue(x).toString();
		assertEquals(left, right);
	}

	/**
	 * Axiom 6: getFront(enqueue(q,x)) = if isEmpty (q) then x else getfront(q)
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom6if() throws Underflow {
		String x = "huhu";
		queue.enqueue(x);
		assertEquals(x, queue.getFront());
	}

	/**
	 * Axiom 6: getFront(enqueue(q,x)) = if isEmpty (q) then x else getfront(q)
	 * 
	 * @throws Underflow
	 */
	@Test
	public void axiom6else() throws Underflow {
		// as enqueue and dequeue change the queue itself
		// rather than returning a different new queue;
		// we need to make sure to have two distinct instances of
		// queue
		Queue<String> q1 = new Queue<>();
		Queue<String> q2 = new Queue<>();
		q1.enqueue("a");
		q1.enqueue("b");
		q2.enqueue("a");
		q2.enqueue("b");
		String x = "hullu";
		String left = q1.enqueue(x).getFront();
		String right = q2.getFront();
		assertEquals(left, right);
	}

}