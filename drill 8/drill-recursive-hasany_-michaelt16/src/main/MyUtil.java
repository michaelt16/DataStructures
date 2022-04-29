package main;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Small utility class that provides one overloaded method: hasAny.
 *
 * @author jpratt
 */
public class MyUtil {

  /**
   * Returns true if there is at least one element in the given collection which comes after the
   * given cutoff, as decided by the given comparator.
   *
   * <p>There should probably be some error checking here, but there's not.
   *
   * @param <T> the type of elements in the collection
   * @param collection the collection of things to examine
   * @param comparator the comparator to use for determining what "comes after" means
   * @param cutoff if an element comes after this cutoff, hasAny will return true
   * @return true if there is at least one element in the collection which comes after the given
   *     cutoff
   */
  public static <T> boolean hasAny(T[] collection, Comparator<T> comparator, T cutoff) {

    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method

    return helper1(collection, comparator, cutoff, 0);

    // if size 0
    // if size 1
    // else
    // compareTo if -1 0
    // if 1 recursion +1
  }

  /**
   * Overloaded version of the above that takes in SimpleList as the collection.
   *
   * @param <T> the type of elements in the collection
   * @param collection the collection of things to examine
   * @param comparator the comparator to use for determining what "comes after" means
   * @param cutoff if an element comes after this cutoff, hasAny will return true
   * @return true if there is at least one element in the collection which comes after the given
   *     cutoff
   */
  public static <T> boolean hasAny(SimpleList<T> collection, Comparator<T> comparator, T cutoff) {

    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method
    return helper2(collection, comparator, cutoff);
  }

  @SuppressWarnings("unchecked")
  private static <T> boolean helper1(T[] collection, Comparator<T> comparator, T cutoff, int i) {

    if (collection.length == 0) {
      return false;
    }
    int compare = comparator.compare((T) Array.get(collection, i), cutoff);

    if (collection.length == 1) {

      compare = comparator.compare((T) Array.get(collection, i), cutoff);
      if (collection.length == 0) {
        return false;
      } else if (compare > 0) {
        return true;
      } else if (compare == 0) {
        return false;
      }
    } else if (i >= collection.length) {
      return false;
    } else if (compare == 0) {
      return false;

    } else if (compare > 0) {
      return true;
    } else {
      compare = comparator.compare((T) Array.get(collection, i), cutoff);
      if (collection.length == 0) {
        return false;
      } else if (compare > 0) {
        return true;
      } else if (compare == 0) {
        return false;
      } else {

        return helper1(collection, comparator, cutoff, i + 1);
      }
    }
    return false;
  }

  private static <T> boolean helper2(SimpleList<T> collection, Comparator<T> comparator, T cutoff) {

    SimpleList<T> something = collection.rest();
    if (collection.isEmpty()) {
      return false;
    } else if (collection.size() == 1) {
      int compare = comparator.compare(collection.first(), cutoff);

      return compare > 0;

    } else {
      int compare = comparator.compare(collection.first(), cutoff);
      if (compare > 0) {
        return true;
      } else if (compare == 0) {
        return false;

      } else {
        return helper2(something, comparator, cutoff);
      }
    }
  }
}
