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
  @DisplayName("run_one")
  void run_one() throws Exception {

    withTextFromSystemIn("ZEBRA", "TED", "moose", "cabal", "")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Hi! I'm the Always Sorted List app!",
                      "Every word you enter on a line will be added to me in order.",
                      "I will turn each word to lowercase before it is added.",
                      "I will keep the words in alphabetic order.",
                      "I will show you my contents after every word.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering words!",
                      "> contents: [zebra]",
                      "> contents: [ted, zebra]",
                      "> contents: [moose, ted, zebra]",
                      "> contents: [cabal, moose, ted, zebra]",
                      "> Done now! Thanks!");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("run_two_ends_right_away")
  void run_two_ends_right_away() throws Exception {

    withTextFromSystemIn("")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Hi! I'm the Always Sorted List app!",
                      "Every word you enter on a line will be added to me in order.",
                      "I will turn each word to lowercase before it is added.",
                      "I will keep the words in alphabetic order.",
                      "I will show you my contents after every word.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering words!",
                      "> Done now! Thanks!");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("run_three_has_dupes_and_a_number")
  void run_three_has_dupes() throws Exception {

    withTextFromSystemIn("a", "b", "a", "b", "b", "b", "z", "123", "")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Hi! I'm the Always Sorted List app!",
                      "Every word you enter on a line will be added to me in order.",
                      "I will turn each word to lowercase before it is added.",
                      "I will keep the words in alphabetic order.",
                      "I will show you my contents after every word.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering words!",
                      "> contents: [a]",
                      "> contents: [a, b]",
                      "> contents: [a, a, b]",
                      "> contents: [a, a, b, b]",
                      "> contents: [a, a, b, b, b]",
                      "> contents: [a, a, b, b, b, b]",
                      "> contents: [a, a, b, b, b, b, z]",
                      "> contents: [123, a, a, b, b, b, b, z]",
                      "> Done now! Thanks!");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
