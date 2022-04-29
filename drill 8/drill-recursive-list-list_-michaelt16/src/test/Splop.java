package test;

public class Splop {

  private enum Taste {
    SALTY,
    SWEET,
    VILE
  };

  private Taste taste;
  private int intensity;

  public static Splop makeSaltySplop(int intensity) {
    Splop splop = new Splop();
    splop.taste = Taste.SALTY;
    splop.intensity = intensity;
    return splop;
  }

  public static Splop makeSweetSplop(int intensity) {
    Splop splop = new Splop();
    splop.taste = Taste.SWEET;
    splop.intensity = intensity;
    return splop;
  }

  public static Splop makeVileSplop(int intensity) {
    Splop splop = new Splop();
    splop.taste = Taste.VILE;
    splop.intensity = intensity;
    return splop;
  }

  @Override
  public String toString() {
    return String.format("%s Splop [%d]", taste, intensity);
  }
}
