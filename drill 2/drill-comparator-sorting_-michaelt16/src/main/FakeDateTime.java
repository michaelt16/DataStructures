package main;

import java.time.LocalDateTime;

public interface FakeDateTime {

  /**
   * A cheesy way of creating a semi-unique pickup time. I'm not proud.
   *
   * <p>Why am I doing this? To make unit testing easier. Yup.
   *
   * @param name the name of the Item
   * @param value the value of the Item
   */
  static LocalDateTime createFrom(String name, int value) {
    LocalDateTime basePickup = LocalDateTime.of(2020, 12, 30, 3, 45, 0);
    return basePickup.plusHours(value).plusMinutes(name.length());
  }
}
