package main;

/**
 * This currently represents a BunkBed that can hold a Kid in the top bunk and a kid in the bottom
 * bunk...but it needs to be turned into something more generic!
 *
 * <p>We want these BunkBeds to hold *anything* in the top bunk and *anything that's comparable* on
 * the bottom.
 *
 * @author jpratt
 * @param <T> the type of thing to go in the top bunk
 * @param <B> the type of thing to go in the bottom bunk; it must be a Comparable(B) thing
 */
public class BunkBed<T, B> {

  private T top;
  private B bottom;

  public BunkBed(T top, B bottom) {
    this.top = top;
    this.bottom = bottom;
  }

  /**
   * Put a kid in the top bunk.
   *
   * @param top the kid going in the top bunk
   */
  public void grabTop(T top) {
    this.top = top;
  }

  /**
   * Put a kid in the bottom bunk.
   *
   * @param bottom the kid going in the bottom bunk
   */
  public void grabBottom(B bottom) {
    this.bottom = bottom;
  }

  /**
   * Returns the kid on the top.
   *
   * @return the kid on the top
   */
  public T onTop() {
    return top;
  }

  /**
   * Returns the kid on the bottom.
   *
   * @return the kid on the bottom
   */
  public B onBottom() {
    return bottom;
  }

  @Override
  public String toString() {
    return String.format("%s%n------%n%s%n", top, bottom);
  }
}
