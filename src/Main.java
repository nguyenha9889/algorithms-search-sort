import bst.BinarySearchTree;

import java.util.TreeMap;

public class Main {

   static class Node {
      int value;
      Node left;
      Node right;

      public Node(int value) {
         this.value = value;
         left = right = null;
      }
   }

   public static Node root;

   public static void main(String[] args) {
      root = new Node(60);
      // node trái
      root.left = new Node(55);
      // node phải :
      root.right = new Node(100);
      root.left.left = new Node(45);
      root.left.right = new Node(57);
      root.left.left.left = new Node(24);
      root.left.left.right = new Node(46);
      root.left.right.left = new Node(56);
      root.left.right.right = new Node(58);
      bst.BinarySearchTree<Integer> tree = new BinarySearchTree<>(new Integer[]{20, 14, 30, 24, 18, 27, 46, 35, 44});
   }

   public static void inOrder(Node curr) { // trái current phải
      if (curr != null) {
         inOrder(curr.left);
         //Visit the node by Printing the node data
         System.out.printf("%d ", curr.value);
         inOrder(curr.right);
      }
   }

   public static void preorder(Node root) { // current trái phải
      if (root != null) {
         //Visit the node by Printing the node data
         System.out.printf("%d ", root.value);
         preorder(root.left);
         preorder(root.right);
      }
   }

   public static void postorder(Node root) { // trái, phải, current
      if (root != null) {
         //Visit the node by Printing the node data
         postorder(root.left);
         postorder(root.right);
         System.out.printf("%d ", root.value);
      }
   }
}