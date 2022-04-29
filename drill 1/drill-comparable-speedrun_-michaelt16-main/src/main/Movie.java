package main;

import java.time.Year;

/**
 * Represents a movie. Like you see in the theatre. Or on your phone.
 *
 * <p>We'll track only titles and year of release for each Movie.
 *
 * <p>The natural ordering of Material is in ascending order of year. If two Movies have the same
 * year of release, they should then be sorted in reverse alphabetic order by title.
 *
 * @author jpratt
 */
public class Movie implements Comparable<Movie> {

  private String title;
  private Year year;

  /**
   * Creates a Movie with a given title and year of release.
   *
   * @param title the title of this Movie
   * @param year the year of release of this Movie
   */
  public Movie(String title, int year) {
    this.title = title;
    this.year = Year.of(year);
  }

  @Override
  public String toString() {
    return String.format("%s (%s)", title, year);
  }

  @Override
  public int compareTo(Movie otherMovie) {
    if (this.year.getValue() - otherMovie.year.getValue() == 0) {
      return this.title.compareTo(otherMovie.title) * -1;
    }
    return this.year.getValue() - otherMovie.year.getValue();
  }
}
