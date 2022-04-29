package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Index Of Element Not There Tests")
public class AlwaysSortedList_Index_Of_Element_Not_There_Tests {

  @Test
  @DisplayName("getting the index of something not there returns neg 1")
  void getting_the_index_of_something_not_there_returns_neg_1() {

    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(new Pip(4));

    int index = list.indexOf(new Pip(5));

    assertThat(index).isEqualTo(-1);
  }
}
