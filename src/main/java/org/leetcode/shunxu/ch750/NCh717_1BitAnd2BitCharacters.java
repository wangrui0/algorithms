package org.leetcode.shunxu.ch750;

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
public class NCh717_1BitAnd2BitCharacters {

  public boolean isOneBitCharacter(int[] bits) {
    return true;
  }
}
