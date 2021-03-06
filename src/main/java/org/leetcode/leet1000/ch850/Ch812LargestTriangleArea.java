package org.leetcode.leet1000.ch850;

/**
 * <p>812. 最大三角形面积
 *
 * <p>给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * <p>示例:
 * <p>输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * <p>输出: 2
 * <p>解释:
 * <p>这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 *
 * <p>注意:
 *
 * <p>    3 <= points.length <= 50.
 * <p>    不存在重复的点。
 * <p>     -50 <= points[i][j] <= 50.
 * <p>    结果误差值在 10^-6 以内都认为是正确答案。
 *
 * <p>通过次数9,070
 * <p>提交次数14,578
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/largest-triangle-area/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch812LargestTriangleArea {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N^3)，其中 N 是数组 points 的长度。
   *
   * <p>    空间复杂度：O(1)。
   *
   * @param points
   * @return
   */
  public double largestTriangleArea(int[][] points) {
    int N = points.length;
    double ans = 0;
    for (int i = 0; i < N; ++i) {
      for (int j = i + 1; j < N; ++j) {
        for (int k = j + 1; k < N; ++k) {
          ans = Math.max(ans, area(points[i], points[j], points[k]));
        }
      }
    }
    return ans;
  }

  public double area(int[] P, int[] Q, int[] R) {
    return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1]
        - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
  }
}
