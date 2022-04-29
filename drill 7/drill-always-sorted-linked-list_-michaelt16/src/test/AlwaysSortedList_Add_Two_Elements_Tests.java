package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Add Two Elements Tests")
public class AlwaysSortedList_Add_Two_Elements_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_7 = new Pip(7);

  @Test
  @DisplayName("after adding two elements, a new ASL is no longer empty")
  void after_adding_two_elements_a_new_ASL_is_no_longer_empty() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_3);

    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("after adding two elements, a new ASL has a size of 2")
  void after_adding_two_elements_a_new_ASL_has_a_size_of_2() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_3);

    assertThat(list.size()).isEqualTo(2);
  }

  @Test
  @DisplayName("after adding elements in order, you get them at expected indexes")
  void after_adding_elements_in_order_you_get_them_at_expected_indexes() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_7);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after adding elements out of order, you get them at expected indexes")
  void after_adding_elements_out_of_order_you_get_them_at_expected_indexes() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_3);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after adding elements in order, the indexes of them are as expected")
  void after_adding_elements_in_order_the_indexes_of_them_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_7);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_7)).isEqualTo(1);
  }

  @Test
  @DisplayName("after adding elements out of order, the indexes of them are as expected")
  void after_adding_elements_out_of_order_the_indexes_of_them_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_3);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_7)).isEqualTo(1);
  }
}
