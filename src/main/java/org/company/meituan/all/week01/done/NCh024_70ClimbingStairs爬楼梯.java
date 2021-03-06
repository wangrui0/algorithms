package org.company.meituan.all.week01.done;

/**
 * <p>70. 爬楼梯
 *
 * <p>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * <p>每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * <p>注意：给定 n 是一个正整数。
 *
 * <p>示例 1：
 *
 * <p>输入： 2
 * <p>输出： 2
 * <p>解释： 有两种方法可以爬到楼顶。
 * <p>1.  1 阶 + 1 阶
 * <p>2.  2 阶
 *
 * <p>示例 2：
 *
 * <p>输入： 3
 * <p>输出： 3
 * <p>解释： 有三种方法可以爬到楼顶。
 * <p>1.  1 阶 + 1 阶 + 1 阶
 * <p>2.  1 阶 + 2 阶
 * <p>3.  2 阶 + 1 阶
 *
 * <p>通过次数438,379
 * <p>提交次数844,385
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/climbing-stairs/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh024_70ClimbingStairs爬楼梯 {

  public int climbStairs(int n) {
    if (n <= 1) {
      return 1;
    }
    int a = 1, b = 1, ans = 0;
    for (int i = 2; i <= n; i++) {
      ans=a+b;
      a=b;
      b=ans;
    }
    return ans;
  }
}
