package org.company.meituan.all.week01.done;

/**
 * <p>415. 字符串相加
 *
 * <p>给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *
 *
 * <p>提示：
 *
 * <p>    num1 和num2 的长度都小于 5100
 * <p>    num1 和num2 都只包含数字 0-9
 * <p>    num1 和num2 都不包含任何前导零
 * <p>    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * <p>通过次数114,129
 * <p>提交次数217,440
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/add-strings/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class Ch032_415AddStrings字符串相加 {

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(max⁡(len1,len2))O(\max(\textit{len}_1,\textit{len}_2))O(max(len1​,len2​))，其中
   * len1=num1.length\textit{len}_1=\textit{num}_1.\text{length}len1​=num1​.length，len2=num2.length\textit{len}_2=\textit{num}_2.\text{length}len2​=num2​.length。竖式加法的次数取决于较大数的位数。
   * <p>  空间复杂度：O(1)O(1)O(1)。除答案外我们只需要常数空间存放若干变量。在 Java 解法中使用到了 StringBuffer，故 Java 解法的空间复杂度为 O(n)O(n)O(n)。
   *
   * @param num1
   * @param num2
   * @return
   */
  public static String addStrings_self(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    int index1 = n1 - 1;
    int index2 = n2 - 1;
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    while (index1 >= 0 || index2 >= 0) {
      int a = 0, b = 0;
      if (index1 >= 0) {
        a = num1.charAt(index1--) - 48;
      }
      if (index2 >= 0) {
        b = num2.charAt(index2--) - 48;
      }
      int sum = a + b + carry;
      sb.append(sum % 10);
      carry = sum / 10;
    }
    if (carry > 0) {
      sb.append(carry);
    }
    return sb.reverse().toString();
  }

  public String addStrings_2(String num1, String num2) {
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
    // 计算完以后的答案需要翻转过来
    ans.reverse();
    return ans.toString();
  }


}
