package org.leetcode.shunxu.ch850;

/**
 * <p>821. 字符的最短距离
 *
 * <p>给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 *
 * <p>返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 *
 * <p>两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "loveleetcode", c = "e"
 * <p>输出：[3,2,1,0,1,0,0,1,2,2,1,0]
 * <p>解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 * <p>距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
 * <p>距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 3 。
 * <p>对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
 * <p>距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "aaab", c = "b"
 * <p>输出：[3,2,1,0]
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 104
 * <p>    s[i] 和 c 均为小写英文字母
 * <p>    题目数据保证 c 在 s 中至少出现一次
 * <p>  https://leetcode-cn.com/problems/shortest-distance-to-a-character/
 * <p>通过次数19,763
 * <p>提交次数28,735
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/29
 */
public class Ch821ShortestDistanceToACharacter {

  public int[] shortestToChar(String s, char c) {
    int length = s.length();
    int[] ans = new int[length];
    int right = Integer.MAX_VALUE / 2;
    for (int i = length - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        right = i;
      }
      ans[i] = right - i;
    }
    int left = Integer.MIN_VALUE / 2;
    for (int i = 0; i < length; i++) {
      if (s.charAt(i) == c) {
        left = i;
      }
      ans[i] = Math.min(i - left, ans[i]);
    }

    return ans;
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(N)，其中 N 是 S 的长度，我们需要遍历字符串两次。
   *     空间复杂度：O(N)，ans 数组的大小。
   *
   * @param S
   * @param C
   * @return
   */
  public int[] shortestToChar_1(String S, char C) {
    int N = S.length();
    int[] ans = new int[N];
    int prev = Integer.MIN_VALUE / 2;

    for (int i = 0; i < N; ++i) {
      if (S.charAt(i) == C) {
        prev = i;
      }
      ans[i] = i - prev;
    }

    prev = Integer.MAX_VALUE / 2;
    for (int i = N - 1; i >= 0; --i) {
      if (S.charAt(i) == C) {
        prev = i;
      }
      ans[i] = Math.min(ans[i], prev - i);
    }

    return ans;
  }
}


