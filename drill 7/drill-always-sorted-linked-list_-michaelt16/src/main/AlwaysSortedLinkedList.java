package main;

import java.util.ArrayList;
import java.util.Iterator;

public class AlwaysSortedLinkedList<E extends Comparable<E>> implements SimpleList<E> {

  private static class Node<E> {

    private E data;
    private Node<E> next;

    public Node(E data) {
      this.data = data;
      this.next = null;
    }

    @Override
    public String toString() {
      return String.format("%s", data.toString());
    }
  }

  private Node<E> head;

  private int size;

  public AlwaysSortedLinkedList() {
    head = null;
    size = 0;
  }

  @Override
  public Iterator<E> iterator() { // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void add(E e) {
    Node<E> newNode = new Node<>(e);
    Node<E> currNode = head;

    if (isEmpty()) {
      head = newNode;
    } else {

      while (currNode != null) {

        if (currNode == head && e.compareTo(currNode.data) < 0) {

          newNode.next = currNode;
          head = newNode;
          size++;
          return;
        } else if (currNode != head && e.compareTo(currNode.data) < 0) {
          Node<E> prev = nodeAt(indexOf(currNode.data) - 1);
          prev.next = newNode;
          newNode.next = currNode;

          size++;
          return;
        } else if (currNode.next == null && e.compareTo(currNode.data) > 0) {
          addAt(indexOf(currNode.data), e);
        }
        currNode = currNode.next;
      }
    }

    size++;
  }

  @Override
  public String toString() {

    ArrayList<String> nodeContents = new ArrayList<>();

    Node<E> currNode = head;

    while (currNode != null) {
      nodeContents.add(currNode.toString());
      currNode = currNode.next;
    }

    String contents = String.join(" ", nodeContents);

    return String.format("%s", contents);
  }

  @Override
  public E remove(E target) {

    Node<E> currNode = nodeAt(indexOf(target));
    if (isEmpty() || outOfAccessBounds(indexOf(target))) {
      return null;
    } else {
      if (currNode == head) {

        head = head.next;

      } else if (currNode.next == null) {
        Node<E> nodePrevious = nodeAt(indexOf(target) - 1);
        nodePrevious.next = null;
      } else {

        Node<E> nodePrevious = nodeAt(indexOf(target) - 1);
        Node<E> nodeNext = nodeAt(indexOf(target) + 1);

        nodePrevious.next = nodeNext;
      }

      size--;

      return currNode.data;
    }
  }

  @Override
  public E get(int index) {

    if (outOfAccessBounds(index)) {
      throw new IndexOutOfBoundsException();
    } else {
      return nodeAt(index).data;
    }
  }

  @Override
  public int indexOf(E target) {
    Node<E> currNode = head;
    int index = 0;
    for (int i = index; i < size(); i++) {
      if (currNode.data.equals(target)) {
        index = i;
        return index;
      }
      currNode = currNode.next;
    }
    return -1;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {

    return head == null;
  }

  public void prepend(E t) {
    size++;
    Node<E> newGuy = new Node<>(t);
    newGuy.next = head;
    head = newGuy;
  }

  public void append(E t) {

    Node<E> newGuy = new Node<>(t);

    if (isEmpty()) {
      head = newGuy;
    } else {
      Node<E> currNode = nodeAt(size - 1);
      currNode.next = newGuy;
    }

    size++;
  }

  private void addAt(int index, E t) {
    Node<E> newGuy = new Node<>(t);
    Node<E> currNode = nodeAt(index);
    newGuy.next = currNode.next;
    currNode.next = newGuy;
  }

  private Node<E> nodeAt(int index) {
    Node<E> currNode = head;

    for (int i = 0; i < index; i++) {
      currNode = currNode.next;
    }
    return currNode;
  }

  private boolean outOfAccessBounds(int i) {
    return i < 0 || i >= size;
  }
}
