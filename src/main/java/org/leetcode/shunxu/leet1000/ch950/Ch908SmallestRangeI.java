package org.leetcode.shunxu.leet1000.ch950;

/**
 * <p>908. 最小差值 I
 *
 * <p>给你一个整数数组 A，请你给数组中的每个元素 A[i] 都加上一个任意数字 x （-K <= x <= K），从而得到一个新数组 B 。
 *
 * <p>返回数组 B 的最大值和最小值之间可能存在的最小差值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：A = [1], K = 0
 * <p>输出：0
 * <p>解释：B = [1]
 *
 * <p>示例 2：
 *
 * <p>输入：A = [0,10], K = 2
 * <p>输出：6
 * <p>解释：B = [2,8]
 *
 * <p>示例 3：
 *
 * <p>输入：A = [1,3,6], K = 3
 * <p>输出：0
 * <p>解释：B = [3,3,3] 或 B = [4,4,4]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 10000
 * <p>    0 <= A[i] <= 10000
 * <p>    0 <= K <= 10000
 *
 * <p>通过次数17,384
 * <p>提交次数25,040
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/smallest-range-i/
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch908SmallestRangeI {

  public static void main(String[] args) {
    System.out.println(smallestRangeI(new int[]{0, 10}, 2));
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是 A 的长度。
   * <p>    空间复杂度：O(1)
   *
   * @param A
   * @param K
   * @return
   */
  public static int smallestRangeI(int[] A, int K) {
    int min = A[0];
    int max = A[0];
    for (int x : A) {
      min = Math.min(min, x);
      max = Math.max(max, x);
    }
    return Math.max(0, max - min - 2 * K);

  }
}
