package org.leetcode.leet2000.ch1800;

/**
 * <p>1758. 生成交替二进制字符串的最少操作数
 *
 * <p>给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 *
 * <p>交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 *
 * <p>返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "0100"
 * <p>输出：1
 * <p>解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "10"
 * <p>输出：0
 * <p>解释：s 已经是交替字符串。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "1111"
 * <p>输出：2
 * <p>解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 104
 * <p>    s[i] 是 '0' 或 '1'
 *
 * <p>通过次数5,216
 * <p>提交次数8,397
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:05 下午
 */
public class Ch1758MinimumChangesToMakeAlternatingBinaryString {


  /**
   * <p> 两种情况：
   * <p>  1.偶数位为0，奇数位为1 这种情况下，任意位的值和索引奇偶性相同，即s[i]%2==i%2，若不满足，即需要变动该位，则计数cnt1++
   * <p> 2.偶数位为1，奇数位为0这种情况下，任意位的值和索引奇偶性不同，即s[i]%2!=i%2，若不满足，即需要变动该位，则计数cnt2++
   *
   * <p>
   * 比较哪种需要变动的位数小
   * <p>太妙了啊
   *
   * @param s
   * @return
   */
  public int minOperations(String s) {
    int n = s.length(), cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (Integer.valueOf(s.charAt(i) % 2) != i % 2) {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    return Math.min(cnt1, cnt2);
  }

  public int minOperations_2(String s) {
    int n = s.length(), cnt1 = 0, cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (Integer.valueOf(s.charAt(i) % 2) != i % 2) {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    return Math.min(cnt1, cnt2);
  }

}
