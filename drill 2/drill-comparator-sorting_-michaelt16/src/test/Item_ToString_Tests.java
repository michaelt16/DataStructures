package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Item;

@DisplayName("Item toString Tests")
public class Item_ToString_Tests {

  private static final Item MINK_PUDDING = Item.createFood("mink pudding", 0, 2);

  @Test
  @DisplayName("toString returns expected result")
  void toString_returns_expected_result() {

    assertThat(MINK_PUDDING.toString())
        .isEqualTo("mink pudding [2020-12-30, 3:57 a.m.] (v:0, w:2.0, d:0, t:FOOD)");
  }
}
