package main;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class App {

  private Scanner kbd = new Scanner(System.in);

  public void run() {

    chooseBunkPath();

    choosePickyBagPath();
  }

  private void chooseBunkPath() {
    System.out.println();
    System.out.println("Time to use a generic bunk!");
    System.out.println("1 - Integers on top | Strings on bottom, or");
    System.out.println("2 - Duration on top | Duration on botom, or");
    System.out.println("3 - a Bunkable thing on the top | a Comparable thing on the bottom?");
    System.out.println();

    System.out.print("Your choice? ");
    String choice = kbd.nextLine();

    System.out.println();

    if ("1".equals(choice)) {
      handleBunkChoice1();
    } else if ("2".equals(choice)) {
      handleBunkChoice2();
    } else {
      handleBunkChoice3();
    }
  }

  private void handleBunkChoice1() {
    System.out.println("Here's an <Integer, String> BunkBed:");

    System.out.print("What int goes on top? ");
    int num = kbd.nextInt();
    kbd.nextLine();

    System.out.println();

    System.out.print("What String goes on bottom? ");
    String s = kbd.nextLine();

    System.out.println();

    // TODO: create a BunkBed called bunk that holds <Integer, String>

    BunkBed<Integer, String> bunk = new BunkBed(num, s);

    bunk.grabTop(num);
    bunk.grabBottom(s);

    displayBunk(bunk);
  }

  private void handleBunkChoice2() {
    System.out.println("Here's a <Duration, Duration> BunkBed:");

    System.out.print("What duration (in seconds)? ");
    int seconds = kbd.nextInt();
    kbd.nextLine();

    System.out.println();

    System.out.print("What duration (in minutes)? ");
    int minutes = kbd.nextInt();
    kbd.nextLine();

    System.out.println();

    // TODO: create a BunkBed called bunk that holds <Duration, Duration>

    BunkBed<Duration, Duration> bunk = new BunkBed(seconds, minutes);

    bunk.grabTop(Duration.ofSeconds(seconds));
    bunk.grabBottom(Duration.ofMinutes(minutes));

    displayBunk(bunk);
  }

  private void handleBunkChoice3() {
    System.out.println("Here's a <Bunkable, Comparable> BunkBed:");

    System.out.print("What Bunkable (kid name) goes on top? ");
    String name = kbd.nextLine();

    // TODO: make Kid implement Bunkable for this next line to work - you can use the code that
    // Eclipse auto-generates
    Bunkable kid = new Kid(name);

    System.out.println();

    System.out.print("Boolean is Comparable. What Boolean (T/F) goes on bottom?");
    String boolText = kbd.nextLine();
    Boolean bool = Boolean.valueOf(boolText);

    // TODO: create a BunkBed called bunk that holds <Bunkable, Boolean>
    BunkBed<Bunkable, Boolean> bunk = new BunkBed(kid, bool);

    bunk.grabTop(kid);
    bunk.grabBottom(bool);

    displayBunk(bunk);
  }

  private void displayBunk(BunkBed bunk) {
    System.out.println();

    System.out.println("RESULT:");
    System.out.println("on top: " + bunk.onTop());
    System.out.println("on bottom: " + bunk.onBottom());
  }

  private void choosePickyBagPath() {
    System.out.println();
    System.out.println("Time to use a generic PickyBag!");
    System.out.println("1 - Bag should hold ints, or");
    System.out.println("2 - Bag should hold Chickens, or");
    System.out.println("3 - Bag should hold Collections?");
    System.out.println();

    System.out.print("Your choice? ");
    String choice = kbd.nextLine();

    System.out.println();

    if ("1".equals(choice)) {
      handleBagChoice1();
    } else if ("2".equals(choice)) {
      handleBagChoice2();
    } else {
      handleBagChoice3();
    }
  }

  private void handleBagChoice1() {
    int[] intsToAdd = {4, 5, 6, 4, 5, 6, 7};

    // TODO: output "Adding [toString version of intsToAdd] to this picky bag:"
    System.out.printf("Adding %s to this picky bag:\n", Arrays.toString(intsToAdd));

    // TODO: create a PickyBag called bag that holds <Integer>
    PickyBag<Integer> bag = new PickyBag();

    // TODO: add all the intsToAdd to bag
    for (int ints : intsToAdd) {
      bag.add(ints);
    }
    System.out.println("Here's what's in the picky bag now: " + bag);

    System.out.println();

    System.out.print("What other int should we try to add? ");
    int num = kbd.nextInt();
    kbd.nextLine();

    bag.add(num);

    System.out.println();

    System.out.printf("After trying to add %d, here's what's in the picky bag now: %s%n", num, bag);

    displayBagPull(bag);
  }

  private void handleBagChoice2() {
    Chicken[] chickens = {
      new Chicken("Linda Lee", 2), new Chicken("Rhoda", 4), new Chicken("Cthenlu", 4_000_000)
    };

    // TODO: output "Adding [toString version of chickens] to this picky bag:"
    System.out.printf("Adding %s to this picky bag:\n", Arrays.toString(chickens));

    // TODO: create a PickyBag called bag that holds <Chicken>
    PickyBag<Chicken> bag = new PickyBag();

    // TODO: add all the chickens to bag
    for (Chicken chicken : chickens) {
      bag.add(chicken);
    }

    System.out.println("Here's what's in the picky bag now: " + bag);

    System.out.println();

    System.out.println("What chicken should we try to add (weeks name)? ");
    int weeks = kbd.nextInt();
    String name = kbd.nextLine().trim();

    Chicken chicken = new Chicken(name, weeks);

    bag.add(chicken);

    System.out.println();

    System.out.printf(
        "After trying to add %s, here's what's in the picky bag now: %s%n", chicken, bag);

    displayBagPull(bag);
  }

  private void handleBagChoice3() {

    Collection[] collections = {
      List.of("hi", "there"),
      List.of(4, 2),
      List.of(new Kid("Eunice"), new Kid("Lesley"), new Kid("Momo")),
      List.of(new Chicken("Al", 3), new Chicken("Enri", 42))
    };

    // TODO: output "Adding [toString version of collections] to this picky bag:"
    System.out.printf("Adding %s to this picky bag:\n", Arrays.toString(collections));

    // TODO: create a PickyBag called bag that holds <Collection>

    PickyBag<Collection> bag = new PickyBag();

    // TODO: add all the collections to bag
    for (Collection collection : collections) {
      bag.add(collection);
    }

    System.out.println("Here's what's in the picky bag now: " + bag);

    System.out.println();

    System.out.println("What collection of words should we try to add (separate with spaces)? ");
    String words = kbd.nextLine();
    String[] split = words.split(" ");

    bag.add(List.of(split));

    System.out.println();

    System.out.printf(
        "After trying to add %s, here's what's in the picky bag now: %s%n", List.of(split), bag);

    displayBagPull(bag);
  }

  private void displayBagPull(PickyBag bag) {
    System.out.println();
    System.out.println("Closing my eyes and pulling something out of this bag...");
    Object thingGrabbed = bag.pullRandom();
    System.out.println("....and I pull out a " + thingGrabbed);
  }
}
