package org.leetcode.leet1000.ch850;

/**
 * <p>806. 写字符串需要的行数
 *
 * <p>我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。我们给定了一个数组 widths ，这个数组
 * widths[0] 代表 'a' 需要的单位， widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *
 * <p>现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 *
 * <p>示例 1:
 * <p>输入:
 * <p>widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * <p>S = "abcdefghijklmnopqrstuvwxyz"
 * <p>输出: [3, 60]
 * <p>解释:
 * <p>所有的字符拥有相同的占用单位10。所以书写所有的26个字母，
 * <p>我们需要2个整行和占用60个单位的一行。
 *
 * <p>示例 2:
 * <p>输入:
 * <p>widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
 * <p>S = "bbbcccdddaaa"
 * <p>输出: [2, 4]
 * <p>解释:
 * <p>除去字母'a'所有的字符都是相同的单位10，并且字符串 "bbbcccdddaa" 将会覆盖 9 *<p>10 + 2 *<p>4 = 98 个单位.
 * <p>最后一个字母 'a' 将会被写到第二行，因为第一行只剩下2个单位了。
 * <p>所以，这个答案是2行，第二行有4个单位宽度。
 *
 *
 *
 * <p>注:
 *
 * <p>    字符串 S 的长度在 [1, 1000] 的范围。
 * <p>    S 只包含小写字母。
 * <p>    widths 是长度为 26的数组。
 * <p>    widths[i] 值的范围在 [2, 10]。
 *
 * <p>通过次数11,303
 * <p>提交次数17,162
 * <p>https://leetcode-cn.com/problems/number-of-lines-to-write-string/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch806NumberOfLinesToWriteString {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(∣S∣)。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param widths
   * @param S
   * @return
   */
  public int[] numberOfLines(int[] widths, String S) {
    int lines = 1, width = 0;
    for (char c : S.toCharArray()) {
      int w = widths[c - 'a'];
      width += w;
      if (width > 100) {
        lines++;
        width = w;
      }
    }

    return new int[]{lines, width};
  }

  public int[] numberOfLines2(int[] widths, String S) {
    int line = 1, width = 0;
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      int words = widths[c - 'a'];
      if (width + words > 100) {
        line++;
        width = words;
      } else {
        width += words;
      }
    }
    return new int[]{line,width};
  }
}
