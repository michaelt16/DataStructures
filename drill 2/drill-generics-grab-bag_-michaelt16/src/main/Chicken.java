package main;

/**
 * We've seen Chickens before. These ones have a name and an age in weeks.
 *
 * <p>Two chickens are equal if they have the same name and age.
 *
 * @author jpratt
 */
public class Chicken {

  private String name;
  private int ageInWeeks;

  public Chicken(String name, int ageInWeeks) {
    this.name = name;
    this.ageInWeeks = ageInWeeks;
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", name, ageInWeeks);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ageInWeeks;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
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
    Chicken other = (Chicken) obj;
    if (ageInWeeks != other.ageInWeeks) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    return true;
  }
}
