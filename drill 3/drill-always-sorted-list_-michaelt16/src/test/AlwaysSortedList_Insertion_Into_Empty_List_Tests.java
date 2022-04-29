package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedList;

@DisplayName("AlwaysSortedList Insertion Into Empty List Tests")
public class AlwaysSortedList_Insertion_Into_Empty_List_Tests {

  @Test
  @DisplayName("inserting gives you a list with that one thing in it")
  void inserting_gives_you_a_list_with_that_one_thing_in_it() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(4);

    assertThat(asl.size()).isEqualTo(1);

    List<Integer> actualContents = asl.contents();
    assertThat(actualContents).containsAll(List.of(4));
  }
}
