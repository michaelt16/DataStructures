package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import main.MySimpleBst;
import main.SimpleBst;

@DisplayName("MySimpleBst Remove Tests")
public class MySimpleBst_Remove_Tests {

  @Test
  @DisplayName("getting with a null throws an IllegalArgumentExcpetion")
  void getting_with_a_null_throws_an_IllegalArgumentException() {
    SimpleBst<Integer> bst = new MySimpleBst<>();
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(
            () -> {
              bst.remove(null);
            })
        .withMessage("Removing a null element is not allowed.");
  }

  @Test
  @DisplayName("removing from an empty tree doesn't change the size")
  void removing_from_an_empty_tree_doesn_t_change_the_size() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    long sizeBefore = bst.size();

    int somethingNotThere = 14;
    bst.remove(somethingNotThere);

    long sizeAfter = bst.size();

    assertThat(sizeBefore).isEqualTo(sizeAfter);
  }

  @Test
  @DisplayName("removing something not there doesn't change the size")
  void removing_something_not_there_doesn_t_change_the_size() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(3, 6, -2, 11, 777);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int somethingNotThere = 14;
    bst.remove(somethingNotThere);

    long sizeAfter = bst.size();

    assertThat(sizeBefore).isEqualTo(sizeAfter);
  }

  @Test
  @DisplayName("removing a leaf")
  /**
   * We'll use this tree a lot - I thought it would be nice to see it.
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
  void removing_a_leaf() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int thingToRemove = 95;
    bst.remove(thingToRemove);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(thingToRemove);

    assertThat(thingGot).isNull();
  }

  @Test
  @DisplayName("removing node with one left child")
  void removing_node_with_one_left_child() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int thingToRemove = 8;
    bst.remove(thingToRemove);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(thingToRemove);

    assertThat(thingGot).isNull();
  }

  @Test
  @DisplayName("removing node with one right child")
  void removing_node_with_one_right_child() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int thingToRemove = 88;
    bst.remove(thingToRemove);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(thingToRemove);

    assertThat(thingGot).isNull();
  }

  @Test
  @DisplayName("removing node with two children, non-root case")
  void removing_node_with_two_children_non_root_case() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int thingToRemove = 98;
    bst.remove(thingToRemove);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(thingToRemove);

    assertThat(thingGot).isNull();
  }

  @Test
  @DisplayName("removing node with two children, root case")
  void removing_node_with_two_children_root_case() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    List<Integer> toInsert = List.of(80, 2, 98, 57, 99, 8, 59, 88, 95);
    toInsert.forEach(bst::add);

    long sizeBefore = bst.size();

    int thingToRemove = 80;
    bst.remove(thingToRemove);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(thingToRemove);

    assertThat(thingGot).isNull();
  }

  @Test
  @DisplayName("removing the last node")
  void removing_the_last_node() {
    SimpleBst<Integer> bst = new MySimpleBst<>();

    bst.add(42);

    long sizeBefore = bst.size();

    int lastElement = 42;
    bst.remove(lastElement);

    long sizeAfter = bst.size();

    assertThat(sizeAfter).isEqualTo(sizeBefore - 1);

    Integer thingGot = bst.get(lastElement);

    assertThat(thingGot).isNull();
  }
}
