package org.company.meituan.all.week02.done;

/**
 * <p>剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * <p>示例 1：
 *
 * <p>输入：n = 2
 * <p>输出：2
 * <p>示例 2：
 *
 * <p>输入：n = 7
 * <p>输出：21
 * <p>示例 3：
 *
 * <p>输入：n = 0
 * <p>输出：1
 * <p>提示：
 *
 * <p>0 <= n <= 100
 * <p>注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 *
 *
 * <p>通过次数137,430提交次数316,830
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 7:06 下午
 */
public class NCh076_offer_10_qingWaTiaoTaiJieWenTiLcof剑指Offer10II青蛙跳台阶问题 {

  public int numWays(int n) {
    int a = 1, b = 1, sum;
    for (int i = 0; i < n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return a;
  }

  /**
   * a:第0级 b:第1级
   *
   * @param n
   * @return
   */
  public int numWays2(int n) {
    int a = 1, b = 1, sum;
    for (int i = 2; i <= n; i++) {
      sum = (a + b) % 1000000007;
      a = b;
      b = sum;
    }
    return b;
  }
}
