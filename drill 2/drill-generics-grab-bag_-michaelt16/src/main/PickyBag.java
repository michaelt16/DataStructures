package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * A PickyBag is currently an ordered collection of ints; if you try to add an int to a PickyBag and
 * it is already there, it doesn't get added.
 *
 * <p>BUT we want PickyBag is be an unordered collection of ANY kind of thing; if you try to add
 * something to a PickyBag and that thing is already there, it doesn't get added. (More precisely,
 * if we're trying to add t and there already is a thing e already in the bag such that
 * Objects.equals(t, e) is true, then t doesn't get added.
 *
 * @author jpratt
 * @param <T> the type of thing that's in the bag
 */
public class PickyBag<T> {
  private Random rgen;
  private Collection<T> thingsInBag;

  /**
   * Create a PickyBag that's empty.
   *
   * <p>We use the seed 1 in Random to make the tests predictable.
   */
  public PickyBag() {
    thingsInBag = new ArrayList<>();
    rgen = new Random(1);
  }

  /**
   * Add an int to this PickyBag. If it already exists in the bag, then it is not added.
   *
   * @param thingToAdd the int to add to this PickyBag
   */
  public void add(T thingToAdd) {
    if (!thingsInBag.contains(thingToAdd)) {
      thingsInBag.add(thingToAdd);
    }
  }

  /**
   * Removes and returns a random int from this PickyBag.
   *
   * @return the int removed from this PickyBag
   */
  public T pullRandom() {
    int indexToPull = rgen.nextInt(thingsInBag.size());
    T thingToReturn = (T) thingsInBag.toArray()[indexToPull];

    thingsInBag.remove(thingToReturn);
    return thingToReturn;
  }

  @Override
  public String toString() {
    return thingsInBag.toString();
  }
}
