package org.niuke;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素,并返回移除后数组的新长度
 */
public class RemoveYuanSu {

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 6, 2};
    int remove = remove(a, 2);
    System.out.println(remove);
    for (int i = 0; i < remove; i++) {
      System.err.print(a[i]);
    }


  }

  public static int remove(int[] a, int target) {
    int length = a.length;

    for (int i = 0; i < length; i++) {
      if (target == a[i]) {
        for (int j = i; j < length - 1; j++) {
          a[j] = a[j + 1];
        }
        length--;

      }
    }
    return length;
  }

  /**
   * {5,1, 2, 3, 6, 2,2,3,4,5,6,2}
   *
   * @param a
   * @param target
   * @return
   */
  public static int remove2(int[] a, int target) {
    int length = a.length;
    for (int i = 0; i < length; i++) {
      if (target == a[i]) {
        for (int j = i; j < length - 1; j++) {
          a[j] = a[j + 1];
        }
        length--;

      }
    }
    return length;
  }
}