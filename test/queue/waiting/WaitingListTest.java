package queue.waiting;

import static org.junit.Assert.*;

import org.junit.Test;

public class WaitingListTest {

	@Test
	public void testOne() {
		WaitingList waitingList = new WaitingList();
		waitingList.addToWaitingList("Trick");
		assertEquals("Trick", waitingList.getFirstInLine());
	}

	@Test
	public void testThree() {
		WaitingList waitingList = new WaitingList();
		waitingList.addToWaitingList("Trick");
		waitingList.addToWaitingList("Tick");
		waitingList.addToWaitingList("Track");
		assertEquals("Trick", waitingList.getFirstInLine());
	}

	@Test
	public void testThreeTakeOutTwo() {
		WaitingList waitingList = new WaitingList();
		waitingList.addToWaitingList("Trick");
		waitingList.addToWaitingList("Tick");
		waitingList.addToWaitingList("Track");
		assertEquals("Trick", waitingList.getFirstInLine());
		assertEquals("Tick", waitingList.getFirstInLine());
	}
}
