package test;

import static org.assertj.core.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.MySimpleBst;
import main.SimpleBst;

@DisplayName("MySimpleBst Traverse Tests")
public class MySimpleBst_Traverse_Tests {

  @Test
  @DisplayName("traversing an empty tree isn't terribly exciting")
  void traversing_an_empty_tree_isn_t_terribly_exciting() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    Iterator<Integer> iter = bst.levelOrderIterator();

    assertThat(iter).isExhausted(); // ie. there's nothing left to iterate through
  }

  @Test
  @DisplayName("traversing a single-element tree isn't a whole lot better")
  void traversing_a_single_element_tree_isn_t_a_whole_lot_better() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    bst.add(42);

    Iterator<Integer> iter = bst.levelOrderIterator();

    assertThat(iter).toIterable().containsExactly(42);
  }

  @Test
  @DisplayName("big iteration time")
  /**
   * We'll use this tree.
   * <code>
   *    80
   *    / \
   *   /   \
   *  /     \
   *  2      98
   *   \     / \
   *   57   88 99
   *   / \    \
   *  8  59   95
   *  /
   * 5
   * </cod>
   */
  void big_iteration_time() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95, 5);
    toInsert.forEach(bst::add);

    Iterator<Integer> iter = bst.levelOrderIterator();

    assertThat(iter).toIterable().containsExactly(80, 2, 98, 57, 88, 99, 8, 59, 95, 5);
  }
}
