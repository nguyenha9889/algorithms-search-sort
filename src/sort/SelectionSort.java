package sort;

import java.util.Comparator;

public class SelectionSort {
   public static void selectionSort(int[] array) {
      for (int i = 0; i < array.length-1; i++) {
         int indexMin = i;
         int min = array[i];
         for (int j = i+1; j < array.length; j++) {
            if (min > array[j]) {
               min = array[j];
               indexMin = j;
            }
         }
         if (indexMin != i) {
            array[indexMin] = array[i];
            array[i] = min;
         }
      }
   }

   public static <T> void selectionSort(T[] array, Comparator<T> comparator) {
      for (int i = 0; i < array.length-1; i++) {
         int indexMin = i;
         T min = array[i];
         for (int j = i+1; j < array.length; j++) {
            if (comparator.compare(min, array[j]) > 0) {
               min = array[j];
               indexMin = j;
            }
         }
         if (indexMin != i) {
            array[indexMin] = array[i];
            array[i] = min;
         }
      }
   }
}
