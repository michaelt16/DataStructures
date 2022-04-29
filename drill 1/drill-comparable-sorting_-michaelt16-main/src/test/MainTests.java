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

    withTextFromSystemIn("potion of snootiness", "2")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "You are carrying 3 items:",
                      "- turnip(value:1)",
                      "- potion of healing(value:3)",
                      "- glaive(value:100)",
                      "Let's add a potion to our stuff....",
                      "What kind of potion did you pick up?",
                      "How much is it worth?",
                      "You are carrying 4 items:",
                      "- turnip(value:1)",
                      "- potion of healing(value:3)",
                      "- glaive(value:100)",
                      "- potion of snootiness(value:2)",
                      "The inventory in natural sorted order is....",
                      "You are carrying 4 items (sorted):",
                      "- glaive(value:100)",
                      "- potion of healing(value:3)",
                      "- potion of snootiness(value:2)",
                      "- turnip(value:1)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("test_two")
  void test_two() throws Exception {

    withTextFromSystemIn("elixir of partial baldness", "100")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "You are carrying 3 items:",
                      "- turnip(value:1)",
                      "- potion of healing(value:3)",
                      "- glaive(value:100)",
                      "Let's add a potion to our stuff....",
                      "What kind of potion did you pick up?",
                      "How much is it worth?",
                      "You are carrying 4 items:",
                      "- turnip(value:1)",
                      "- potion of healing(value:3)",
                      "- glaive(value:100)",
                      "- elixir of partial baldness(value:100)",
                      "The inventory in natural sorted order is....",
                      "You are carrying 4 items (sorted):",
                      "- glaive(value:100)",
                      "- elixir of partial baldness(value:100)",
                      "- potion of healing(value:3)",
                      "- turnip(value:1)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
