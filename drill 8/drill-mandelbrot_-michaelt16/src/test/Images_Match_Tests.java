package test;

import static org.assertj.core.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.App;
import main.CartesianPlane;
import main.ViewPort;

@DisplayName("Images Match Tests")
public class Images_Match_Tests {

  @Test
  @DisplayName("max bailout 100, 150 rows by 100 cols")
  void max_bailout_100_150_rows_by_100_cols() throws FileNotFoundException {

    File expectedFile = new File("src//test//expected-images//mandy-max100-150-100.txt");

    ViewPort viewport = new ViewPort(-2, 0.5, -1.0, 1.0);
    CartesianPlane plane = new CartesianPlane(150, 100, viewport);

    new App(100, plane).run("mandy-test-1.txt");

    File actualFile = new File("mandy-test-1.txt");

    assertThat(actualFile).hasSameTextualContentAs(expectedFile, Charset.defaultCharset());
  }

  @Test
  @DisplayName("max bailout 100, 300 rows by 200 cols")
  void max_bailout_100_300_rows_by_200_cols() throws FileNotFoundException {

    File expectedFile = new File("src//test//expected-images//mandy-max100-300-200.txt");

    ViewPort viewport = new ViewPort(-2, 0.5, -1.0, 1.0);
    CartesianPlane plane = new CartesianPlane(300, 200, viewport);

    new App(100, plane).run("mandy-test-2.txt");

    File actualFile = new File("mandy-test-2.txt");

    assertThat(actualFile).hasSameTextualContentAs(expectedFile, Charset.defaultCharset());
  }
}
