package main;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a colored 20-sided dice.
 *
 * <p>Two dice are considered equal if they have the same number showing and the same color.
 *
 * @author jpratt
 */
public class Dice {

  private static final Random rgen = new Random();
  private String color;
  private int numberShowing;

  /**
   * Creates a Dice with a given color and number showing.
   *
   * @param color the color of this Dice
   * @param numShowing the number showing on this Dice
   */
  public Dice(String color, int numShowing) {
    this.color = color;
    this.numberShowing = numShowing;
  }

  /**
   * Creates a white dice with a given number showing.
   *
   * @param numShowing the number showing on this Dice
   */
  public Dice(int numShowing) {
    this("white", numShowing);
  }

  /**
   * Creates a dice of a given color with a random number between 1 and 20 showing.
   *
   * @param color the color of this Dice
   */
  public Dice(String color) {
    this(color, rgen.nextInt(20) + 1);
  }

  /** Creates a white dice with a random number between 1 and 20 showing. */
  public Dice() {
    this("white");
  }

  /**
   * Returns the text version of a dice.
   *
   * <p>It's the [number showing][capitalized first letter of color].
   *
   * @return the String as described
   */
  @Override
  public String toString() {
    String cappedFirstLetterOfColor = color.toUpperCase().substring(0, 1);
    return String.format("%d(%s)", numberShowing, cappedFirstLetterOfColor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(color, numberShowing);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Dice other = (Dice) obj;
    return Objects.equals(color, other.color) && numberShowing == other.numberShowing;
  }
}
