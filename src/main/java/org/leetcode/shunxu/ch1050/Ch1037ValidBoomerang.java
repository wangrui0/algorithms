package org.leetcode.shunxu.ch1050;

/**
 * <p>1037. 有效的回旋镖
 *
 * <p>回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 *
 * <p>给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[[1,1],[2,3],[3,2]]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：[[1,1],[2,2],[3,3]]
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    points.length == 3
 * <p>    points[i].length == 2
 * <p>    0 <= points[i][j] <= 100
 *
 * <p>通过次数8,031
 * <p>提交次数18,201
 * <p>https://leetcode-cn.com/problems/valid-boomerang/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1037ValidBoomerang {

  /**
   * <p>思路
   *
   * <p>判断三点是否同直线，直接思路就是判断斜率。
   * <p>假设三点分别为a(x1, y1), b(x2, y2), c(x3,y3),
   * <p>a、b两点的斜率为 k1 = (y2 - y1) / (x2 - x1)
   * <p>a、c两点的斜率为 k2 = (y3 - y1) / (x3 - x1)
   * <p>如果在同一直线，则k1 = k2，考虑到分母为0 的情况，可以直接交叉相乘，省去判断0的情况，直接判断
   * <p>(y2 - y1) * (x3 - x1) 与 (y3 - y1) * (x2 - x1)
   * <p>不相等即为不在同一直线上
   *
   * @param points
   * @return
   */
  public boolean isBoomerang(int[][] points) {
    return (points[1][0] - points[0][0]) * (points[2][1] - points[0][1]) != (points[2][0] - points[0][0]) * (
        points[1][1] - points[0][1]);
  }

  public boolean isBoomerang_2(int[][] points) {
    return (points[1][1] - points[0][1]) * (points[2][0] - points[0][0]) != (points[2][1] - points[0][1]) * (
        points[1][0] - points[0][0]);
  }


}
