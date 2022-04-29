package test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.OscillatingResizableList;

@DisplayName("OscillatingResizableList Add Tests")
public class OscillatingResizableList_Add_Tests {

  @Test
  @DisplayName("adding a new item gives a list with that item")
  void adding_a_new_item_gives_a_list_with_that_item() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");

    List<String> actualContents = list.contents();

    String[] expectedArray = {null, null, null, "my", null, null, null};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(1);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("when adding 2 items, the first goes in the middle, the next to the right")
  void when_adding_2_items_the_first_goes_in_the_middle_the_next_to_the_right() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");

    List<String> actualContents = list.contents();
    String[] expectedArray = {null, null, null, "my", "dog", null, null};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(2);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("when adding 3 items, we go middle, then right, then left")
  void when_adding_3_items_we_go_middle_then_right_then_left() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");

    List<String> actualContents = list.contents();
    String[] expectedArray = {null, null, "has", "my", "dog", null, null};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(3);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's do 4")
  void lets_do_4() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");
    list.add("fleas");

    List<String> actualContents = list.contents();
    String[] expectedArray = {null, null, "has", "my", "dog", "fleas", null};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(4);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's do 5")
  void lets_do_5() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");
    list.add("fleas");
    list.add("does");

    List<String> actualContents = list.contents();
    String[] expectedArray = {null, "does", "has", "my", "dog", "fleas", null};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(5);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's do 6")
  void lets_do_6() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");
    list.add("fleas");
    list.add("does");
    list.add("yours");

    List<String> actualContents = list.contents();
    String[] expectedArray = {null, "does", "has", "my", "dog", "fleas", "yours"};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(6);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's do 7")
  void lets_do_7() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");
    list.add("fleas");
    list.add("does");
    list.add("yours");
    list.add("?");

    List<String> actualContents = list.contents();
    String[] expectedArray = {"?", "does", "has", "my", "dog", "fleas", "yours"};
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(7);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's fill it and see if it resizes")
  void lets_fill_it_and_see_if_it_resizes() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("my");
    list.add("dog");
    list.add("has");
    list.add("fleas");
    list.add("does");
    list.add("yours");
    list.add("?");
    list.add("?");

    List<String> actualContents = list.contents();
    String[] expectedArray = {
      null, null, null, "?", "does", "has", "my", "dog", "fleas", "yours", "?", null, null
    };
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(8);
    assertThat(actualContents).isEqualTo(expectedContents);
  }

  @Test
  @DisplayName("let's fill it twice and see if it resizes right")
  void lets_fill_it_twice_and_see_if_it_resizes_right() {

    OscillatingResizableList<String> list = new OscillatingResizableList<>();

    list.add("twas");
    list.add("brillig");
    list.add("and");
    list.add("the");
    list.add("slithy");
    list.add("toves");
    list.add("did");
    list.add("gyre");
    list.add("and");
    list.add("gimble");
    list.add("in");
    list.add("the");
    list.add("wabe"); // that's a second fill
    list.add("all");
    list.add("mimsy");

    List<String> actualContents = list.contents();
    String[] expectedArray = {
      null, null, "mimsy", "wabe", "in", "and", "did", "slithy", "and", "twas", "brillig", "the",
      "toves", "gyre", "gimble", "the", "all", null, null
    };
    List<String> expectedContents = new ArrayList<>(Arrays.asList(expectedArray));

    assertThat(list.size()).isEqualTo(15);
    assertThat(actualContents).isEqualTo(expectedContents);
  }
}
