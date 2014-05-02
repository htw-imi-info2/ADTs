package stack.history;

public class History {

	String[] content = new String[5];
	// zeigt immer auf das nächste freie element
	// gleich der Anzahl der elemente in der History
	int counter = 0;

	public void addToHistory(String url) {
		// content[counter++] = url;
		content[counter] = url;
		counter = counter + 1;
	}

	public String getLast() {
		if (counter == 0)
			return null;
		return content[--counter];
	}
}
