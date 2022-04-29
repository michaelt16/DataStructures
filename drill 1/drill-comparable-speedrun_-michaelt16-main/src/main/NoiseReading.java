package main;

import java.util.Random;

/**
 * Represents a reading taken from some kind of noise-measuring device.
 *
 * <p>We'll assume the device has some sort of GPS system that tracks its latitude and longitude.
 *
 * <p>The natural ordering of NoiseReadings is in descending order of decibels. (That is, from loud
 * readings to quiet.)
 *
 * @author jpratt
 */
public class NoiseReading implements Comparable<NoiseReading> {
  private int decibels;
  private double latitude;
  private double longitude;
  private final Random rgen;

  private static int drift = 0;

  /**
   * Creates a NoiseReading from a machine located at a random latitude and longitude. The reading
   * is in decibels.
   *
   * @param decibels noise reading in decibels
   */
  public NoiseReading(int decibels) {
    // we use a seed for Random so that our unit tests are predictable
    rgen = new Random(1 + drift);
    drift++;

    this.decibels = decibels;
    this.latitude = someRandomLatitude();
    this.longitude = someRandomLongitude();
  }

  /**
   * Latitudes run from -90 to +90 degrees.
   *
   * @return a random latitude in [-90, 90)
   */
  private double someRandomLatitude() {
    return 180 * rgen.nextDouble() - 90;
  }

  /**
   * Longitudes run from -180 to +180 degrees.
   *
   * @return a random longitude in [-180, 180)
   */
  private double someRandomLongitude() {
    return 360 * rgen.nextDouble() - 180;
  }

  @Override
  public String toString() {
    return String.format("%ddB @ (%.1f,%.1f)", decibels, latitude, longitude);
  }

  @Override
  public int compareTo(NoiseReading otherNoiseReading) {
    return otherNoiseReading.decibels - this.decibels;
  }
}
