package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    // TODO: using the shortcut syntax, make an array called ints that holds these
    // ints:
    // [1, 2, 3]
    int[] ints = {1, 2, 3};

    // TODO: using the shortcut syntax, make an array called doubles that holds
    // these doubles:
    // [3.14, -0.22, Double.MAX_VALUE]
    double[] doubles = {3.14, -0.22, Double.MAX_VALUE};

    // TODO: using the shortcut syntax, make an array called strings that holds
    // these Strings:
    // ["Wait...what?", "Push the button, Frank.", "Game over, man - game over!"]
    String[] strings = {"Wait...what?", "Push the button, Frank.", "Game over, man - game over!"};

    // TODO: using the shortcut syntax, make an array called foods that holds these
    // Food objects:
    // [Okonomiyaki, null, null, Surstromming, Green Eggs and Ham]
    Food food = new Food("Okonomiyaki");
    Food food1 = new Food("Surstromming");
    Food food2 = new Food("Green Eggs and Ham");

    Food[] foods = {food, null, null, food1, food2};

    // TODO: using the constructor that takes in a Collection, make an ArrayList
    // called games
    // that holds these Boardgame objects:
    // - name: Ticket to Ride, rating: 8
    // - name: The Awful Green Things from Outer Space, rating: 7
    //
    // Hint: consider using either Arrays.asList or - my pref - List.of to make this
    // easier.
    // See https://www.geeksforgeeks.org/initialize-an-arraylist-in-java/

    Boardgame game = new Boardgame("Ticket to Ride", 8);
    Boardgame game1 = new Boardgame("The Awful Green Things from Outer Space", 7);

    ArrayList<Boardgame> boardgame = new ArrayList<>();
    boardgame.add(game);
    boardgame.add(game1);

    // TODO: provide proper arguments to the printf calls in order to display
    // messages to the
    // console as shown in the instructions
    System.out.printf("Here are the %d ints: %s%n", ints.length, Arrays.toString(ints));
    System.out.printf("Here are the %d doubles: %s%n", doubles.length, Arrays.toString(doubles));
    System.out.printf("Here are the %d strings: %s%n", strings.length, Arrays.toString(strings));
    System.out.printf("Here are the %d foods: %s%n", foods.length, Arrays.toString(foods));
    System.out.printf("Here are the %d games: %s%n", boardgame.size(), boardgame);
  }
}
