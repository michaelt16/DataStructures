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
  @DisplayName("test_one")
  void test_one() throws Exception {

    withTextFromSystemIn("7", "9")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "What number are you looking for?",
                      "Sorry...no 7 in [4, 11, 2, 18, 18, 1, 6, 9]",
                      "What dice number are you looking for?",
                      "Found at least one 9(W)! It's at index 7.");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("test_two")
  void test_two() throws Exception {

    withTextFromSystemIn("18", "18")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "What number are you looking for?",
                      "Found at least one 18! It's at index 3.",
                      "What dice number are you looking for?",
                      "Found at least one 18(W)! It's at index 4.");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
