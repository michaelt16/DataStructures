package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
    ViewPort viewport = new ViewPort(-2, 0.5, -1.0, 1.0);

    // choose different widths and heights: ideally, they should be a
    // 3:2 ratio ... don't go too big (like past 1000), because the
    // App can take a long time to run and the resulting files won't
    // really be viewable!

    int width = 150;
    int height = 100;

    // the maxIterations controls how "accurate" the image will be...in
    // a text version like this, larger numbers won't make a huge
    // difference, but if these were "real" images....
    int maxIterations = 100;

    CartesianPlane plane = new CartesianPlane(width, height, viewport);

    String filename = "my-mandy.txt";

    new App(maxIterations, plane).run(filename);
  }

  // some stuffs used from here:
  // https://www.codingame.com/playgrounds/2358/how-to-plot-the-mandelbrot-set/adding-some-colors

  private static final int DEFAULT_MAX_ITERATIONS = 1000;

  private static final int DEFAULT_WIDTH = 600;
  private static final int DEFAULT_HEIGHT = 400;
  private static final double DEFAULT_X_LEFT = -2.0;
  private static final double DEFAULT_X_RIGHT = 0.5;
  private static final double DEFAULT_Y_UP = 1.0;
  private static final double DEFAULT_Y_DOWN = -1.0;

  private final CartesianPlane plane;
  private final int maxIterations;

  private PrintWriter pw;

  public App() {
    ViewPort viewport = new ViewPort(DEFAULT_X_LEFT, DEFAULT_X_RIGHT, DEFAULT_Y_DOWN, DEFAULT_Y_UP);
    CartesianPlane plane = new CartesianPlane(DEFAULT_WIDTH, DEFAULT_HEIGHT, viewport);
    this.plane = plane;
    this.maxIterations = DEFAULT_MAX_ITERATIONS;
  }

  public App(int maxIterations, CartesianPlane plane) {
    this.maxIterations = maxIterations;
    this.plane = plane;
  }

  /**
   * Write a text Mandelbrot to a file with a given filename.
   *
   * @param filename the name of the file to write to
   * @throws FileNotFoundException if there's a problem getting to Mandy
   */
  public void run(String filename) throws FileNotFoundException {

    try (PrintWriter pw = new PrintWriter(new File(filename))) {
      this.pw = pw;
      paintAllTheBrotRows();
    }
  }

  /**
   * Paints all the rows in the Mandelbrot, starting at row 0 and ending at plane.height - 1. After
   * each row, print a newline.
   */
  private void paintAllTheBrotRows() {
    // TODO: turn this loop into an equivalent recursive (or pair of recursive) method
    //
    // Hint: your recursive method will need parameters currRowNum and the number of
    // rows (which is found using plane.height()). Your wrapper won't have any parameters,
    // just like this looped version
    int currRowNum = 0;
    int rows = plane.height();
    paintHelp(currRowNum, rows);
  }

  private void paintHelp(int currRowNum, int rows) {
    if (currRowNum != rows) {

      paintOneRow(currRowNum);
      pw.println();

      paintHelp(currRowNum + 1, rows);
    }
  }

  /**
   * Paints a single row with a given row number.
   *
   * @param currRowNum the number of the row to paint
   */
  private void paintOneRow(int currRowNum) {
    // TODO: turn this method into an equivalent recursive (or pair of recursive) method
    //
    // Hint: your recursive method will need parameters currRowNum, currColNum, and the number of
    // columns (which is found using plane.width()). Your wrapper will just have parameter
    // currRowNum, just like this looped version.

    paintRowHelp(currRowNum, 0, plane.width());
  }

  private void paintRowHelp(int currRowNum, int currColNum, int width) {
    if (currColNum < width) {
      paintOnePixel(currRowNum, currColNum);
      paintRowHelp(currRowNum, currColNum + 1, width);
    }
  }

  /**
   * Don't worry about the Math here...just know it works. If you're still interested, check out:
   * https://en.wikipedia.org/wiki/Plotting_algorithms_for_the_Mandelbrot_set
   *
   * @param p0 the complex point being evaluated
   * @return the number of iterations necessary to determine if p0 is in the Mandelbrot set
   */
  private int escapeValueFor(ComplexNumber p0) {
    // TODO: turn this method into an equivalent recursive (or pair of recursive) method
    //
    // Hint: your recursive method will need parameters p, p0, and currIterationNumber. Your wrapper
    // will just have parameter p0 - just like this looped version.

    ComplexNumber p = new ComplexNumber(0, 0);
    int currIterationNum = 0;
    return helper(p, p0, currIterationNum);
  }

  private int helper(ComplexNumber p, ComplexNumber p0, int currIterationNum) {
    if (!bounded(p) || currIterationNum == maxIterations) {

      return currIterationNum;
    } else {

      update(p, p0);
      currIterationNum += 1;

      return helper(p, p0, currIterationNum);
    }
  }

  /**
   * Paints a single "pixel" (a character at a given row and col) using some Maths.
   *
   * @param currRow the row where the character is being painted
   * @param currCol the col where the character is being painted
   */
  private void paintOnePixel(int currRow, int currCol) {

    ComplexNumber p0 = complexNumberFrom(currRow, currCol);
    int escapeValue = escapeValueFor(p0);
    pw.print(MandelbrotColorUtil.colorFor(escapeValue, maxIterations));
  }

  private ComplexNumber complexNumberFrom(int row, int col) {
    double realPart = plane.xcoordFor(col);
    double imaginaryPart = plane.ycoordFor(row);
    return new ComplexNumber(realPart, imaginaryPart);
  }

  /**
   * Here there be tygers. Math tygers. See
   * https://en.wikipedia.org/wiki/Plotting_algorithms_for_the_Mandelbrot_set
   *
   * @param p the complex number currently being updated
   * @param p0 the original complex number being painted
   */
  private void update(ComplexNumber p, ComplexNumber p0) {
    double xtemp = Math.pow(p.realPortion, 2) - Math.pow(p.imaginaryPortion, 2) + p0.realPortion;
    p.imaginaryPortion = 2 * p.realPortion * p.imaginaryPortion + p0.imaginaryPortion;
    p.realPortion = xtemp;
  }

  private boolean bounded(ComplexNumber p) {
    return Math.pow(p.realPortion, 2) + Math.pow(p.imaginaryPortion, 2) <= 4;
  }

  private class ComplexNumber {
    private double realPortion;
    private double imaginaryPortion;

    ComplexNumber(double realPortion, double imaginaryPortion) {
      this.realPortion = realPortion;
      this.imaginaryPortion = imaginaryPortion;
    }

    @Override
    public String toString() {
      return String.format("(%d,%d)", realPortion, imaginaryPortion);
    }
  }
}
