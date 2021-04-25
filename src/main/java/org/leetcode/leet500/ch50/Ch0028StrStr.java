package org.leetcode.leet500.ch50;

/**
 * <p>
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * <p>
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * <p>
 * 输出: -1
 * <p>
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/10
 */
public class Ch0028StrStr {

  public static void main(String[] args) {
 /*   System.out.println(strStr("hello", "ll"));
    System.out.println(strStr("", ""));*/
    System.out.println(strStr("a", "a"));
  }

  /**
   * 自己
   *
   * @param haystack
   * @param needle
   * @return
   */
  public static int strStr(String haystack, String needle) {
    if (needle == null || needle.length() == 0) {
      return 0;
    }
    int haystackLength = haystack.length();
    int needleLength = needle.length();
    for (int i = 0; i <= haystackLength - needleLength; i++) {
      if (haystack.substring(i, i + needleLength).equals(needle)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 官方：
   * <p>
   * 方法一：子串逐一比较 - 线性时间复杂度
   * <p>
   * 最直接的方法 - 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较。
   * <p>
   * ============================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O((N−L)L)，其中 N 为 haystack 字符串的长度，L 为 needle 字符串的长度。内循环中比较字符串的复杂度为 L，总共需要比较 (N - L) 次。
   * <p>
   * 空间复杂度：O(1)。
   * <p>
   *
   * @param haystack
   * @param needle
   * @return
   */
  public int strStr2(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }

  /**
   * 方法二：双指针 - 线性时间复杂度
   * <p>
   * 上一个方法的缺陷是会将 haystack 所有长度为 L 的子串都与 needle 字符串比较，实际上是不需要这么做的。
   * <p>
   * 首先，只有子串的第一个字符跟 needle 字符串第一个字符相同的时候才需要比较。
   * <p>
   * 其次，可以一个字符一个字符比较，一旦不匹配了就立刻终止。
   * <p>
   * 如下图所示，比较到最后一位时发现不匹配，这时候开始回溯。需要注意的是，pn 指针是移动到 pn = pn - curr_len + 1 的位置，而 不是 pn = pn - curr_len 的位置。
   * <p>
   * 这时候再比较一次，就找到了完整匹配的子串，直接返回子串的开始位置 pn - L。
   * <p>
   * 算法
   * <p>
   * 移动 pn 指针，直到 pn 所指向位置的字符与 needle 字符串第一个字符相等。
   * <p>
   * 通过 pn，pL，curr_len 计算匹配长度。
   * <p>
   * 如果完全匹配（即 curr_len == L），返回匹配子串的起始坐标（即 pn - L）。
   * <p>
   * 如果不完全匹配，回溯。使 pn = pn - curr_len + 1， pL = 0， curr_len = 0。
   * <p>
   * =========================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：最坏时间复杂度为 O((N−L)L)，最优时间复杂度为 O(N)。
   * <p>
   * 空间复杂度：O(1)。
   *
   * @param haystack
   * @param needle
   * @return
   */
  public int strStr3(String haystack, String needle) {

    int L = needle.length(), n = haystack.length();

    if (L == 0) {
      return 0;
    }

    int pn = 0;
    while (pn < n - L + 1) {
      // find the position of the first needle character
      // in the haystack string
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
        ++pn;
      }

      // compute the max match string
      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      // if the whole needle string is found,
      // return its start position
      if (currLen == L) {
        return pn - L;
      }

      // otherwise, backtrack
      pn = pn - currLen + 1;
    }
    return -1;
  }

}
