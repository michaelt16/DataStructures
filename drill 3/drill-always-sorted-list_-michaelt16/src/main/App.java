package main;

import java.util.Scanner;

public class App {

  private AlwaysSortedList<String> asl = new AlwaysSortedList<String>();

  public void run() {
    // TODO: code this run so that it works as shown in the example
    //       output in the instructions - and so that all the tests in MainTests pass as well
    displayInstructions();
    askNStore();
  }

  private void displayInstructions() {
    System.out.println("Hi! I'm the Always Sorted List app!");
    System.out.println("Every word you enter on a line will be added to me in order.");
    System.out.println("I will turn each word to lowercase before it is added.");
    System.out.println("I will keep the words in alphabetic order.");

    System.out.println();

    System.out.println("I will show you my contents after every word.");
    System.out.println("I will stop when you enter an empty line.");

    System.out.println("Ready? Start entering words!");
  }

  public void askNStore() {
    Scanner scanner = new Scanner(System.in);
    String words = scanner.nextLine().toLowerCase();

    asl.add(words);

    if (words.isEmpty()) {
      System.out.println("> Done now! Thanks!");
    } else {
      System.out.println("> contents: " + asl.contents());

      askNStore();
    }
  }
}
