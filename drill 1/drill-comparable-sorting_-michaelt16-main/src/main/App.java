package main;

import java.util.List;
import java.util.Scanner;

/**
 * A simple inventory application demo.
 *
 * @author jpratt
 */
public class App {

  private Scanner kbd = new Scanner(System.in);
  private Inventory inventory;

  public void run() {

    buildStartingInventory();

    System.out.println("Here's what we have already....");

    displayInventory();

    System.out.println();
    System.out.println("Let's add a potion to our stuff....");
    System.out.println();

    addPotionToInventory();

    displayInventory();

    System.out.println();
    System.out.println("The inventory in natural sorted order is....");
    System.out.println();

    displaySortedInventory();
  }

  /** Initializes the inventory with some starting items. */
  private void buildStartingInventory() {
    // TODO: initialize the inventory field
    // TODO: populate the inventory with the following (in this order):
    //       1. a food item: (name: turnip, value: 1, weight: 0.5)
    //       2. a potion item: (name: potion of healing, value: 3)
    //       3. a weapon item: (name: glaive, value: 100, weight: 10, durability: 4)
    inventory = new Inventory();

    Item turnip = Item.createFood("turnip", 1, 0.5);
    Item pot = Item.createPotion("potion of healing", 3);
    Item glaive = Item.createWeapon("glaive", 100, 10, 4);
    inventory.add(turnip);
    inventory.add(pot);
    inventory.add(glaive);
  }

  /** Adds a potion to the inventory after gathering the necessary info from the user. */
  private void addPotionToInventory() {
    System.out.print("What kind of potion did you pick up? ");
    String potionName = kbd.nextLine();

    System.out.println();

    System.out.print("How much is it worth? ");
    String valueAsText = kbd.nextLine();
    int value = Integer.parseInt(valueAsText);

    System.out.println();

    Item potion = Item.createPotion(potionName, value);
    inventory.add(potion);
  }

  /**
   * Displays the items in the inventory, in the order they were added.
   *
   * <p>Should look like:
   *
   * <pre>
   * You are carrying [num] items:
   * - thing
   * - thing
   * - thing
   * </pre>
   */
  private void displayInventory() {
    // TODO: make this work as per the documentation
    // hint: how do you ask the inventory for the items in it?
    System.out.printf("You are carrying %d items: %n", inventory.numItems());
    List<Item> list = inventory.get();
    for (Item items : list) {
      System.out.println("- " + items);
    }
  }

  /**
   * Displays the items in the inventory, in their natural order.
   *
   * <p>Should look like:
   *
   * <pre>
   * You are carrying [num] items (sorted):
   * - thing
   * - thing
   * - thing
   * </pre>
   */
  private void displaySortedInventory() {
    // TODO: make this work as per the documentation
    // hint: how do you ask the inventory for the items in it in sorted order?
    System.out.printf("You are carrying %d items (sorted):%n", inventory.numItems());
    List<Item> ordered = inventory.getSorted();
    for (int i = 0; i < inventory.numItems(); i++) {
      System.out.println("- " + ordered.get(i));
    }
  }
}
