package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.ExceptionThrowingList;

@DisplayName("ExceptionThrowingList Find Biggest Tests")
public class ExceptionThrowingList_Find_Biggest_Tests {

  @Test
  @DisplayName(
      "attempting to find the biggest thing in an empty ExceptionThrowingList throws a NoSuchElementException")
  void
      attempting_to_find_the_biggest_thing_in_an_empty_ExceptionThrowingList_throws_a_NoSuchElementException() {

    ExceptionThrowingList<Double> list = ExceptionThrowingList.emptyList();

    assertThatExceptionOfType(NoSuchElementException.class)
        .isThrownBy(() -> list.findBiggest())
        .withMessage("You can't findBiggest when it's empty.");
  }

  @Test
  @DisplayName(
      "attempting to find the biggest thing in a non-empty ExceptionThrowingList returns the last thing in the list")
  void
      attempting_to_find_the_biggest_thing_in_a_non_empty_ExceptionThrowingList_returns_the_last_thing_in_the_list() {

    List<Double> startingThings = List.of(1.0, 193.0, 999999.9999);
    ExceptionThrowingList<Double> list = ExceptionThrowingList.fullList(startingThings);

    assertThat(list.findBiggest()).isEqualTo(999999.9999);
  }
}
