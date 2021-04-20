package org.leetcode.shunxu.leet1000.ch750;

/**
 * <p>744. 寻找比目标字母大的最小字母
 *
 * <p>给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 * <p>在比较时，字母是依序循环出现的。举个例子：
 *
 * <p>    如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *
 *
 *
 * <p>示例：
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "a"
 * <p>输出: "c"
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "c"
 * <p>输出: "f"
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "d"
 * <p>输出: "f"
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "g"
 * <p>输出: "j"
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "j"
 * <p>输出: "c"
 *
 * <p>输入:
 * <p>letters = ["c", "f", "j"]
 * <p>target = "k"
 * <p>输出: "c"
 *
 *
 *
 * <p>提示：
 *
 * <p>    letters长度范围在[2, 10000]区间内。
 * <p>    letters 仅由小写字母组成，最少包含两个不同的字母。
 * <p>    目标字母target 是一个小写字母。
 * <p>https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * <p>通过次数31,602
 * <p>提交次数69,172
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/24
 */
public class Ch744FindSmallestLetterGreaterThanTarge {

  /**
   * <p> 算法：
   *
   * <p>     我们可以扫描 letters 记录字母是否存在。我们可以用大小为 26 的数组或者 Set 来实现。
   * <p>     然后，从下一个字母（从比目标大一个的字母开始）开始检查一下是否存在。如果有的话则是答案。
   * <p>
   * ================================
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N)。N 指的是 letters 的长度，我们扫描数组的每个元素。
   * <p>   空间复杂度：O(1)。seen 最大的空间为 26。
   *
   * @param letters
   * @param target
   * @return
   */
  public char nextGreatestLetter(char[] letters, char target) {
    boolean[] seen = new boolean[26];
    for (char c : letters) {
      seen[c - 'a'] = true;
    }

    while (true) {
      target++;
      if (target > 'z') {
        target = 'a';
      }
      if (seen[target - 'a']) {
        return target;
      }
    }
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(N)。N 指的是 letters 的长度，我们扫描数组的每个元素。
   * <p> 空间复杂度：O(1)。只使用了指针
   *
   * @param letters
   * @param target
   * @return
   */
  public char nextGreatestLetter2(char[] letters, char target) {
    for (char c : letters) {
      if (c > target) {
        return c;
      }
    }
    return letters[0];
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(logN)。N 指的是 letters 的长度，我们只查看数组中的 logn 个元素。
   * <p> 空间复杂度：O(1)。只使用了指针。
   *
   * @param letters
   * @param target
   * @return
   */
  public char nextGreatestLetter3(char[] letters, char target) {
    //想想这一句和最后一句的关系，为啥不-1
    int lo = 0, hi = letters.length;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (letters[mi] <= target) {
        lo = mi + 1;
      } else {
        hi = mi;
      }
    }
    //为啥要取余，因为如果lo为letter.length,那么久取第一个了
    return letters[lo % letters.length];
  }
}
