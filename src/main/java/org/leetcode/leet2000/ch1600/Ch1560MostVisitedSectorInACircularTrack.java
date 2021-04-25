package org.leetcode.leet2000.ch1600;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1560. 圆形赛道上经过次数最多的扇区
 *
 * <p>给你一个整数 n 和一个整数数组 rounds 。有一条圆形赛道由 n 个扇区组成，扇区编号从 1 到 n 。现将在这条赛道上举办一场马拉松比赛，该马拉松全程由 m 个阶段组成。其中，第 i 个阶段将会从扇区 rounds[i
 * - 1] 开始，到扇区 rounds[i] 结束。举例来说，第 1 阶段从 rounds[0] 开始，到 rounds[1] 结束。
 *
 * <p>请你以数组形式返回经过次数最多的那几个扇区，按扇区编号 升序 排列。
 *
 * <p>注意，赛道按扇区编号升序逆时针形成一个圆（请参见第一个示例）。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：n = 4, rounds = [1,3,1,2]
 * <p>输出：[1,2]
 * <p>解释：本场马拉松比赛从扇区 1 开始。经过各个扇区的次序如下所示：
 * <p>1 --> 2 --> 3（阶段 1 结束）--> 4 --> 1（阶段 2 结束）--> 2（阶段 3 结束，即本场马拉松结束）
 * <p>其中，扇区 1 和 2 都经过了两次，它们是经过次数最多的两个扇区。扇区 3 和 4 都只经过了一次。
 *
 * <p>示例 2：
 *
 * <p>输入：n = 2, rounds = [2,1,2,1,2,1,2,1,2]
 * <p>输出：[2]
 *
 * <p>示例 3：
 *
 * <p>输入：n = 7, rounds = [1,3,5,7]
 * <p>输出：[1,2,3,4,5,6,7]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= n <= 100
 * <p>    1 <= m <= 100
 * <p>    rounds.length == m + 1
 * <p>    1 <= rounds[i] <= n
 * <p>    rounds[i] != rounds[i + 1] ，其中 0 <= i < m
 *
 * <p>通过次数7,707
 * <p>提交次数13,498
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/most-visited-sector-in-a-circular-track/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1560MostVisitedSectorInACircularTrack {

  /**
   * <p> 思路与算法
   *
   * <p>  由于马拉松全程只会按照同一个方向跑，中间不论跑了多少圈，对所有扇区的经过次数的贡献都是相同的。
   * <p> 因此此题的答案仅与起点和终点相关。从起点沿着逆时针方向走到终点的这部分扇区，就是经过次数最多的扇区
   *
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N)。起点和终点之间最多相距 N−1 个扇区。
   *
   * <p>    空间复杂度：O(1)。除答案数组外，我们只需常数的空间来存放若干变量。
   *
   * @param n
   * @param rounds
   * @return
   */
  public List<Integer> mostVisited(int n, int[] rounds) {
    List<Integer> ret = new ArrayList<Integer>();
    int length = rounds.length;
    int start = rounds[0], end = rounds[length - 1];
    if (start <= end) {
      for (int i = start; i <= end; i++) {
        ret.add(i);
      }
    } else { // 由于题目要求按扇区大小排序，因此我们要将区间分成两部分
      for (int i = 1; i <= end; i++) {
        ret.add(i);
      }
      for (int i = start; i <= n; i++) {
        ret.add(i);
      }
    }
    return ret;
  }


}
