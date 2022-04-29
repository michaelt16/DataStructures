package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Add Three Elements Tests")
public class AlwaysSortedList_Add_Three_Elements_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_5 = new Pip(5);
  private static final Pip PIP_7 = new Pip(7);

  @Test
  @DisplayName("after adding three elements, a new ASL is no longer empty")
  void after_adding_three_elements_a_new_ASL_is_no_longer_empty() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_5);
    list.add(PIP_7);
    list.add(PIP_3);

    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("after adding three elements, a new ASL has a size of 3")
  void after_adding_three_element_a_new_ASL_has_a_size_of_3() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_5);
    list.add(PIP_3);

    assertThat(list.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("after adding elements in order, you get them at expected indexes")
  void after_adding_elements_in_order_you_get_them_at_expected_indexes() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_5);
    assertThat(list.get(2)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after adding elements in mixed order, you get them at expected indexes")
  void after_adding_elements_in_mixed_order_you_get_them_at_expected_indexes() {
    SimpleList<Pip> mixedList1 = new AlwaysSortedLinkedList<>();

    mixedList1.add(PIP_7);
    mixedList1.add(PIP_3);
    mixedList1.add(PIP_5);

    assertThat(mixedList1.get(0)).isSameAs(PIP_3);
    assertThat(mixedList1.get(1)).isSameAs(PIP_5);
    assertThat(mixedList1.get(2)).isSameAs(PIP_7);

    SimpleList<Pip> mixedList2 = new AlwaysSortedLinkedList<>();

    mixedList2.add(PIP_3);
    mixedList2.add(PIP_7);
    mixedList2.add(PIP_5);

    assertThat(mixedList2.get(0)).isSameAs(PIP_3);
    assertThat(mixedList2.get(1)).isSameAs(PIP_5);
    assertThat(mixedList2.get(2)).isSameAs(PIP_7);

    SimpleList<Pip> mixedList3 = new AlwaysSortedLinkedList<>();

    mixedList3.add(PIP_5);
    mixedList3.add(PIP_3);
    mixedList3.add(PIP_7);

    assertThat(mixedList3.get(0)).isSameAs(PIP_3);
    assertThat(mixedList3.get(1)).isSameAs(PIP_5);
    assertThat(mixedList3.get(2)).isSameAs(PIP_7);

    SimpleList<Pip> mixedList4 = new AlwaysSortedLinkedList<>();

    mixedList4.add(PIP_5);
    mixedList4.add(PIP_7);
    mixedList4.add(PIP_3);

    assertThat(mixedList4.get(0)).isSameAs(PIP_3);
    assertThat(mixedList4.get(1)).isSameAs(PIP_5);
    assertThat(mixedList4.get(2)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after adding elements in reverse order, you get them at expected indexes")
  void after_adding_elements_in_reverse_order_you_get_them_at_expected_indexes() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_5);
    list.add(PIP_3);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_5);
    assertThat(list.get(2)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after adding elements in order, the indexes of them are as expected")
  void after_adding_elements_in_order_the_indexes_of_them_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_5)).isEqualTo(1);
    assertThat(list.indexOf(PIP_7)).isEqualTo(2);
  }

  @Test
  @DisplayName("after adding elements in mixed order, the indexes of them are as expected")
  void after_adding_elements_in_mixed_order_the_indexes_of_them_are_as_expected() {
    SimpleList<Pip> mixedList1 = new AlwaysSortedLinkedList<>();

    mixedList1.add(PIP_7);
    mixedList1.add(PIP_3);
    mixedList1.add(PIP_5);

    assertThat(mixedList1.indexOf(PIP_3)).isEqualTo(0);
    assertThat(mixedList1.indexOf(PIP_5)).isEqualTo(1);
    assertThat(mixedList1.indexOf(PIP_7)).isEqualTo(2);

    SimpleList<Pip> mixedList2 = new AlwaysSortedLinkedList<>();

    mixedList2.add(PIP_3);
    mixedList2.add(PIP_7);
    mixedList2.add(PIP_5);

    assertThat(mixedList2.indexOf(PIP_3)).isEqualTo(0);
    assertThat(mixedList2.indexOf(PIP_5)).isEqualTo(1);
    assertThat(mixedList2.indexOf(PIP_7)).isEqualTo(2);

    SimpleList<Pip> mixedList3 = new AlwaysSortedLinkedList<>();

    mixedList3.add(PIP_5);
    mixedList3.add(PIP_3);
    mixedList3.add(PIP_7);

    assertThat(mixedList3.indexOf(PIP_3)).isEqualTo(0);
    assertThat(mixedList3.indexOf(PIP_5)).isEqualTo(1);
    assertThat(mixedList3.indexOf(PIP_7)).isEqualTo(2);

    SimpleList<Pip> mixedList4 = new AlwaysSortedLinkedList<>();

    mixedList4.add(PIP_5);
    mixedList4.add(PIP_7);
    mixedList4.add(PIP_3);

    assertThat(mixedList4.indexOf(PIP_3)).isEqualTo(0);
    assertThat(mixedList4.indexOf(PIP_5)).isEqualTo(1);
    assertThat(mixedList4.indexOf(PIP_7)).isEqualTo(2);
  }

  @Test
  @DisplayName("after adding elements in reverse order, the indexes of them are as expected")
  void after_adding_elements_in_reverse_order_the_indexes_of_them_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_7);
    list.add(PIP_5);
    list.add(PIP_3);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_5)).isEqualTo(1);
    assertThat(list.indexOf(PIP_7)).isEqualTo(2);
  }
}
