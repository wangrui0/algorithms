package org.company.meituan.all.week02.done;

/**
 * <p>43. 字符串相乘
 * <p>给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * <p>示例 1:
 *
 * <p>输入: num1 = "2", num2 = "3"
 * <p>输出: "6"
 * <p>示例 2:
 *
 * <p>输入: num1 = "123", num2 = "456"
 * <p>输出: "56088"
 * <p>说明：
 *
 * <p>num1 和 num2 的长度小于110。
 * <p>num1 和 num2 只包含数字 0-9。
 * <p>num1 和 num2 均不以零开头，除非是数字 0 本身。
 * <p>不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>通过次数141,186提交次数315,832
 * <p>https://leetcode-cn.com/problems/multiply-strings/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 7:12 下午
 */
public class NCh080_43_multiplyStrings字符串相乘 {

  /**
   * 方法一：做加法 复杂度分析
   * <p>
   * 时间复杂度：O(mn+n^2)，
   * <p>
   * 空间复杂度：O(m+n)，
   *
   * @param num1
   * @param num2
   * @return
   */
  public String multiply_1(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    String ans = "0";
    int m = num1.length(), n = num2.length();
    for (int i = n - 1; i >= 0; i--) {
      StringBuffer curr = new StringBuffer();
      int add = 0;
      for (int j = n - 1; j > i; j--) {
        curr.append(0);
      }
      int y = num2.charAt(i) - '0';
      for (int j = m - 1; j >= 0; j--) {
        int x = num1.charAt(j) - '0';
        int product = x * y + add;
        curr.append(product % 10);
        add = product / 10;
      }
      if (add != 0) {
        curr.append(add % 10);
      }
      ans = addStrings(ans, curr.reverse().toString());
    }
    return ans;
  }

  public String addStrings(String num1, String num2) {
    int i = num1.length() - 1, j = num2.length() - 1, add = 0;
    StringBuffer ans = new StringBuffer();
    while (i >= 0 || j >= 0 || add != 0) {
      int x = i >= 0 ? num1.charAt(i) - '0' : 0;
      int y = j >= 0 ? num2.charAt(j) - '0' : 0;
      int result = x + y + add;
      ans.append(result % 10);
      add = result / 10;
      i--;
      j--;
    }
    ans.reverse();
    return ans.toString();
  }

  /**
   * 方法二：做乘法 复杂度分析
   * <p>
   * 时间复杂度：O(mn)，
   * <p>
   * 空间复杂度：O(m+n)
   *
   * @param num1
   * @param num2
   * @return
   */
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }
    int m = num1.length(), n = num2.length();
    int[] ansArr = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      int x = num1.charAt(i) - '0';
      for (int j = n - 1; j >= 0; j--) {
        int y = num2.charAt(j) - '0';
        ansArr[i + j + 1] += x * y;
      }
    }
    for (int i = m + n - 1; i > 0; i--) {
      ansArr[i - 1] += ansArr[i] / 10;
      ansArr[i] %= 10;
    }
    int index = ansArr[0] == 0 ? 1 : 0;
    StringBuffer ans = new StringBuffer();
    while (index < m + n) {
      ans.append(ansArr[index]);
      index++;
    }
    return ans.toString();
  }
}
