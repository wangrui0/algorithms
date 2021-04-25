package org.leetcode.leet1000.ch900;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>874. 模拟行走机器人
 *
 * <p>机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 *
 * <p>    -2 ：向左转 90 度
 * <p>    -1 ：向右转 90 度
 * <p>    1 <= x <= 9 ：向前移动 x 个单位长度
 *
 * <p>在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 *
 * <p>机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 *
 * <p>返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 *
 *
 * <p>注意：
 *
 * <p>    北表示 +Y 方向。
 * <p>    东表示 +X 方向。
 * <p>    南表示 -Y 方向。
 * <p>    西表示 -X 方向。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：commands = [4,-1,3], obstacles = []
 * <p>输出：25
 * <p>解释：
 * <p>机器人开始位于 (0, 0)：
 * <p>1. 向北移动 4 个单位，到达 (0, 4)
 * <p>2. 右转
 * <p>3. 向东移动 3 个单位，到达 (3, 4)
 * <p>距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 *
 * <p>示例 2：
 *
 * <p>输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * <p>输出：65
 * <p>解释：机器人开始位于 (0, 0)：
 * <p>1. 向北移动 4 个单位，到达 (0, 4)
 * <p>2. 右转
 * <p>3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * <p>4. 左转
 * <p>5. 向北走 4 个单位，到达 (1, 8)
 * <p>距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= commands.length <= 104
 * <p>    commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * <p>    0 <= obstacles.length <= 104
 * <p>    -3 *104 <= xi, yi <= 3 *104
 * <p>    答案保证小于 231
 * <p> https://leetcode-cn.com/problems/walking-robot-simulation/
 * <p>通过次数16,397
 * <p>提交次数40,044
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch874WalkingRobotSimulation {

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N+K)，其中 N,K 分别是 commands 和 obstacles 的长度。
   * <p>   空间复杂度：O(K)，用于存储 obstacleSet 而使用的空间。
   * <p> 注意该加括号的一定要加括号
   *
   * @param commands
   * @param obstacles
   * @return
   */
  public int robotSim(int[] commands, int[][] obstacles) {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int x = 0, y = 0, di = 0;

    // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)
    //2^16=65536
    Set<Long> obstacleSet = new HashSet();
    for (int[] obstacle : obstacles) {
      long ox = (long) obstacle[0] + 30000;
      long oy = (long) obstacle[1] + 30000;
      obstacleSet.add((ox << 16) + oy);
    }

    int ans = 0;
    for (int cmd : commands) {
      if (cmd == -2)  //left
      {
        di = (di + 3) % 4;
      } else if (cmd == -1)  //right
      {
        di = (di + 1) % 4;
      } else {
        for (int k = 0; k < cmd; ++k) {
          int nx = x + dx[di];
          int ny = y + dy[di];
          long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
          if (!obstacleSet.contains(code)) {
            x = nx;
            y = ny;
            ans = Math.max(ans, x * x + y * y);
          }
        }
      }
    }

    return ans;
  }

  public int robotSim2(int[] commands, int[][] obstacles) {
    // 存储方向为北、东、南、西时，机器人走一步的坐标变化，按照顺时针存储
    // 如：向北走一步，则x + 0，y + 1；向东走一步，则x + 1，y + 0
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    // 初始坐标：(0,0)，初始方向：正北
    int x = 0, y = 0, di = 0;

    // Encode obstacles (x, y) as (x+30000) * (2^16) + (y+30000)

    // 为什么long?
    // 因为-30000 <= obstacle[i][0] <= 30000 -30000 <= obstacle[i][1] <= 30000，
    // 而2^16=65536,所以obstacle[0] + 30000用16位存储足矣，
    // 高16位存储obstacle[0] + 30000，低16位存储obstacle[1] + 30000
    // Java int是32位，最高位是符号位，显然存不下两个16位，所以用long

    // 为什么用set呢？
    // 其实就是为了用HashSet，使用hash取值，时间复杂度是O(1),
    // 不然每次判断障碍物都需要遍历obstacles，复杂度是O(n)，
    // 而0 <= obstacles.length <= 10000，遍历的话，每一步就是10000次，所以官方题解说
    // "必须注意使用 集合 Set 作为对障碍物使用的数据结构，以便我们可以有效地检查下一步是否受阻。如果不这样做，我们检查 该点是障碍点吗 可能会慢大约 10000 倍。"
    Set<Long> obstacleSet = new HashSet();
    for (int[] obstacle : obstacles) {
      long ox = (long) obstacle[0] + 30000;
      long oy = (long) obstacle[1] + 30000;
      obstacleSet.add((ox << 16) + oy);
    }

    int ans = 0;
    for (int cmd : commands) {
      if (cmd == -2)  //left 左转，相当于右转三次
      {
        di = (di + 3) % 4;
      } else if (cmd == -1)  //right 右转
      {
        di = (di + 1) % 4;
      } else {
        for (int k = 0; k < cmd; ++k) {
          // 计算下一步的坐标
          int nx = x + dx[di];
          int ny = y + dy[di];
          // 此处下一步移动到的点的坐标用同样的方式计算code，判断是否是障碍物，不是则计算最大欧式距离的平方
          long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
          if (!obstacleSet.contains(code)) {
            // 真正走到这一步
            x = nx;
            y = ny;
            ans = Math.max(ans, x * x + y * y);
          }
        }
      }
    }

    return ans;
  }
}


