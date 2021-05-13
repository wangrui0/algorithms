package org.company.meituan.all.leet25;

import java.util.Arrays;

/**
 * <p>88. 合并两个有序数组
 *
 * <p>给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * <p>初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * <p>输出：[1,2,2,3,5,6]
 *
 * <p>示例 2：
 *
 * <p>输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * <p>输出：[1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    nums1.length == m + n
 * <p>    nums2.length == n
 * <p>    0 <= m, n <= 200
 * <p>    1 <= m + n <= 200
 * <p>    -109 <= nums1[i], nums2[i] <= 109
 *
 * <p>通过次数353,386
 * <p>提交次数694,581
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/merge-sorted-array/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch004_88MergeSortedArray合并两个有序数组 {

  public static void main(String[] args) {
    merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int length = nums1.length - 1;
    int indexM = m - 1;
    int indexN = n - 1;
    while (indexM >= 0 && indexN >= 0) {
      int numM = nums1[indexM];
      int numN = nums2[indexN];
      if (numM > numN) {
        nums1[length--] = numM;
        indexM--;
      } else {
        nums1[length--] = numN;
        indexN--;
      }
    }
    while (indexN >= 0) {
      nums1[length--] = nums2[indexN--];
    }
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O((m+n)log⁡(m+n))O((m+n)\log(m+n))O((m+n)log(m+n))。
   * <p>   排序序列长度为 m+nm+nm+n，套用快速排序的时间复杂度即可，平均情况为 O((m+n)log⁡(m+n))O((m+n)\log(m+n))O((m+n)log(m+n))。
   *
   * <p>  空间复杂度：O(log⁡(m+n))O(\log(m+n))O(log(m+n))。
   * <p>  排序序列长度为 m+nm+nm+n，套用快速排序的空间复杂度即可，平均情况为 O(log⁡(m+n))O(\log(m+n))O(log(m+n))
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge_2(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i != n; ++i) {
      nums1[m + i] = nums2[i];
    }
    Arrays.sort(nums1);
  }

  /**
   * 方法二：双指针
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(m+n)O(m+n)O(m+n)。
   * <p>    指针移动单调递增，最多移动 m+nm+nm+n 次，因此时间复杂度为 O(m+n)O(m+n)O(m+n)。
   *
   * <p>    空间复杂度：O(m+n)O(m+n)O(m+n)。
   * <p>    需要建立长度为 m+nm+nm+n 的中间数组 sorted\textit{sorted}sorted。
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge_3(int[] nums1, int m, int[] nums2, int n) {
    int p1 = 0, p2 = 0;
    int[] sorted = new int[m + n];
    int cur;
    while (p1 < m || p2 < n) {
      if (p1 == m) {
        cur = nums2[p2++];
      } else if (p2 == n) {
        cur = nums1[p1++];
      } else if (nums1[p1] < nums2[p2]) {
        cur = nums1[p1++];
      } else {
        cur = nums2[p2++];
      }
      sorted[p1 + p2 - 1] = cur;
    }
    for (int i = 0; i != m + n; ++i) {
      nums1[i] = sorted[i];
    }
  }

  /**
   * <p> 方法三：逆向双指针
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(m+n)O(m+n)O(m+n)。
   * <p>  指针移动单调递减，最多移动 m+nm+nm+n 次，因此时间复杂度为 O(m+n)O(m+n)O(m+n)。
   *
   * <p>  空间复杂度：O(1)O(1)O(1)。
   * <p>  直接对数组 nums1\textit{nums}_1nums1​ 原地修改，不需要额外空间。
   *
   * @param nums1
   * @param m
   * @param nums2
   * @param n
   */
  public void merge_4(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1, p2 = n - 1;
    int tail = m + n - 1;
    int cur;
    while (p1 >= 0 || p2 >= 0) {
      if (p1 == -1) {
        cur = nums2[p2--];
      } else if (p2 == -1) {
        cur = nums1[p1--];
      } else if (nums1[p1] > nums2[p2]) {
        cur = nums1[p1--];
      } else {
        cur = nums2[p2--];
      }
      nums1[tail--] = cur;
    }
  }


}
