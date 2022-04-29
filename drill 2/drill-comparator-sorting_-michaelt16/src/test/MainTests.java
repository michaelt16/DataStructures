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
  @DisplayName("not sorted")
  void no_sorting() throws Exception {

    withTextFromSystemIn("1")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "How do you want to view your inventory?",
                      "1 - no sorting",
                      "2 - descending value (natural order)",
                      "3 - chronological order of pickup",
                      "4 - ascending weight / alphabetical name",
                      "5 - item type / ascending durability",
                      "Your choice?",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "Here's our inventory - it should be in the same order as earlier:",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("sorted by desc value")
  void sorted_by_desc_value() throws Exception {

    withTextFromSystemIn("2")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "How do you want to view your inventory?",
                      "1 - no sorting",
                      "2 - descending value (natural order)",
                      "3 - chronological order of pickup",
                      "4 - ascending weight / alphabetical name",
                      "5 - item type / ascending durability",
                      "Your choice?",
                      "== VALUE ORDER (NATURAL ORDER) ==",
                      "You are carrying 5 items:",
                      "001 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "002 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "003 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "004 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "Here's our inventory - it should be in the same order as earlier:",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("sorted by pickup")
  void sorted_by_pickup() throws Exception {

    withTextFromSystemIn("3")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "How do you want to view your inventory?",
                      "1 - no sorting",
                      "2 - descending value (natural order)",
                      "3 - chronological order of pickup",
                      "4 - ascending weight / alphabetical name",
                      "5 - item type / ascending durability",
                      "Your choice?",
                      "== PICKUP ORDER ==",
                      "You are carrying 5 items:",
                      "001 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "002 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "003 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "004 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "005 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "Here's our inventory - it should be in the same order as earlier:",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("sorted by weight then name")
  void sorted_by_weight_then_name() throws Exception {

    withTextFromSystemIn("4")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "How do you want to view your inventory?",
                      "1 - no sorting",
                      "2 - descending value (natural order)",
                      "3 - chronological order of pickup",
                      "4 - ascending weight / alphabetical name",
                      "5 - item type / ascending durability",
                      "Your choice?",
                      "== WEIGHT, then NAME ORDER ==",
                      "You are carrying 5 items:",
                      "001 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "004 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "005 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "Here's our inventory - it should be in the same order as earlier:",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("sorted by type then durability")
  void sorted_by_type_then_durability() throws Exception {

    withTextFromSystemIn("5")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Here's what we have already....",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "How do you want to view your inventory?",
                      "1 - no sorting",
                      "2 - descending value (natural order)",
                      "3 - chronological order of pickup",
                      "4 - ascending weight / alphabetical name",
                      "5 - item type / ascending durability",
                      "Your choice?",
                      "== ITEM TYPE, then DURABILITY ORDER ==",
                      "You are carrying 5 items:",
                      "001 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "002 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "003 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "004 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)",
                      "005 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "Here's our inventory - it should be in the same order as earlier:",
                      "== NOT SORTED ==",
                      "You are carrying 5 items:",
                      "001 - biscuit [2020-12-30, 5:52 a.m.] (v:2, w:0.5, d:0, t:FOOD)",
                      "002 - potion of healing [2020-12-30, 7:02 a.m.] (v:3, w:0.3, d:1, t:POTION)",
                      "003 - yo-yo [2021-01-01, 12:50 a.m.] (v:45, w:0.2, d:12, t:WEAPON)",
                      "004 - glaive [2021-01-03, 7:51 a.m.] (v:100, w:10.0, d:4, t:WEAPON)",
                      "005 - turnip [2020-12-30, 4:51 a.m.] (v:1, w:0.5, d:0, t:FOOD)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
