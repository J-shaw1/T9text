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
 * Tree class for making a new bst out of a given root and two bsts.
 * 
 * @author Martin Escardo
 */

public class Fork implements Bst {

	private final int root;
	private final Bst left, right;

	public Fork(int root, Bst left, Bst right) {
		assert (left != null); // Refuse to work with null pointers.
		assert (right != null);

		assert (left.smaller(root)); // Refuse to violate the bst property.
		assert (right.bigger(root)); // So all our objects will really be bst's.

		this.root = root; // The usual stuff now.
		this.left = left;
		this.right = right;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean isLeaf() {
		return false;
	}

	public boolean smaller(int e) { // Checks whether all nodes smaller than e.
		return root < e && right.smaller(e);
	}

	public boolean bigger(int e) {

		return root > e && left.bigger(e);

		// return Unimplemented.booleanExercise("boolean bigger(int e)");
	}

	public boolean has(int e) { // Checks whether e occurs in "this".
		if (e == root)
			return true;
		else if (e < root) // Only one sub-tree needs to be searched.
			return left.has(e);
		else
			return right.has(e);
	}

	public boolean has2(int e) { // More concisely.
		return root == e // Opportunity to discuss "shortcut or" and "and".
				|| (root < e && left.has(e)) || (root > e && right.has(e));
	}

	public Bst find(int e) { // Returns subtree of "this" with e at root (or
								// null).
		// If e is the root, return the tree
		if (root == e) {
			return this;
		}
		// If both sub trees return null then return null
		else if (left.find(e) == null && right.find(e) == null) {
			return null;
		}
		// Otherwise return the non null element
		else {
			return left.find(e) == null ? right.find(e) : left.find(e);
		}

		// return Unimplemented.bstExercise("Bst Fork.find(int e)");
	}

	public Bst insert(int e) { // Returns a copy of this with e inserted.
		if (e == root) // Bst's can't have duplicates.
			return this; // Return unchanged.
		else // (Another possibility is to trigger an exception.)
		if (e < root)
			return new Fork(root, left.insert(e), right);
		else
			return new Fork(root, left, right.insert(e));

		// return Unimplemented.bstExercise("Bst Fork.insert(int e)");
	}

	public int smallest() {
		if (left.isEmpty())
			return root;
		else
			return left.smallest();

	}

	public Bst deleteSmallest() {

		if (left.isLeaf() && right.isEmpty()) {
			return new Leaf(root);
		} else {
			if (left.isEmpty())
				return right;
			else
				return new Fork(root, left.deleteSmallest(), right);
		}
	}

	public int largest() {

		return right.isEmpty() ? root : right.largest();

		// return Unimplemented.intExercise("int Fork.largest()");
	}

	public Bst deleteLargest() {

		if (left.isEmpty() && right.isLeaf()) {
			return new Leaf(root);
		} else {

			return right.isEmpty() ? left : new Fork(root, left,
					right.deleteLargest());
		}
		// return Unimplemented.bstExercise("int Fork.deleteLargest()");
	}

	public Bst delete(int e) { // Returns a copy of self with e deleted.
		if (e == root)
			if (left.isEmpty())
				return right;
			else if (right.isEmpty())
				return left;
			else
				// Both non-empty.
				return new Fork(left.largest(), left.deleteLargest(), right);
		else // We have to delete from one of the subtrees.
		if (e < root)
			return new Fork(root, left.delete(e), right);
		else
			return new Fork(root, left, right.delete(e));
	}

	// Mirrored algorithm:

	public Bst delete2(int e) { // Returns a copy of self with e deleted.
		// Delegation calls should be to delete2(e) and not to
		// delete(e). Why?
		//
		// You should use smallest and deleteSmallest, and swap left and
		// right in appropriate places, but not everywhere. See the
		// Foundations handout.

		if (e == root)
			if (left.isEmpty())
				return right;
			else if (right.isEmpty())
				return left;
			else
				// Both non-empty.
				return new Fork(right.smallest(), left, right.deleteSmallest());
		else // We have to delete from one of the subtrees.
		if (e < root)
			return new Fork(root, left.delete2(e), right);
		else
			return new Fork(root, left, right.delete2(e));

		// return Unimplemented.bstExercise("Bst Fork.delete2(int e)");
	}

	public String toString() {
		return "Fork(" + root + "," + left.toString() + "," + right.toString()
				+ ")";
	}

	public String fancyToString() {
		return "\n\n" + fancyToString(0) + "\n\n";
	}

	public String fancyToString(int depth) {
		int step = 4; // depth step
		String l = left.fancyToString(depth + step);
		String r = right.fancyToString(depth + step);
		return r + spaces(depth) + root + "\n" + l;
	}

	private String spaces(int n) { // Helper method for the above:
		String s = "";
		for (int i = 0; i < n; i++)
			s = s + " ";
		return s;
	}

	public int size() {
		return 1 + left.size() + right.size();
	}

	public int height() {
		return 1 + Math.max(left.height(), right.height());
	}

	public void printInOrder() {

		left.printInOrder();
		System.out.print(root + " ");
		right.printInOrder();

		// Unimplemented.Exercise("void Fork.printInOrder()");
	}

	public int saveInOrder(int a[]) {
		// Saves the tree in the array a.
		// Returns the next available position in the array.
		return saveInOrder(a, 0);
	}

	public int saveInOrder(int[] a, int i) {
		// Saves in the array a starting from position i.
		// Returns the next available position in the array.

		i = left.saveInOrder(a, i);

		a[i] = root;
		i++;

		i = right.saveInOrder(a, i);

		return i;

		// return Unimplemented.intExercise("void Fork.saveInOrder(a, i)");
	}
}
