package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Inventory addAll Tests")
public class Inventory_AddAll_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3);
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44);

  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  @DisplayName(
      "if we add a list of a single item to an empty inventory, the inventory now contains that item")
  void
      if_we_add_a_list_of_a_single_item_to_an_empty_inventory_the_inventory_now_contains_that_item() {

    assertThat(inventory.get()).isEmpty();

    List<Item> thingsToAdd = List.of(WHACKER);

    inventory.addAll(thingsToAdd);

    assertThat(inventory.get()).containsExactly(WHACKER);
  }

  @Test
  @DisplayName("if we add multiple items, the inventory contains those items in that order")
  void if_we_add_multiple_items_the_inventory_contains_those_items_in_that_order() {

    assertThat(inventory.get()).isEmpty();

    List<Item> thingsToAdd = List.of(MINK_PUDDING, POTION_OF_WOOO, WHACKER);

    inventory.addAll(thingsToAdd);

    assertThat(inventory.get()).containsExactly(MINK_PUDDING, POTION_OF_WOOO, WHACKER);
  }

  @Test
  @DisplayName("adding more than 10 things doesn't break anything")
  void adding_more_than_10_things_doesnt_break_anything() {

    for (int i = 1; i <= 8; i++) {
      inventory.add(MINK_PUDDING);
    }

    inventory.addAll(List.of(WHACKER, WHACKER, POTION_OF_WOOO)); // potion is the 11th thing

    assertThat(inventory.get()).doesNotContain(POTION_OF_WOOO);
  }
}
