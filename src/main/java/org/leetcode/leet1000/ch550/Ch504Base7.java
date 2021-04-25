package org.leetcode.leet1000.ch550;

/**
 * 504. 七进制数
 * <p>
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 100 输出: "202"
 * <p>
 * 示例 2:
 * <p>
 * 输入: -7 输出: "-10"
 * <p>
 * <p>注意: 输入范围是 [-1e7, 1e7] 。
 * <p>通过次数21,874 提交次数43,744
 * <p>https://leetcode-cn.com/problems/base-7/
 *
 * @author: wangrui
 * @date: 2021/3/12
 */
public class Ch504Base7 {


    public String convertToBase7(int num) {

        StringBuilder sb = new StringBuilder();
        //判断零
        if (num == 0) {
            sb.append("0");
            return sb.toString();
        }
        boolean flag = false;
        //判断是否小于零，将小于零的数，转换成大于零的数，统一处理
        if (num < 0) {
            num = -num;
            flag = true;
        }
        // 求进制的模板，转换成几进制，就先求余几，然后再除以几
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        // 逆序
        sb.reverse();
        if (flag) sb.insert(0, "-");
        return sb.toString();
    }

    //参考Java toString(int i, int radix)的做法
    public String convertToBase7_2(int num) {
        char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6'};
        //33是因为有符号int转化为2进制最长为32位，加符号即为33位
        char[] buf = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;
        //同一转换为正数来处理
        if (negative) {
            num = -num;
        }
        //这么做是为了解决0的特殊情况
        while (num >= 7) {
            buf[charPos--] = digits[num % 7];
            num /= 7;
        }
        buf[charPos] = digits[num];
        if (negative) {
            buf[--charPos] = '-';
        }
        //new String(char[], offset, length)
        return new String(buf, charPos, 33 - charPos);
    }
}
