package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents the Items carried by a character in a video game.
 *
 * <p>For simplicity, this inventory is implemented using an array of Items of fixed size 10.
 *
 * @author jpratt
 */
public class Inventory {

  private static final int DEFAULT_SIZE = 10;

  private int numItems;
  private Item[] items;

  /**
   * Creates an Inventory that has no items in it.
   *
   * <p>Don't forget to initialize your fields!
   */
  public Inventory() {
    // TODO: complete this constructor

    this.numItems = 0;
    this.items = new Item[DEFAULT_SIZE];
  }

  /**
   * Returns the number of items in this Inventory.
   *
   * @return the number of items in this Inventory
   */
  // TODO: create a numItems method
  public int numItems() {
    return this.numItems; // or array.length()
  }

  /**
   * Add an item to this Inventory.
   *
   * <p>Assumption: if adding the item would overfill the inventory, the item is NOT added, but no
   * indication of failure is given.
   *
   * @param item the item to add to this Inventory
   */
  // TODO: create an add method

  public void add(Item item) {
    // loop look for empty spot in array. if empty, make it so that array at that index turns into
    // "item. if its full don't do
    // anything

    /* for (int i = 0; i < this.items.length; i++) {
    if (this.items[i] == null) { // turn this into if the spot in the array is empty

      this.items[i] = item;
      i = this.items.length;*/

    if (numItems() < this.items.length) {
      this.items[numItems] = new Item(item);
      numItems++;
    }
  }

  /**
   * Adds a number of items to this Inventory.
   *
   * <p>Assumption: any attempt to overfill the inventory will fail silently.
   *
   * @param items the items to add to this Inventory
   */
  // TODO: create an addAll method
  // hint: if you've done add(), then this method is easy-peasy
  public void addAll(List<Item> itemArray) {

    for (Item item : itemArray) {
      add(item);
    }
  }

  /**
   * Return a list of all the Items in this Inventory in the order they appear in the backing array.
   *
   * <p>Any nulls in the array are not included.
   *
   * @return a list of all non-null Items in this Inventory in order of array appearance
   */
  // TODO: create a get method
  //
  // hint: there are some nice ways to copy an array - or part of an array - in the Arrays
  // library. Look into copyOf.
  //
  // hint: you can use List.of to make a list from an array

  public List<Item> get() {

    List<Item> newList = new ArrayList<>();
    for (Item item : items) {
      if (item != null) {
        newList.add(item);
      }
    }
    return newList;
  }

  /**
   * Return a list of all the Items in this Inventory in their natural order.
   *
   * <p>Any nulls in the array are not included.
   *
   * @return a list of all non-null Items in this Inventory in natural order
   */
  public List<Item> getSortedValue() {

    List<Item> newList = new ArrayList<>(get());
    Collections.sort(newList);
    return newList;

    // TODO: complete getSorted
    // hint: you can use Collections.sort to sort the result and return it

  }

  // TODO: add a getSortedPickup method that returns a List<Item> in chronological pickup order
  public List<Item> getSortedPickup() {
    Comparator<Item> comparedPickup = Comparator.comparing(Item::getPickedUp);
    List<Item> copy = new ArrayList<>(get());
    Collections.sort(copy, comparedPickup);

    return copy;
  }
  // add a getSortedWeightName method that returns a List<Item> in ascending weight then alphabetic
  // name order

  public List<Item> getSortedWeightName() {

    Comparator<Item> weightThenAlph =
        Comparator.comparing(Item::getWeight).thenComparing(Item::getName);
    List<Item> copy = new ArrayList<>(get());
    Collections.sort(copy, weightThenAlph);
    return copy;
  }
  // add a getSortedItemTypeDurability method that returns a List<Item> in ascending itemType then
  // ascending durability order

  public List<Item> getSortedItemTypeDurability() {

    Comparator<Item> compareTypeThenDur =
        Item.ItemTypeComparator.thenComparing(Item::getDurability);
    List<Item> copy = new ArrayList<>(get());
    Collections.sort(copy, compareTypeThenDur);
    return copy;
  }
}
