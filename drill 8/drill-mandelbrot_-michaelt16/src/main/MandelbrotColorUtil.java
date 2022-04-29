package main;

public class MandelbrotColorUtil {

  /**
   * Map a Mandelbrot escape number onto a character. You can get some pretty interesting behaviour
   * here!
   *
   * @param escapeNum the number of iterations needed to see if a point was in the Mandelbrot set
   * @param maxIterations the maximum num of iterations to try before deciding the point's in the
   *     set
   * @return a character to display in the resulting drawing
   */
  public static char colorFor(int escapeNum, int maxIterations) {
    if (escapeNum == maxIterations) {
      return ' ';
    }

    int colorVal = escapeNum % 7;
    switch (colorVal) {
      case 0:
        return 'a';
      case 1:
        return 'b';
      case 2:
        return 'c';
      case 3:
        return 'd';
      case 4:
        return 'e';
      case 5:
        return 'f';
      default:
        return 'g';
    }
  }
}
