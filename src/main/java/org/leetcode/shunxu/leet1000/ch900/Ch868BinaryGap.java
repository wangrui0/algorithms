package org.leetcode.shunxu.leet1000.ch900;

/**
 * <p>868. 二进制间距
 *
 * <p>给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 *
 * <p>如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 22
 * <p>输出：2
 * <p>解释：
 * <p>22 的二进制是 "10110" 。
 * <p>在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * <p>第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * <p>第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * <p>答案取两个距离之中最大的，也就是 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 5
 * <p>输出：2
 * <p>解释：
 * <p>5 的二进制是 "101" 。
 *
 * <p>示例 3：
 *
 * <p>输入：n = 6
 * <p>输出：1
 * <p>解释：
 * <p>6 的二进制是 "110" 。
 *
 * <p>示例 4：
 *
 * <p>输入：n = 8
 * <p>输出：0
 * <p>解释：
 * <p>8 的二进制是 "1000" 。
 * <p>在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 *
 * <p>示例 5：
 *
 * <p>输入：n = 1
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= N <= 10^9
 * <p> https://leetcode-cn.com/problems/binary-gap/
 * <p>通过次数14,046
 * <p>提交次数22,640
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch868BinaryGap {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(logN)。
   * <p>   空间复杂度：O(logN)，数组 A 所使用的空间。
   *
   * @param N
   * @return
   */
  public int binaryGap(int N) {
    int[] A = new int[32];
    int t = 0;
    for (int i = 0; i < 32; ++i) {
      if (((N >> i) & 1) != 0) {
        A[t++] = i;
      }
    }

    int ans = 0;
    for (int i = 0; i < t - 1; ++i) {
      ans = Math.max(ans, A[i + 1] - A[i]);
    }
    return ans;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(logN)。
   * <p>   空间复杂度：O(1)。
   *
   * @param N
   * @return
   */
  public int binaryGap2(int N) {
    int last = -1, ans = 0;
    for (int i = 0; i < 32; ++i) {
      if (((N >> i) & 1) > 0) {
        if (last >= 0) {
          ans = Math.max(ans, i - last);
        }
        last = i;
      }
    }

    return ans;
  }


}