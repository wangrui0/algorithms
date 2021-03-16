package org.leetcode.shunxu.ch550;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import sun.nio.cs.ext.MacHebrew;

/**
 * <p>521. 最长特殊序列 Ⅰ
 * <p>给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
 *
 * <p>「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 *
 * <p>子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 *
 * <p>输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入: "aba", "cdc"
 * <p>输出: 3
 * <p> 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 * <p> 示例 2：
 *
 * <p>输入：a = "aaa", b = "bbb"
 * <p>输出：3
 * <p>示例 3：
 *
 * <p>输入：a = "aaa", b = "aaa"
 * <p>输出：-1
 *
 *
 *
 * <p>提示：
 *
 * <p>两个字符串长度均处于区间 [1 - 100] 。
 * <p>字符串中的字符仅含有 'a'~'z' 。
 * <p>通过次数20,989提交次数29,848
 * <p> 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:20 下午
 */
public class Ch521LongestUncommonSubsequenceI {
    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(min(x,y))，其中 x 和 y 是字符串 a 和 b 的长度。方法 equals 的时间复杂度为 min(x,y)。
     *
     * <p>空间复杂度：O(1)，无需额外空间。
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
