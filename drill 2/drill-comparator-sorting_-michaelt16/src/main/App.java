package main;

import java.util.List;
import java.util.Scanner;

/**
 * A simple inventory application demo.
 *
 * @author jpratt...and you!
 */
public class App {

  private Scanner kbd = new Scanner(System.in);
  private Inventory inventory;

  public void run() {

    buildStartingInventory();

    System.out.println("Here's what we have already....");

    handleNoSortDisplay();

    System.out.println();
    System.out.println("How do you want to view your inventory? ");
    System.out.println();

    String choice = userViewingChoice();
    System.out.println();

    handle(choice);

    System.out.println();

    System.out.println("Here's our inventory - it should be in the same order as earlier:");

    handleNoSortDisplay();
  }

  private void handle(String choice) {

    switch (choice) {
      case "1":
        handleNoSortDisplay();
        break;
      case "2":
        handleNaturalSortDisplay();
        break;
      case "3":
        handleChronoSortDisplay();
        break;
      case "4":
        handleWeightNameSortDisplay();
        break;
      default:
        handleItemTypeDurabilitySortDisplay();
        break;
    }
  }

  private void handleNoSortDisplay() {
    System.out.println("== NOT SORTED ==");
    display(inventory.get());
  }

  private void handleNaturalSortDisplay() {
    System.out.println("== VALUE ORDER (NATURAL ORDER) ==");
    display(inventory.getSortedValue());
  }

  private void handleChronoSortDisplay() {

    System.out.println("== PICKUP ORDER ==");
    display(inventory.getSortedPickup());
  }

  private void handleWeightNameSortDisplay() {
    System.out.println("== WEIGHT, then NAME ORDER ==");
    display(inventory.getSortedWeightName());
  }

  private void handleItemTypeDurabilitySortDisplay() {
    System.out.println("== ITEM TYPE, then DURABILITY ORDER ==");
    display(inventory.getSortedItemTypeDurability());
  }

  private String userViewingChoice() {
    System.out.println("1 - no sorting");
    System.out.println("2 - descending value (natural order)");
    System.out.println("3 - chronological order of pickup");
    System.out.println("4 - ascending weight / alphabetical name");
    System.out.println("5 - item type / ascending durability");
    System.out.println();

    System.out.print("Your choice? ");
    return kbd.nextLine();
  }

  /** Initializes the inventory with some starting items. */
  private void buildStartingInventory() {

    inventory = new Inventory();

    List<Item> startingItems =
        List.of(
            Item.createFood("biscuit", 2, 0.5),
            Item.createPotion("potion of healing", 3),
            Item.createWeapon("yo-yo", 45, 0.2, 12),
            Item.createWeapon("glaive", 100, 10, 4),
            Item.createFood("turnip", 1, 0.5));

    inventory.addAll(startingItems);
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
  private void display(List<Item> stuffs) {
    System.out.printf("You are carrying %d items:%n", inventory.numItems());
    int count = 1;
    for (Item item : stuffs) {
      System.out.printf("%03d", count);
      System.out.println(" - " + item);
      count++;
    }
  }
}
