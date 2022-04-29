package main;

import java.util.Scanner;

public class App {
  private AlwaysSortedLinkedList<String> asll = new AlwaysSortedLinkedList<>();

  public void run() {

    // TODO: code this run so that it works as shown in the example
    //       output in the instructions - and so that all the tests in MainTests pass as well
    displayDemInstructions();
    dooer();
    System.out.println("Here are the words, in order:");
    for (int i = 0; i < asll.size(); i++) {
      System.out.print(asll.get(i) + " ");
    }
  }

  private void displayDemInstructions() {
    System.out.println("Enter a list of words separated by spaces.");
    System.out.println("If the word has a + in front of it, I'll add it.");
    System.out.println("If the word has a - in front of it, I'll remove it.");
    System.out.println("Otherwise, I'll ignore it.");
    System.out.println("I'll stop when you enter a # for the word.");
    System.out.println("Let's begin!");
    System.out.println();
  }
  // helper

  private void dooer() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Your words>");
    String input = scanner.nextLine();
    String[] split = input.split(" ");

    for (String loop : split) {
      String s = loop;
      // System.out.println(s);
      String word = s.substring(1);
      if ("-".equals(s.substring(0, 1))) {
        asll.remove(word);

      } else if ("+".equals(s.substring(0, 1))) {
        asll.add(word);
      }
    }
    scanner.close();
  }
}
