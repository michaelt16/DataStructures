package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Get Out Of Bounds Tests")
public class AlwaysSortedList_Get_Out_Of_Bounds_Tests {

  @Test
  @DisplayName("getting before 0 throws an IndexOutOfBoundsException")
  void getting_before_0_throws_an_IndexOutOfBoundsException() {

    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(new Pip(4));

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(
            () -> {
              list.get(-1);
            });
  }

  @Test
  @DisplayName("getting at index on upper boundary throws an IndexOutOfBoundsException")
  void getting_at_index_on_upper_boundary_throws_an_IndexOutOfBoundsException() {

    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(new Pip(4));
    list.add(new Pip(5));

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(
            () -> {
              list.get(2);
            });
  }

  @Test
  @DisplayName("getting at index past upper boundary throws an IndexOutOfBoundsException")
  void getting_at_index_past_upper_boundary_throws_an_IndexOutOfBoundsException() {

    SimpleList<Pip> list = new AlwaysSortedLinkedList<>();

    list.add(new Pip(4));
    list.add(new Pip(5));

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(
            () -> {
              list.get(3);
            });
  }
}
