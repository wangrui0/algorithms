package org.leetcode.leet1000.ch550;

/**
 * <p>509. 斐波那契数
 * <p>斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * <p>F(0) = 0，F(1) = 1
 * <p>F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * <p>给你 n ，请计算 F(n) 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：2
 * <p>输出：1
 * <p>解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>示例 2：
 *
 * <p>输入：3
 * <p>输出：2
 * <p>解释：F(3) = F(2) + F(1) = 1 + 1 = 2
 * <p>示例 3：
 *
 * <p>输入：4
 * <p>输出：3
 * <p>解释：F(4) = F(3) + F(2) = 2 + 1 = 3
 *
 *
 * <p>提示：
 *
 *
 * <p>0 <= n <= 30
 * <p>通过次数152,245提交次数222,945
 * <p>https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:24 下午
 */
public class Ch509FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(2));
    }

    //非递归

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(n)。
     *
     * <p>空间复杂度：O(1)。
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;

    }

    public static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }
}
