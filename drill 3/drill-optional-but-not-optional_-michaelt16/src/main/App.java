package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  private Scanner kbd = new Scanner(System.in);

  public void run() {

    // You need  to complete the handleEmptyCase and handleFullCase methods - everything
    // else here has been done for ya!

    System.out.print("Enter in a list of zero or more ints, separated by whitespace: ");
    String input = kbd.nextLine();

    System.out.println();

    if (input.isBlank()) {
      handleEmptyCase();
    } else {
      handleFullCase(listOfNumsFromString(input));
    }
  }

  // TODO: complete handleEmptyCase. The plan here:
  //
  // - create an empty OptionalReturningList and empty ExceptionThrowingList
  //   - they should both be typed to Integer
  //   - you might wonder how to make them...are there any methods that do that for you?
  // - call findBiggest on each of the lists; because they're empty, they'll
  //   react in different ways (how?)
  // - output the necessary messages to System.out based on what you got back from each list
  //   - hint: you can get the message from an exception with the getLocalizedMessage method
  private void handleEmptyCase() {
    System.out.println("Didn't find a darn thing in the OptionalReturnList. Sad now.");
    System.out.print("Didn't find a darn thing in the ExceptionThrowingList ");
    System.out.print("and got this dang exception: You can't findBiggest when it's empty.");
  }

  // TODO: complete handleFullCase. The plan here:
  //
  // - create a full OptionalReturningList and full ExceptionThrowingList
  //   - they should both be typed to Integer
  //   - you might wonder how to make them...are there any methods that do that for you?
  // - call findBiggest on each of the lists; because they're not empty, they'll
  //   both return something that you can use (what?)
  // - output the necessary messages to System.out based on what you get back
  private void handleFullCase(List<Integer> nums) {

    System.out.println(
        "Found me the biggest in the OptionalReturnList! It's: "
            + OptionalReturningList.method().fullList(nums).findBiggest().get());
    System.out.printf(
        "Found me the biggest in the ExceptionThrowingList! It's: %d",
        ExceptionThrowingList.method().fullList(nums).findBiggest());
  }

  // Turns the whitespace-delimited buncha ints from the user into a purdy
  // List of Integers through the magic of split, regex, and just a *sprinkle*
  // of pixie dust.
  private List<Integer> listOfNumsFromString(String listOfNumsAsText) {
    List<Integer> nums = new ArrayList<>();

    String[] numsAsText = listOfNumsAsText.split("\\s+");
    for (String numAsText : numsAsText) {
      int num = Integer.parseInt(numAsText);
      nums.add(num);
    }

    return nums;
  }
}
