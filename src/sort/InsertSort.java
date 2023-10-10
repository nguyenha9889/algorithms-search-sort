package sort;

import java.util.Comparator;

public class InsertSort {
   public static void insertSort(int[] array) {
      for (int i = 1; i < array.length; i++) {
         int insert = array[i];
         int j;
         for (j = i-1; j >= 0 && array[j] > insert; j--) {
            array[j+1] = array[j];
         }
         array[j+1] = insert;
      }
   }

   public static <T> void insertSort(T[] array , Comparator<T> comparator) {
      for (int i = 1; i < array.length; i++) {
         T insert = array[i];
         int j;
         for (j = i-1; j >= 0 && comparator.compare(array[j], insert) > 0; j--) {
            array[j+1] = array[j];
         }
         array[j+1] = insert;
      }
   }
}
