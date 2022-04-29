package test;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.MyUtil;

@DisplayName("MyUtil hasAny In Array Tests")
public class MyUtil_hasAny_In_Array_Tests {

  private static final Comparator<Integer> ASC_NUM_COMP = Comparator.naturalOrder();
  private static final Comparator<String> ASC_TEXT_COMPT = Comparator.naturalOrder();

  @Test
  @DisplayName("an empty array doesn't have any")
  void an_empty_array_doesn_t_have_any() {

    Integer[] emptyArray = {};

    int someCutoffNumber = 19;
    boolean result = MyUtil.hasAny(emptyArray, ASC_NUM_COMP, someCutoffNumber);

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("a single element array and the element isn't bigger than the cutoff")
  void a_single_element_array_and_the_element_isn_t_bigger_than_the_cutoff() {

    String[] oneElementArray = {"nimrod"};

    boolean result = MyUtil.hasAny(oneElementArray, ASC_TEXT_COMPT, "orzbatic");

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("a single element array and the element is bigger than the cutoff")
  void a_single_element_array_and_the_element_is_bigger_than_the_cutoff() {

    String[] oneElementArray = {"nimrod"};

    boolean result = MyUtil.hasAny(oneElementArray, ASC_TEXT_COMPT, "murmlemurmlemurmle");

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and the first element is bigger than the cutoff")
  void multiple_element_array_and_the_first_element_is_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {15, 1, 5, 8, 1, -3};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 14);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and the last element is bigger than the cutoff")
  void multiple_element_array_and_the_last_element_is_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {-4, 1, 5, 8, 1, 43};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 42);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and the second element is bigger than the cutoff")
  void multiple_element_array_and_the_second_element_is_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {-4, 1, 5, 8, 1, 43};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 0);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and the second-to-last element is bigger than the cutoff")
  void multiple_element_array_and_the_second_to_last_element_is_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {-4, 1, 5, 8, 33, 43};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 30);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and the middle element is bigger than the cutoff")
  void multiple_element_array_and_the_middle_element_is_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {-4, 1, 5, 8, 1, 43};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 4);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element array and none of the elements are bigger than the cutoff")
  void multiple_element_array_and_none_of_the_elements_are_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {88, 88, 88, 88};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 88);

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("multiple-element array and all of the elements are bigger than the cutoff")
  void multiple_element_array_and_all_of_the_elements_are_bigger_than_the_cutoff() {

    Integer[] multiElementArray = {88, 88, 88, 88};

    boolean result = MyUtil.hasAny(multiElementArray, ASC_NUM_COMP, 87);

    assertThat(result).isTrue();
  }
}
