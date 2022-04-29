package main;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    // TODO: spin up a Scanner for keyboard input
    Scanner scanner = new Scanner(System.in);

    // TODO: prompt for and get then number of chickens

    System.out.println("How many chickens do you need?");
    int chickenAmt = scanner.nextInt();

    // TODO: output message that includes the number of chickens
    System.out.println("Spinning up an array to hold exactly " + chickenAmt + " chickens...");

    // TODO: create a properly-sized array to hold these dang chickens
    Chicken[] chickenCount = new Chicken[chickenAmt];
    System.out.println("...and spinning up a same-sized array to hold egg counts...");

    // question for jp: whats the difference between int eggCount[] and int [] eggcount

    // TODO: create a properly-sized array to hold the egg counts (integers) for the
    // chickens - it
    // should be the same size as the Chicken array
    int[] eggCount = new int[chickenAmt];

    System.out.println();

    System.out.println("Here's what's currently in our Chicken array: ");
    // TODO: print out the contents of the Chicken array using Arrays.toString
    System.out.println(Arrays.toString(chickenCount));

    System.out.println();

    System.out.println("And here's what's currently in our egg-count array: ");

    System.out.println(Arrays.toString(eggCount));

    // TODO: print out the contents of the egg counts array using Arrays.toString

    System.out.println();

    System.out.println("Let's add us a chicken!");

    System.out.println();

    // TODO: prompt for and get the name of the chicken to create
    scanner.nextLine();
    System.out.println("Name of bird? ");
    String name = scanner.nextLine();
    System.out.println();

    // TODO: prompt for and get the index to use for chicken storage...I wonder if
    // it will fit in
    // there?!?
    System.out.println("Which index to use (0-" + (chickenCount.length - 1) + ")? ");
    int numbah = scanner.nextInt();
    System.out.println();

    // TODO: output a message saying where the bird is going to go
    System.out.println("Adding " + name + " into slot " + numbah + "...");

    // TODO: create a chicken with the given name
    Chicken chicken = new Chicken(name);

    // TODO: add the chicken to the array at the desired index
    chickenCount[numbah] = chicken;
    System.out.println(
        "...and adding the number of eggs she laid into the egg count array at the same index.");

    // TODO: add the number of eggs laid by the chicken into the egg count array at
    // the proper index...look in the Chicken class to see if the damn bird has
    // a way of telling you how many eggs it laid....
    eggCount[numbah] = chicken.eggsLaid();

    System.out.println();

    System.out.println("Now here's what's in our Chicken array: ");
    // TODO: print out the contents of the Chicken array using Arrays.toString
    System.out.println(Arrays.toString(chickenCount));

    System.out.println();

    System.out.println("And here's what's in our egg-count array: ");
    // TODO: print out the contents of the egg counts array using Arrays.toString
    System.out.println(Arrays.toString(eggCount));
  }
}
