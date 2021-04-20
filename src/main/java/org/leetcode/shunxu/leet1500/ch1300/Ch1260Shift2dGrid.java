package org.leetcode.shunxu.leet1500.ch1300;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1260. 二维网格迁移
 *
 * <p>给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *
 * <p>每次「迁移」操作将会引发下述活动：
 *
 * <p>    位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * <p>    位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * <p>    位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 *
 * <p>请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * <p>输出：[[9,1,2],[3,4,5],[6,7,8]]
 *
 * <p>示例 2：
 *
 * <p>输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * <p>输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 *
 * <p>示例 3：
 *
 * <p>输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * <p>输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1260Shift2dGrid {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n⋅m⋅k)，其中 n⋅mn  是元素数量，共迁移 k 次。
   *
   * <p>   空间复杂度：O(n⋅m)。每次迁移时需要创建一个新数组。
   *
   * @param grid
   * @param k
   * @return
   */
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {

    // Repeat the transform k times.
    for (; k > 0; k--) {
      // We'll write the transform into a new 2D array.
      int[][] newGrid = new int[grid.length][grid[0].length];

      // Case #1: Move everything not in the last column.
      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length - 1; col++) {
          newGrid[row][col + 1] = grid[row][col];
        }
      }

      // Case #2: Move everything in last column, but not last row.
      for (int row = 0; row < grid.length - 1; row++) {
        newGrid[row + 1][0] = grid[row][grid[0].length - 1];
      }

      // Case #3: Move the bottom right.
      newGrid[0][0] = grid[grid.length - 1][grid[0].length - 1];

      // Update grid to be the transformed grid.
      grid = newGrid;
    }

    // Copy the grid into a list for returning.
    List<List<Integer>> result = new ArrayList<>();
    for (int[] row : grid) {
      List<Integer> listRow = new ArrayList<>();
      result.add(listRow);
      for (int v : row) {
        listRow.add(v);
      }
    }

    return result;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n⋅m⋅k)，其中 mn⋅m 是元素数量，共迁移 k 次。
   *
   * <p>   空间复杂度：取决于输入输出类型。在 LeetCode 中，取决于使用的语言。
   *
   * <p>      如果输入输出类型相同 （Python 和 C++）：O(1)，不使用额外空间。
   *
   * <p>      如果输入输出类型不同 （Java）：O(n⋅m)。创建大小为 n x m 的二维数组。
   *
   * @param grid
   * @param k
   * @return
   */
  public List<List<Integer>> shiftGrid_2(int[][] grid, int k) {

    // Repeat the transform k times.
    for (; k > 0; k--) {

      int previous = grid[grid.length - 1][grid[0].length - 1];
      for (int row = 0; row < grid.length; row++) {
        for (int col = 0; col < grid[0].length; col++) {
          int temp = grid[row][col];
          grid[row][col] = previous;
          previous = temp;
        }
      }
    }

    // Copy the grid into a list for returning.
    List<List<Integer>> result = new ArrayList<>();
    for (int[] row : grid) {
      List<Integer> listRow = new ArrayList<>();
      result.add(listRow);
      for (int v : row) {
        listRow.add(v);
      }
    }

    return result;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(n⋅m)，其中网格数量为 n⋅mn 。计算每个元素的新位置花费 O(1) 的时间。一般情况下，无法再提高其效率，因为每个元素都要移动。
   *
   * <p>   空间复杂度：O(n⋅m)，存储输出二维列表。
   *
   * @param grid
   * @param k
   * @return
   */
  public List<List<Integer>> shiftGrid_3(int[][] grid, int k) {

    int numCols = grid[0].length;
    int numRows = grid.length;

    // Setup the 2d list.
    List<List<Integer>> newGrid = new ArrayList<>();
    for (int row = 0; row < numRows; row++) {
      List<Integer> newRow = new ArrayList<>();
      newGrid.add(newRow);
      for (int col = 0; col < numCols; col++) {
        newRow.add(0);
      }
    }

    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numCols; col++) {
        //推移几列
        int newCol = (col + k) % numCols;
        //推移几行
        int wrapAroundCount = (col + k) / numCols;
        //新的行
        int newRow = (row + wrapAroundCount) % numRows;
        newGrid.get(newRow).set(newCol, grid[row][col]);
      }
    }

    return newGrid;
  }
}
