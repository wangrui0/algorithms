package org.leetcode.shunxu.ch100;

/**
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * <p>
 * 输出： 2
 * <p>
 * 解释： 有两种方法可以爬到楼顶。
 * <p>
 * 1.  1 阶 + 1 阶
 * <p>
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * <p>
 * 输出： 3
 * <p>
 * 解释： 有三种方法可以爬到楼顶。
 * <p>
 * 1.  1 阶 + 1 阶 + 1 阶
 * <p>
 * 2.  1 阶 + 2 阶
 * <p>
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/12
 */
public class Ch0070ClimbStairs {

  public static void main(String[] args) {
    System.out.println(climbStairs(45));//1836311903
    System.out.println(climbStairs2(45));//1836311903
  }

  /**
   * f(n)=f(n-1)+f(n-2)
   *
   * @param n
   * @return
   */
  public static int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    return climbStairs(n - 1) + climbStairs(n - 2);
  }

  /**
   * 方法一：动态规划
   * <p>
   * 思路和算法
   * <p>
   * 我们用 f(x) 表示爬到第 x 级台阶的方案数，考虑最后一步可能跨了一级台阶，也可能跨了两级台阶，所以我们可以列出如下式子：
   * <p>
   * f(x)=f(x−1)+f(x−2)
   * <p>
   * 它意味着爬到第 x 级台阶的方案数是爬到第 x−1 级台阶的方案数和爬到第 x−2 级台阶的方案数的和。很好理解，因为每次只能爬 1 级或 2 级，
   * <p>
   * 所以 f(x) 只能从 f(x−1) 和 f(x−2) 转移过来，而这里要统计方案总数，我们就需要对这两项的贡献求和。
   * <p>
   * 以上是动态规划的转移方程，下面我们来讨论边界条件。我们是从第 0 级开始爬的，所以从第 0 级爬到第 0 级我们可以看作只有一种方案，
   * <p>
   * 即 f(0) = 1；从第 0 级到第 1级也只有一种方案，即爬一级，f(1)=1。这两个作为边界条件就可以继续向后推导出第 n 级的正确结果。
   * <p>
   * 我们不妨写几项来验证一下，根据转移方程得到 f(2)=2，f(3)=3，f(4)=5......我们把这些情况都枚举出来，发现计算的结果是正确的。
   * <p>
   * 我们不难通过转移方程和边界条件给出一个时间复杂度和空间复杂度都是 O(n) 的实现，但是由于这里的 f(x) 只和 f(x−1) 与 f(x−2)
   * <p>
   * 有关，所以我们可以用「滚动数组思想」把空间复杂度优化成 O(1)。下面的代码中给出的就是这种实现。
   * <p>
   * =========================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：循环执行 n 次，每次花费常数的时间代价，故渐进时间复杂度为O(n)。
   * <p>
   * 空间复杂度：这里只用了常数个变量作为辅助空间，故渐进空间复杂度为 O(1)。
   * <p>
   *
   * @param n
   * @return
   */
  public static int climbStairs2(int n) {
    int p = 0, q = 0, ans = 1;
    for (int i = 1; i <= n; i++) {
      p = q;
      q = ans;
      ans = p + q;
    }
    return ans;
  }


}