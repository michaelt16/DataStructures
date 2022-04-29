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
  @DisplayName("1 int list case")
  void run_one() throws Exception {

    withTextFromSystemIn("8")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter in a list of zero or more ints, separated by whitespace:",
                      "Found me the biggest in the OptionalReturnList! It's: 8",
                      "Found me the biggest in the ExceptionThrowingList! It's: 8");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("empty list case")
  void run_two_ends_right_away() throws Exception {

    withTextFromSystemIn("")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter in a list of zero or more ints, separated by whitespace:",
                      "Didn't find a darn thing in the OptionalReturnList. Sad now.",
                      "Didn't find a darn thing in the ExceptionThrowingList and got this dang exception: You can't findBiggest when it's empty.");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("multiple int list case")
  void fill_that_sucker_up() throws Exception {

    withTextFromSystemIn("11", "22", "33", "44", "55", "66", "77", "88")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter in a list of zero or more ints, separated by whitespace:",
                      "Found me the biggest in the OptionalReturnList! It's: 11",
                      "Found me the biggest in the ExceptionThrowingList! It's: 11");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
