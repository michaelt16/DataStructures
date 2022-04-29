package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Add One Element Tests")
public class AlwaysSortedList_Add_One_Element_Tests {

  @Test
  @DisplayName("after adding one element, a new ASL is no longer empty")
  void after_adding_one_element_a_new_ASL_is_no_longer_empty() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    assertThat(list.isEmpty()).isFalse();
  }

  @Test
  @DisplayName("after adding one element, a new ASL has a size of 1")
  void after_adding_one_element_a_new_ASL_has_a_size_of_1() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    assertThat(list.size()).isEqualTo(1);
  }

  @Test
  @DisplayName("after adding one element, you can get the added element at index 0")
  void after_adding_one_element_you_can_get_the_added_element_at_index_0() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    assertThat(list.get(0)).isSameAs(pippy);
  }

  @Test
  @DisplayName("after adding one element, the index of that element is 0")
  void after_adding_one_element_the_index_of_that_element_is_0() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    assertThat(list.indexOf(pippy)).isEqualTo(0);
  }
}
