package stack.history;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HistoryTest {
	History history;

	@Before
	public void createHistory() {
		history = new History();
	}

	@Test
	public void testEmpty() {
		assertEquals(null, history.getLast());
	}

	@Test
	public void testHistoryOneElement() {
		history.addToHistory("http://www.htw-berlin.de");
		assertEquals("http://www.htw-berlin.de", history.getLast());
	}

	@Test
	public void testHistoryThreeElements() {
		history.addToHistory("http://www.google");
		history.addToHistory("http://www.github.com");
		history.addToHistory("http://www.htw-berlin.de");
		assertEquals("http://www.htw-berlin.de", history.getLast());
	}

	@Test
	public void testHistoryBackAndForthElements() {
		history.addToHistory("a");
		history.addToHistory("b");
		history.addToHistory("c");
		assertEquals("c", history.getLast());
		history.addToHistory("d");
		assertEquals("d", history.getLast());

	}

}
