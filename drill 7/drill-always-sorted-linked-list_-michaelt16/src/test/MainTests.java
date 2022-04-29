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
  @DisplayName("no entries case")
  void no_entries_case() throws Exception {

    withTextFromSystemIn("#")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter a list of words separated by spaces.",
                      "If the word has a + in front of it, I'll add it.",
                      "If the word has a - in front of it, I'll remove it.",
                      "Otherwise, I'll ignore it.",
                      "I'll stop when you enter a # for the word.",
                      "Let's begin!",
                      "Your words>",
                      "Here are the words, in order:");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("add 3 words in reverse order")
  void add_3_words_in_reverse_order() throws Exception {

    withTextFromSystemIn("+wow +pop +gig +blurt #")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter a list of words separated by spaces.",
                      "If the word has a + in front of it, I'll add it.",
                      "If the word has a - in front of it, I'll remove it.",
                      "Otherwise, I'll ignore it.",
                      "I'll stop when you enter a # for the word.",
                      "Let's begin!",
                      "Your words>",
                      "Here are the words, in order:",
                      "blurt gig pop wow");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("add words in order with dupes and remove one dupe")
  void add_words_in_order_with_dupes_and_remove_one_dupe() throws Exception {

    withTextFromSystemIn("+angus +brittle +calliope +dastardly +edifice +calliope -calliope #")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Enter a list of words separated by spaces.",
                      "If the word has a + in front of it, I'll add it.",
                      "If the word has a - in front of it, I'll remove it.",
                      "Otherwise, I'll ignore it.",
                      "I'll stop when you enter a # for the word.",
                      "Let's begin!",
                      "Your words>",
                      "Here are the words, in order:",
                      "angus brittle calliope dastardly edifice");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
