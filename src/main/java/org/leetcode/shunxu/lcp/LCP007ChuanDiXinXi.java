package org.leetcode.shunxu.lcp;

/**
 * <p>LCP 07. 传递信息
 *
 * <p>小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 *
 * <p>    有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * <p>    每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * <p>    每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 *
 * <p>给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * <p>示例 1：
 *
 * <p>    输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 *
 * <p>    输出：3
 *
 * <p>    解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 *
 * <p>示例 2：
 *
 * <p>    输入：n = 3, relation = [[0,2],[2,1]], k = 2
 *
 * <p>    输出：0
 *
 * <p>    解释：信息不能从小 A 处经过 2 轮传递到编号 2
 *
 * <p>限制：
 *
 * <p>    2 <= n <= 10
 * <p>    1 <= k <= 5
 * <p>    1 <= relation.length <= 90, 且 relation[i].length == 2
 * <p>    0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 * <p>  https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * <p>通过次数7,821
 * <p>提交次数12,390
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/31
 */
public class LCP007ChuanDiXinXi {

  /**
   * <p> 方法二：动态规划
   *
   * <p> 我们用 dp[i][j] 表示数组的第 i 轮传递给编号 j 的人的方案数。
   * <p> 若能传递给编号 y 玩家的所有玩家编号 x1,x2,x3... , 则第 i+1 轮传递信息给编号 y 玩家的递推方程为
   * <p>dp[i+1][y] = sum(dp[i][x1],dp[i][x2],dp[i][x3]...)，
   * <p>其递推形式即
   * <p>dp[i+1][y] += dp[i][x]
   * <p>n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
   * =========================
   * <p>复杂度分析
   * <p>    时间复杂度：O(k * n^2)。
   * <p>   空间复杂度：O(k∗n)。
   *
   * @param n
   * @param relation
   * @param k
   * @return
   */
  public int numWays(int n, int[][] relation, int k) {
    int[][] dp = new int[k + 1][n];
    dp[0][0] = 1;
    for (int i = 1; i <= k; i++) {
      for (int[] pos : relation) {
        //0:是起始位置；1:是结束位置
        dp[i][pos[1]] += dp[i - 1][pos[0]];
      }
    }
    return dp[k][n - 1];
  }

  /**
   * <p> 方法三：动态规划 + 空间优化
   * <p> 由于方法二中的每一轮的状态数推导 dp[i+1][...]，只和 dp[i][...] 有关，因此可以用两个一维数组优化动态规划的空间复杂度。
   *
   * @param n
   * @param relation
   * @param k
   * @return
   */
  public static int numWays_2(int n, int[][] relation, int k) {
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 1; i <= k; i++) {
      int[] array = new int[n];
      for (int[] pos : relation) {
        //0:是起始位置；1:是结束位置
        array[pos[1]] += dp[pos[0]];
      }
      dp = array;
    }
    return dp[n - 1];
  }
}

