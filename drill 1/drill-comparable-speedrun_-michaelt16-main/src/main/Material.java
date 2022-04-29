package main;

/**
 * Represents a chunk of material. Tres exciting!
 *
 * <p>We'll assume we'd like to track a name and density (in kg/m3) for this material.
 *
 * <p>The natural ordering of Material is in ascending order of density. If two Materials have the
 * same density, they should then be sorted in alphabetic order by name.
 *
 * @author jpratt
 */
public class Material implements Comparable<Material>  {

  private String name;
  private double density;

  /**
   * Creates a Material with a given name and density.
   *
   * @param name the name of this Material
   * @param density the density of this Material in kg/m3
   */
  public Material(String name, double density) {
    this.name = name;
    this.density = density;
  }

  @Override
  public String toString() {
    return String.format("%s(%.2fkg/m3)", name, density);
  }

  @Override
  public int compareTo(Material otherMaterial) {
    int dif = (int) (this.density - otherMaterial.density);
    if (dif == 0) {
      return this.name.compareToIgnoreCase(otherMaterial.name);
    } else {
      return (int) (this.density - otherMaterial.density);
    }
  }
}
