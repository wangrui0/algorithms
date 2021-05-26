package org.company.meituan.all.week02.day02;

/**
 * <p>62. 不同路径
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * <p>问总共有多少条不同的路径？
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：m = 3, n = 7
 * <p>输出：28
 * <p>示例 2：
 *
 * <p>输入：m = 3, n = 2
 * <p>输出：3
 * <p>解释：
 * <p>从左上角开始，总共有 3 条路径可以到达右下角。
 * <p>1. 向右 -> 向下 -> 向下
 * <p>2. 向下 -> 向下 -> 向右
 * <p>3. 向下 -> 向右 -> 向下
 * <p>示例 3：
 *
 * <p>输入：m = 7, n = 3
 * <p>输出：28
 * <p>示例 4：
 *
 * <p>输入：m = 3, n = 3
 * <p>输出：6
 *
 *
 * <p>提示：
 *
 * <p>1 <= m, n <= 100
 * <p>题目数据保证答案小于等于 2 *<p>109
 * <p>通过次数250,435提交次数384,888
 * <p>请问您在哪类招聘中遇到此题？
 * <p>贡献者
 * <p>https://leetcode-cn.com/problems/unique-paths/
 * <p>LeetCode
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 7:07 下午
 */
public class Ch077_62_uniquePaths不同路径 {

  /**
   * <p>动态规划
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(mn)
   *
   * <p>   空间复杂度：O(mn)
   *
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths(int m, int n) {
    int[][] f = new int[m][n];
    for (int i = 0; i < m; ++i) {
      f[i][0] = 1;
    }
    for (int j = 0; j < n; ++j) {
      f[0][j] = 1;
    }
    for (int i = 1; i < m; ++i) {
      for (int j = 1; j < n; ++j) {
        f[i][j] = f[i - 1][j] + f[i][j - 1];
      }
    }
    return f[m - 1][n - 1];
  }

  /**
   * <p> 数学：
   * <p>  时间复杂度：O(mn)
   * <p> 空间复杂度：O(1)
   *
   * @param m
   * @param n
   * @return
   */
  public int uniquePaths_2(int m, int n) {
    long ans = 1;
    for (int x = n, y = 1; y < m; ++x, ++y) {
      ans = ans * x / y;
    }
    return (int) ans;
  }
}
