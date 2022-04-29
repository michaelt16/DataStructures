package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedList;

@DisplayName("AlwaysSortedList Insertion Into Two Element List Tests")
public class AlwaysSortedList_Insertion_Into_Two_Element_List_Tests {

  @Test
  @DisplayName("the case when the incoming element goes before the first one")
  void the_case_when_the_incoming_element_goes_before_the_first_one() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(12);

    asl.add(2);

    asl.add(1);

    assertThat(asl.size()).isEqualTo(3);
    assertThat(asl.contents()).containsExactlyElementsOf(List.of(1, 2, 12));
  }

  @Test
  @DisplayName("the case when the incoming element goes after the last one")
  void the_case_when_the_incoming_element_goes_after_the_last_one() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(4);

    asl.add(18);

    asl.add(25);

    assertThat(asl.size()).isEqualTo(3);
    assertThat(asl.contents()).containsExactlyElementsOf(List.of(4, 18, 25));
  }

  @Test
  @DisplayName("the case when the incoming element goes after the first one")
  void the_case_when_the_incoming_element_goes_after_the_first_one() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(11);

    asl.add(912);

    asl.add(67);

    assertThat(asl.size()).isEqualTo(3);
    assertThat(asl.contents()).containsExactlyElementsOf(List.of(11, 67, 912));
  }

  @Test
  @DisplayName("the case when the incoming element has the same ordering as the first one")
  void the_case_when_the_incoming_element_has_the_same_ordering_as_the_first_one() {

    AlwaysSortedList<Blorb> asl = new AlwaysSortedList<>();

    Blorb firstBlorb = new Blorb(7);
    asl.add(firstBlorb);

    Blorb secondBlorb = new Blorb(10);
    asl.add(secondBlorb);

    Blorb newBlorb = new Blorb(7);
    asl.add(newBlorb);

    assertThat(asl.size()).isEqualTo(3);
    assertThat(asl.contents())
        .containsExactlyElementsOf(List.of(firstBlorb, newBlorb, secondBlorb));
  }

  @Test
  @DisplayName("the case when the incoming element has the same ordering as the second one")
  void the_case_when_the_incoming_element_has_the_same_ordering_as_the_second_one() {

    AlwaysSortedList<Blorb> asl = new AlwaysSortedList<>();

    Blorb firstBlorb = new Blorb(7);
    asl.add(firstBlorb);

    Blorb secondBlorb = new Blorb(10);
    asl.add(secondBlorb);

    Blorb newBlorb = new Blorb(10);
    asl.add(newBlorb);

    assertThat(asl.size()).isEqualTo(3);
    assertThat(asl.contents())
        .containsExactlyElementsOf(List.of(firstBlorb, secondBlorb, newBlorb));
  }

  class Blorb implements Comparable<Blorb> {
    private int blorbiness;

    public Blorb(int blorbiness) {
      this.blorbiness = blorbiness;
    }

    @Override
    public int compareTo(Blorb otherBlorb) {
      return this.blorbiness - otherBlorb.blorbiness;
    }

    @Override
    public String toString() {
      return String.format("blorb (%d)", blorbiness);
    }
  }
}
