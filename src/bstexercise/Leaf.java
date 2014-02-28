/*
 *           --------------------------------------------------
 * Students: replace the occurrences of Exercise with your code please
 *           --------------------------------------------------
 *
 * If you don't attept an exercise, or don't succeed, leave it as it
 * was originally please, so that your submission will compile.
 *
 * Created on 3 Feb 2014.
 */

package bstexercise;

/**
 * Tree class for making a leaf. Not necessary. But saves space.
 * 
 * @author Martin Escardo
 */

public class Leaf implements Bst {

	private final int value;

	public Leaf(int value) {
		this.value = value;
	}

	public boolean isEmpty() {
		return false;
	}
	
	public boolean isLeaf() {
		return true;
	}

	public boolean smaller(int e) { // Checks whether all nodes smaller than e.
		return e > value;
	}

	public boolean bigger(int e) {
		return e < value;
	}

	public boolean has(int e) { // Checks whether e occurs in "this".
		return e == value;
	}

	public Bst find(int e) {
		return e == value ? this : null;
	}

	public Bst insert(int e) {
		if (e == value)
			return this;
		else if (e < value) {
			return new Fork(value, new Leaf(e), new Empty());
		} else if (e > value) {
			return new Fork(value, new Empty(), new Leaf(e));
		} else {
			throw new RuntimeException("No place for new node");
		}
	}

	public int smallest() {
		return value;
	}

	public Bst deleteSmallest() {// Returns new tree with smallest element
									// deleted.
		return new Empty();
	}

	public int largest() {
		return value;
	}

	public Bst deleteLargest() {// Returns new tree with largest element
								// deleted.
		return new Empty();
	}

	public Bst delete(int e) { // Returns a copy of this with e deleted.
		return new Empty();
	}

	public Bst delete2(int e) { // Same algorithm here. But don't call
								// delete(2). Why?
		return new Empty();
	}

	public String toString() { // Generated string "Leaf(<value>)"
		return "Leaf(" + value + ")";
	}

	public String fancyToString() {
		return fancyToString(0);
	}

	public String fancyToString(int d) {
		return spaces(d) + value + "\n";
	}

	private String spaces(int n) { // Helper method for the above:
		String s = "";
		for (int i = 0; i < n; i++)
			s = s + " ";
		return s;
	}

	public int size() {
		return 1;
	}

	public int height() {
		return 0;
	}

	public void printInOrder() {
		System.out.print(value + " ");
	}

	public int saveInOrder(int a[]) {
		return saveInOrder(a, 0);
	}

	public int saveInOrder(int a[], int i) {
		a[i++] = value;
		return i;
	}
}
