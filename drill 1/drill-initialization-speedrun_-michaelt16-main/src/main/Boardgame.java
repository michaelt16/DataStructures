package main;

public class Boardgame {
  private String name;
  private int rating;

  public Boardgame(String name, int rating) {
    this.name = name;
    this.rating = rating;
  }

  @Override
  public String toString() {
    return String.format("%s (%d)", name, rating);
  }
}
