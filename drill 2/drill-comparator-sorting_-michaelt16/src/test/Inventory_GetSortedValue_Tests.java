package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Inventory getSortedValue Tests")
public class Inventory_GetSortedValue_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2); // value: 0
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3); // value: 2
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44); // value: 44

  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  @DisplayName("returns an empty list when the inventory is empty")
  void returns_an_empty_list_when_the_inventory_is_empty() {

    assertThat(inventory.getSortedValue()).isEmpty();
  }

  @Test
  @DisplayName(
      "returns list of items ordered by descending item values when the inventory has items")
  void returns_list_of_items_ordered_by_descending_item_values_when_the_inventory_has_items() {

    List<Item> thingsToAdd = List.of(MINK_PUDDING, WHACKER, POTION_OF_WOOO);

    inventory.addAll(thingsToAdd);

    assertThat(inventory.getSortedValue()).containsExactly(POTION_OF_WOOO, WHACKER, MINK_PUDDING);
  }
}
