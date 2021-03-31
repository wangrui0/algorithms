package org.leetcode.shunxu.ch900;

/**
 * <p> 852. 山脉数组的峰顶索引
 * <p> 符合下列属性的数组 arr 称为 山脉数组 ：
 *
 * <p>     arr.length >= 3
 * <p>     存在 i（0 < i < arr.length - 1）使得：
 * <p>         arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * <p>         arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * <p> 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标
 * i 。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：arr = [0,1,0]
 * <p> 输出：1
 *
 * <p> 示例 2：
 *
 * <p> 输入：arr = [0,2,1,0]
 * <p> 输出：1
 *
 * <p> 示例 3：
 *
 * <p> 输入：arr = [0,10,5,2]
 * <p> 输出：1
 *
 * <p> 示例 4：
 *
 * <p> 输入：arr = [3,4,5,1]
 * <p> 输出：2
 *
 * <p> 示例 5：
 *
 * <p> 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * <p> 输出：2
 *
 *
 *
 * <p> 提示：
 *
 * <p>     3 <= arr.length <= 104
 * <p>     0 <= arr[i] <= 106
 * <p>     题目数据保证 arr 是一个山脉数组
 * <p>
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * <p> 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 * <p> 通过次数38,683
 * <p> 提交次数55,049
 * <p> 在真实的面试中遇到过这道题？
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch852PeakIndexInAMountainArray {

  public int peakIndexInMountainArray(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是 A 的长度。
   *
   * <p> 空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public int peakIndexInMountainArray_1(int[] A) {
    int i = 0;
    while (A[i] < A[i + 1]) {
      i++;
    }
    return i;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：O(logN)，其中 N 是 A 的长度。
   *
   * <p>  空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public int peakIndexInMountainArray_2(int[] A) {
    int lo = 0, hi = A.length - 1;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (A[mi] < A[mi + 1]) {
        lo = mi + 1;
      } else {
        hi = mi;
      }
    }
    return lo;
  }
}
