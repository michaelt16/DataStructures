package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class represents a list of T, but is kind of silly.
 *
 * <p>For example:
 *
 * <ul>
 *   <li>you can only create an empty or full one, and only with the included simple factories
 *   <li>you can never add anything to it once it's created
 *   <li>you can ask it to findBiggest(), which just means to either to return an empty Optional (if
 *       the list is empty), or return an Optional holding the last element in the list
 * </ul>
 *
 * @author jpratt
 * @param <T> the type of thing in the list
 */
public final class OptionalReturningList<T> {

  private List<T> thingsInList;
  private int size;

  /**
   * This is a simple factory to return an empty OptionalReturningList. It's a static method, so
   * remember to call it...how?
   *
   * @param <T> the type of thing you want to put in this OptionalReturningList
   * @return an empty OptionalReturningList
   */
  public static <T> OptionalReturningList<T> emptyList() {

    return new OptionalReturningList<T>();
  }

  /**
   * This is a simple factory to return a "full" OptionalReturningList; you give it the stuff you
   * want to fill it with. It's a static method, so remember to call it...how?
   *
   * @param <T> the type of thing you want to put in this OptionalReturningList
   * @param filledWithThese the things you want to put in this OptionalReturningList
   * @return the "full" OptionalReturningList
   */
  public static <T> OptionalReturningList<T> fullList(List<T> filledWithThese) {
    OptionalReturningList<T> theNewContainer = emptyList();
    theNewContainer.thingsInList.addAll(filledWithThese);

    theNewContainer.size += filledWithThese.size();
    return theNewContainer;
  }

  // TODO: complete the findBiggest method
  /**
   * Returns the "biggest" element in this OptionalReturningList; we'll assume that's the element in
   * the last index of the underlying thingsInList.
   *
   * @return an Optional that either holds the element in the last position of thingsInList, or is
   *     empty
   */
  public Optional<T> findBiggest() {
    if (thingsInList.isEmpty()) {
      return Optional.empty();

    } else {
      return Optional.of(thingsInList.get(size - 1));
    }
  }

  public static OptionalReturningList method() {
    return new OptionalReturningList<Integer>();
  }

  /**
   * This constructor is private so that it forces clients of this class to use the two simple
   * factories (emptyList and fullList) to make lists.
   */
  private OptionalReturningList() {
    this.thingsInList = new ArrayList<>();
    this.size = 0;
  }
}
