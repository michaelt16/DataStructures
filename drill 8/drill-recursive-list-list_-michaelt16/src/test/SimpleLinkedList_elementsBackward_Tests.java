package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.SimpleLinkedList;

@DisplayName("SimpleLinkedList elementsBackward Tests")
public class SimpleLinkedList_elementsBackward_Tests {

  private static final Splop SWEETY = Splop.makeSweetSplop(51);
  private static final Splop SWEETIER = Splop.makeSweetSplop(54);
  private static final Splop SALTY = Splop.makeSaltySplop(2);
  private static final Splop VINCE = Splop.makeVileSplop(88);

  @Test
  @DisplayName("if the SLL is empty, so is elementsBackward")
  void if_the_SLL_is_empty_so_is_elementsBackward() {

    SimpleLinkedList<Splop> emptyList = new SimpleLinkedList<>();

    List<Splop> backwardList = emptyList.elementsBackward();

    assertThat(backwardList).isEmpty();
  }

  @Test
  @DisplayName("if the SLL has one element, elementsBackward just has that element")
  void if_the_SLL_has_one_element_elementsBackward_just_has_that_element() {

    List<Splop> splops = List.of(SWEETY);
    SimpleLinkedList<Splop> singleElementList = new SimpleLinkedList<>(splops);

    List<Splop> backwardList = singleElementList.elementsBackward();

    assertThat(backwardList).containsExactly(SWEETY);
  }

  @Test
  @DisplayName("if the SLL has two elements, elementsBackward returns a list with them in order")
  void if_the_SLL_has_two_elements_elementsBackward_returns_a_list_with_them_in_order() {

    List<Splop> splops = List.of(SALTY, SWEETIER);
    SimpleLinkedList<Splop> twoElementList = new SimpleLinkedList<>(splops);

    List<Splop> backwardList = twoElementList.elementsBackward();

    assertThat(backwardList).containsExactly(SWEETIER, SALTY);
  }

  @Test
  @DisplayName(
      "if the SLL has all the elements, elementsBackward returns a list with them in order")
  void if_the_SLL_has_all_the_elements_elementsBackward_returns_a_list_with_them_in_order() {

    List<Splop> splops = List.of(VINCE, SALTY, SWEETIER, VINCE, SWEETY);
    SimpleLinkedList<Splop> multiElementList = new SimpleLinkedList<>(splops);

    List<Splop> backwardList = multiElementList.elementsBackward();

    assertThat(backwardList).containsExactly(SWEETY, VINCE, SWEETIER, SALTY, VINCE);
  }
}
