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

    withTextFromSystemIn("1", "2", "")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Hi! I'm the Oscillating Resizable List app!",
                      "Please enter one integer per line.",
                      "I will add that number to the list and then show you its contents.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering numbers!",
                      "> contents: [null, null, null, 1, null, null, null]",
                      "> contents: [null, null, null, 1, 2, null, null]",
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
                      "Hi! I'm the Oscillating Resizable List app!",
                      "Please enter one integer per line.",
                      "I will add that number to the list and then show you its contents.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering numbers!",
                      "> Done now! Thanks!");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("fill that sucker up")
  void fill_that_sucker_up() throws Exception {

    withTextFromSystemIn("11", "22", "33", "44", "55", "66", "77", "88", "")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Hi! I'm the Oscillating Resizable List app!",
                      "Please enter one integer per line.",
                      "I will add that number to the list and then show you its contents.",
                      "I will stop when you enter an empty line.",
                      "Ready? Start entering numbers!",
                      "> contents: [null, null, null, 11, null, null, null]",
                      "> contents: [null, null, null, 11, 22, null, null]",
                      "> contents: [null, null, 33, 11, 22, null, null]",
                      "> contents: [null, null, 33, 11, 22, 44, null]",
                      "> contents: [null, 55, 33, 11, 22, 44, null]",
                      "> contents: [null, 55, 33, 11, 22, 44, 66]",
                      "> contents: [77, 55, 33, 11, 22, 44, 66]",
                      "> contents: [null, null, null, 77, 55, 33, 11, 22, 44, 66, 88, null, null]",
                      "> Done now! Thanks!");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
