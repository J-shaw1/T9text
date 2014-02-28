/*
 *
 *           ----------------------------------
 * Students: DON'T CHANGE ANYTHING IN THIS FILE please
 *           ----------------------------------
 * 
 * Bst.java
 *
 * Martin Escardo 3 Feb 2014.
 *
 */

package bstexercise;

/**
 * Interface for immutable binary search trees of integers.
 *
 * We will replace integers by "Comparable"s later, in a lecture on "generics".
 * We can only construct bsts. (The constructors check sanity.) 
 * 
 * NB. Unconventional indentation is used in this package to cope with the 
       size of the projector in lecture theatres.
 * You should use any of the conventional indentation styles 
 * in your submissions. Do as I say and not as I do.
 * 
 * @author  Martin Escardo
 */

public interface Bst {
  public boolean isEmpty();
  public boolean isLeaf();
  public boolean smaller(int e); // Checks whether all nodes smaller than e.
  public boolean bigger(int e);  // Checks whether all nodes bigger than e.
  public boolean has(int e);     // Checks whether e occurs in "this".
  public Bst     find(int e);    // Returns subtree of "this" with e at root (or null).
  public Bst     insert(int e);  // Returns a copy of "this" with e inserted.  
  public Bst     delete(int e);  // Returns a copy of "this" with e deleted.
  public Bst     delete2(int e); // Returns a copy of "this" with e deleted, another approach.
  public int     smallest();     // Returns smallest node (=left-most node).
  public Bst     deleteSmallest();// Return new tree with smallest element deleted.
  public int     largest();      // Returns largest node (=right-most node).
  public Bst     deleteLargest();// Return new tree with largest element deleted.
  public String  fancyToString();// 2-dimensional, rotated tree printing.
  public String  fancyToString(int d);// Starting at a given position d.
  public int     size();         // Count how many hodes.
  public int     height();       // (That of the empty tree is -1 by convention.)
  public void    printInOrder(); // 
  public int     saveInOrder(int a[]); // Save in order in the array a starting at 0 or i.
  public int     saveInOrder(int a[], int i); // Inform what the next available position is.
}
