package org.search.基本有序;


/**
 * 二分查找
 *
 * @author: wangrui
 * @date: 2020/10/22
 */
public class BinarySearch {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 6, 7, 8, 9};
    int index = search(array, 0, array.length - 1, 100);
    int index2 = binarySearch(array, 0, array.length - 1, 100);
    System.out.println(index);
    System.out.println(index2);
  }

  /**
   * 循环方式
   *
   * @param array
   * @param left
   * @param right
   * @param target
   * @return
   */
  public static int search(int[] array, int left, int right, int target) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  /**
   * 递归方式
   *
   * @param array
   * @param left
   * @param right
   * @param target
   * @return
   */
  public static int binarySearch(int[] array, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (array[mid] == target) {
      return mid;
    } else if (array[mid] < target) {
      return binarySearch(array, mid + 1, right, target);
    } else {
      return binarySearch(array, left, mid - 1, target);
    }
  }
}
