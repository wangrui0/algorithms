package org.sort;

import java.util.Arrays;

/**
 * @author: wangrui
 * @date: 2020/9/29
 * <p>
 * 冒泡排序，从小到大排序；(大的数据先浮出来)
 * <p>
 * 掌握思想
 */
public class Ch0001BubbleSort {

  public static void main(String[] args) {
    int[] array = {1, 3, 2, 3, 5, 7, 1, 4, 6, 9, 10, 20, 13};
    int[] result = bubbleSort(array);
    System.out.println(Arrays.toString(result));
    //[1, 1, 2, 3, 3, 4, 5, 6, 7, 9, 10, 13, 20]
  }

  public static int[] bubbleSort(int[] array) {
    if (null == array || array.length == 0) {
      return array;
    }
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - 1 - i; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }
}
