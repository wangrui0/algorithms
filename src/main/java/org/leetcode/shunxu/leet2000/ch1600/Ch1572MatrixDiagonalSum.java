package org.leetcode.shunxu.leet2000.ch1600;

/**
 *<p>1572. 矩阵对角线元素的和
 *
 *<p>给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
 *
 *<p>请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
 *
 *
 *
 *<p>示例  1：
 *
 *<p>输入：mat = [[1,2,3],
 *<p>            [4,5,6],
 *<p>            [7,8,9]]
 *<p>输出：25
 *<p>解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 *<p>请注意，元素 mat[1][1] = 5 只会被计算一次。
 *
 *<p>示例  2：
 *
 *<p>输入：mat = [[1,1,1,1],
 *<p>            [1,1,1,1],
 *<p>            [1,1,1,1],
 *<p>            [1,1,1,1]]
 *<p>输出：8
 *
 *<p>示例 3：
 *
 *<p>输入：mat = [[5]]
 *<p>输出：5
 *
 *
 *
 *<p>提示：
 *
 *<p>    n == mat.length == mat[i].length
 *<p>    1 <= n <= 100
 *<p>    1 <= mat[i][j] <= 100
 *
 *<p>通过次数15,561
 *<p>提交次数19,320
 *<p>请问您在哪类招聘中遇到此题？
 *<p>https://leetcode-cn.com/problems/matrix-diagonal-sum/
 *<p>@author: wangrui
 *<p>@date: 2021/4/22
 */
public class Ch1572MatrixDiagonalSum {
  public int diagonalSum_self(int[][] mat) {
    //11  22  33
    //03  12  22 30
    int ans = 0;
    for (int i = 0; i < mat.length; i++) {
      ans += mat[i][i];
      if (i != mat.length - 1 - i) {
        ans += mat[i][mat.length - 1 - i];
      }
    }
    return ans;
  }

  /**
   * <p>方法一：遍历
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n^2)，其中 n 是矩阵 mat 的边长。
   * <p>   空间复杂度：O(1)。
   *
   * @param mat
   * @return
   */
  public int diagonalSum_1(int[][] mat) {
    int n = mat.length, sum = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == j || i + j == n - 1) {
          sum += mat[i][j];
        }
      }
    }
    return sum;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：O(n)，其中 n 是矩阵 mat 的边长。
   * <p>   空间复杂度：O(1)。
   *
   * @param mat
   * @return
   */
  public int diagonalSum_2(int[][] mat) {
    int n = mat.length, sum = 0, mid = n / 2;
    for (int i = 0; i < n; ++i) {
      sum += mat[i][i] + mat[i][n - 1 - i];
    }
    return sum - mat[mid][mid] * (n & 1);
  }
}
