package queue.waiting;

public class WaitingList {

	String[] content = new String[5];
	// zeigt immer auf das nächste freie element
	// gleich der Anzahl der elemente in der History
	int counter = 0;
	int nextInLine = 0;

	public void addToWaitingList(String name) {
		content[counter++] = name;
	}

	public String getFirstInLine() {
		if (counter == 0)
			return null;
		return content[nextInLine++];
	}
}
