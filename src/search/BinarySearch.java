package search;

import java.util.Comparator;
import java.util.Objects;

public class BinarySearch {
   public static <T> int indexWithoutRecursive(T[] array, T t, Comparator<T> comparator) {
      int start = 0;
      int end = array.length - 1;
      while (start <= end) {
         int mid = start + (end - start) / 2;
         if (Objects.equals(array[mid], t)) {
            return mid;
         }
         if (comparator.compare(array[mid], t) > 0) {
            end = mid - 1;
         } else {
            start = mid + 1;
         }
      }
      return -1;
   }

   public static <T> int indexWithRecursive(T[] array, T t, int start, int end, Comparator<T> comparator) {
      if (start < 0) {
         start = 0;
      }
      if (start <= end) {
         int mid = start + (end - start) / 2;
         if (Objects.equals(array[mid], t)) {
            return mid;
         }
         if (comparator.compare(array[mid], t) > 0) {
            return indexWithRecursive(array, t, start, mid-1, comparator);

         } else {
            return indexWithRecursive(array, t, mid+1, end, comparator);
         }
      }
      return -1;
   }
}
