package org.leetcode.leet2000.ch1800;

/**
 * <p>1784. 检查二进制字符串字段
 *
 * <p>给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * <p>如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "1001"
 * <p>输出：false
 * <p>解释：字符串中的 1 没有形成一个连续字段。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "110"
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= s.length <= 100
 * <p>    s[i]​​​​ 为 '0' 或 '1'
 * <p>    s[0] 为 '1'
 *
 * <p>通过次数7,117
 * <p>提交次数17,374
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:13 下午
 */
public class Ch1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    /*
        解题思路：
            1.即判断字符串中是否包含子串"01"，如果包含"01"子串就表示1不是连续的了
            参考自其他题解：https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solution/ji-ran-da-jia-du-yi-xing-dai-ma-na-javay-jpoc/
     */
    public boolean checkOnesSegment_1(String s) {
        return !s.contains("01");
    }


    /*
     解题思路：
     1.用正则表达式进行匹配，"1+"表示1出现一次或多次，"0*"表示0出现零次或多次
     */
    public boolean checkOnesSegment_2(String s) {
        return s.matches("1+0*");
    }

    /*
    解题思路：
        1.将字符串转换成一个字符数组
        2.判断相邻的两个字符是否是"0"和"1"的情况，如果存在"01"表示从首字符开始的"1"不连续了
 */
    public boolean checkOnesSegment_3(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '0' && chars[i + 1] == '1') {
                return false;
            }
        }
        return true;
    }

    /*
解题思路：
    1.将字符"1"和"0"转换成数字来进行运算
    2.存在这么几种情况：[1,0]、[1,1]、[0,0]、[0,1]
    3.前三种情况都表示1是连续的，即前面的数减去后面的数的差为1,0,0，而[0,1]的差为-1，表示不连续
*/
    public boolean checkOnesSegment_4(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length - 1) {
            if (Integer.valueOf(chars[i] + "") - Integer.valueOf(chars[i + 1] + "") == -1) {
                return false;
            }
        }
        return true;
    }

    /*
        解题思路：
            1.将字符串s转换成字符数组chars
            2.统计字符'0'的出现个数
            3.由于chars[0]必定为1，所以最开始如果是连续的，那么字符'0'的个数必定为0
            4.所以在每次判断字符是否是'1'之前，先判断字符'0'的个数，如果"0"的个数大于了0，表示在字符串s中已经出现了'0'字符，那么执行到了该条判断，又表示又出现了'1'字符，但这些'1'字符不是连续的，直接返回false
     */
    public boolean checkOnesSegment_5(String s) {
        // 将字符串s转换成字符数组
        char[] chars = s.toCharArray();
        // 计数器，记录'0'字符的出现个数
        int zeroCount = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                if (zeroCount > 0) {
                    return false;
                }
            } else {
                zeroCount++;
            }
        }
        return true;
    }

    /*
        解题思路：
            即将字符串s分割成只包含字符'1’的子串，然后统计子串的个数，只有小于等于1才是连续的，否则有多个出现
            参考自：https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/solution/java-zhi-jie-zi-fu-chuan-fen-ge-by-hxz19-pib3/
     */
    public boolean checkOnesSegment_6(String s) {
        // 将字符串按'0'字符分割成只包含'1'字符的子串
        String[] split = s.split("0");
        // 计算分割后数组中非空串的个数（即只包含'1'字符的子串个数）
        int count = 0;
        for (String s1 : split) {
            if (!s1.equals("")) {
                count++;
            }
        }
        // 看最后子串的数目
        return count <= 1;
    }

}
