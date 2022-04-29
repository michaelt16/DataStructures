package main;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class represents a list of T, but is kind of silly.
 *
 * <p>For example:
 *
 * <ul>
 *   <li>you can only create an empty or full one, and only with the included simple factories
 *   <li>you can never add anything to it once it's created
 *   <li>you can ask it to findBiggest(), which just means to either throw an exception (if the list
 *       is empty), or return the last element in the list
 * </ul>
 *
 * @author jpratt
 * @param <T> the type of thing in the list
 */
public final class ExceptionThrowingList<T> {

  private List<T> thingsInList;
  private int size;

  /**
   * This is a simple factory to return an empty ExceptionThrowingList. It's a static method, so
   * remember to call it...how?
   *
   * @param <T> the type of thing you want to put in this ExceptionThrowingList
   * @return an empty ExceptionThrowingList
   */
  public static <T> ExceptionThrowingList<T> emptyList() {

    return new ExceptionThrowingList<T>();
  }

  /**
   * This is a simple factory to return a "full" ExceptionThrowingList; you give it the stuff you
   * want to fill it with. It's a static method, so remember to call it...how?
   *
   * @param <T> the type of thing you want to put in this ExceptionThrowingList
   * @param filledWithThese the things you want to put in this ExceptionThrowingList
   * @return the "full" ExceptionThrowingList
   */
  public static <T> ExceptionThrowingList<T> fullList(List<T> filledWithThese) {
    ExceptionThrowingList<T> theNewList = emptyList();
    theNewList.thingsInList.addAll(filledWithThese);

    theNewList.size += filledWithThese.size();
    return theNewList;
  }

  // TODO: complete the findBiggest method
  /**
   * Returns the "biggest" element in this ExceptionThrowingList; we'll assume that's the element in
   * the last index of the underlying thingsInList.
   *
   * <p>If someone tries to use this method when there's nothing in thingsInList, this method should
   * throw a NoSuchElementException with the message "You can't findBiggest when it's empty."
   *
   * @return the element in the last position of thingsInList
   * @throws NoSuchElementException if there's nothing in this ExceptionThrowingList
   */
  public T findBiggest() {
    if (thingsInList.isEmpty()) {
      throw new NoSuchElementException("You can't findBiggest when it's empty.");

    } else {
      return thingsInList.get(size - 1);
    }
  }

  public static ExceptionThrowingList method() {
    return new ExceptionThrowingList<Integer>();
  }

  /**
   * This constructor is private so that it forces clients of this class to use the two simple
   * factories (emptyList and fullList) to make lists.
   */
  private ExceptionThrowingList() {
    this.thingsInList = new ArrayList<>();
    this.size = 0;
  }
}
