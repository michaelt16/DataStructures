package test;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.AlwaysSortedList;

@DisplayName("AlwaysSortedList Insertion Into Single Element List Tests")
public class AlwaysSortedList_Insertion_Into_Single_Element_List_Tests {

  @Test
  @DisplayName("the case when the incoming element goes before the existing one")
  void the_case_when_the_incoming_element_goes_before_the_existing_one() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(12);

    asl.add(2);

    assertThat(asl.size()).isEqualTo(2);

    List<Integer> actualContents = asl.contents();
    assertThat(actualContents).containsExactlyElementsOf(List.of(2, 12));
  }

  @Test
  @DisplayName("the case when the incoming element goes after the existing one")
  void the_case_when_the_incoming_element_goes_after_the_existing_one() {

    AlwaysSortedList<Integer> asl = new AlwaysSortedList<>();

    asl.add(3);

    asl.add(16);

    assertThat(asl.size()).isEqualTo(2);

    List<Integer> actualContents = asl.contents();
    assertThat(actualContents).containsExactlyElementsOf(List.of(3, 16));
  }

  @Test
  @DisplayName("the case when the incoming element has the same ordering as the existing one")
  void the_case_when_the_incoming_element_has_the_same_ordering_as_the_existing_one() {

    AlwaysSortedList<Blorb> asl = new AlwaysSortedList<>();

    Blorb firstBlorb = new Blorb(7);
    asl.add(firstBlorb);

    Blorb secondBlorb = new Blorb(7);
    asl.add(secondBlorb);

    assertThat(asl.size()).isEqualTo(2);

    List<Blorb> actualContents = asl.contents();
    assertThat(actualContents).containsExactlyElementsOf(List.of(firstBlorb, secondBlorb));
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
