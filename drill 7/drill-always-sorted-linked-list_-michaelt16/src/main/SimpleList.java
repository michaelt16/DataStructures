package main;

public interface SimpleList<E extends Comparable<E>> extends Iterable<E> {

  /**
   * Adds the specified element to this List. The element will be added such that the elements in
   * this List retain their natural ordering.
   *
   * @param e the element to be added
   */
  void add(E e);

  /**
   * Removes the first occurrence of the specified element from this List. If the element does not
   * exist, that's cool - the list doesn't change and no exceptions are thrown, but null is
   * returned.
   *
   * @param e the element to be removed from this list
   * @return the element that was removed, or null if it wasn't found in this List
   */
  E remove(E e);

  /**
   * Returns the element found at the given index in this List.
   *
   * @param index the index where you want to grab an element
   * @return the element at the given index
   * @throws IndexOutOfBoundsException if the index is out of range
   */
  E get(int index);

  /**
   * Returns the index of the first element in the list that equals the given target. If no such
   * element is found, returns -1.
   *
   * @param target the element to search for in the list
   * @return the index of the target, or -1 if its not in the list
   */
  int indexOf(E target);

  /**
   * Returns the number of elements in this List.
   *
   * @return the number of elements in this List
   */
  int size();

  /**
   * Returns true if there are no elements in this List.
   *
   * @return true if this list has not elements
   */
  boolean isEmpty();
}
