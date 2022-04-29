package main;

/**
 * A Kid with a name.
 *
 * @author jpratt
 */
public class Kid implements Bunkable {

  private String name;

  public Kid(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public void bunk() { // TODO Auto-generated method stub
  }
}
