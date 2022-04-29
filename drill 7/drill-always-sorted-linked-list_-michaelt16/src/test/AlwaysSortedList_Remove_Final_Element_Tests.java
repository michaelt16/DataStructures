package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Remove Final Element Tests")
public class AlwaysSortedList_Remove_Final_Element_Tests {

  @Test
  @DisplayName("after removing the final element, the ASL is empty")
  void after_removing_the_final_element_the_ASL_is_empty() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    list.remove(pippy);

    assertThat(list.isEmpty()).isTrue();
  }

  @Test
  @DisplayName("after removing the final element, the ASL has a size of 0")
  void after_removing_the_final_element_the_ASL_has_a_size_of_0() {
    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    Pip pippy = new Pip(4);

    list.add(pippy);

    list.remove(pippy);

    assertThat(list.size()).isEqualTo(0);
  }
}
