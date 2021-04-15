package org.leetcode.shunxu.ch1250;

/**
 * <p>1232. 缀点成线
 *
 * <p>在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * <p>请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= coordinates.length <= 1000
 * <p>    coordinates[i].length == 2
 * <p>    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * <p>    coordinates 中不含重复的点
 *
 * <p>通过次数31,773
 * <p>提交次数67,732
 * <p>请问您在哪类招聘中遇到此题？
 * https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1232CheckIfItIsAStraightLine {

  /**
   * <p>方法一：数学
   *
   * <p>思路
   *
   * <p> 记数组 coordinates\textit{coordinates}coordinates 中的点为 P0,P1,…,Pn−1P_0, P_1, \dots,
   * P_{n-1}P0​,P1​,…,Pn−1​。为方便后续计算，将所有点向 (−P0x,−P0y)(-P_{0x}, -P_{0y})(−P0x​,−P0y​) 方向平移。记平移后的点为 P0′,P1′,…,Pn−1′P_0',
   * P_1', \dots, P_{n-1}'P0′​,P1′​,…,Pn−1′​，其中 Pi′=(Pix−P0x,Piy−P0y)P_i'=(P_{ix}-P_{0x},
   * P_{iy}-P_{0y})Pi′​=(Pix​−P0x​,Piy​−P0y​)，P0′P_0'P0′​ 位于坐标系原点 OOO 上。
   *
   * <p>由于经过两点的直线有且仅有一条，我们以 P0′P_0'P0′​ 和 P1′P_1'P1′​ 来确定这条直线。
   *
   * <p>因为 P0′P_0'P0′​ 位于坐标系原点 OOO 上，直线过原点，故设其方程为 Ax+By=0Ax+By=0Ax+By=0，将 P1′P_1'P1′​ 坐标代入可得
   * A=P1y′,B=−P1x′A=P_{1y}',B=-P_{1x}'A=P1y′​,B=−P1x′​.
   *
   * <p>然后依次判断 P2′,…,Pn−1′P_2', \dots, P_{n-1}'P2′​,…,Pn−1′​ 是否在这条直线上，将其坐标代入直线方程即可。
   *
   * @param coordinates
   * @return
   */
  public boolean checkStraightLine(int[][] coordinates) {
    int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
    int n = coordinates.length;
    for (int i = 0; i < n; i++) {
      coordinates[i][0] -= deltaX;
      coordinates[i][1] -= deltaY;
    }
    int A = coordinates[1][1], B = -coordinates[1][0];
    for (int i = 2; i < n; i++) {
      int x = coordinates[i][0], y = coordinates[i][1];
      if (A * x + B * y != 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkStraightLine_self(int[][] coordinates) {
    int x = coordinates[0][0], y = coordinates[0][1];
    for (int i = 0; i < coordinates.length; i++) {
      coordinates[i][0] -= x;
      coordinates[i][1] -= y;
    }
    int A = coordinates[1][0], B = coordinates[1][1];
    for (int i = 2; i < coordinates.length; i++) {
      if (coordinates[i][0] * B - coordinates[i][1] * A != 0) {
        return false;
      }
    }
    return true;
  }
}
