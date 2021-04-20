package org.leetcode.shunxu.leet1000.ch900;

/**
 * <p>867. 转置矩阵
 *
 * <p>给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * <p>矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * <p>示例 2：
 *
 * <p>输入：matrix = [[1,2,3],[4,5,6]]
 * <p>输出：[[1,4],[2,5],[3,6]]
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == matrix.length
 * <p>    n == matrix[i].length
 * <p>    1 <= m, n <= 1000
 * <p>    1 <= m *<p>n <= 105
 * <p>    -109 <= matrix[i][j] <= 109
 * <p>https://leetcode-cn.com/problems/transpose-matrix/
 * <p>通过次数76,500
 * <p>提交次数113,336
 * <p>在真实的面试中遇到过这道题？
 * <p>贡献者
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch867TransposeMatrix {

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(mn)，其中 m 和 n 分别是矩阵 matrix 的行数和列数。需要遍历整个矩阵，并对转置后的矩阵进行赋值操作。
   *
   * <p>    空间复杂度：O(1)。除了返回值以外，额外使用的空间为常数。
   *
   * @param matrix
   * @return
   */
  public int[][] transpose(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    int[][] transposed = new int[n][m];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        transposed[j][i] = matrix[i][j];
      }
    }
    return transposed;
  }
}
