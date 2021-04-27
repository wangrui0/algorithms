package org.leetcode.leet2000.ch1700;

/**
 * <p>1694. 重新格式化电话号码
 *
 * <p>给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * <p>请你按下述方式重新格式化电话号码。
 *
 * <p>    首先，删除 所有的空格和破折号。
 * <p>    其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * <p>        2 个数字：单个含 2 个数字的块。
 * <p>        3 个数字：单个含 3 个数字的块。
 * <p>        4 个数字：两个分别含 2 个数字的块。
 *
 * <p>最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * <p>返回格式化后的电话号码。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：number = "1-23-45 6"
 * <p>输出："123-456"
 * <p>解释：数字是 "123456"
 * <p>步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * <p>步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * <p>连接这些块后得到 "123-456" 。
 *
 * <p>示例 2：
 *
 * <p>输入：number = "123 4-567"
 * <p>输出："123-45-67"
 * <p>解释：数字是 "1234567".
 * <p>步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * <p>步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * <p>连接这些块后得到 "123-45-67" 。
 *
 * <p>示例 3：
 *
 * <p>输入：number = "123 4-5678"
 * <p>输出："123-456-78"
 * <p>解释：数字是 "12345678" 。
 * <p>步骤 1：第 1 个块 "123" 。
 * <p>步骤 2：第 2 个块 "456" 。
 * <p>步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
 * <p>连接这些块后得到 "123-456-78" 。
 *
 * <p>示例 4：
 *
 * <p>输入：number = "12"
 * <p>输出："12"
 *
 * <p>示例 5：
 *
 * <p>输入：number = "--17-5 229 35-39475 "
 * <p>输出："175-229-353-94-75"
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= number.length <= 100
 * <p>    number 由数字和字符 '-' 及 ' ' 组成。
 * <p>    number 中至少含 2 个数字。
 *
 * <p>通过次数6,216
 * <p>提交次数9,735
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reformat-phone-number/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:33 下午
 */
public class Ch1694ReformatPhoneNumber {

  public static String reformatNumber_self(String number) {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      if (c != '-' && c != ' ') {
        sb.append(c);
        index++;
        if (index % 3 == 0 && i != number.length() - 1) {
          sb.append('-');
        }
      }
    }
    if (sb.charAt(sb.length() - 2) == '-') {
      String str = sb.substring(sb.length() - 5, sb.length());
      sb.delete(sb.length() - 5, sb.length());
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) != '-') {
          sb.append(str.charAt(i));
        }
        if (i == 1) {
          sb.append('-');
        }
      }
    }
    return sb.charAt(sb.length() - 1) == '-' ? sb.substring(0, sb.length() - 1) : sb.toString();
  }

  public String reformatNumber_2(String number) {
    String ans = "";
    int count = 0;
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) != ' ' && number.charAt(i) != '-') {
        ans += number.charAt(i);
        count++;
        if (count % 3 == 0) {
          ans += "-";
        }
      }
    }
    if (ans.length() < 3) {
      return ans;
    }
    int index = ans.lastIndexOf("-");
    if (index == ans.length() - 1) {
      return ans.substring(0, index);
    }
    char[] help = ans.toCharArray();
    if (help[help.length - 2] == '-') {
      char t = help[help.length - 3];
      help[help.length - 3] = help[help.length - 2];
      help[help.length - 2] = t;
    }
    return new String(help);
  }

  public String reformatNumber_3(String number) {
    number = number.replace(" ", "").replace("-", "");
    int len = number.length();
    StringBuilder sb = new StringBuilder();
    int i = 0;
    int count = 0;
    if (len % 3 == 0 || (len % 3 == 2)) {
      for (int j = 0; j < len; j++) {
        sb.append(number.charAt(j));
        count++;
        if (count == 3 && j != len - 1) { //j != len-1 避免最后位置拼接"-"
          sb.append("-");
          count = 0; //重新计数
        }
      }
    } else { //剩四位的处理逻辑
      for (int j = 0; j < len; j++) {
        sb.append(number.charAt(j));
        count++;
        if (count == 3) {
          sb.append("-");
          count = 0;
        }
        if (len - 1 - j == 2 && count == 2) { //表示还剩2位，比如123-4567，此时在45后面拼"-"
          sb.append("-");
          count = 0; //需要置为0
        }
      }
    }
    return sb.toString();
  }
}
