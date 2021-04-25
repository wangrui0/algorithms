package org.leetcode.leet1000.ch900;

/**
 * <p>892. 三维形体的表面积
 *
 * <p>给你一个 n *<p>n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。
 *
 * <p>每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * <p>放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 *
 * <p>请你返回最终这些形体的总表面积。
 *
 * <p>注意：每个形体的底面也需要计入表面积中。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：grid = [[2]]
 * <p>输出：10
 *
 * <p>示例 2：
 *
 * <p>输入：grid = [[1,2],[3,4]]
 * <p>输出：34
 *
 * <p>示例 3：
 *
 * <p>输入：grid = [[1,0],[0,2]]
 * <p>输出：16
 *
 * <p>示例 4：
 *
 * <p>输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * <p>输出：32
 *
 * <p>示例 5：
 *
 * <p>输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * <p>输出：46
 *
 *
 *
 * <p>提示：
 *
 * <p>    n == grid.length
 * <p>    n == grid[i].length
 * <p>    1 <= n <= 50
 * <p>    0 <= grid[i][j] <= 50
 *
 * <p>https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 * <p>通过次数31,573
 * <p>提交次数49,422
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch892SurfaceAreaOf3dShapes {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N^2)，其中 N 是 grid 中的行和列的数目。
   *
   * <p> 空间复杂度：O(1)。
   *
   * @param grid
   * @return
   */
  public int surfaceArea(int[][] grid) {
    int[] dr = new int[]{0, 1, 0, -1};
    int[] dc = new int[]{1, 0, -1, 0};

    int N = grid.length;
    int ans = 0;

    for (int r = 0; r < N; ++r) {
      for (int c = 0; c < N; ++c) {
        if (grid[r][c] > 0) {
          ans += 2;
          for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            int nv = 0;
            if (0 <= nr && nr < N && 0 <= nc && nc < N) {
              nv = grid[nr][nc];
            }

            ans += Math.max(grid[r][c] - nv, 0);
          }
        }
      }
    }

    return ans;
  }
}

