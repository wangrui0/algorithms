package org.leetcode.shunxu.leet1500.ch1300;

/**
 * <p>1252. 奇数值单元格的数目
 *
 * <p>给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * <p>另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * <p>对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * <p>    ri 行上的所有单元格，加 1 。
 * <p>    ci 列上的所有单元格，加 1 。
 *
 * <p>给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * <p>输出：6
 * <p>解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * <p>第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * <p>最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * <p>示例 2：
 *
 * <p>输入：m = 2, n = 2, indices = [[1,1],[0,0]]
 * <p>输出：0
 * <p>解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= m, n <= 50
 * <p>    1 <= indices.length <= 100
 * <p>    0 <= ri < m
 * <p>    0 <= ci < n
 * <p>https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
 *
 *
 * <p>进阶：你可以设计一个时间复杂度为 O(n + m + indices.length) 且仅用 O(n + m) 额外空间的算法来解决此问题吗？
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1252CellsWithOddValuesInAMatrix {


  public static int oddCells2(int m, int n, int[][] indices) {
    int[] row = new int[m];
    int[] col = new int[n];
    for (int[] indice : indices) {
      row[indice[0]]++;
      col[indice[1]]++;
    }
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if ((row[i] + col[j]) % 2 != 0) {
          ans++;
        }
      }
    }
    return ans;

  }

}
