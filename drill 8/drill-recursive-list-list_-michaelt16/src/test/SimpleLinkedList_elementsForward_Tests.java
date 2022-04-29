package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.SimpleLinkedList;

@DisplayName("SimpleLinkedList elementsForward Tests")
public class SimpleLinkedList_elementsForward_Tests {

  private static final Splop SWEETY = Splop.makeSweetSplop(51);
  private static final Splop SWEETIER = Splop.makeSweetSplop(54);
  private static final Splop SALTY = Splop.makeSaltySplop(2);
  private static final Splop VINCE = Splop.makeVileSplop(88);

  @Test
  @DisplayName("if the SLL is empty, so is elementsForward")
  void if_the_SLL_is_empty_so_is_elementsForward() {

    SimpleLinkedList<Splop> emptyList = new SimpleLinkedList<>();

    List<Splop> forwardList = emptyList.elementsForward();

    assertThat(forwardList).isEmpty();
  }

  @Test
  @DisplayName("if the SLL has one element, elementsForward just has that element")
  void if_the_SLL_has_one_element_elementsForward_just_has_that_element() {

    List<Splop> splops = List.of(SWEETY);
    SimpleLinkedList<Splop> singleElementList = new SimpleLinkedList<>(splops);

    List<Splop> forwardList = singleElementList.elementsForward();

    assertThat(forwardList).containsExactly(SWEETY);
  }

  @Test
  @DisplayName("if the SLL has two elements, elementsForward returns a list with them in order")
  void if_the_SLL_has_two_elements_elementsForward_returns_a_list_with_them_in_order() {

    List<Splop> splops = List.of(SALTY, SWEETIER);
    SimpleLinkedList<Splop> twoElementList = new SimpleLinkedList<>(splops);

    List<Splop> forwardList = twoElementList.elementsForward();

    assertThat(forwardList).containsExactly(SALTY, SWEETIER);
  }

  @Test
  @DisplayName("if the SLL has all the elements, elementsForward returns a list with them in order")
  void if_the_SLL_has_all_the_elements_elementsForward_returns_a_list_with_them_in_order() {

    List<Splop> splops = List.of(VINCE, SALTY, SWEETIER, VINCE, SWEETY);
    SimpleLinkedList<Splop> multiElementList = new SimpleLinkedList<>(splops);

    List<Splop> forwardList = multiElementList.elementsForward();

    assertThat(forwardList).containsExactly(VINCE, SALTY, SWEETIER, VINCE, SWEETY);
  }
}
