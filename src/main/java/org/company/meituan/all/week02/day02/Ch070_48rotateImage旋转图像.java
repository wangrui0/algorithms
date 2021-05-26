package org.company.meituan.all.week02.day02;

/**
 * <p>48. 旋转图像
 * <p>给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * <p>你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>示例 2：
 *
 *
 * <p>输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * <p>输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * <p>示例 3：
 *
 * <p>输入：matrix = [[1]]
 * <p>输出：[[1]]
 * <p>示例 4：
 *
 * <p>输入：matrix = [[1,2],[3,4]]
 * <p>输出：[[3,1],[4,2]]
 *
 *
 * <p>提示：
 *
 * <p>matrix.length == n
 * <p>matrix[i].length == n
 * <p>1 <= n <= 20
 * <p>-1000 <= matrix[i][j] <= 1000
 * <p>通过次数172,459提交次数236,873
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/rotate-image/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:36 下午
 */
public class Ch070_48rotateImage旋转图像 {

  /**
   * <p>方法一：使用辅助数组
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N^2)，
   *
   * <p> 空间复杂度：O(N^2)
   *
   * @param matrix
   */
  public void rotate_1(int[][] matrix) {
    int n = matrix.length;
    int[][] matrix_new = new int[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        matrix_new[j][n - i - 1] = matrix[i][j];
      }
    }
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        matrix[i][j] = matrix_new[i][j];
      }
    }
  }

  /**
   * 方法二：原地旋转
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N^2)
   *
   * <p> 空间复杂度：O(1)
   *
   * @param matrix
   */
  public void rotate_2(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n / 2; ++i) {
      for (int j = 0; j < (n + 1) / 2; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - j - 1][i];
        matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
        matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
        matrix[j][n - i - 1] = temp;
      }
    }
  }

  /**
   * 方法三：用翻转代替旋转
   * <p>    时间复杂度：O(N^2)
   *
   * <p> 空间复杂度：O(1)
   *
   * @param matrix
   */
  public void rotate_3(int[][] matrix) {
    int n = matrix.length;
    // 水平翻转
    for (int i = 0; i < n / 2; ++i) {
      for (int j = 0; j < n; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - i - 1][j];
        matrix[n - i - 1][j] = temp;
      }
    }
    // 主对角线翻转
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < i; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
  }
}
