package org.leetcode;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3] nums2 = [2]
 * <p>
 * 则中位数是 2.0 示例 2:
 * <p>
 * nums1 = [1, 2] nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/9/25
 */
public class Ch0004FindMedianSortedArrays {

  public static void main(String[] args) {
    int[] num1 = {};
    int[] num2 = {};
    double result = findMedianSortedArrays(num1, num2);
    System.out.println(result);
  }

  /**
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

    return 1.0;
  }
}
