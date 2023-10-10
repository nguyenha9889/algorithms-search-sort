package sort;

import java.util.Comparator;

public class BubbleSort {
   public static void bubbleSort(int[] array) {
      boolean flag = true;
      for (int i = 0; i < array.length && flag; i++) {
         flag = false;
         for (int j = 0; j < array.length-1-i; j++) {
            if (array[j] > array[j+1]) {
               int temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
               flag = true;
            }
         }
      }
   }

   public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
      boolean flag = true;
      for (int i = 0; i < array.length && flag; i++) {
         flag = false;
         for (int j = 0; j < array.length-1-i; j++) {
            if (comparator.compare(array[j], array[j+1]) > 0) {
               T temp = array[j];
               array[j] = array[j+1];
               array[j+1] = temp;
               flag = true;
            }
         }
      }
   }
}
