package test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Main;

public class MainTests {

  private List<String> clean(String rawConsoleOutput) {
    String[] split = rawConsoleOutput.split("\n");
    return Arrays.stream(split)
        .filter(s -> !s.isEmpty())
        .map(String::trim)
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("integer bunk, integer picky bag")
  void integer_bunk_integer_picky_bag() throws Exception {

    withTextFromSystemIn("1", "3", "how y'all doin'?", "1", "32")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Time to use a generic bunk!",
                      "1 - Integers on top | Strings on bottom, or",
                      "2 - Duration on top | Duration on botom, or",
                      "3 - a Bunkable thing on the top | a Comparable thing on the bottom?",
                      "Your choice?",
                      "Here's an <Integer, String> BunkBed:",
                      "What int goes on top?",
                      "What String goes on bottom?",
                      "RESULT:",
                      "on top: 3",
                      "on bottom: how y'all doin'?",
                      "Time to use a generic PickyBag!",
                      "1 - Bag should hold ints, or",
                      "2 - Bag should hold Chickens, or",
                      "3 - Bag should hold Collections?",
                      "Your choice?",
                      "Adding [4, 5, 6, 4, 5, 6, 7] to this picky bag:",
                      "Here's what's in the picky bag now: [4, 5, 6, 7]",
                      "What other int should we try to add?",
                      "After trying to add 32, here's what's in the picky bag now: [4, 5, 6, 7, 32]",
                      "Closing my eyes and pulling something out of this bag...",
                      "....and I pull out a 4");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("duration bunk, chicken picky bag")
  void integer_bunk_chicken_picky_bag() throws Exception {

    withTextFromSystemIn("2", "3170", "91332", "2", "4 Rhoda")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Time to use a generic bunk!",
                      "1 - Integers on top | Strings on bottom, or",
                      "2 - Duration on top | Duration on botom, or",
                      "3 - a Bunkable thing on the top | a Comparable thing on the bottom?",
                      "Your choice?",
                      "Here's a <Duration, Duration> BunkBed:",
                      "What duration (in seconds)?",
                      "What duration (in minutes)?",
                      "RESULT:",
                      "on top: PT52M50S",
                      "on bottom: PT1522H12M",
                      "Time to use a generic PickyBag!",
                      "1 - Bag should hold ints, or",
                      "2 - Bag should hold Chickens, or",
                      "3 - Bag should hold Collections?",
                      "Your choice?",
                      "Adding [Linda Lee (2), Rhoda (4), Cthenlu (4000000)] to this picky bag:",
                      "Here's what's in the picky bag now: [Linda Lee (2), Rhoda (4), Cthenlu (4000000)]",
                      "What chicken should we try to add (weeks name)?",
                      "After trying to add Rhoda (4), here's what's in the picky bag now: [Linda Lee (2), Rhoda (4), Cthenlu (4000000)]",
                      "Closing my eyes and pulling something out of this bag...",
                      "....and I pull out a Linda Lee (2)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("bunkable bunk, collection picky bag")
  void bunkable_bunk_collection_picky_bag() throws Exception {

    withTextFromSystemIn("3", "Kenny", "T", "3", "push the button, Frank")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Time to use a generic bunk!",
                      "1 - Integers on top | Strings on bottom, or",
                      "2 - Duration on top | Duration on botom, or",
                      "3 - a Bunkable thing on the top | a Comparable thing on the bottom?",
                      "Your choice?",
                      "Here's a <Bunkable, Comparable> BunkBed:",
                      "What Bunkable (kid name) goes on top?",
                      "Boolean is Comparable. What Boolean (T/F) goes on bottom?",
                      "RESULT:",
                      "on top: Kenny",
                      "on bottom: false",
                      "Time to use a generic PickyBag!",
                      "1 - Bag should hold ints, or",
                      "2 - Bag should hold Chickens, or",
                      "3 - Bag should hold Collections?",
                      "Your choice?",
                      "Adding [[hi, there], [4, 2], [Eunice, Lesley, Momo], [Al (3), Enri (42)]] to this picky bag:",
                      "Here's what's in the picky bag now: [[hi, there], [4, 2], [Eunice, Lesley, Momo], [Al (3), Enri (42)]]",
                      "What collection of words should we try to add (separate with spaces)?",
                      "After trying to add [push, the, button,, Frank], here's what's in the picky bag now: [[hi, there], [4, 2], [Eunice, Lesley, Momo], [Al (3), Enri (42)], [push, the, button,, Frank]]",
                      "Closing my eyes and pulling something out of this bag...",
                      "....and I pull out a [hi, there]");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
