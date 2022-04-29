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
	return Arrays.stream(split).filter(s -> !s.isEmpty()).map(String::trim).collect(Collectors.toList());
    }

    @Test
    @DisplayName("the sole test")
    void the_sole_test() throws Exception {

	withTextFromSystemIn("").execute(() -> {
	    List<String> expectedOutputParts = List.of("Here are the 3 ints: [1, 2, 3]",
		    "Here are the 3 doubles: [3.14, -0.22, 1.7976931348623157E308]",
		    "Here are the 3 strings: [Wait...what?, Push the button, Frank., Game over, man - game over!]",
		    "Here are the 5 foods: [Okonomiyaki, null, null, Surstromming, Green Eggs and Ham]",
		    "Here are the 2 games: [Ticket to Ride (8), The Awful Green Things from Outer Space (7)]");

	    String rawConsoleOutput = tapSystemOutNormalized(() -> Main.main(new String[0])).trim();
	    List<String> cleanedOutput = clean(rawConsoleOutput);

	    assertThat(cleanedOutput).isEqualTo(expectedOutputParts);
	});
    }
}
