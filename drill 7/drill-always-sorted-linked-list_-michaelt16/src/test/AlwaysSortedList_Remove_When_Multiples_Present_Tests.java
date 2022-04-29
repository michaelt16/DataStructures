package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Remove When Multiples Present Tests")
public class AlwaysSortedList_Remove_When_Multiples_Present_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_5 = new Pip(5);
  private static final Pip PIP_7 = new Pip(7);

  @Test
  @DisplayName("removing the first one gives it back to you")
  void removing_the_first_one_gives_it_back_to_you() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_7);

    Pip removed = list.remove(PIP_3);

    assertThat(removed).isEqualTo(PIP_3);
  }

  @Test
  @DisplayName("removing the next one gives it back to you")
  void removing_the_next_one_gives_it_back_to_you() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_7);

    Pip removed = list.remove(PIP_3);

    assertThat(removed).isEqualTo(PIP_3);

    removed = list.remove(PIP_3);

    assertThat(removed).isEqualTo(PIP_3);
  }

  @Test
  @DisplayName("after removing the first one, the size has only gone down by one")
  void after_removing_the_first_one_the_size_has_only_gone_down_by_one() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_7);

    list.remove(PIP_3);

    assertThat(list.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("after removing the first one, the remaining elements can be found where expected")
  void after_removing_the_first_one_the_remaining_elements_can_be_found_where_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_7);

    list.remove(PIP_3);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_5);
    assertThat(list.get(2)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after removing the first one, the remaining indexes are as expected")
  void after_removing_the_first_one_the_remaining_indexes_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_7);

    list.remove(PIP_3);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_5)).isEqualTo(1);
    assertThat(list.indexOf(PIP_7)).isEqualTo(2);
  }
}
