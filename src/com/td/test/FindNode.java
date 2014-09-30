package com.td.test;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/23/14
 * Time: 3:49 PM
 */
public class FindNode {


  public Node findClosestMatch(Node root, int valToFind) {
    Node result;


    if (root.getValue() < valToFind && root.getRight() != null) {

      return findClosestMatch(root.getRight(), valToFind);

    } else if (root.getLeft() != null) {
      return findClosestMatch(root.getLeft(), valToFind);

    }

    return root;
  }


}
