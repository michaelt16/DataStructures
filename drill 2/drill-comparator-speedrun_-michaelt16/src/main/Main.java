package main;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    List<YouTubeVideo> vids = loadedVids();

    addVideoTo(vids);

    System.out.println("Here are the vids as they appear at the start:");

    display(vids);

    System.out.println("Here are the vids in descending order of likes (natural order):");

    displayInNaturalOrder(vids);

    System.out.println("Vids in ascending duration/reverse chronological creation date order:");

    Comparator<YouTubeVideo> durationCreationComparator =
        new AscDurationRevChronCreationDateComparator();

    displayInAlternateOrder(vids, durationCreationComparator);

    System.out.println("Vids in reverse alphabetic creator order:");

    // TODO: create an inline Comparator that sorts in reverse alphabetic order on creator
    //       You can use either a lambda (recommended) or an anonymous class.
    Comparator<YouTubeVideo> reverseCreatorComparator =
        (YouTubeVideo name1, YouTubeVideo name2) ->
            name2.getCreator().compareToIgnoreCase(name1.getCreator());

    displayInAlternateOrder(vids, reverseCreatorComparator);

    System.out.println(
        "Vids in descending number of comments/descending number of views/alphabetic title order:");

    Comparator<YouTubeVideo> numCommentsNumViewsTitleComparator =
        YouTubeVideo.DESCCOMMENTSDESCVIEWSALPHTITTLECOMPARATOR;

    displayInAlternateOrder(vids, numCommentsNumViewsTitleComparator);

    System.out.println("The vids should still be in the order they started in:");

    display(vids);
  }

  private static void addVideoTo(List<YouTubeVideo> vids) {
    Scanner kbd = new Scanner(System.in);
    System.out.print("Name of video to add? ");
    String nameOfVideo = kbd.nextLine();

    System.out.println();

    System.out.print("Name of creator? ");
    String nameOfCreator = kbd.nextLine();

    System.out.println();

    vids.add(hackedVideo(nameOfVideo, nameOfCreator));
  }

  private static YouTubeVideo hackedVideo(String nameOfVideo, String nameOfCreator) {
    LocalDate hackedDate = LocalDate.of(2020, 12, 29);
    return new YouTubeVideo(
        nameOfVideo, nameOfCreator, hackedDate, Duration.ofSeconds(600), 0, 0, 0, List.of());
  }

  private static List<YouTubeVideo> loadedVids() {
    List<YouTubeVideo> vids = new ArrayList<>();
    vids.add(
        new YouTubeVideo(
            "My Cat, My Killer",
            "stubblyBeast",
            LocalDate.of(2020, 12, 29),
            Duration.ofSeconds(143),
            0,
            0,
            0,
            List.of()));
    vids.add(
        new YouTubeVideo(
            "Fashion Coward - SNL",
            "Saturday Night Live",
            LocalDate.of(2019, 4, 13),
            Duration.ofSeconds(123),
            3_920_363,
            75_000,
            915,
            List.of(
                "I somehow feel attacked and comforted at the same time",
                "Pants for the legs revolutionary",
                "You really didn't have to expose me like this")));
    vids.add(
        new YouTubeVideo(
            "Playing an RPG for the first time",
            "Joel Haver",
            LocalDate.of(2020, 11, 20),
            Duration.ofSeconds(188),
            2_004_937,
            233_000,
            1_600,
            List.of(
                "There is probably a reason your character started out in a prison...",
                "I used to have rats so I really appreciate this. Justice for Marshall.",
                "Recommended to me 3 times. Watched 3 times. laughed 3 times.",
                "The quiet sobbing sells the joke much more than hysterical crying would")));
    vids.add(
        new YouTubeVideo(
            "Nice Stub",
            "Hans Hans",
            LocalDate.of(2020, 11, 21),
            Duration.ofSeconds(188),
            0,
            2,
            1,
            Collections.emptyList()));

    return vids;
  }

  /**
   * Displays the given List of videos in their natural ordering.
   *
   * <p>You will need to make a defensive copy of the incoming videos and then display that copy -
   * we don't want to change the order of the original list!
   *
   * @param vids the List of videos to display in natural order
   */
  private static void displayInNaturalOrder(List<YouTubeVideo> vids) {
    // TODO: make a defensive copy of vids

    // TODO: sort the copy using natural order

    List<YouTubeVideo> copy = new ArrayList<YouTubeVideo>(vids);
    Collections.sort(copy);
    display(copy);
  }

  /**
   * Displays the given List of videos in the order determined by the given comparator.
   *
   * <p>You will need to make a defensive copy of the incoming videos and then display that copy -
   * we don't want to change the order of the original list!
   *
   * @param vids the List of videos to display in comparator order
   * @param comparator the comparator used to sort
   */
  private static void displayInAlternateOrder(
      List<YouTubeVideo> vids, Comparator<YouTubeVideo> comparator) {
    // TODO: make a defensive copy of vids

    // TODO: sort the copy using the comparator

    List<YouTubeVideo> copy = new ArrayList<YouTubeVideo>(vids);
    Collections.sort(copy, comparator);
    display(copy);
  }

  private static void display(List<YouTubeVideo> vids) {
    int place = 1;
    for (YouTubeVideo vid : vids) {
      System.out.println(place + "  => " + vid);
      place++;
    }

    System.out.println();
  }
}
