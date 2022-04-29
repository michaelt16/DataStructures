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

    withTextFromSystemIn("15", "aluminium", "2700", "Stand By Me", "1986")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Noise reading in dB?",
                      "Here are the natural orderings for the 3 NoiseReading objects in the Comparable[] array:",
                      "12dB @ (41.6,144.5) is the same as 12dB @ (41.6,144.5)",
                      "12dB @ (41.6,144.5) comes after 15dB @ (41.6,-32.4)",
                      "12dB @ (41.6,144.5) is the same as 12dB @ (41.6,-154.4)",
                      "15dB @ (41.6,-32.4) comes before 12dB @ (41.6,144.5)",
                      "15dB @ (41.6,-32.4) is the same as 15dB @ (41.6,-32.4)",
                      "15dB @ (41.6,-32.4) comes before 12dB @ (41.6,-154.4)",
                      "12dB @ (41.6,-154.4) is the same as 12dB @ (41.6,144.5)",
                      "12dB @ (41.6,-154.4) comes after 15dB @ (41.6,-32.4)",
                      "12dB @ (41.6,-154.4) is the same as 12dB @ (41.6,-154.4)",
                      "Name of material?",
                      "Denisty of material?",
                      "Here are the natural orderings for the 3 Material objects in the Comparable[] array:",
                      "aluminium(2700.00kg/m3) is the same as aluminium(2700.00kg/m3)",
                      "aluminium(2700.00kg/m3) comes after blood(1.60kg/m3)",
                      "aluminium(2700.00kg/m3) comes before granite(2700.00kg/m3)",
                      "blood(1.60kg/m3) comes before aluminium(2700.00kg/m3)",
                      "blood(1.60kg/m3) is the same as blood(1.60kg/m3)",
                      "blood(1.60kg/m3) comes before granite(2700.00kg/m3)",
                      "granite(2700.00kg/m3) comes after aluminium(2700.00kg/m3)",
                      "granite(2700.00kg/m3) comes after blood(1.60kg/m3)",
                      "granite(2700.00kg/m3) is the same as granite(2700.00kg/m3)",
                      "Title of movie?",
                      "Year of release?",
                      "Here are the natural orderings for the 3 Movie objects in the Comparable[] array:",
                      "Aliens (1986) is the same as Aliens (1986)",
                      "Aliens (1986) comes after Battleship Potemkin (1925)",
                      "Aliens (1986) comes after Stand By Me (1986)",
                      "Battleship Potemkin (1925) comes before Aliens (1986)",
                      "Battleship Potemkin (1925) is the same as Battleship Potemkin (1925)",
                      "Battleship Potemkin (1925) comes before Stand By Me (1986)",
                      "Stand By Me (1986) comes before Aliens (1986)",
                      "Stand By Me (1986) comes after Battleship Potemkin (1925)",
                      "Stand By Me (1986) is the same as Stand By Me (1986)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("run_two")
  void run_two() throws Exception {

    withTextFromSystemIn("1", "air", "1.2", "Knives Out", "2019")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Noise reading in dB?",
                      "Here are the natural orderings for the 3 NoiseReading objects in the Comparable[] array:",
                      "12dB @ (41.5,-148.2) is the same as 12dB @ (41.5,-148.2)",
                      "12dB @ (41.5,-148.2) comes before 1dB @ (41.5,150.7)",
                      "12dB @ (41.5,-148.2) is the same as 12dB @ (41.5,28.7)",
                      "1dB @ (41.5,150.7) comes after 12dB @ (41.5,-148.2)",
                      "1dB @ (41.5,150.7) is the same as 1dB @ (41.5,150.7)",
                      "1dB @ (41.5,150.7) comes after 12dB @ (41.5,28.7)",
                      "12dB @ (41.5,28.7) is the same as 12dB @ (41.5,-148.2)",
                      "12dB @ (41.5,28.7) comes before 1dB @ (41.5,150.7)",
                      "12dB @ (41.5,28.7) is the same as 12dB @ (41.5,28.7)",
                      "Name of material?",
                      "Denisty of material?",
                      "Here are the natural orderings for the 3 Material objects in the Comparable[] array:",
                      "air(1.20kg/m3) is the same as air(1.20kg/m3)",
                      "air(1.20kg/m3) comes before blood(1.60kg/m3)",
                      "air(1.20kg/m3) comes before granite(2700.00kg/m3)",
                      "blood(1.60kg/m3) comes after air(1.20kg/m3)",
                      "blood(1.60kg/m3) is the same as blood(1.60kg/m3)",
                      "blood(1.60kg/m3) comes before granite(2700.00kg/m3)",
                      "granite(2700.00kg/m3) comes after air(1.20kg/m3)",
                      "granite(2700.00kg/m3) comes after blood(1.60kg/m3)",
                      "granite(2700.00kg/m3) is the same as granite(2700.00kg/m3)",
                      "Title of movie?",
                      "Year of release?",
                      "Here are the natural orderings for the 3 Movie objects in the Comparable[] array:",
                      "Aliens (1986) is the same as Aliens (1986)",
                      "Aliens (1986) comes after Battleship Potemkin (1925)",
                      "Aliens (1986) comes before Knives Out (2019)",
                      "Battleship Potemkin (1925) comes before Aliens (1986)",
                      "Battleship Potemkin (1925) is the same as Battleship Potemkin (1925)",
                      "Battleship Potemkin (1925) comes before Knives Out (2019)",
                      "Knives Out (2019) comes after Aliens (1986)",
                      "Knives Out (2019) comes after Battleship Potemkin (1925)",
                      "Knives Out (2019) is the same as Knives Out (2019)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
