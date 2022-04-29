package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;

@DisplayName("Item Comparable Tests")
public class Item_Comparable_Tests {

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
