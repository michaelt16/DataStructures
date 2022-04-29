package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Comparator;

/**
 * Represents something you can pick up and carry around with you in a game.
 *
 * <p>We'll consider two Items equal if all their fields are equal.
 *
 * <p>The natural ordering of Items should be descending value; that is, more valuable items come
 * before less valuable one.
 *
 * @author jpratt
 */
public final class Item implements Comparable<Item>, FakeDateTime {

  private static final double DEFAULT_POTION_WEIGHT = 0.25;
  public static final Comparator<Item> ItemTypeComparator =
      (item1, item2) -> item1.itemType.compareTo(item2.itemType);

  private enum ItemType {
    WEAPON,
    FOOD,
    POTION
  }

  private String name;
  private LocalDateTime pickedUp;
  private int value;
  private double weight;
  private int durability;
  private ItemType itemType;

  /**
   * Copy constructor for Items.
   *
   * @param other the Item being copied
   */
  public Item(Item otherItem) {
    // TODO: complete this copy constructor
    this.name = otherItem.name;
    this.pickedUp = otherItem.pickedUp;
    this.value = otherItem.value;
    this.weight = otherItem.weight;
    this.durability = otherItem.durability;
    this.itemType = otherItem.itemType;
  }

  /**
   * Simple factory for weapon Items.
   *
   * @param name the name of this weapon
   * @param value the value of this weapon
   * @param weight the weight of this weapon
   * @param durability the durability of this weapon
   * @return the Item (which is a weapon)
   */
  public static Item createWeapon(String name, int value, double weight, int durability) {
    Item item = new Item();
    item.name = name;
    item.pickedUp = FakeDateTime.createFrom(name, value);
    item.value = value;
    item.weight = weight;
    item.durability = durability;
    item.itemType = ItemType.WEAPON;

    return item;
  }

  /**
   * Simple factory for food Items.
   *
   * <p>It's assumed that food has a durability of 0.
   *
   * @param name the name of this food
   * @param value the value of this food
   * @param weight the weight of this food
   * @return the Item (which is a food)
   */
  public static Item createFood(String name, int value, double weight) {
    Item item = new Item();
    item.name = name;
    item.pickedUp = FakeDateTime.createFrom(name, value);
    item.value = value;
    item.weight = weight;
    item.durability = 0;
    item.itemType = ItemType.FOOD;

    return item;
  }

  /**
   * Simple factory for potion Items.
   *
   * <p>It's assumed that potions have a default weight and durability.
   *
   * @param name the name of this potion
   * @param value the value of this potion
   * @return the Item (which is a potion)
   */
  public static Item createPotion(String name, int value) {
    Item item = new Item();
    item.name = name;
    item.pickedUp = FakeDateTime.createFrom(name, value);
    item.value = value;
    item.weight = DEFAULT_POTION_WEIGHT;
    item.durability = 1;
    item.itemType = ItemType.POTION;

    return item;
  }

  /** We only want to create Items using the "createBlah" methods. */
  private Item() {}

  public String getName() {
    return name;
  }

  public LocalDateTime getPickedUp() {
    return pickedUp;
  }

  public int getValue() {
    return value;
  }

  public double getWeight() {
    return weight;
  }

  public int getDurability() {
    return durability;
  }

  public boolean isWeapon() {
    return itemType == ItemType.WEAPON;
  }

  public boolean isFood() {
    return itemType == ItemType.FOOD;
  }

  public boolean isPotion() {
    return itemType == ItemType.POTION;
  }

  @Override
  public String toString() {
    String formattedPickup =
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(pickedUp);

    return String.format(
        "%s [%s] (v:%d, w:%.1f, d:%d, t:%s)",
        name, formattedPickup, value, weight, durability, itemType);
  }

  @Override
  public int compareTo(Item otherItem) { // TODO Auto-generated method stub
    return otherItem.value - this.value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + durability;
    result = prime * result + ((itemType == null) ? 0 : itemType.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((pickedUp == null) ? 0 : pickedUp.hashCode());
    result = prime * result + value;
    long temp;
    temp = Double.doubleToLongBits(weight);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Item other = (Item) obj;
    if (durability != other.durability) {
      return false;
    }
    if (itemType != other.itemType) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (pickedUp == null) {
      if (other.pickedUp != null) {
        return false;
      }
    } else if (!pickedUp.equals(other.pickedUp)) {
      return false;
    }
    if (value != other.value) {
      return false;
    }

    return Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
  }
}
