package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Item ItemTypeComparator Tests")
public class Item_ItemTypeComparator_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3);
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44);

  @Test
  @DisplayName("ItemTypeComparator has been implemented")
  void itemTypeComparator_has_been_implemented() {
    assertThat(WHACKER)
        .usingComparator(Item.ItemTypeComparator)
        .isEqualByComparingTo(WHACKER)
        .isLessThan(MINK_PUDDING)
        .isLessThan(POTION_OF_WOOO);

    assertThat(MINK_PUDDING)
        .usingComparator(Item.ItemTypeComparator)
        .isEqualByComparingTo(MINK_PUDDING)
        .isGreaterThan(WHACKER)
        .isLessThan(POTION_OF_WOOO);

    assertThat(POTION_OF_WOOO)
        .usingComparator(Item.ItemTypeComparator)
        .isEqualByComparingTo(POTION_OF_WOOO)
        .isGreaterThan(WHACKER)
        .isGreaterThan(MINK_PUDDING);
  }
}
