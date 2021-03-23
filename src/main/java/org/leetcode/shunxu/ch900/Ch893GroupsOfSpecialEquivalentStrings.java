package org.leetcode.shunxu.ch900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>893. 特殊等价字符串组
 *
 * <p>你将得到一个字符串数组 A。
 *
 * <p>每次移动都可以交换 S 的任意两个偶数下标的字符或任意两个奇数下标的字符。
 *
 * <p>如果经过任意次数的移动，S == T，那么两个字符串 S 和 T 是 特殊等价 的。
 *
 * <p>例如，S = "zzxy" 和 T = "xyzz" 是一对特殊等价字符串，因为可以先交换 S[0] 和 S[2]，然后交换 S[1] 和 S[3]，使得 "zzxy" -> "xzzy" -> "xyzz" 。
 *
 * <p>现在规定，A 的 一组特殊等价字符串 就是 A 的一个同时满足下述条件的非空子集：
 *
 * <p>    该组中的每一对字符串都是 特殊等价 的
 * <p>    该组字符串已经涵盖了该类别中的所有特殊等价字符串，容量达到理论上的最大值（也就是说，如果一个字符串不在该组中，那么这个字符串就 不会 与该组内任何字符串特殊等价）
 *
 * <p>返回 A 中特殊等价字符串组的数量。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
 * <p>输出：3
 * <p>解释：
 * <p>其中一组为 ["abcd", "cdab", "cbad"]，因为它们是成对的特殊等价字符串，且没有其他字符串与这些字符串特殊等价。
 * <p>另外两组分别是 ["xyzz", "zzxy"] 和 ["zzyx"]。特别需要注意的是，"zzxy" 不与 "zzyx" 特殊等价。
 *
 * <p>示例 2：
 *
 * <p>输入：["abc","acb","bac","bca","cab","cba"]
 * <p>输出：3
 * <p>解释：3 组 ["abc","cba"]，["acb","bca"]，["bac","cab"]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 1000
 * <p>    1 <= A[i].length <= 20
 * <p>    所有 A[i] 都具有相同的长度。
 * <p>    所有 A[i] 都只由小写字母组成。
 *
 * <p>通过次数9,282
 * <p>提交次数12,922
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/groups-of-special-equivalent-strings/
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch893GroupsOfSpecialEquivalentStrings {

  public static void main(String[] args) {
    System.out.println(numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}));
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(i∑​(Ai​).length)。
   *
   * <p>  空间复杂度：O(N)，其中 N 是 A 的长度。
   * <p>用一个52位的数组表示奇数的26个字母，和偶数的26个字母，统计每个单词的奇数字母情况和偶数情况加入set
   *
   * @param A
   * @return
   */
  public static int numSpecialEquivGroups(String[] A) {
    Set<String> seen = new HashSet();
    for (String S : A) {
      int[] count = new int[52];
      for (int i = 0; i < S.length(); ++i) {
        count[S.charAt(i) - 'a' + 26 * (i % 2)]++;
      }
      seen.add(Arrays.toString(count));
    }
    return seen.size();
  }
}
