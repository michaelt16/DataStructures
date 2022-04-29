package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedList;

@DisplayName("AlwaysSortedList Creation Tests")
public class AlwaysSortedList_Creation_Tests {

  @Test
  @DisplayName("a new AlwaysSortedList is empty")
  void a_new_AlwaysSortedList_is_empty() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    assertThat(asl.size()).isZero();

    List<Integer> actualContents = asl.contents();
    assertThat(actualContents).isEmpty();
  }
}
