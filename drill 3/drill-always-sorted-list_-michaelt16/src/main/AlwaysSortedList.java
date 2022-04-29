package main;

import java.util.ArrayList;
import java.util.List;

public class AlwaysSortedList<T extends Comparable<T>> {

  private ArrayList<T> arraylist = new ArrayList<>();

  public List<T> contents() {

    return new ArrayList<T>(arraylist);
  }

  public void add(T addedThing) {

    if (arraylist.isEmpty()) {
      arraylist.add(addedThing);
    } else {
      int listSize = size();
      for (int i = 0; i < listSize; i++) {
        if (addedThing.compareTo(arraylist.get(i)) < 0) {
          arraylist.add(i, addedThing);
          return;
        }
      }
      arraylist.add(addedThing);
    }
  }

  public int size() {
    return arraylist.size();
  }
}
