package test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Item Creation Tests")
public class Item_Creation_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);
  private static final Item WHACKER = Item.createWeapon("whacker", 2, 11, 3);
  private static final Item POTION_OF_WOOO = Item.createPotion("potion of wooo", 44);

  @Test
  @DisplayName("items created with copy constructor are equal but not the same object")
  void items_created_with_copy_constructor_are_equal_but_not_the_same_object() {

    Item copyOfMinkPudding = new Item(MINK_PUDDING);

    assertThat(copyOfMinkPudding).isEqualTo(MINK_PUDDING);
    assertThat(MINK_PUDDING).isEqualTo(copyOfMinkPudding);

    assertThat(copyOfMinkPudding).isNotSameAs(MINK_PUDDING);
  }

  @Test
  @DisplayName("pickup LocalDateTime set correctly")
  void pickup_localDateTime_set_correctly() {

    assertThat(MINK_PUDDING.getPickedUp()).isEqualTo(LocalDateTime.parse("2020-12-30T03:57"));
    assertThat(WHACKER.getPickedUp()).isEqualTo(LocalDateTime.parse("2020-12-30T05:52"));
    assertThat(POTION_OF_WOOO.getPickedUp()).isEqualTo(LocalDateTime.parse("2020-12-31T23:59"));
  }
}
