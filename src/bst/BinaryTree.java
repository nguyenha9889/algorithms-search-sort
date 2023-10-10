package bst;

public interface BinaryTree<E> {
   int getSize();
   boolean isEmpty();
   boolean search(E e);
   boolean insert(E e);
   boolean delete(E e);
   void inOrder();
   void preOrder();
   void postOrder();
   void clear();

}
