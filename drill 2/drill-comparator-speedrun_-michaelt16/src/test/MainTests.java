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

    withTextFromSystemIn("That Time Me and Kyle", "Ellis")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Name of video to add?",
                      "Name of creator?",
                      "Here are the vids as they appear at the start:",
                      "1  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Here are the vids in descending order of likes (natural order):",
                      "1  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "4  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Vids in ascending duration/reverse chronological creation date order:",
                      "1  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "2  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "3  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "4  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Vids in reverse alphabetic creator order:",
                      "1  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Vids in descending number of comments/descending number of views/alphabetic title order:",
                      "1  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "The vids should still be in the order they started in:",
                      "1  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => That Time Me and Kyle[Ellis] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }

  @Test
  @DisplayName("run_two")
  void run_two() throws Exception {

    withTextFromSystemIn("Stop Making Sense", "TalkingHeadsCentral")
        .execute(
            () -> {
              List<String> expectedOutputParts =
                  List.of(
                      "Name of video to add?",
                      "Name of creator?",
                      "Here are the vids as they appear at the start:",
                      "1  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Here are the vids in descending order of likes (natural order):",
                      "1  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "4  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "5  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Vids in ascending duration/reverse chronological creation date order:",
                      "1  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "2  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "3  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "4  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "5  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "Vids in reverse alphabetic creator order:",
                      "1  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "2  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "3  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "4  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "5  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "Vids in descending number of comments/descending number of views/alphabetic title order:",
                      "1  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)",
                      "The vids should still be in the order they started in:",
                      "1  => My Cat, My Killer[stubblyBeast] (likes: 0, cr: 2020-12-29, d: 02:23, v: 0, nc: 0)",
                      "2  => Fashion Coward - SNL[Saturday Night Live] (likes: 75,000, cr: 2019-04-13, d: 02:03, v: 3,920,363, nc: 3)",
                      "3  => Playing an RPG for the first time[Joel Haver] (likes: 233,000, cr: 2020-11-20, d: 03:08, v: 2,004,937, nc: 4)",
                      "4  => Nice Stub[Hans Hans] (likes: 2, cr: 2020-11-21, d: 03:08, v: 0, nc: 0)",
                      "5  => Stop Making Sense[TalkingHeadsCentral] (likes: 0, cr: 2020-12-29, d: 10:00, v: 0, nc: 0)");

              String rawConsoleOutput =
                  tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
              List<String> cleanedOutput = clean(rawConsoleOutput);

              assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
            });
  }
}
