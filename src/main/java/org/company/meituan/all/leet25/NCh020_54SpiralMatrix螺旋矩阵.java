package org.company.meituan.all.leet25;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>54. 螺旋矩阵
 *
 * <p>给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * <p>输出：[1,2,3,6,9,8,7,4,5]
 *
 * <p>示例 2：
 *
 * <p>输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * <p>输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == matrix.length
 * <p>    n == matrix[i].length
 * <p>    1 <= m, n <= 10
 * <p>    -100 <= matrix[i][j] <= 100
 *
 * <p>通过次数151,940
 * <p>提交次数324,476
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/spiral-matrix/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class NCh020_54SpiralMatrix螺旋矩阵 {

  /**
   * <p> 方法一：模拟
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(mn)，其中 m 和 n 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
   *
   * <p>   空间复杂度：O(mn)。需要创建一个大小为 m×n 的矩阵 visited 记录每个位置是否被访问过。
   *
   * @param matrix
   * @return
   */
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> order = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return order;
    }
    int rows = matrix.length, columns = matrix[0].length;
    boolean[][] visited = new boolean[rows][columns];
    int total = rows * columns;
    int row = 0, column = 0;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int directionIndex = 0;
    for (int i = 0; i < total; i++) {
      order.add(matrix[row][column]);
      visited[row][column] = true;
      int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
      if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
        directionIndex = (directionIndex + 1) % 4;
      }
      row += directions[directionIndex][0];
      column += directions[directionIndex][1];
    }
    return order;
  }

  /**
   * <p>  方法二：按层模拟
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(mn)，其中 m 和 n 分别是输入矩阵的行数和列数。矩阵中的每个元素都要被访问一次。
   *
   * <p> 空间复杂度：O(1)。除了输出数组以外，空间复杂度是常数
   *
   * @param matrix
   * @return
   */
  public List<Integer> spiralOrder_2(int[][] matrix) {
    List<Integer> order = new ArrayList<Integer>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return order;
    }
    int rows = matrix.length, columns = matrix[0].length;
    int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
    while (left <= right && top <= bottom) {
      for (int column = left; column <= right; column++) {
        order.add(matrix[top][column]);
      }
      for (int row = top + 1; row <= bottom; row++) {
        order.add(matrix[row][right]);
      }
      if (left < right && top < bottom) {
        for (int column = right - 1; column > left; column--) {
          order.add(matrix[bottom][column]);
        }
        for (int row = bottom; row > top; row--) {
          order.add(matrix[row][left]);
        }
      }
      left++;
      right--;
      top++;
      bottom--;
    }
    return order;
  }


}
