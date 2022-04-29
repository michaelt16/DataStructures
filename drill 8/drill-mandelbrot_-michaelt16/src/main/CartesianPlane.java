package main;

public class CartesianPlane {

  private int widthInPixels;
  private int heightInPixels;
  private ViewPort viewport;

  public CartesianPlane(int widthInPixels, int heightInPixels, ViewPort viewport) {
    this.widthInPixels = widthInPixels;
    this.heightInPixels = heightInPixels;
    this.viewport = viewport;
  }

  public int width() {
    return widthInPixels;
  }

  public int height() {
    return heightInPixels;
  }

  public double xcoordFor(int col) {
    return viewport.leftBoundary() + ((double) col / widthInPixels) * viewport.width();
  }

  public double ycoordFor(int row) {
    return viewport.downBoundary() + ((double) row / heightInPixels) * viewport.height();
  }
}
