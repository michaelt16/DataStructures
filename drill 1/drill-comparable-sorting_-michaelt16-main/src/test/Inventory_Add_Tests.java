package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Inventory add tests")
public class Inventory_Add_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3);
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44);

  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  @DisplayName("if we add an item to an empty inventory, the inventory now contains that item")
  void if_we_add_an_item_to_an_empty_inventory_the_inventory_now_contains_that_item() {

    assertThat(inventory.get()).isEmpty();
    assertThat(inventory.numItems()).isEqualTo(0);

    inventory.add(MINK_PUDDING);

    assertThat(inventory.get()).containsExactly(MINK_PUDDING);
    assertThat(inventory.numItems()).isEqualTo(1);
  }

  @Test
  @DisplayName("if we add multiple items, the inventory contains those items in that order")
  void if_we_add_multiple_itemsss_the_inventory_contains_those_items_in_that_order() {

    assertThat(inventory.get()).isEmpty();
    assertThat(inventory.numItems()).isEqualTo(0);

    inventory.add(POTION_OF_WOOO);
    inventory.add(MINK_PUDDING);
    inventory.add(WHACKER);

    assertThat(inventory.get()).containsExactly(POTION_OF_WOOO, MINK_PUDDING, WHACKER);
    assertThat(inventory.numItems()).isEqualTo(3);
  }

  @Test
  @DisplayName("adding more than 10 things doesn't break anything")
  void adding_more_than_10_things_doesnt_break_anything() {

    for (int i = 1; i <= 10; i++) {
      inventory.add(MINK_PUDDING);
    }

    inventory.add(WHACKER); // this is the 11th thing

    assertThat(inventory.get()).doesNotContain(WHACKER);
    assertThat(inventory.numItems()).isEqualTo(10);
  }
}
