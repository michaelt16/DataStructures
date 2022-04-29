package test;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Main;

public class MainTests {

  @Test
  @DisplayName("Bronco Billy")
  void bronco_billy() throws Exception {

    withTextFromSystemIn("Bronco Billy", "74", "right turn, Clyde")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "What is your name?",
                      "How old are you, Bronco Billy?",
                      "If I were half that age, I'd be 37.0.",
                      "Gimme at least two words. Separate them with spaces:",
                      "The first word that you gave me was \"right\".");

              String whatIsOutput = tapSystemOutNormalized(() -> Main.main(new String[0])).trim();

              assertThat(whatIsOutput).containsSubsequence(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("ghost sweeper mikami")
  void ghost_sweeper_mikami() throws Exception {

    withTextFromSystemIn("ghost sweeper mikami", "33", "don't make me come over there")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "What is your name?",
                      "How old are you, ghost sweeper mikami?",
                      "If I were half that age, I'd be 16.5.",
                      "Gimme at least two words. Separate them with spaces:",
                      "The first word that you gave me was \"don't\".");

              String whatIsOutput = tapSystemOutNormalized(() -> Main.main(new String[0])).trim();

              assertThat(whatIsOutput).containsSubsequence(expectedOutputParts);
            });
  }
}
