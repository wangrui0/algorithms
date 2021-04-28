package org.leetcode.leet2000.ch1800;

/**
 * <p>1779. 找到最近的有相同 X 或 Y 坐标的点
 *
 * <p>给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。同时，在同一个坐标系下给你一个数组 points ，其中 points[i] = [ai, bi] 表示在 (ai, bi)
 * 处有一个点。当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 *
 * <p>请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 *
 * <p>两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * <p>输出：2
 * <p>解释：所有点中，[3,1]，[2,4] 和 [4,4] 是有效点。有效点中，[2,4] 和 [4,4] 距离你当前位置的曼哈顿距离最小，都为 1 。[2,4] 的下标最小，所以返回 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：x = 3, y = 4, points = [[3,4]]
 * <p>输出：0
 * <p>提示：答案可以与你当前所在位置坐标相同。
 *
 * <p>示例 3：
 *
 * <p>输入：x = 3, y = 4, points = [[2,3]]
 * <p>输出：-1
 * <p>解释：没有有效点。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= points.length <= 104
 * <p>    points[i].length == 2
 * <p>    1 <= x, y, ai, bi <= 104
 *
 * <p>通过次数4,145
 * <p>提交次数6,475
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:10 下午
 */
public class Ch1779FindNearestPointThatHasTheSameXOrYCoordinate {


  public int nearestValidPoint(int x, int y, int[][] points) {
    int index = -1;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < points.length; i++) {
      int[] point = points[i];
      if (point[0] == x || point[1] == y) {
        int value = Math.abs(point[0] - x) + Math.abs(point[1] - y);
        if (value < min) {
          min = Math.min(min, value);
          index = i;
        }
      }
    }
    return index;
  }

  public int nearestValidPoint_2(int x, int y, int[][] points) {
    int min = 20000;
    int index = -1;
    for (int i = 0; i < points.length; ++i) {
      if (x == points[i][0] || y == points[i][1]) {
        if (min > Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y)) {
          min = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
          index = i;
        }
      }
    }
    return index;
  }
}
