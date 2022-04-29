package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Remove Something Not There Tests")
public class AlwaysSortedList_Remove_Something_Not_There_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_5 = new Pip(5);
  private static final Pip PIP_7 = new Pip(7);
  private static final Pip PIP_NOT_THERE = new Pip(88);

  @Test
  @DisplayName("removing something not there returns a null")
  void removing_something_not_there_returns_a_null() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    Pip removed = list.remove(PIP_NOT_THERE);

    assertThat(removed).isNull();
  }

  @Test
  @DisplayName("removing something that's been removed also returns a null")
  void removing_something_that_s_been_removed_also_returns_a_null() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_7);
    Pip removed = list.remove(PIP_7);

    assertThat(removed).isNull();
  }

  @Test
  @DisplayName("after removing an element not there, the ASL hasn't changed size")
  void after_removing_an_element_not_there_the_ASL_hasn_t_changed_size() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_NOT_THERE);

    assertThat(list.size()).isEqualTo(3);
  }

  @Test
  @DisplayName("after removing an element not there, the elements can be found where expected")
  void after_removing_an_element_not_there_the_elements_can_be_found_where_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_NOT_THERE);

    assertThat(list.get(0)).isSameAs(PIP_3);
    assertThat(list.get(1)).isSameAs(PIP_5);
    assertThat(list.get(2)).isSameAs(PIP_7);
  }

  @Test
  @DisplayName("after removing an element not there, the indexes are as expected")
  void after_removing_an_element_not_there_the_indexes_are_as_expected() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);

    list.remove(PIP_NOT_THERE);

    assertThat(list.indexOf(PIP_3)).isEqualTo(0);
    assertThat(list.indexOf(PIP_5)).isEqualTo(1);
    assertThat(list.indexOf(PIP_7)).isEqualTo(2);
  }
}
