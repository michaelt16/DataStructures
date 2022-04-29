package test;

import static org.assertj.core.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("No Loops Me Bucko Tests")
public class No_Loops_Me_Bucko_Tests {

  @Test
  @DisplayName("you don't need no steenking loops")
  void you_don_t_need_no_steenking_loops() {
    File appSourceFile = new File("src//main//App.java");

    assertThat(contentOf(appSourceFile))
        .doesNotContain("for(")
        .doesNotContain("for (")
        .doesNotContain("while(")
        .doesNotContain("while (");
  }
}
