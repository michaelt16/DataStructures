package main;

public class ViewPort {

  private final double xcoordLeftBoundary;
  private final double xcoordRightBoundary;
  private final double ycoordUpBoundary;
  private final double ycoordDownBoundary;

  public ViewPort(double minX, double maxX, double minY, double maxY) {
    xcoordLeftBoundary = minX;
    xcoordRightBoundary = maxX;
    ycoordUpBoundary = maxY;
    ycoordDownBoundary = minY;
  }

  public double leftBoundary() {
    return xcoordLeftBoundary;
  }

  public double downBoundary() {
    return ycoordDownBoundary;
  }

  public double height() {
    return ycoordUpBoundary - ycoordDownBoundary;
  }

  public double width() {
    return xcoordRightBoundary - xcoordLeftBoundary;
  }
}
