package org.leetcode.shunxu.ch900;

/**
 * <p>883. 三维形体投影面积
 *
 * <p>在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 *1 *1 立方体。
 *
 * <p>每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *
 * <p>现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 *
 * <p>投影就像影子，将三维形体映射到一个二维平面上。
 *
 * <p>在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * <p>返回所有三个投影的总面积。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[[2]]
 * <p>输出：5
 *
 * <p>示例 2：
 *
 * <p>输入：[[1,2],[3,4]]
 * <p>输出：17
 * <p>解释：
 * <p>这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
 *
 * <p>示例 3：
 *
 * <p>输入：[[1,0],[0,2]]
 * <p>输出：8
 *
 * <p>示例 4：
 *
 * <p>输入：[[1,1,1],[1,0,1],[1,1,1]]
 * <p>输出：14
 *
 * <p>示例 5：
 *
 * <p>输入：[[2,2,2],[2,1,2],[2,2,2]]
 * <p>输出：21
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= grid.length = grid[0].length <= 50
 * <p>    0 <= grid[i][j] <= 50
 * <p> https://leetcode-cn.com/problems/projection-area-of-3d-shapes/
 * <p>通过次数9,246
 * <p>提交次数13,684
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch883ProjectionAreaOf3dShapes {

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N^2)，其中 N 是 grid 的长度。
   *
   * <p>     空间复杂度：O(1).
   *
   * @param grid
   * @return
   */
  public int projectionArea(int[][] grid) {
    int N = grid.length;
    int ans = 0;

    for (int i = 0; i < N; ++i) {
      int bestRow = 0;  // largest of grid[i][j]
      int bestCol = 0;  // largest of grid[j][i]
      for (int j = 0; j < N; ++j) {
        if (grid[i][j] > 0) {
          ans++;  // top shadow
        }
        bestRow = Math.max(bestRow, grid[i][j]);
        bestCol = Math.max(bestCol, grid[j][i]);
      }
      ans += bestRow + bestCol;
    }

    return ans;
  }
}
