package org.leetcode.shunxu.ch500;

/**
 * <p>463. 岛屿的周长
 *
 * <p>给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 *
 * <p>网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * <p>岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * <p>输出：16
 * <p>解释：它的周长是上面图片中的 16 个黄色的边
 *
 * <p>示例 2：
 *
 * <p>输入：grid = [[1]]
 * <p>输出：4
 *
 * <p>示例 3：
 *
 *
 *
 * <p>输入：grid = [[1,0]]
 * <p>输出：4
 *
 *
 *
 * <p>提示：
 *
 *
 * <p>    row == grid.length
 * <p>    col == grid[i].length
 * <p>   1 <= row, col <= 100
 * <p>   grid[i][j] 为 0 或 1
 *
 *
 * <p>通过次数62,784
 * <p>提交次数87,858
 * <p>https://leetcode-cn.com/problems/island-perimeter/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch463IslandPerimeter {

  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {1, 0, -1, 0};

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(nm)，其中 n 为网格的高度，m 为网格的宽度。我们需要遍历每个格子，每个格子要看其周围 444 个格子是否为岛屿，因此总时间复杂度为 O(4nm)=O(nm)。
   *
   * <p>   空间复杂度：O(1)。只需要常数空间存放若干变量
   *
   * @param grid
   * @return
   */
  public int islandPerimeter(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (grid[i][j] == 1) {
          int cnt = 0;
            for (int k = 0; k < 4; ++k) {
            int tx = i + dx[k];
            int ty = j + dy[k];
            if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
              cnt += 1;
            }
          }
          ans += cnt;
        }
      }
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(nm)，其中 n 为网格的高度，m 为网格的宽度。每个格子至多会被遍历一次，因此总时间复杂度为 O(nm)。
   *
   * <p>空间复杂度：O(nm)。深度优先搜索复杂度取决于递归的栈空间，而栈空间最坏情况下会达到 O(nm)。
   *
   * @param grid
   * @return
   */
  public int islandPerimeter2(int[][] grid) {
    int n = grid.length, m = grid[0].length;
    int ans = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (grid[i][j] == 1) {
          ans += dfs(i, j, grid, n, m);
        }
      }
    }
    return ans;
  }

  public int dfs(int x, int y, int[][] grid, int n, int m) {
    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
      return 1;
    }
    if (grid[x][y] == 2) {
      return 0;
    }
    grid[x][y] = 2;
    int res = 0;
    for (int i = 0; i < 4; ++i) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      res += dfs(tx, ty, grid, n, m);
    }
    return res;
  }

}