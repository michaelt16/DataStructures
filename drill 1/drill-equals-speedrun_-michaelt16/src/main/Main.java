package main;

import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner kbd = new Scanner(System.in);

    List<Integer> someNumbers = List.of(4, 11, 2, 18, 18, 1, 6, 9);

    // these are all white dice (except for one) with the given numbers showing
    List<Dice> someDice =
        List.of(
            new Dice(4),
            new Dice(11),
            new Dice(2),
            new Dice("red", 18),
            new Dice(18),
            new Dice(1),
            new Dice(6),
            new Dice(9));

    // TODO: prompt for and get a number to find. There's a method for that....

    int numbah = intFromUser(kbd, "What number are you looking for?");

    // TODO: search for the number from the user in someNumbers. There's a method for that....

    searchFor(numbah, someNumbers);
    // TODO: prompt for and get a dice number to look for.

    int num = intFromUser(kbd, "What dice number are you looking for? ");
    // TODO: create a white dice from that number
    Dice diceWhite = new Dice(num);
    // TODO: search for the dice you created in someDice.
    searchFor(diceWhite, someDice);
  }

  private static int intFromUser(Scanner kbd, String prompt) {
    System.out.print(prompt);
    String intAsText = kbd.nextLine();

    System.out.println();

    return Integer.parseInt(intAsText);
  }

  private static void searchFor(Object thingToFind, List whereToSearch) {
    if (whereToSearch.contains(thingToFind)) {
      int indexWhereFound = whereToSearch.indexOf(thingToFind);
      System.out.printf("Found at least one %s! It's at index %d.%n", thingToFind, indexWhereFound);
    } else {
      System.out.println("Sorry...no " + thingToFind + " in " + whereToSearch);
    }
    System.out.println();
  }
}
