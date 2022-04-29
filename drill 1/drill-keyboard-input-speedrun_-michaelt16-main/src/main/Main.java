package main;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // TODO: create a Scanner that can do the keyboard input for you
    Scanner scanner = new Scanner(System.in);

    // TODO: prompt for and get a name

    System.out.print("What is your name?");
    String name = scanner.nextLine();

    System.out.println();

    // TODO: prompt for and get an integer age
    System.out.print("How old are you, " + name + "?");
    int number = scanner.nextInt();

    System.out.println();

    // TODO: calculate and print out the "If I were half that age..." message
    // Careful with the number of decimal places...
    double half = number / 2.0;

    System.out.printf("If I were half that age, I'd be %.1f.", half);

    System.out.println();

    // TODO: prompt for and get 2 or more words separated by whitespace

    System.out.print("Gimme at least two words. Separate them with spaces: ");
    String moreWords = scanner.next();

    System.out.println();

    // TODO: calculate and print out "The first word that you gave me...." message
    System.out.print("The first word that you gave me was \"" + moreWords + "\".");
  }

  //  public static String twoWords(String word) {
  //    System.out.println(" ");
  //    System.out.println("Gimme at least two words. Separate them with spaces: ");
  //    System.out.println(" ");
  //    Scanner scanner = new Scanner(System.in);
  //    word = scanner.nextLine();
  //    if (word.contains(" ")) {
  //
  //      return word;
  //
  //    } else {
  //      twoWords(" ");
  //    }
  //
  //    return word;
  //  }
}
