package org.leetcode.shunxu.ch750;

/**
 * <p>709. 转换成小写字母
 *
 * <p>实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入: "Hello"
 * <p>输出: "hello"
 *
 * <p>示例 2：
 *
 * <p>输入: "here"
 * <p>输出: "here"
 *
 * <p>示例 3：
 *
 * <p>输入: "LOVELY"
 * <p>输出: "lovely"
 * https://leetcode-cn.com/problems/to-lower-case/
 * <p>通过次数63,094
 * <p>提交次数82,949
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch709ToLowerCase {

  public String toLowerCase(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    for (char ch : str.toCharArray()) {
      // a-z：97-122  A-Z：65-90  0-9：48-57
      if (ch >= 'A' && ch <= 'Z') {
        sb.append((char) (ch + 32));
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();
  }

  public String toLowerCase2(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }
    char[] ch = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (ch[i] >= 'A' && ch[i] <= 'Z') {
        ch[i] += 32;
      }
    }
    return String.valueOf(ch);
  }

  /**
   * <p>方法2：位运算
   * <p>思路：
   *
   * <p>用位运算的技巧：
   *
   * <p>    大写变小写、小写变大写：字符 ^= 32;
   * <p>    大写变小写、小写变小写：字符 |= 32;
   * <p>    大写变大写、小写变大写：字符 &= 33;
   *
   * <p>SCII码表中大写的A是65，小写的a是97，它们的差是32
   * <p>65 | 32 转为二进制（按8位来算）可以得到 0100 0001 | 0010 0000 = 0110 0001 = 97 = a
   *
   * <p>作者：yijiaoqian
   * <p>链接：https://leetcode-cn.com/problems/to-lower-case/solution/709zhuan-huan-cheng-xiao-xie-zi-mu-java-by-yijiaoq/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param str
   * @return
   */
  public String toLowerCase3(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }
    char[] ch = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      ch[i] |= 32;
    }
    return String.valueOf(ch);
  }
}
