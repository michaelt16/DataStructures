package test;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedLinkedList;
import main.SimpleList;

@DisplayName("AlwaysSortedList Creation Tests")
public class AlwaysSortedList_Creation_Tests {

  @Test
  @DisplayName("a brand-spanking new ASL has these properties")
  void a_brand_spanking_new_ASL_has_these_properties() {

    SimpleList<String> list = new AlwaysSortedLinkedList<>();

    assertThat(list.isEmpty()).isTrue();
    assertThat(list.size()).isZero();
  }
}
