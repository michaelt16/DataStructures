package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OscillatingResizableList<T> {

  private static final int DEFAULT_CAPACITY = 7;

  private T[] listContents;
  private List<T> content;
  private int size;
  private boolean lastRight = false;
  private int posLeft = 2;
  private int posRight = 4;
  private boolean codeIsDone = false;
  private int threshold = 7;

  // private boolean isFull = false;

  /**
   * Creates a new OscillatingResizableList that is empty.
   *
   * <p>I've provided the initialization of the backing array because it's goofy.
   */
  public OscillatingResizableList() {

    listContents = (T[]) new Object[DEFAULT_CAPACITY];
    content = Arrays.asList(listContents);
    size = 0;
  }

  /**
   * Returns a List of the contents of the backing array listContents.
   *
   * <p>For the record, documentation in public methods should RARELY - if EVER - talk about the
   * internal guts of the class. :)
   *
   * @return a List of the backing array contents
   */
  public List<T> contents() {

    return new ArrayList<T>(Arrays.asList(listContents));
  }

  public void add(T nextLocation) {
    if (size % threshold == 0 && size != 0) {

      //  copied = Arrays.copyOf(listContents, content.size() + 6);
      listContents = (T[]) new Object[content.size() + 6];
      int start = 3;
      for (T contents : content) {
        listContents[start] = contents;
        start++;
      }

      content = Arrays.asList(listContents);
      /*  System.out.println("before" + posRight);
      System.out.println("before" + posLeft);*/
      posRight += 3;
      posLeft += 3;
      threshold += 6;
      /* System.out.println(posRight);
      System.out.println(posLeft);*/
    }
    if (content.get(3) == null && codeIsDone == false) {
      listContents[3] = nextLocation;
      codeIsDone = true;
      // lastRight is saying was it on the right side last time? true or false
    } else if (lastRight == false) {
      // System.out.println(posRight);

      listContents[posRight] = nextLocation;

      posRight++;
      // unfortunately if posRight is already at 6 the pointer will turn into 7
      lastRight = true;

    } else if (lastRight == true) {

      listContents[posLeft] = nextLocation;

      posLeft--;
      // unfortunately if posLeft is already at 0 the pointer will turn into -1
      lastRight = false;
    }
    size++;
  }

  public int size() {
    return size;
  }
}
