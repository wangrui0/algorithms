package org.search;

/**
 * @author: wangrui
 * @date: 2021/4/19
 */
public class BinarySerach {

  public static void main(String[] args) {
    System.out.println(binarySearch_2(new int[]{1, 2, 3, 4, 4, 4, 5, 6, 7}, 4));
    System.out.println(binarySearch_2(new int[]{1, 2, 3, 3, 4, 4, 4, 4}, 4));
    System.out.println(binarySearch_2(new int[]{1, 1, 1, 1, 2, 3, 3, 4, 5, 6, 7}, 1));
  }

  //从有序中查找某个第一次出现的元素
  public static int binarySearch(int[] array, int target) {
    int left = 0, right = array.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  //从有序中查找某个最后一次出现的元素
  public static int binarySearch_2(int[] array, int target) {
    int left = 0, right = array.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (array[mid] <= target) {
        left = mid+1;
      } else {
        right = mid - 1;
      }
    }
    return left - 1;
  }
}