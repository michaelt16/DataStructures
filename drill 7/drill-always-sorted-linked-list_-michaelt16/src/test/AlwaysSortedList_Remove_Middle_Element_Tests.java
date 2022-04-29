package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Remove Middle Element Tests")
public class AlwaysSortedList_Remove_Middle_Element_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_5 = new Pip(5);
  private static final Pip PIP_7 = new Pip(7);

  @Test
  @DisplayName("after removing the middle element, the ASL is still not empty")
  void after_removing_the_middle_element_the_ASL_is_still_not_empty() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_5);

    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("after removing the middle element, the ASL has a size of one less")
  void after_removing_the_middle_element_the_ASL_has_a_size_of_one_less() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_5);

    assertThat(list.size()).isEqualTo(2);
  }

  @Test
  @DisplayName(
      "after removing the middle element, the remaining elements can be found where expected")
  void after_removing_the_middle_element_the_remaining_elements_can_be_found_where_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_5);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after removing the middle element, the remaining indexes are as expected")
  void after_removing_the_middle_element_the_remaining_indexes_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_5);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_7)).isEqualTo(1);
  }
}
