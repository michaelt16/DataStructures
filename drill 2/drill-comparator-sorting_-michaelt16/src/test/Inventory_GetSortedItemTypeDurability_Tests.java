package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Inventory getSortedItemTypeDurability Tests")
public class Inventory_GetSortedItemTypeDurability_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 30); // durability: 30
  private static final Item UNGODLY_AXE =
      Item.createWeapon("ungodly axe", 2, 11, 20); // durability: 20
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44);

  private Inventory inventory;

  @BeforeEach
  void setUp() {
    inventory = new Inventory();
  }

  @Test
  @DisplayName("returns an empty list when the inventory is empty")
  void returns_an_empty_list_when_the_inventory_is_empty() {

    assertThat(inventory.getSortedItemTypeDurability()).isEmpty();
  }

  @Test
  @DisplayName(
      "returns list of items ordered by item type then durability when the inventory has items")
  void returns_list_of_items_ordered_by_item_type_then_durability_when_the_inventory_has_items() {

    List<Item> thingsToAdd = List.of(MINK_PUDDING, WHACKER, POTION_OF_WOOO, UNGODLY_AXE);

    inventory.addAll(thingsToAdd);

    assertThat(inventory.getSortedItemTypeDurability())
        .containsExactly(UNGODLY_AXE, WHACKER, MINK_PUDDING, POTION_OF_WOOO);
  }
}
