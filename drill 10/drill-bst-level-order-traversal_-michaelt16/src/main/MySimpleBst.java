package main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MySimpleBst<T extends Comparable<T>> implements SimpleBst<T> {

  /**
   * This is a private static class which represents a singular node that contains data, previous
   * and next.
   */
  public static class Node<T> {

    private T data;
    private Node<T> right;
    private Node<T> left;

    /**
     * this constructor initialized the values of our node which contains next, previous, data.
     *
     * @param T data
     */
    public Node(T data) {
      this.data = data;
      right = null;
      left = null;
    }
  }

  private class BstIterator<T> implements Iterator<T> {
    private Stack<Node<T>> stack;

    private BstIterator(Node<T> root) {
      this.stack = new Stack<>();
      addLeft(root);
    }

    private void addLeft(Node<T> node) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }

    @Override
    public boolean hasNext() {

      return stack.size() > 0;
    }

    @Override
    public T next() {
      Node<T> top = stack.pop();
      if (top.right != null) {
        addLeft(top.right);
      }
      return top.data;
    }
  }

  private Node<T> root;
  private Comparator<T> comparator = Comparator.naturalOrder();
  private long size;
  private List<Node<T>> list = new ArrayList<>();

  public MySimpleBst(Comparator<T> comparator) {

    this.comparator = comparator;
    if (comparator == null) {
      throw new IllegalArgumentException("A null comparator is not allowed.");
    }
  }

  public MySimpleBst() {
    root = null;
  }

  @Override
  public void add(T data) {

    if (data == null) {
      throw new IllegalArgumentException("Adding a null item is not allowed.");
    } else {
      // if our data is the same as a data we already have, don't do anything. Don't increase the
      // size, don't add  it in

      root = add(root, data);
    }
  }
  // i wanna make a wrapper that adds and everytime i call the method again, the root will be set to
  // a different root

  private Node<T> add(Node<T> focusedNode, T data) {

    // base case because for example, if we recursion and loop.right is the new root for example
    // and it has nothing in it, that will be the new node

    if (focusedNode == null) {
      size++;
      focusedNode = new Node<>(data);
    }
    if (comparator.compare(data, focusedNode.data) < 0) {

      focusedNode.left = add(focusedNode.left, data);
    } else if (comparator.compare(data, focusedNode.data) > 0) {

      focusedNode.right = add(focusedNode.right, data);
    }

    return focusedNode;
  }

  @Override
  public int depth() {

    return maxDepth(root);
  }

  private int maxDepth(Node<T> focusedNode) {

    if (focusedNode == null) {
      return -1;
    } else {
      int left = maxDepth(focusedNode.left);
      int right = maxDepth(focusedNode.right);
      if (left > right) {
        return left + 1;
      } else {
        return right + 1;
      }
    }
  }

  @Override
  public long size() {

    return size;
  }

  @Override
  public T get(T target) {
    if (target == null) {
      throw new IllegalArgumentException("Lookup on a null key is not allowed.");
    } else if (root == null) {
      return null;
    }

    return get(root, target);
  }

  // i wanna make a wrapper that gets the node of the target

  private T get(Node<T> focusedNode, T target) {
    if (focusedNode == null) {
      return null;
    }

    if (focusedNode.data == target) {
      return focusedNode.data;
    } else if (target.compareTo(focusedNode.data) < 0) {

      return get(focusedNode.left, target);
    } else if (target.compareTo(focusedNode.data) > 0) {
      return get(focusedNode.right, target);
    } else {
      return focusedNode.data;
    }
  }
  // from the https://www.youtube.com/watch?v=LU4fGD-fgJQ
  // if the absolute value of left - right subtree's height is <= 1 its balanced
  // |left subtree height - right subtree height| <= 1
  // if its null its balanced
  // if theres only one thing its balanced

  @Override
  public boolean isBalanced() {

    return isBalanced(root);
  }

  private boolean isBalanced(Node<T> focusedNode) {
    // base case
    if (focusedNode == null) {
      return true;
      // absolute value using Math.abs
      // the tree is not balanced if its greater than 1
      // base case
    } else if (Math.abs(maxDepth(focusedNode.left) - maxDepth(focusedNode.right)) > 1) {
      return false;
    } else if (Math.abs(maxDepth(focusedNode.left) - maxDepth(focusedNode.right)) <= 1) {

      return isBalanced(focusedNode.left) && isBalanced(focusedNode.right);
    }
    return true;
  }

  @Override
  public Iterator<T> inOrderIterator() {

    return new BstIterator<T>(root);
  }
  // https://leetcode.com/problems/balance-a-binary-search-tree/discuss/1124362/Java-oror-In-Order-traversal-oror-quite-fast

  @Override
  public void balance() {
    balanceBst(root);
  }

  public Node<T> balanceBst(Node<T> focusedNode) {
    if (focusedNode == null) {
      return null;
    }
    inOrder(root);
    return formTree(0, list.size() - 1);
  }

  public void inOrder(Node<T> focusedNode) {

    if (focusedNode == null) {
      return;
    } else {
      inOrder(focusedNode.left);
      list.add(focusedNode);
      inOrder(focusedNode.right);
    }
  }
  // recursive form BST

  public Node<T> formTree(int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    Node<T> root = list.get(mid);
    root.left = formTree(start, mid - 1);
    root.right = formTree(mid + 1, end);
    return root;
  }

  @Override
  public T min() {
    if (root == null) {
      return null;
    }

    return findMin(root).data;
  }

  @Override
  public T max() {
    if (root == null) {
      return null;
    }
    return findMax(root).data;
  }

  // i can either do a loop or recursion

  private Node<T> findMin(Node<T> node) {
    // set base case
    if (node.left != null) {
      return findMin(node.left);
    }

    return node;
  }
  // while loop version
  /*private Node<T> findMin(Node<T> node) {
    // set base case
   while (node.left != null){
   node = node.left;
   }
   return node;

  }*/

  private Node<T> findMax(Node<T> node) {
    // set base case
    if (node.right != null) {
      return findMax(node.right);
    }

    return node;
  }

  private class LevelIterator<T> implements Iterator<T> {
    private Queue<Node<T>> queue;

    private LevelIterator(Node<T> root) {
      this.queue = new LinkedList<>();
      queue.add(root);
    }

    @Override
    public boolean hasNext() {

      return root != null;
    }

    @Override
    public T next() {
      Node<T> node = queue.remove();

      if (node.left != null) {
        queue.add(node.left);
      }

      if (node.right != null) {
        queue.add(node.right);
      }
      return node.data;
    }
  }

  @Override
  public Iterator<T> levelOrderIterator() { // TODO Auto-generated method stub
    return new LevelIterator(root);
  }

  @Override
  public void remove(T t) { // TODO Auto-generated method stub
  }
}
