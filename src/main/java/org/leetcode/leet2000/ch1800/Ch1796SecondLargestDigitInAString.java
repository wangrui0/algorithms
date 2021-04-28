package org.leetcode.leet2000.ch1800;

/**
 * <p>1796. 字符串中第二大的数字
 *
 * <p>给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * <p>混合字符串 由小写英文字母和数字组成。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "dfa12321afd"
 * <p>输出：2
 * <p>解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abc1111"
 * <p>输出：-1
 * <p>解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 500
 * <p>    s 只包含小写英文字母和（或）数字。
 *
 * <p>通过次数4,248
 * <p>提交次数8,988
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/second-largest-digit-in-a-string/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:15 下午
 */
public class Ch1796SecondLargestDigitInAString {
    public static void main(String[] args) {
        System.out.println(secondHighest("ck077"));
    }

    public static int secondHighest(String s) {
        int maxValue = Integer.MIN_VALUE;
        int secondValue = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                continue;
            }
            int num = Integer.parseInt(String.valueOf(c));
            if (num > maxValue) {
                secondValue = maxValue;
                maxValue = num;
            } else if (num > secondValue && num != maxValue) {
                secondValue = num;
            }
        }
        if (secondValue == maxValue || secondValue == Integer.MIN_VALUE) {
            return -1;
        }
        return secondValue;
    }

    public int secondHighest_2(String s) {
        // 顾名思义，first 是用来记录第一个的，second 是用来记录第二个的
        int first = -1, second = -1;
        for (char c : s.toCharArray()) {
            // 如果 c 是一个数字，那么就进行检查处理
            if (Character.isDigit(c)) {
                // 首先字符转换成数字
                int num = c - '0';
                // 如果 first 还没有赋值呢，那么就直接赋值
                if (first == -1) first = num;
                    // first 已经带值，而且 num 比 first 还大，那么就更新它们
                else if (num > first) {
                    second = first;
                    first = num;
                } else if (num < first && num > second)
                    // 如果介于两者中间，那么就只更新第二个值
                    second = num;
            }
        }
        return second;
    }

}
