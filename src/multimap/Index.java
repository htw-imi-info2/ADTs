package multimap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Index {
	Map<String, Set<Integer>> index = new HashMap<>();

	public Index() {
	}

	public static void main(String[] args) {
		Index index = new Index();
		index.addReference("television", 35);
		index.addReference("television", 132);
		index.addReference("Dan", 97);
		index.addReference("xy", 5);
		index.addReference("xy", 7);
		index.addReference("xy", 6);
		System.out.println("Index");
		index.printIndex();

	}

	// Add a page reference to the index.
	void addReference(String term, int pageNum) {
		// The set of page references that we
		// have so far for the term.
		Set<Integer> references = index.get(term);
		if (references == null) {
			// This is the first reference
			Set<Integer> firstRef = new TreeSet<Integer>();
			firstRef.add(new Integer(pageNum));
			index.put(term, firstRef);
		} else {
			references.add(new Integer(pageNum));
		}
	}

	void printIntegers(Set<Integer> integers) {
		if (integers.isEmpty()) {
			// There is nothing to print!
			return;
		}
		Integer i;
		Iterator<Integer> iter = integers.iterator();
		i = (Integer) iter.next();
		System.out.print(i.intValue());
		while (iter.hasNext()) {
			i = (Integer) iter.next();
			System.out.print(", " + i.intValue());
		}
	}

	void printIndex() {
		Set<String> terms = new TreeSet<>(index.keySet());
		for (String term : terms) {
			System.out.print(term+" -> ");
			printIntegers(index.get(term));
			System.out.println();

		}

	}
}
