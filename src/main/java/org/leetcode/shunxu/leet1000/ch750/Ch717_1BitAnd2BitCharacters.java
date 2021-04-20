package org.leetcode.shunxu.leet1000.ch750;

/**
 * <p>717. 1比特与2比特字符
 *
 * <p>有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 *
 * <p>现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 *
 * <p>示例 1:
 *
 * <p>输入:
 * <p>bits = [1, 0, 0]
 * <p>输出: True
 * <p>解释:
 * <p>唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * <p>示例 2:
 *
 * <p>输入:
 * <p>bits = [1, 1, 1, 0]
 * <p>输出: False
 * <p>解释:
 * <p>唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * <p>注意:
 *
 * <p>    1 <= len(bits) <= 1000.
 * <p>    bits[i] 总是0 或 1.
 * https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/
 * <p>通过次数26,957
 * <p>提交次数53,503
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch717_1BitAnd2BitCharacters {

  /**
   * <p>我们可以对 bits 数组从左到右扫描来判断最后一位是否为一比特字符。当扫描到第 i 位时，如果
   * <p>bits[i]=1，那么说明这是一个两比特字符，将 i 的值增加 2。如果 bits[i]=0，
   * <p>那么说明这是一个一比特字符，将 i 的值增加 1。
   * <p>如果 i 最终落在了 bits.length−1的位置，那么说明最后一位一定是一比特字符。
   * <p>
   * ======================================
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是 bits 数组的长度。
   * <p>  空间复杂度：O(1)。
   *
   * @param bits
   * @return
   */
  public boolean isOneBitCharacter(int[] bits) {
    int i = 0;
    while (i < bits.length - 1) {
      i += bits[i] + 1;
    }
    return i == bits.length - 1;
  }

  /**
   * <p>三种字符分别为 0，10 和 11，那么 bits 数组中出现的所有 0 都表示一个字符的结束位置（无论其为一比特还是两比特）。
   * <p>因此最后一位是否为一比特字符，只和他左侧出现的连续的 1 的个数（即它与倒数第二个 0 出现的位置之间的 1 的个数，如果 bits
   * <p>数组中只有 1 个 0，那么就是整个数组的长度减一）有关。如果 1 的个数为偶数个，那么最后一位是一比特字符，如果 1 的个数为奇数个，
   * <p>那么最后一位不是一比特字符。
   * <p>
   * =========================
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 N 是 bits 数组的长度。
   * <p>   空间复杂度：O(1)
   * 1的个数为偶数，则可以，否则不可以。
   *
   * @param bits
   * @return
   */
  public boolean isOneBitCharacter2(int[] bits) {
    int i = bits.length - 2;
    while (i >= 0 && bits[i] > 0) {
      i--;
    }
    return (bits.length - i) % 2 == 0;
  }

}