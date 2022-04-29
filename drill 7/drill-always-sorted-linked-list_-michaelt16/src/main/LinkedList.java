package main;

import java.util.ArrayList;

public class LinkedList<T> {

  private Node<T> head;
  private int size;

  public LinkedList() {
    head = null;
    size = 0;
  }

  public void prepend(T t) {
    size++;
    Node<T> newGuy = new Node<>(t);
    newGuy.next = head;
    head = newGuy;
  }

  public void append(T t) {

    Node<T> newGuy = new Node<>(t);

    if (isEmpty()) {
      head = newGuy;
    } else {
      Node<T> currNode = nodeAt(size - 1);
      currNode.next = newGuy;
    }

    size++;
  }

  public void add(int index, T t) {
    if (outOfInsertionBounds(index)) {
      throw new IndexOutOfBoundsException();
    } else if (index == 0) {
      prepend(t);
    } else if (index == size) {
      append(t);
    } else {
      addAt(index, t);
    }
  }

  private void addAt(int index, T t) {
    Node<T> newGuy = new Node<>(t);
    Node<T> currNode = nodeAt(index - 1);
    newGuy.next = currNode.next;
    currNode.next = newGuy;
    size++;
  }

  public T get(int index) {
    if (outOfAccessBounds(index)) {
      throw new IndexOutOfBoundsException();
    } else {
      return nodeAt(index).data;
    }
  }

  public int indexOf(T target) {
    // not implemented
    return -1;
  }

  public T remove(int index) {
    // TODO
    Node<T> currNode = nodeAt(index);
    if (isEmpty() || outOfAccessBounds(index)) {
      throw new IndexOutOfBoundsException();
    } else {
      if (currNode == head) {

        head = head.next;

      } else if (currNode.next == null) {
        Node<T> nodePrevious = nodeAt(index - 1);
        nodePrevious.next = null;
      } else {

        Node<T> nodePrevious = nodeAt(index - 1);
        Node<T> nodeNext = nodeAt(index + 1);

        nodePrevious.next = nodeNext;
      }

      size--;

      return currNode.data;
    }
  }

  public int size() {
    return size;
  }

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

  private Node<T> nodeAt(int index) {
    Node<T> currNode = head;

    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }
    return currNode;
  }

  private boolean outOfAccessBounds(int i) {
    return i < 0 || i >= size;
  }

  private boolean outOfInsertionBounds(int i) {
    return i < 0 || i > size;
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
