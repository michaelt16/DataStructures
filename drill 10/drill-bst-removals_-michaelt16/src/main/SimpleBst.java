package main;

import java.util.Iterator;

/**
 * These are the methods required for this assignment's implementation of a Binary Search Tree
 * (BST).
 *
 * @author jpratt
 * @param <T> the type of things in the BST
 */
public interface SimpleBst<T extends Comparable<T>> {

  /**
   * Adds a single item to the BST.
   *
   * @param data the item to add
   * @throws an IllegalArgumentException if a null data is added
   */
  void add(T data);

  /**
   * Returns the depth of this BST. We'll say that the depth of an empty tree should be -1.
   *
   * <p>This is a good visual example: https://stackoverflow.com/a/2603707
   *
   * @return the depth of the tree
   */
  int depth();

  /**
   * Returns the number of items in this BST. It's a long because you should have some exposure to
   * longs...that's about it. :)
   *
   * @return the number of items in this BST
   */
  long size();

  /**
   * Returns the item in the tree such that item.equals(target) is true. If no such item exists,
   * then returns null.
   *
   * @param target the item to get out of the tree
   * @return the item found, or null if no such item exists
   */
  T get(T target);

  /**
   * Returns true if this BST is balanced.
   *
   * <p>Have a gander here: https://www.youtube.com/watch?v=LU4fGD-fgJQ
   *
   * @return true if this BST is balanced
   */
  boolean isBalanced();

  /**
   * Returns an Iterator that returns the results of an in-order traversal of the BST. (Which you
   * know - I know you know - will be in ascending order of the items in the tree.)
   *
   * @return an Iterator of results of an in-order traversal of the BST
   */
  Iterator<T> inOrderIterator();

  /**
   * Balances the tree. There are a number of ways to do this...feel free to use what you find out
   * there - but remember to cite your work, eh?
   */
  void balance();

  /**
   * Returns the "smallest" item in the BST, either as determined by the natural order of the
   * elements, or by the comparator used to create this tree.
   *
   * @return the smallest item in the BST
   */
  T min();

  /**
   * Returns the "largest" item in the BST, either as determined by the natural order of the
   * elements, or by the comparator used to create this tree.
   *
   * @return the largest item in the BST
   */
  T max();

  /**
   * Removes the given element from the BST, if it exists. If it does not exist, nothing blows up -
   * the tree just remains unaltered.
   *
   * @param toRemove the element to remove from the BST
   * @throws IllegalArgumentException if the element to remove is null
   */
  void remove(T toRemove);
}
