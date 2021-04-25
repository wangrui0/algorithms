package org.leetcode.leet1500.ch1200;

/**
 * <p>1184. 公交站间的距离
 *
 * <p>环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * <p>环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * <p>返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：distance = [1,2,3,4], start = 0, destination = 1
 * <p>输出：1
 * <p>解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 *
 *
 *
 * <p>示例 2：
 *
 * <p>输入：distance = [1,2,3,4], start = 0, destination = 2
 * <p>输出：3
 * <p>解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
 *
 *
 *
 * <p>示例 3：
 *
 * <p>输入：distance = [1,2,3,4], start = 0, destination = 3
 * <p>输出：4
 * <p>解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 10^4
 * <p>    distance.length == n
 * <p>    0 <= start, destination < n
 * <p>    0 <= distance[i] <= 10^4
 *
 * <p>通过次数11,704
 * <p>提交次数20,100
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1184DistanceBetweenBusStops {

  public static void main(String[] args) {
    System.out.println(distanceBetweenBusStops(new int[]{1, 2, 3, 4}, 0, 3));
  }

  public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
    if (start > destination) {
      int temp = start;
      start = destination;
      destination = temp;
    }
    int sum = 0;
    int sum1 = 0;
    for (int i = 0; i < distance.length; i++) {
      sum += distance[i];
      if (i >= start && i < destination) {
        sum1 += distance[i];
      }
    }
    return Math.min(sum1, sum - sum1);
  }
}
