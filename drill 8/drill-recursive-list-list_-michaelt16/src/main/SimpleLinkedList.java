package main;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedList<T> implements SimpleList<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;
  private List<T> ret = new ArrayList<>();

  public SimpleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public SimpleLinkedList(List<T> startingElem) {
    this();
    appendAll(startingElem);
  }

  // private 'cause my Nodes are my own bidness
  private SimpleLinkedList(Node<T> head, Node<T> tail, int size) {
    this.head = head;
    this.tail = tail;
    this.size = size;
  }

  @Override
  public T first() {
    return isEmpty() ? null : head.data;
  }

  @Override
  public SimpleLinkedList<T> rest() {
    return isEmpty() ? null : new SimpleLinkedList<>(head.next, tail, size - 1);
  }

  @Override
  public void append(T t) {

    Node<T> newGuy = new Node<>(t);

    if (isEmpty()) {
      head = newGuy;

    } else {
      tail.next = newGuy;
    }
    tail = newGuy;

    size++;
  }

  /**
   * Adds all items in the given List to the end of this SLL.
   *
   * <p>Good Lord, yes - it should not be recursive, but that dang loop-sniffing unit test will
   * brook no insolence!
   *
   * @param things the things to add to the end of this list
   */
  public void appendAll(List<T> things) {
    if (things.isEmpty()) {
      return;
    } else if (things.size() == 1) {
      append(things.get(0));
    } else {
      List<T> smallerList = new ArrayList<>(things);
      append(smallerList.remove(0));
      appendAll(smallerList);
    }
  }

  /**
   * Returns a List of the elements in this SLL from the start to the end.
   *
   * @return a List of the elements in this SLL from the start to the end
   */
  @Override
  public List<T> elementsForward() {
    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method
    return elementsForward(head);
  }

  private List<T> elementsForward(Node<T> node) {
    Node<T> currNode = node;

    if (currNode == null) {
      return ret;
    } else {

      ret.add(currNode.data);

      elementsForward(currNode.next);
    }
    return ret;
  }

  /**
   * Returns a List of the elements in this SLL from the end to the start.
   *
   * @return a List of the elements in this SLL from the end to the start
   */
  @Override
  public List<T> elementsBackward() {
    // TODO: complete this recursive wrapper method; it should be paired with a private
    // recursive method
    return elementsBackward(head);
  }

  private List<T> elementsBackward(Node<T> node) {
    Node<T> currNode = node;

    if (currNode == null) {
      return ret;
    } else {

      elementsBackward(currNode.next);
      ret.add(currNode.data);
    }

    return ret;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  private static class Node<T> {

    private T data;
    private Node<T> next;

    public Node(T data) {
      this.data = data;
      this.next = null;
    }

    @Override
    public String toString() {
      return String.format("%s", data.toString());
    }
  }
}
