package org.leetcode.leet2000.ch1750;

/**
 * <p>1736. 替换隐藏数字得到的最晚时间
 *
 * <p>给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 *
 * <p>有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 *
 * <p>替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：time = "2?:?0"
 * <p>输出："23:50"
 * <p>解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 *
 * <p>示例 2：
 *
 * <p>输入：time = "0?:3?"
 * <p>输出："09:39"
 *
 * <p>示例 3：
 *
 * <p>输入：time = "1?:22"
 * <p>输出："19:22"
 *
 *
 *
 * <p>提示：
 *
 * <p>    time 的格式为 hh:mm
 * <p>    题目数据保证你可以由输入的字符串生成有效的时间
 *
 * <p>通过次数6,484
 * <p>提交次数16,129
 * <p>https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:01 下午
 */
public class Ch1736latestTimeByReplacingHiddenDigits {
    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));
    }

    public static String maximumTime(String time) {
        char c1 = time.charAt(0);
        char c2 = time.charAt(1);
        char c3 = time.charAt(3);
        char c4 = time.charAt(4);
        if (c1 == '?') {
            if (c2 <= '3' || c2 == '?') {
                c1 = '2';
            } else {
                c1 = '1';
            }
        }
        if (c2 == '?') {
            if (c1 < '2') {
                c2 = '9';
            } else {
                c2 = '3';
            }
        }
        if (c3 == '?') {
            c3 = '5';
        }
        if (c4 == '?') {
            c4 = '9';
        }
        StringBuffer sb = new StringBuffer();
        sb.append(c1).append(c2).append(":").append(c3).append(c4);
        return sb.toString();
    }

    public String maximumTime_2(String time) {
        char[] cs = time.toCharArray();
        for (int i = 0; i < time.length(); ++i) {
            if (cs[i] == '?') switch (i) {
                case 0:
                    if (cs[i + 1] == '?' || cs[i + 1] < '4') cs[i] = '2';
                    else cs[i] = '1';
                    break;
                case 1:
                    if (cs[i - 1] == '2') cs[i] = '3';
                    else cs[i] = '9';
                    break;
                case 3:
                    cs[i] = '5';
                    break;
                case 4:
                    cs[i] = '9';
                    break;
            }
        }
        return new String(cs);
    }

}
