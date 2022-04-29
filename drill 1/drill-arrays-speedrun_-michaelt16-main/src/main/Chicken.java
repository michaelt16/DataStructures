package main;

/**
 * Represents a chicken with a given name which always lays the same amount of eggs - the number of
 * letters in her name.
 *
 * @author jpratt
 */
public class Chicken {

  private String name;
  private final int numEggsToLay;

  public Chicken(String name) {
    this.name = name;
    numEggsToLay = name.length();
  }

  public String name() {
    return this.name;
  }

  public int eggsLaid() {
    return numEggsToLay;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
