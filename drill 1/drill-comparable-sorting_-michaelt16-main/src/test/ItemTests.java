package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Inventory;
import main.Item;

@DisplayName("Item tests")
public class ItemTests {

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
  @DisplayName("when two items have same value but other fields are different")
  void when_two_items_have_same_value_but_other_fields_are_different() {
    int someValue = 14;
    Item food = Item.createFood("a food", someValue, 11);
    Item weapon = Item.createWeapon("a weapon", someValue, 15, 1);

    assertThat(food).isEqualByComparingTo(weapon);
    assertThat(weapon).isEqualByComparingTo(food);
  }

  @Test
  @DisplayName("when two items have same value and other fields are same")
  void when_two_items_have_same_value_and_other_fields_are_same() {
    int someValue = 14;
    Item food = Item.createFood("a food", someValue, 11);
    Item otherFood = Item.createFood("a food", someValue, 11);

    assertThat(food).isEqualByComparingTo(otherFood);
    assertThat(otherFood).isEqualByComparingTo(food);
  }

  @Test
  @DisplayName("when two items have different values and other fields are different")
  void when_two_items_have_different_values_and_other_fields_are_different() {
    int someValue = 1;
    int someDifferentValue = 14;

    Item food = Item.createFood("a food", someValue, 11);
    Item weapon = Item.createWeapon("a weapon", someDifferentValue, 15, 1);

    assertThat(food).isGreaterThan(weapon);
    assertThat(weapon).isLessThan(food);
  }

  @Test
  @DisplayName("when two items have different values but other fields are same")
  void when_two_items_have_different_values_but_other_fields_are_same() {
    int someValue = 23;
    int someDifferentValue = 52;

    Item food = Item.createFood("a food", someValue, 11);
    Item almostSameFood = Item.createFood("a food", someDifferentValue, 11);

    assertThat(food).isGreaterThan(almostSameFood);
    assertThat(almostSameFood).isLessThan(food);
  }
}
