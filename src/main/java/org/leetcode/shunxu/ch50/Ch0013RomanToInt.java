package org.leetcode.shunxu.ch50;

/**
 * 罗马数字转整数
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * <p>
 * I             1
 * <p>
 * V             5
 * <p>
 * X             10
 * <p>
 * L             50
 * <p>
 * C             100
 * <p>
 * D             500
 * <p>
 * M             1000
 * <p>
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9
 * 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * <p>
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * <p>
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * <p>
 * 输出: 3
 * <p>
 * 示例 2:
 * <p>
 * 输入: "IV"
 * <p>
 * 输出: 4
 * <p>
 * 示例 3:
 * <p>
 * 输入: "IX"
 * <p>
 * 输出: 9
 * <p>
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * <p>
 * 输出: 58
 * <p>
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * <p>
 * 输出: 1994
 * <p>
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.  <p> 提示：
 * <p>
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * <p>
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * <p>
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/4
 */
public class Ch0013RomanToInt {

  public static void main(String[] args) {
    System.out.println(romanToInt("III"));//3
    System.out.println(romanToInt("IV"));//4
    System.out.println(romanToInt("IX"));//9
    System.out.println(romanToInt("LVIII"));//58
    System.out.println(romanToInt("MCMXCIV"));//1994
  }

  /**
   * III IV
   *
   * @param str
   * @return
   */
  public static int romanToInt(String str) {
    int result = 0;
    if (str == null || str.length() == 0) {
      return result;
    }
    int length = str.length();
    int pre = 0;
    int current = 0;
    for (int i = 0; i < length; i++) {
      char c = str.charAt(i);
      current = convertCharToInt(c);
      if (current > pre) {
        result -= pre;
      } else {
        result += pre;
      }
      pre = current;
    }
    result += current;
    return result;
  }

  public static int convertCharToInt(Character c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        throw new IllegalArgumentException("非法字符");
    }

  }

}