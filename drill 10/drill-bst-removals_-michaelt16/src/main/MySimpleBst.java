package main;

import java.util.Iterator;
import java.util.Stack;

public class MySimpleBst<T extends Comparable<T>> implements SimpleBst<T> {

  /**
   * This is a private static class which represents a singular node that contains data, previous
   * and next.
   */
  private static class Node<T> {

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

  private long size;

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
    if (data.compareTo(focusedNode.data) < 0) {

      focusedNode.left = add(focusedNode.left, data);
    } else if (data.compareTo(focusedNode.data) > 0) {

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

  @Override
  public boolean isBalanced() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public Iterator<T> inOrderIterator() {
    return new BstIterator<T>(root);
  }

  @Override
  public void balance() {
    // TODO Auto-generated method stub

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

  private Node<T> findMax(Node<T> node) {
    // set base case
    if (node.right != null) {
      return findMax(node.right);
    }

    return node;
  }

  @Override
  public void remove(T toRemove) {
    if (toRemove == null) {
      throw new IllegalArgumentException("Removing a null element is not allowed.");
    } else if (root != null) {
      delete(root, toRemove);
    }
  }

  public Node<T> delete(Node<T> root, T val) {
    if (root == null) {
      return root;
    } else if (val.compareTo(root.data) < 0) {
      root.left = delete(root.left, val);

    } else if (val.compareTo(root.data) > 0) {
      root.right = delete(root.right, val);
    } else {

      // no child
      if (root.left == null && root.right == null) {
        this.root = null;
        size--;

        // one child
      } else if (root.left == null) {

        root = root.right;
        size--;
      } else if (root.right == null) {

        root = root.left;
        size--;

      } else { // two child
        T temp = min();

        root.data = temp;
        size--;
        root.right = delete(root.right, temp);
      }
    }
    return root;
  }

  // found online
  // public Node<T> delete(Node<T> node, T val) {
  /*  if (node == null) {

        return node;
      }

      if (val.compareTo(node.data) < 0) {

        node.left = delete(node.left, val);
      } else if (val.compareTo(node.data) > 0) {

        node.right = delete(node.right, val);
      } else {

        if (node.left == null || node.right == null) {
          Node<T> temp = node.left != null ? node.left : node.right;

          if (temp == null) {
            size--;
            return null;
          } else {
            size--;
            return temp;
          }
        } else {
          Node<T> successor = getSuccessor(node);
          node.data = successor.data;

          node.right = delete(node.right, successor.data);

          return node;
        }
      }

      return node;
    }

    public Node<T> getSuccessor(Node<T> node) {
      if (node == null) {
        return null;
      }

      Node<T> temp = node.right;

      while (temp.left != null) {
        temp = temp.left;
      }

      return temp;
    }
  */
  // wrong :C

  /* private Node<T> remove(T toRemove, Node<T> focusedNode) { // changed from void to node

    if (focusedNode != null) {

      if (toRemove.compareTo(focusedNode.data) == 0) {
        // if its the same as the data we're looking for
        // then check if its leaf
        // if has one child or if it has two

        if (isLeaf(focusedNode) == true) {
          // if its a leaf
          remove(toRemove, null);

          size--;
        } else if (hasOneRightChild(focusedNode) == true) {
          // if it has one right child, set that child to be the focusedNode
          focusedNode.data = focusedNode.right.data;
          focusedNode.right = null;
          size--;
        } else if (hasOneLeftChild(focusedNode) == true) {
          // if it has one left child, set that child to be the focusedNode
          focusedNode.data = focusedNode.left.data;
          focusedNode.left = null;
          size--;

        } else if (hasTwoChild(focusedNode) == true) {
          // if it has two child
          focusedNode.data = min();
          // i don't know how to chain the rest of em
          size--;
        }
      } else {
        // if its not the same as what we're asking just skip it
        // then compare it
        // if its less, than root traverse left
        // if its more, than root traverse right
        // by doing it this way, we split the right side and the left side of the tree
        if (toRemove.compareTo(focusedNode.data) < 0) {
          // left side only
          // now we gotta check left side and the right side
          // recursion here
          remove(toRemove, focusedNode.left);

        } else if (toRemove.compareTo(focusedNode.data) > 0) {
          // right side only. It wouldn't be equal, its already filtered

          remove(toRemove, focusedNode.right);
        }
      }
    }
    return focusedNode;
  }*/

  /*private boolean isLeaf(Node<T> focusedNode) {

    return focusedNode.right == null && focusedNode.left == null;
  }

  private boolean hasOneRightChild(Node<T> focusedNode) {
    return focusedNode.right != null && focusedNode.left == null;
  }

  private boolean hasOneLeftChild(Node<T> focusedNode) {
    return focusedNode.right == null && focusedNode.left != null;
  }

  private boolean hasTwoChild(Node<T> focusedNode) {
    return focusedNode.right != null && focusedNode.left != null;
  }*/

}
