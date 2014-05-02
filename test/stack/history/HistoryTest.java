package stack.history;

import static org.junit.Assert.*;

import org.junit.Test;

public class HistoryTest {

	@Test
	public void testHistoryOneElement() {
		History history = new History();
		history.addToHistory("http://www.htw-berlin.de");
		assertEquals("http://www.htw-berlin.de",history.getLast());
	}
	
	@Test
	public void testHistoryThreeElements() {
		History history = new History();
		history.addToHistory("http://www.google");
		history.addToHistory("http://www.github.com");
		history.addToHistory("http://www.htw-berlin.de");
		assertEquals("http://www.htw-berlin.de",history.getLast());
	}

}
