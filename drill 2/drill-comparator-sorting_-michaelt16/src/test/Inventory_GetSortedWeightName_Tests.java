package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Inventory getSortedWeightName Tests")
public class Inventory_GetSortedWeightName_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2); // weight: 2
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3); // weight: 11
  private static final Item POTION_OF_WOOO =
      Item.createPotion("potion of wooo", 44); // weight: 0.25
  private static final Item POULTRY_GRAB_BAG =
      Item.createFood("poultry grab bag", 3, 11); // weight: 11

  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  @DisplayName("returns an empty list when the inventory is empty")
  void returns_an_empty_list_when_the_inventory_is_empty() {

    assertThat(inventory.getSortedWeightName()).isEmpty();
  }

  @Test
  @DisplayName("returns list of items ordered by weights then names when the inventory has items")
  void returns_list_of_items_ordered_by_weights_then_names_when_the_inventory_has_items() {

    List<Item> thingsToAdd = List.of(WHACKER, POULTRY_GRAB_BAG, MINK_PUDDING, POTION_OF_WOOO);

    inventory.addAll(thingsToAdd);

    assertThat(inventory.getSortedWeightName())
        .containsExactly(POTION_OF_WOOO, MINK_PUDDING, POULTRY_GRAB_BAG, WHACKER);
  }
}
