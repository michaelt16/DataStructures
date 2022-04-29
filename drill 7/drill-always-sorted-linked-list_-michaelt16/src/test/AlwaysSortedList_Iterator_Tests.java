package test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;

@DisplayName("AlwaysSortedList Iterator Tests")
public class AlwaysSortedList_Iterator_Tests {

  private static final Pip PIP_3 = new Pip(3);
  private static final Pip PIP_5 = new Pip(5);
  private static final Pip PIP_7 = new Pip(7);

  @Test
  @DisplayName("iterating through an empty list")
  void iterating_through_an_empty_list() {

    AlwaysSortedLinkedList<Pip> list = new AlwaysSortedLinkedList<>();

    java.util.List<Pip> iterResults = new ArrayList<>();

    for (Pip pip : list) {
      iterResults.add(pip);
    }

    assertThat(iterResults).isEmpty();
  }

  @Test
  @DisplayName("iterating through list of size 1")
  void iterating_through_list_of_size_1() {

    AlwaysSortedLinkedList<Pip> list = new AlwaysSortedLinkedList<>();
    list.add(PIP_3);

    java.util.List<Pip> iterResults = new ArrayList<>();

    for (Pip pip : list) {
      iterResults.add(pip);
    }

    assertThat(iterResults).containsExactly(PIP_3);
  }

  @Test
  @DisplayName("iterating through list of size 2")
  void iterating_through_list_of_size_2() {

    AlwaysSortedLinkedList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_5);
    list.add(PIP_3);

    java.util.List<Pip> iterResults = new ArrayList<>();

    for (Pip pip : list) {
      iterResults.add(pip);
    }

    assertThat(iterResults).containsExactly(PIP_3, PIP_5);
  }

  @Test
  @DisplayName("iterating through list of size whatever")
  void iterating_through_list_of_size_whatever() {

    AlwaysSortedLinkedList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(PIP_5);
    list.add(PIP_3);
    list.add(PIP_5);
    list.add(PIP_7);
    list.add(PIP_5);
    list.add(PIP_3);

    java.util.List<Pip> iterResults = new ArrayList<>();

    for (Pip pip : list) {
      iterResults.add(pip);
    }

    assertThat(iterResults).containsExactly(PIP_3, PIP_3, PIP_5, PIP_5, PIP_5, PIP_7);
  }
}
