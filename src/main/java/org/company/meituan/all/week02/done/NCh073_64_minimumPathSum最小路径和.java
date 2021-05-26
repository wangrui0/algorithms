package org.company.meituan.all.week02.done;

/**
 * <p>64. 最小路径和
 * <p>给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * <p>说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * <p>输出：7
 * <p>解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>示例 2：
 *
 * <p>输入：grid = [[1,2,3],[4,5,6]]
 * <p>输出：12
 *
 *
 * <p>提示：
 *
 * <p>m == grid.length
 * <p>n == grid[i].length
 * <p>1 <= m, n <= 200
 * <p>0 <= grid[i][j] <= 100
 * <p>通过次数216,731提交次数316,593
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:41 下午
 */
public class NCh073_64_minimumPathSum最小路径和 {

  /**
   * <p>动态规划：
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(mn)，其中 m 和 n 分别是网格的行数和列数。需要对整个网格遍历一次，计算 dp 的每个元素的值。
   *
   * <p>   空间复杂度：O(mn)，其中 m 和 n 分别是网格的行数和列数。创建一个二维数组 dp，和网格大小相同。
   * <p>  空间复杂度可以优化，例如每次只存储上一行的 dp 值，则可以将空间复杂度优化到 O(n)。
   *
   * @param grid
   * @return
   */
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int rows = grid.length, columns = grid[0].length;
    int[][] dp = new int[rows][columns];
    dp[0][0] = grid[0][0];
    for (int i = 1; i < rows; i++) {
      dp[i][0] = dp[i - 1][0] + grid[i][0];
    }
    for (int j = 1; j < columns; j++) {
      dp[0][j] = dp[0][j - 1] + grid[0][j];
    }
    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
      }
    }
    return dp[rows - 1][columns - 1];
  }

  /**
   *  <p> 对于不在第一行和第一列的元素，可以从其上方相邻元素向下移动一步到达，或者从其左方相邻元素向右移动一步到达，元素对应的最小路径和等于其上方相邻元素与其左方相邻元素两者对应的最小路径和中的最小值加上当前元素的值。由于每个元素对应的最小路径和与其相邻元素对应的最小路径和有关，因此可以使用动态规划求解。
   *
   *  <p> 创建二维数组dp，与原始网格的大小相同，dp[i][j] 表示从左上角出发到 (i,j) 位置的最小路径和。显然，dp[0][0]=grid0][0]。对于 dp 中的其余元素，通过以下状态转移方程计算元素值。
   *
   *   <p>    当 i>0 且 j=0 时，dp[i][0]=dp[i−1][0]+grid[i][0]。
   *
   *   <p>    当 i=0 且 j>0 时，dp[0][j]=dp[0][j−1]+grid[0][j]。
   *
   *   <p>    当 i>0i 且 j>0 时，dp[i][j]=min⁡(dp[i−1][j],dp[i][j−1])+grid[i][j]。
   *
   *  <p> 最后得到 dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和。
   */
}
