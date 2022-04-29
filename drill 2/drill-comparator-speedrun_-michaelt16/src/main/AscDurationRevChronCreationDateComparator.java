package main;

import java.util.Comparator;

public class AscDurationRevChronCreationDateComparator implements Comparator<YouTubeVideo> {

  /*public static Comparator<YouTubeVideo> bob =
  Comparator.comparing(YouTubeVideo::getDuration)

      .thenComparing(YouTubeVideo::getCreationDate).reversed();*/

  @Override
  public int compare(YouTubeVideo v1, YouTubeVideo v2) {

    if (v1.getDuration().compareTo(v2.getDuration()) == 0) {
      return v2.getCreationDate().compareTo(v1.getCreationDate());
    }
    return v1.getDuration().compareTo(v2.getDuration());
  }
}
