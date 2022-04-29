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
        .map(s -> s.trim())
        .collect(Collectors.toList());
  }

  @Test
  @DisplayName("Big Red")
  void big_red() throws Exception {

    withTextFromSystemIn("10", "Big Red", "3")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "How many chickens do you need?",
                      "Spinning up an array to hold exactly 10 chickens...",
                      "...and spinning up a same-sized array to hold egg counts...",
                      "Here's what's currently in our Chicken array:",
                      "[null, null, null, null, null, null, null, null, null, null]",
                      "And here's what's currently in our egg-count array:",
                      "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]",
                      "Let's add us a chicken!",
                      "Name of bird?",
                      "Which index to use (0-9)?",
                      "Adding Big Red into slot 3...",
                      "...and adding the number of eggs she laid into the egg count array at the same index.",
                      "Now here's what's in our Chicken array:",
                      "[null, null, null, Big Red, null, null, null, null, null, null]",
                      "And here's what's in our egg-count array:",
                      "[0, 0, 0, 7, 0, 0, 0, 0, 0, 0]");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("Henzilla")
  void henzilla() throws Exception {

    withTextFromSystemIn("1", "Henzilla", "0")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "How many chickens do you need?",
                      "Spinning up an array to hold exactly 1 chickens...",
                      "...and spinning up a same-sized array to hold egg counts...",
                      "Here's what's currently in our Chicken array:",
                      "[null]",
                      "And here's what's currently in our egg-count array:",
                      "[0]",
                      "Let's add us a chicken!",
                      "Name of bird?",
                      "Which index to use (0-0)?",
                      "Adding Henzilla into slot 0...",
                      "...and adding the number of eggs she laid into the egg count array at the same index.",
                      "Now here's what's in our Chicken array:",
                      "[Henzilla]",
                      "And here's what's in our egg-count array:",
                      "[8]");
              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
