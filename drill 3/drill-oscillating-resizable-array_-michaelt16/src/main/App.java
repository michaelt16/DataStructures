package main;

import java.util.Scanner;

public class App {

  private OscillatingResizableList<String> list = new OscillatingResizableList<>();

  public void run() {

    // TODO: code this run so that it works as shown in the example
    //       output in the instructions - and so that all the tests in MainTests pass as well
    displayInstructions();
    dooer();
  }

  private void displayInstructions() {
    System.out.println("Hi! I'm the Oscillating Resizable List app!");
    System.out.println("Please enter one integer per line.");
    System.out.println("I will add that number to the list and then show you its contents.");

    System.out.println();

    System.out.println("I will stop when you enter an empty line.");

    System.out.println();

    System.out.println("Ready? Start entering numbers!");
  }

  public void dooer() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    // i can do while loop or recursion
    if (input.isEmpty()) {
      System.out.println(" > Done now! Thanks!");
    } else {
      list.add(input);
      System.out.println("> contents: " + list.contents());
      dooer();
    }
  }
}
