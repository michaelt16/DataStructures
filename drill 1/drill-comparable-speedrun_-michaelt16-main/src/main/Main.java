package main;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner kbd = new Scanner(System.in);

    NoiseReading reading = createNoiseReading(kbd);

    // TODO: using the shortcut syntax, make an array of Comparable called readings.
    //       It should contain the following, in this order:
    //       - a new NoiseReading (db: 12)
    //       - the reading created above
    //       - a new NoiseReading (db: 12)

    Comparable[] readings = {new NoiseReading(12), reading, new NoiseReading(12)};

    displayComparisonsFor(readings);

    // TODO: using the shortcut syntax, make an array of Comparable called materials.
    //       It should contain the following, in this order:
    //       - the material created above
    //       - a new Material (name: blood, density: 1.6)
    //       - a new Material (name: granite, density: 2700)
    Material material = createMaterial(kbd);
    System.out.println();

    Comparable[] materials = {material, new Material("blood", 1.6), new Material("granite", 2700)};

    displayComparisonsFor(materials);

    // TODO: using the shortcut syntax, make an array of Comparable called movies.
    //       It should contain the following, in this order:
    //       - a new Movie (title: Aliens, year: 1986)
    //       - a new Movie (title: Battleship Potemkin, year: 1925)
    //       - the movie created above
    Movie movie = createMovie(kbd);
    System.out.println();

    Comparable[] movies = {
      new Movie("Aliens", 1986), new Movie("Battleship Potemkin", 1925), movie
    };

    displayComparisonsFor(movies);
  }

  private static Movie createMovie(Scanner kbd) {
    System.out.print("Title of movie? ");
    String title = kbd.nextLine();

    System.out.println();

    System.out.print("Year of release? ");
    String yearAsText = kbd.nextLine();
    int year = Integer.parseInt(yearAsText);

    return new Movie(title, year);
  }

  private static Material createMaterial(Scanner kbd) {
    System.out.print("Name of material? ");
    String name = kbd.nextLine();

    System.out.println();

    System.out.print("Denisty of material? ");
    String densityAsText = kbd.nextLine();
    double density = Double.parseDouble(densityAsText);

    return new Material(name, density);
  }

  private static NoiseReading createNoiseReading(Scanner kbd) {
    System.out.print("Noise reading in dB? ");
    String dbAsText = kbd.nextLine();
    int db = Integer.parseInt(dbAsText);

    return new NoiseReading(db);
  }

  private static void displayComparisonsFor(Comparable[] materials) {
    String arrayName = materials.getClass().getSimpleName();
    String contentName = materials[0].getClass().getSimpleName();
    int numThings = materials.length;

    System.out.println();
    System.out.printf(
        "Here are the natural orderings for the %d %s objects in the %s array:%n",
        numThings, contentName, arrayName);

    for (int i = 0; i < numThings; i++) {
      for (int j = 0; j < numThings; j++) {
        Comparable thingOne = materials[i];
        Comparable thingTwo = materials[j];
        System.out.println(thingOne + position(thingOne, thingTwo) + thingTwo);
      }
    }
    System.out.println();
  }

  /**
   * Given Comparables t1 and t2, returns a String describing the ordering of t1 and t2.
   *
   * <p>The String returned is:
   *
   * <ul>
   *   <li>" comes before " if t1 comes before t2
   *   <li>" comes after " if t1 comes after t2
   *   <li>" is the same as " if t1 is the same as t2
   * </ul>
   *
   * @param t1 a Comparable thing
   * @param t2 another Comparable thing
   * @return the String described above
   */
  private static String position(Comparable t1, Comparable t2) {
    // TODO: complete this method so it behaves as described
    if (t1.compareTo(t2) > 0) {
      return " comes after ";

    } else if (t1.compareTo(t2) < 0) {
      return " comes before ";
    } else {
      return " is the same as ";
    }
  }
}
