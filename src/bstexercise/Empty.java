/*
 *           --------------------------------------------------
 * Students: replace the occurrences of Exercise with your code please
 *           --------------------------------------------------
 *
 * If you don't attept an exercise, or don't succeed, leave it as it
 * was originally please, so that your submission will compile.
 *
 * Empty.java
 *
 * Created on 3 Feb 2014.
 */

package bstexercise;

/**
 * Bst class for empty trees of integers.
 * 
 * @author Martin Escardo
 */

public class Empty implements Bst {

	public Empty() { // Nothing to do in the constructor!
	}

	public boolean isEmpty() {
		return true;
	}
	
	public boolean isLeaf() {
		return false;
	}

	public boolean smaller(int e) {
		return true;
	}

	public boolean bigger(int e) {
		return true;
	}

	public boolean has(int e) {
		return false;
	}

	public Bst find(int e) {
		return null; // Nothing found in the empty tree.
	}

	// public Bst insert(int e) {
	// return new Fork(e, new Empty(), new Empty());
	// }

	// ---------
	// IMPORTANT for the leaf Exercise
	// ---------
	// After you implement Leaf.java, delete the above method "insert" and
	// include the following instead, to test your file:

	public Bst insert(int e) {
		return new Leaf(e);
	}

	public Bst delete(int e) {
		return this; // Nothing to delete. Return unchanged.
	}

	public Bst delete2(int e) {
		return this; // No difference here.
	}

	public int smallest() { // Bad. Need to improve.
		throw new RuntimeException(
				"Attempted to find smallest node of empty tree");
	}

	public Bst deleteSmallest() {
		throw new RuntimeException(
				"Attempted to delete smallest node of empty tree");
	}

	public int largest() {
		throw new RuntimeException(
				"Attempted to find largest node of empty tree");
	}

	public Bst deleteLargest() {
		throw new RuntimeException(
				"Attempted to delete largest node of empty tree");
	}

	public String toString() {
		return "Empty";
	}

	public String fancyToString() {
		return "";
	}

	public String fancyToString(int d) {
		return fancyToString();
	}

	public int size() {
		return 0;
	}

	public int height() {
		return -1; // By convention.
	}

	public void printInOrder() { // Nothing to print.
	}

	public int saveInOrder(int a[]) {
		return saveInOrder(a, 0); // Calls next method.
	}

	public int saveInOrder(int a[], int i) { // Nothing to do.
		return i; // Except inform caller that the next available position is i.
	}
}
