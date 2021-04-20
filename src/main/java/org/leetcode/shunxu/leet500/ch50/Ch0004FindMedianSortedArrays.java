package org.leetcode.shunxu.leet500.ch50;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * <p>
 * 输出：2.00000
 * <p>
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * <p>
 * 输出：2.50000
 * <p>
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * <p>
 * 输出：0.00000
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * <p>
 * 输出：1.00000
 * <p>
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * <p>
 * 输出：2.00000
 * <p>
 * 提示： nums1.length == m
 * <p>
 * nums2.length == n
 * <p>
 * 0 <= m <= 1000
 * <p>
 * 0 <= n <= 1000
 * <p>
 * 1 <= m + n <= 2000
 * <p>
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/9/25
 */
public class Ch0004FindMedianSortedArrays {

  /**
   * toList ,toSet ,toMap,groupBy,joining
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] num1 = {1, 2, 3};
    int[] num2 = {2, 4, 8};
    //1 2 2 3 4 8
    double result = findMedianSortedArrays(num1, num2);
    System.out.println(result);
  }

  /**
   * 错了啊，错了。不会做这个
   * <p>
   * l1
   * <p>
   * 1,2,3,4,4,5,6            ------------->7
   * <p>
   * l2
   * <p>
   * 2,3,4,4,5,5,8,9          ------------->8
   * <p>
   * (7+8)/2=8
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int leftMid = -1;
    int rightMid = -1;
    if (nums1.length == 0) {
      if (nums2.length % 2 == 0) {
        leftMid = nums2.length / 2;
        rightMid = nums2.length / 2 + 1;
      } else {
        leftMid = nums2.length / 2 - 1;
        rightMid = leftMid;
      }
      return (Double.valueOf(nums2[leftMid] + nums2[rightMid])) / 2;
    }
    if (nums2.length == 0) {
      if (nums1.length % 2 == 0) {
        leftMid = nums1.length / 2 - 1;
        rightMid = nums1.length / 2;
      } else {
        leftMid = nums1.length / 2;
        rightMid = leftMid;
      }
      return (Double.valueOf(nums1[leftMid - 1] + nums1[rightMid - 1])) / 2;
    }
    int sum = nums1.length + nums2.length;
    if (sum % 2 == 0) {
      leftMid = sum / 2;
      rightMid = sum / 2 + 1;
    } else {
      leftMid = sum / 2 + 1;
      rightMid = leftMid;
    }
    int num1Index = 1;
    int num2Index = 1;
    int left = -1;
    int right = -1;
    while (num1Index <= nums1.length - 1 && num2Index <= nums2.length - 1 && num1Index + num2Index < leftMid) {
      if (nums1[num1Index - 1] < nums2[num2Index - 1]) {
        num1Index++;
      } else {
        num2Index++;
      }
    }
    if (num1Index + num2Index == leftMid) {
      left = nums1[num1Index - 1] < nums2[num2Index - 1] ? nums1[num1Index - 1] : nums2[num2Index - 1];
      right =
          nums1[num1Index - 1] < nums2[num2Index - 1] ? nums2[num2Index - 1] < nums1[num1Index] ? nums2[num2Index - 1]
              : nums1[num1Index] : nums1[num1Index - 1] < nums2[num2Index] ? nums1[num1Index - 1] : nums2[num2Index];
      return (Double.valueOf(left + right)) / 2;
    }

    while (num1Index <= nums1.length - 1 && num1Index + num2Index < leftMid) {
      if (num1Index + num2Index == leftMid) {
        left = nums1[num1Index - 1];
        right = nums1[num1Index];
      }
      num1Index++;
    }
    while (num2Index <= nums2.length - 1 && num1Index + num2Index < rightMid) {
      if (num1Index + num2Index == leftMid) {
        left = nums2[num2Index - 1];
        right = nums2[num2Index];
      }
      num2Index++;
    }
    return (Double.valueOf(left + right)) / 2;
  }

  /**
   *
   * 官方：
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
    return -1;
  }

}
