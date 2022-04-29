package main;

import java.util.ArrayList;
import java.util.List;

public class SimpleLinkedList<T> implements SimpleList<T> {

  private Node<T> head;
  private Node<T> tail;
  private int size;

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

  public void appendAll(List<T> coll) {
    for (T t : coll) {
      append(t);
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public String toString() {

    ArrayList<String> nodeContents = new ArrayList<>();

    Node<T> currNode = head;

    while (currNode != null) {
      nodeContents.add(currNode.toString());
      currNode = currNode.next;
    }

    String contents = String.join(",", nodeContents);

    return String.format("[%s] size:%d", contents, size);
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
