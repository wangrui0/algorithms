package org.leetcode.leet500.ch500;

/**
 * <p>459. 重复的子字符串
 *
 * <p>给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * <p>示例 1:
 *
 * <p>输入: "abab"
 *
 * <p>输出: True
 *
 * <p>解释: 可由子字符串 "ab" 重复两次构成。
 *
 * <p> 示例 2:
 *
 * <p>输入: "aba"
 *
 * <p>输出: False
 *
 * <p>示例 3:
 *
 * <p>输入: "abcabcabcabc"
 *
 * <p>输出: True
 *
 * <p>解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * <p>通过次数62,179
 * <p>提交次数121,778
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch459RepeatedSubstringPattern {

  /**
   * <p>self
   * <p> 1:倍数 2：开头 3：任意的,s[i]=s[i-n]
   *
   * @param s
   * @return
   */
  public static boolean repeatedSubstringPattern(String s) {
    int num = s.length();
    for (int i = 1; 2 * i <= num; i++) {
      if (num % i == 0) {
        boolean match = true;
        for (int j = i; j < num; j++) {
          if (s.charAt(j) != s.charAt(j - i)) {
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * <p>思路与算法
   *
   * <p>如果一个长度为 n 的字符串 sss 可以由它的一个长度为 n′ 的子串 s′ 重复多次构成，那么：
   *
   * <p>    n 一定是 n′ 的倍数；
   *
   * <p>   s′ 一定是 s 的前缀；
   *
   * <p>   对于任意的 i∈[n′,n)，有 s[i]=s[i−n′]。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * =========================
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(n^2)，其中 n 是字符串 s 的长度。枚举 i 的时间复杂度为 O(n)，遍历 s 的时间复杂度为 O(n)，相乘即为总时间复杂度。
   *
   * <p>    空间复杂度：O(1)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public boolean repeatedSubstringPattern2(String s) {
    int n = s.length();
    for (int i = 1; i * 2 <= n; ++i) {
      if (n % i == 0) {
        boolean match = true;
        for (int j = i; j < n; ++j) {
          if (s.charAt(j) != s.charAt(j - i)) {
            match = false;
            break;
          }
        }
        if (match) {
          return true;
        }
      }
    }
    return false;
  }
}
