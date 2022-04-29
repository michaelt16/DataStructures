package test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.OscillatingResizableList;

@DisplayName("OscillatingResizableList Creation Tests")
public class OscillatingResizableList_Creation_Tests {

  @Test
  @DisplayName("a new OscillatingResizableList is empty")
  void a_new_OscillatingResizableList_is_empty() {

    OscillatingResizableList<Integer> list = new OscillatingResizableList<>();

    assertThat(list.size()).isZero();

    List<Integer> actualContents = list.contents();
    Integer[] expectedArray = {null, null, null, null, null, null, null};
    List<Integer> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(actualContents).isEqualTo(expectedContents);
  }
}
