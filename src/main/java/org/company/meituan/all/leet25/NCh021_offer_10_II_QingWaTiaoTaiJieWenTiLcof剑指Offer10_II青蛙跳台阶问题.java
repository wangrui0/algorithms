package org.company.meituan.all.leet25;

/**
 * <p>剑指 Offer 10- II. 青蛙跳台阶问题
 *
 * <p>一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * <p>答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * <p>示例 1：
 *
 * <p>输入：n = 2
 * <p>输出：2
 *
 * <p>示例 2：
 *
 * <p>输入：n = 7
 * <p>输出：21
 *
 * <p>示例 3：
 *
 * <p>输入：n = 0
 * <p>输出：1
 *
 * <p>提示：
 *
 * <p>    0 <= n <= 100
 *
 * <p>注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 *
 *
 * <p>通过次数134,692
 * <p>提交次数310,496
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * <p>@author: wangrui
 * <p>@date: 2021/5/9
 */
public class NCh021_offer_10_II_QingWaTiaoTaiJieWenTiLcof剑指Offer10_II青蛙跳台阶问题 {

  /**
   * <p>动态规划 f(x)=f(x−1)+f(x−2)
   * <p>复杂度分析
   *
   * <p>   时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为 O(n)。
   * <p> 空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)
   *
   * <p> 我们是从第 0 级开始爬的，所以从第 0 级爬到第 0 级我们可以看作只有一种方案，即 f(0)=1；从第 0 级到第 1 级也只有一种方案，
   * <p> 即爬一级，f(1)=1。这两个作为边界条件就可以继续向后推导出第 n 级的正确结果
   *
   * @param n
   * @return
   */
  public int numWays(int n) {
    int p = 0;//-1
    int q = 0;//-2
    int r = 1;
    for (int i = 1; i <= n; i++) {
      p = q;
      q = r;
      r = (p + q) % 1000000007;
    }
    return r;
  }

  public int numWays_2(int n) {
    if (n <= 1) {
      return 1;
    }
    int a = 1, b = 1, ans = 0;
    for (int i = 2; i <= n; i++) {
      ans = (a + b) % 1000000007;
      a = b;
      b = ans;
    }
    return ans;
  }
}
