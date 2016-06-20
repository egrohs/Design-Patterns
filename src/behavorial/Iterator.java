package behavorial;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provide a way to access the elements of an aggregate object sequentially
 * without exposing its underlying representation.
 */
class BitSetIterator implements Iterator<Boolean> {
	private final BitSet bitset;
	private int index;

	public BitSetIterator(BitSet bitset) {
		this.bitset = bitset;
	}

	public boolean hasNext() {
		return index < bitset.length();
	}

	public Boolean next() {
		if (index >= bitset.length()) {
			throw new NoSuchElementException();
		}
		boolean b = bitset.get(index++);
		return new Boolean(b);
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}

// Two different usage examples:
class Iterator1 {
	public static void main(String[] args) {
		// create BitSet and set some bits
		BitSet bitset = new BitSet();
		bitset.set(1);
		bitset.set(3400);
		bitset.set(20);
		bitset.set(47);
		BitSetIterator iter = new BitSetIterator(bitset);
		while (iter.hasNext()) {
			Boolean b = iter.next();
			String tf = (b.booleanValue() ? "T" : "F");
			System.out.print(tf);
		}
		System.out.println();
	}
}

class Iterator2 {
	public static void main(String[] args) {
		ArrayList<Object> al = new ArrayList<Object>();
		al.add(new Integer(42));
		al.add(new String("test"));
		al.add(new Double("-12.34"));
		for (Iterator<Object> iter = al.iterator(); iter.hasNext();)
			System.out.println(iter.next());
		// JEE5 syntax
		for (Object o : al)
			System.out.println(o);
	}
}