package bst;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E>{

   private TreeNode<E> root;

   public TreeNode<E> getRoot() {
      return root;
   }

   private int size;
   public BinarySearchTree() {}
   public BinarySearchTree(E[] objects) {
      for (int i = 0; i < objects.length; i++) {
         insert(objects[i]);
      }
   }
   @Override
   public int getSize() {
      return size;
   }

   @Override
   public boolean isEmpty() {
      return size==0;
   }

   @Override
   public boolean search(E e) {
      TreeNode<E> current = root;
      while (current != null) {
         if (current.element.compareTo(e) == 0) {
            return true;
         }
         if (current.element.compareTo(e) > 0) {
            current = current.left;
         } else current = current.right;
      }
      return false;
   }

   @Override
   public boolean insert(E e) {
      if (size == 0) {
         root = new TreeNode<>(e);
      } else {
         TreeNode<E> parent = null;
         TreeNode<E> current = root;
         boolean check = true;
         while (current != null) {
            if (current.element.compareTo(e) == 0) {
               return false;
            }
            if (current.element.compareTo(e) > 0) {
               parent = current;
               current = current.left;
               check = false;
            } else {
               parent = current;
               current = current.right;
               check = true;
            }
         }
         if (check) {
            assert parent != null;
            parent.right = new TreeNode<>(e);
         } else {
            parent.left = new TreeNode<>(e);
         }
      }
      size++;
      return true;
   }

   @Override
   public boolean delete(E e) {
      if (search(e)) {
         root = deleteWithRecursive(root, e);
         return true;
      }
      return false;
   }

   TreeNode<E> deleteWithRecursive(TreeNode<E> root, E key) {
      if (root == null) return null;

      //traverse the tree
      if (key.compareTo(root.element) < 0) {
         root.left = deleteWithRecursive(root.left, key);
      }
      //traverse right subtree
      else if(key.compareTo(root.element) > 0) {
         root.right = deleteWithRecursive(root.right, key);
      }
      //Đây là node cần xóa , node contains only one child
      else {
         if (root.left == null) {
            return root.right;
         } else if(root.right == null) {
            return root.left;
         }
         //node có 2 children
         //get inorder successor (min value in the right subtree)
         root.element = maxValue(root.left);

         // Delete the inorder successor
         root.left = deleteWithRecursive(root.left, root.element);
      }
      return root;
   }

   E maxValue(TreeNode<E> root) {
      E maxValue = root.element;
      while (root.right != null) {
         maxValue = root.right.element;
         root = root.right;
      }
      return maxValue;
   }
   @Override
   public void inOrder() {
      inOrderRec(root);
   }

   void inOrderRec(TreeNode<E> root) {
      if (root != null) {
         inOrderRec(root.left);
         System.out.println(root.element + " ");
         inOrderRec(root.right);
      }
   }

   @Override
   public void preOrder() {

   }

   @Override
   public void postOrder() {

   }

   @Override
   public void clear() {
      root = null;
      size = 0;
   }

   public TreeNode<E> findTreeNodeByElement(E e) {
      TreeNode<E> current = root;
      while (current != null) {
         if (current.element.compareTo(e) == 0) {
            return current;
         }
         if (current.element.compareTo(e) > 0) {
            current = current.left;
         } else current = current.right;
      }
      return null;
   }

}
