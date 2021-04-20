package org.leetcode.shunxu.leet1500.ch1100;

/**
 * <p>1071. 字符串的最大公因子
 *
 * <p>对于字符串 S 和 T，只有在 S = T + ... + T（T 自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 *
 * <p>返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：str1 = "ABCABC", str2 = "ABC"
 * <p>输出："ABC"
 *
 * <p>示例 2：
 *
 * <p>输入：str1 = "ABABAB", str2 = "ABAB"
 * <p>输出："AB"
 *
 * <p>示例 3：
 *
 * <p>输入：str1 = "LEET", str2 = "CODE"
 * <p>输出：""
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= str1.length <= 1000
 * <p>    1 <= str2.length <= 1000
 * <p>    str1[i] 和 str2[i] 为大写英文字母
 *
 * <p>通过次数32,428
 * <p>提交次数55,328
 * <p>https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1071GreatestCommonDivisorOfStrings {

  /**
   * <p> 方法一：枚举
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O((len1+len2)σ(gcd(len1,len2)))，其中 σ(n) 表示 n 的约数个数，gcd(a,b) 表示 a 和 b
   * 的的最大公约数。我们需要线性的时间来两两比较拼接后的字符串和被比较的串是否相等，而之前提到符合条件的长度 lenx​ 一定是 len1 和 len2​ 的公约数，所以符合条件的 lenx​ 的个数即为 len1​ 和 len2​
   * 的公约数个数（即最大公约数的约数个数）σ(gcd(len1,len2))，最坏情况下所有符合条件的 lenx​ 均要被判断一次，再算上之前提及的判断是否符合的时间复杂度，最后时间复杂度即为
   * O((len1+len2)σ(gcd(len1,len2)))。
   *
   * <p>    空间复杂度：O(len1+len2)，每次枚举比较的过程中需要创建长度为 len1​ 和 len2​ 的临时字符串变量，所以需要额外 O(len1+len2的空间。
   *
   * @param str1
   * @param str2
   * @return
   */
  public String gcdOfStrings_1(String str1, String str2) {
    int len1 = str1.length(), len2 = str2.length();
    for (int i = Math.min(len1, len2); i >= 1; --i) { // 从长度大的开始枚举
      if (len1 % i == 0 && len2 % i == 0) {
        String X = str1.substring(0, i);
        if (check(X, str1) && check(X, str2)) {
          return X;
        }
      }
    }
    return "";
  }

  public boolean check(String t, String s) {
    int lenx = s.length() / t.length();
    StringBuffer ans = new StringBuffer();
    for (int i = 1; i <= lenx; ++i) {
      ans.append(t);
    }
    return ans.toString().equals(s);
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n)，其中 n 是两个字符串的长度范围，即 len1+len2。判断最大公约数长度的前缀串是否符合条件需要O(n) 的时间复杂度，求两个字符串长度的最大公约数需要 O(logn)
   * 的时间复杂度，所以总时间复杂度为O(n)O(n+logn)=O(n) 。
   * <p>  空间复杂度：O(n)，比较的过程中需要创建一个长度创建长度为 O(n) 的临时字符串变量，所以需要额外 O(n) 的空间。
   *
   * @param str1
   * @param str2
   * @return
   */
  public String gcdOfStrings_2(String str1, String str2) {
    int len1 = str1.length(), len2 = str2.length();
    String T = str1.substring(0, gcd(len1, len2));
    if (check(T, str1) && check(T, str2)) {
      return T;
    }
    return "";
  }

  public int gcd(int a, int b) {
    int remainder = a % b;
    while (remainder != 0) {
      a = b;
      b = remainder;
      remainder = a % b;
    }
    return b;
  }

  /**
   * <p> 方法三：数学 如果 str1 和 str2 拼接后等于 str2和 str1 拼接起来的字符串（注意拼接顺序不同），那么一定存在符合条件的字符串 X,满足 X 能除尽 str1 且 X 能除尽 str2
   * 复杂度分析
   *
   * <p>   时间复杂度：O(n) ，字符串拼接比较是否相等需要 O(n) 的时间复杂度，求两个字符串长度的最大公约数需要 O(logn) 的时间复杂度，所以总时间复杂度为 O(n+logn)=O(n) 。
   *
   * <p>   空间复杂度：O(n) ，程序运行时建立了中间变量用来存储 str1 与 str2 的相加结果。
   *
   * @param str1
   * @param str2
   * @return
   */
  public String gcdOfStrings_3(String str1, String str2) {
    if (!str1.concat(str2).equals(str2.concat(str1))) {
      return "";
    }
    return str1.substring(0, gcd(str1.length(), str2.length()));
  }


}
