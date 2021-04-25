package org.leetcode.leet1000.ch800;

/**
 * <p>766. 托普利茨矩阵
 *
 * <p>给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 *
 * <p>如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * <p>输出：true
 * <p>解释：
 * <p>在上述矩阵中, 其对角线为:
 * <p>"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * <p>各条对角线上的所有元素均相同, 因此答案是 True 。
 *
 * <p>示例 2：
 *
 * <p>输入：matrix = [[1,2],[2,2]]
 * <p>输出：false
 * <p>解释：
 * <p>对角线 "[1, 2]" 上的元素不同。
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == matrix.length
 * <p>    n == matrix[i].length
 * <p>    1 <= m, n <= 20
 * <p>    0 <= matrix[i][j] <= 99
 *
 *
 *
 * <p>进阶：
 *
 * <p>    如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * <p>    如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 * <p> https://leetcode-cn.com/problems/toeplitz-matrix/
 * <p>通过次数50,612
 * <p>提交次数71,417
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch766ToeplitzMatrix {

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(mn)，其中 m 为矩阵的行数，n 为矩阵的列数。矩阵中每个元素至多被访问两次。
   *
   *     空间复杂度：O(1)，我们只需要常数的空间保存若干变量。
   *
   * @param matrix
   * @return
   */
  public boolean isToeplitzMatrix(int[][] matrix) {
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }
      }
    }
    return true;
  }


  public boolean isToeplitzMatrix2(int[][] matrix) {
    int m = matrix.length, n = matrix[0].length;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] != matrix[i - 1][j - 1]) {
          return false;
        }
      }
    }
    return true;
  }}
