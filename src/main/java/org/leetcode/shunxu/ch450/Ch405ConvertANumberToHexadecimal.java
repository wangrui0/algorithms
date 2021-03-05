package org.leetcode.shunxu.ch450;

import org.junit.jupiter.api.Test;

/**
 * <p> 405. 数字转换为十六进制数
 *
 * <p>给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * <p>注意:
 *
 * <p>    十六进制中所有字母(a-f)都必须是小写。
 * <p>    十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * <p>    给定的数确保在32位有符号整数范围内。
 * <p>    不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 *
 * <p>示例 1：
 *
 * <p>输入:
 * <p>26
 *
 * <p>输出:
 * "1a"
 *
 * <p> 示例 2：
 *
 * <p>输入:
 * <p>-1
 *
 * <p>输出:
 * <p> "ffffffff"
 * <p>https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch405ConvertANumberToHexadecimal {

  char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  @Test
  public void test() {
    System.out.println(toHex(26));
    System.out.println(toHex(-1));
  }

  /**
   * <p>由于num本来的储存形式就是二进制，可以直接和0xf, 也就是0000000f = 0000 0000 0000 0000 0000 0000 0000 1111相与，
   * <p>来提取后4位，也就是对16取余的结果，将这个结果依次加入result。每一次num >>= 4，相当于整除16，直到取满8次或者num为0。
   * <p>最后将结果reverse并返回。
   * <p>因为负数以补码的形式存储，不需要特别处理。但是要记录一个count，否则会造成overflow。
   *
   * @param num
   * @return
   */
  public String toHex(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    while (num != 0) {
      //对15 进行取余数
      sb.append(map[(num & 15)]);
//      sb.append(map[(num & 0xf)]);
      //除以16
      num = (num >>> 4);
    }
    return sb.reverse().toString();
  }
}
