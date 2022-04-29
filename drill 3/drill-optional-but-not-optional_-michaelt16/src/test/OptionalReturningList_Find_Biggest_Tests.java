package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.OptionalReturningList;

@DisplayName("OptionalReturningList Find Biggest Tests")
public class OptionalReturningList_Find_Biggest_Tests {

  @Test
  @DisplayName(
      "attempting to find the biggest thing in an empty OptionalReturningList returns an empty Optional")
  void
      attempting_to_find_the_biggest_thing_in_an_empty_OptionalReturningList_throws_a_NoSuchElementException() {

    OptionalReturningList<Double> list = OptionalReturningList.emptyList();

    // in this case isEmpty is NOT checking for an empty List - it's checking for
    // an empty Optional!
    assertThat(list.findBiggest()).isEmpty();
  }

  @Test
  @DisplayName(
      "attempting to find the biggest thing in a non-empty OptionalReturningList returns the last thing in the list")
  void
      attempting_to_find_the_biggest_thing_in_a_non_empty_OptionalReturningList_returns_the_last_thing_in_the_list() {

    List<Double> startingThings = List.of(1.0, 193.0, 999999.9999);
    OptionalReturningList<Double> list = OptionalReturningList.fullList(startingThings);

    // assertJ has a hasValue method that extract the value inside an Optional
    assertThat(list.findBiggest()).hasValue(999999.9999);
  }
}
