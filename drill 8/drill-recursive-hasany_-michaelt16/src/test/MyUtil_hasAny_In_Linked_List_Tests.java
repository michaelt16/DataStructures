package test;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.MyUtil;
import main.SimpleLinkedList;
import main.SimpleList;

@DisplayName("MyUtil hasAny In Linked List Tests")
public class MyUtil_hasAny_In_Linked_List_Tests {

  private static final Comparator<Integer> ASC_NUM_COMP = Comparator.naturalOrder();
  private static final Comparator<String> ASC_TEXT_COMPT = Comparator.naturalOrder();

  @Test
  @DisplayName("an empty list doesn't have any")
  void an_empty_list_doesn_t_have_any() {

    SimpleList<Integer> emptyList = new SimpleLinkedList<>();

    int someCutoffNumber = 19;
    boolean result = MyUtil.hasAny(emptyList, ASC_NUM_COMP, someCutoffNumber);

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("a single element list and the element isn't bigger than the cutoff")
  void a_single_element_list_and_the_element_isn_t_bigger_than_the_cutoff() {

    SimpleList<String> oneElementList = new SimpleLinkedList<>(List.of("nimrod"));

    boolean result = MyUtil.hasAny(oneElementList, ASC_TEXT_COMPT, "orzbatic");

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("a single element list and the element is bigger than the cutoff")
  void a_single_element_list_and_the_element_is_bigger_than_the_cutoff() {

    SimpleList<String> oneElementList = new SimpleLinkedList<>(List.of("nimrod"));

    boolean result = MyUtil.hasAny(oneElementList, ASC_TEXT_COMPT, "murmlemurmlemurmle");

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and the first element is bigger than the cutoff")
  void multiple_element_list_and_the_first_element_is_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(15, 1, 5, 8, 1, -3));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 14);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and the last element is bigger than the cutoff")
  void multiple_element_list_and_the_last_element_is_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(-4, 1, 5, 8, 1, 43));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 42);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and the second element is bigger than the cutoff")
  void multiple_element_list_and_the_second_element_is_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(-4, 1, 5, 8, 1, 43));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 0);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and the second-to-last element is bigger than the cutoff")
  void multiple_element_list_and_the_second_to_last_element_is_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(-4, 1, 5, 8, 33, 43));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 30);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and the middle element is bigger than the cutoff")
  void multiple_element_list_and_the_middle_element_is_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(-4, 1, 5, 8, 1, 43));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 4);

    assertThat(result).isTrue();
  }

  @Test
  @DisplayName("multiple-element list and none of the elements are bigger than the cutoff")
  void multiple_element_list_and_none_of_the_elements_are_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(88, 88, 88, 88));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 88);

    assertThat(result).isFalse();
  }

  @Test
  @DisplayName("multiple-element list and all of the elements are bigger than the cutoff")
  void multiple_element_list_and_all_of_the_elements_are_bigger_than_the_cutoff() {

    SimpleList<Integer> multiElementList = new SimpleLinkedList<>(List.of(88, 88, 88, 88));

    boolean result = MyUtil.hasAny(multiElementList, ASC_NUM_COMP, 87);

    assertThat(result).isTrue();
  }
}
