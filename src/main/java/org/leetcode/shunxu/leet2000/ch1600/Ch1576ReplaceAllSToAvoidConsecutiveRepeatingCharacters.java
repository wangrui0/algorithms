package org.leetcode.shunxu.leet2000.ch1600;

/**
 *<p>1576. 替换所有的问号
 *
 *<p>给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 *<p>注意：你 不能 修改非 '?' 字符。
 *
 *<p>题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 *
 *<p>在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 *
 *
 *<p>示例 1：
 *
 *<p>输入：s = "?zs"
 *<p>输出："azs"
 *<p>解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两个 'z' 。
 *
 *<p>示例 2：
 *
 *<p>输入：s = "ubv?w"
 *<p>输出："ubvaw"
 *<p>解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
 *
 *<p>示例 3：
 *
 *<p>输入：s = "j?qg??b"
 *<p>输出："jaqgacb"
 *
 *<p>示例 4：
 *
 *<p>输入：s = "??yw?ipkj?"
 *<p>输出："acywaipkja"
 *
 *
 *
 *<p>提示：
 *
 *<p>    1 <= s.length <= 100
 *
 *<p>    s 仅包含小写英文字母和 '?' 字符
 *
 *<p>通过次数15,814
 *<p>提交次数33,465
 *<p>请问您在哪类招聘中遇到此题？
 *<p>https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 *<p>@author: wangrui
 *<p>@date: 2021/4/22
 */
public class Ch1576ReplaceAllSToAvoidConsecutiveRepeatingCharacters {

}
