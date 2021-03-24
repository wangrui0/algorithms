package org.leetcode.shunxu.ch750;

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
public class NCh744FindSmallestLetterGreaterThanTarge {

  public char nextGreatestLetter(char[] letters, char target) {

    return 'a';
  }
}
