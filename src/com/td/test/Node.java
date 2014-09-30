package com.td.test;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/23/14
 * Time: 3:49 PM
 */
public class Node {

  private int value;

  private Node left;
  private Node right;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
