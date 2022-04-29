package main;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents data about a YouTubeVideo.
 *
 * <p>The natural order for YouTubeVideos is by descending number of likes. (That is, videos with
 * many likes come before videos with few ones.)
 *
 * @author jpratt
 */
public class YouTubeVideo implements Comparable<YouTubeVideo> {

  private String title;
  private String creator;
  private LocalDate creationDate;
  private Duration duration;
  private int numViews;
  private int numLikes;
  private int numDislikes;
  private List<String> comments;

  // TODO: complete the Comparator constant; it orders by descending number of comments, followed by
  // descending number of views, followed by alphabetic on title
  //
  // You can use either use a lambda here or an anonymous class

  // DescCommentsDescViewsAlphTitleComparator
  /* (YouTubeVideo v1, YouTubeVideo v2) ->
  Integer.toString(v1.numViews).compareTo(Integer.toString(v2.numViews));*/

  public static final Comparator<YouTubeVideo> DESCCOMMENTSDESCVIEWSALPHTITTLECOMPARATOR =
      new Comparator<YouTubeVideo>() {
        @Override
        public int compare(YouTubeVideo v1, YouTubeVideo v2) {

          if (v1.comments.size() - v2.comments.size() == 0) {
            return Integer.toString(v2.numViews).compareTo(Integer.toString(v1.numViews));
          } else if (v1.numViews - v2.numViews == 0) {
            return v1.title.compareTo(v2.title);
          }
          return Integer.toString(v2.comments.size())
              .compareTo(Integer.toString(v1.comments.size()));
        }
      };

  public YouTubeVideo(
      String title,
      String creator,
      LocalDate creationDate,
      Duration duration,
      int numViews,
      int numLikes,
      int numDislikes,
      List<String> comments) {
    this.title = title;
    this.creator = creator;
    this.creationDate = creationDate;
    this.duration = duration;
    this.numViews = numViews;
    this.numLikes = numLikes;
    this.numDislikes = numDislikes;
    this.comments = new ArrayList<>(comments);
  }

  public YouTubeVideo(String title, String creator, Duration duration) {
    this(title, creator, LocalDate.now(), duration, 0, 0, 0, Collections.emptyList());
  }

  public String getTitle() {
    return title;
  }

  public String getCreator() {
    return creator;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public Duration getDuration() {
    return duration;
  }

  public int getNumViews() {
    return numViews;
  }

  public int getNumLikes() {
    return numLikes;
  }

  public int getNumDislikes() {
    return numDislikes;
  }

  public List<String> getComments() {
    return comments;
  }

  @Override
  public String toString() {
    String durationAsText =
        String.format("%02d:%02d", duration.toMinutesPart(), duration.toSecondsPart());
    return String.format(
        "%s[%s] (likes: %,d, cr: %s, d: %s, v: %,d, nc: %d)",
        title, creator, numLikes, creationDate, durationAsText, numViews, comments.size());
  }

  @Override
  public int compareTo(YouTubeVideo video1) {
    return video1.getNumLikes() - this.getNumLikes();
  }
}
