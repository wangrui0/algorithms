package org.leetcode.leet500.ch100;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 说明：
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * <p>
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。  <p> 示例：
 * <p>
 * 输入：
 * <p>
 * nums1 = [1,2,3,0,0,0], m = 3
 * <p>
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出：[1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/12
 */
public class Ch0088Merge {

  public static void main(String[] args) {
//    int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
//        int[] num2 = new int[]{2, 5, 6};
//    int[] num1 = new int[]{1, 2, 3, 5, 6, 0};
//    int[] num2 = new int[]{2};
    int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
    int[] num2 = new int[]{2, 5, 6};
    merge6(num1, 3, num2, 3);
    System.out.println(Arrays.toString(num1));
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {

    int i = 0, j = 0;
    for (; i < m && j < n; ) {
      if (nums1[i] <= nums2[j]) {
        i++;
      } else {
        for (int k = m; k >= i && k - 1 >= 0; k--) {
          nums1[k] = nums1[k - 1];
        }
        nums1[i] = nums2[j];
        j++;
        m++;
      }
    }
    if (j < n) {
      for (int k = j; k < n; ) {
        nums1[i++] = nums2[k++];
      }
    }
  }

  /**
   * <p>
   * 方法一 : 合并后排序
   * <p>
   * 直觉
   * <p>
   * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为
   * <p>
   * O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度 : O((n+m)log(n+m))。
   * <p>
   * 空间复杂度 : O(1)。
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }

  /**
   * 方法二 : 双指针 / 从前往后
   * <p>
   * 直觉
   * <p>
   * 一般而言，对于有序数组可以通过 双指针法 达到O(n+m)的时间复杂度。
   * <p>
   * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
   * <p>
   * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m) 的空间复杂度。
   * <p>
   * ==============================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度 : O(n+m)。
   * <p>
   * 空间复杂度 : O(m)。
   */
  public void merge3(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);

    int p1 = 0;
    int p2 = 0;
    int p = 0;

    while ((p1 < m) && (p2 < n)) {
      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
    }

    if (p1 < m) {
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    }
    if (p2 < n) {
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

  }

  /**
   * 方法三 : 双指针 / 从后往前
   * <p>
   * 直觉
   * <p>
   * 方法二已经取得了最优的时间复杂度O(n+m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
   * <p>
   * 如果我们从结尾开始改写 nums1 的值又会如何呢？这里没有信息，因此不需要额外空间。
   * <p>
   * 这里的指针 p 用于追踪添加元素的位置。
   * <p>
   * ====================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度 : O(n+m)。
   * <p>
   * 空间复杂度 : O(1)。
   */
  public void merge4(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;
    int p2 = n - 1;
    int p = m + n - 1;

    while ((p1 >= 0) && (p2 >= 0)) {
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
    }
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

  }

  public void merge5(int[] nums1, int m, int[] nums2, int n) {
    int[] nums1Copy = new int[m];
    System.arraycopy(nums1, 0, nums1Copy, 0, m);
    int p1 = 0;
    int p2 = 0;
    int p = 0;

    while (p1 < m && p2 < n) {
      nums1[p++] = nums1Copy[p1] > nums2[p2] ? nums2[p2++] : nums1Copy[p1++];
    }
    if (p1 < m) {
      System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    }
    if (p2 < n) {
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
  }

  public static void merge6(int[] nums1, int m, int[] nums2, int n) {

    int p1 = m - 1;
    int p2 = n - 1;
    int p = m + n - 1;

    while (p1 >= 0 && p2 >= 0) {
      nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
    }
    System.arraycopy(nums2, 0, nums1, 0, n - (n - p2 - 1));
  }

}
