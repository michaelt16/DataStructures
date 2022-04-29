package test;

/**
 * Just used for testing, eh?
 *
 * @author jpratt
 */
public class Pip implements Comparable<Pip> {
  private int pip;

  Pip(int pip) {
    this.pip = pip;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + pip;
    return result;
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
    Pip other = (Pip) obj;
    if (pip != other.pip) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(Pip otherPip) {
    return Integer.compare(this.pip, otherPip.pip);
  }

  @Override
  public String toString() {
    return String.format("pip[%d]", pip);
  }
}
