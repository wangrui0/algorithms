package org.leetcode.shunxu.leet1500.ch1250;

/**
 * <p>1217. 玩筹码
 *
 * <p>数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 *
 * <p>你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 *
 * <p>    将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * <p>    将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 *
 * <p>最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 *
 * <p>返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：chips = [1,2,3]
 * <p>输出：1
 * <p>解释：第二个筹码移动到位置三的代价是 1，第一个筹码移动到位置三的代价是 0，总代价为 1。
 *
 * <p>示例 2：
 *
 * <p>输入：chips = [2,2,2,3,3]
 * <p>输出：2
 * <p>解释：第四和第五个筹码移动到位置二的代价都是 1，所以最小总代价为 2。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= chips.length <= 100
 * <p>    1 <= chips[i] <= 10^9
 *
 * <p>通过次数18,669
 * <p>提交次数26,951
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 * https://leetcode-cn.com/problems/minimum-cost-to-move-chips-to-the-same-position/solution/yong-tan-xin-si-xiang-lai-zhao-gui-lu-chao-xiang-x/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1217MinimumCostToMoveChipsToTheSamePosition {

  /**
   * 偶数,或奇数，每次移动2个。到相隔的位置，然后将偶数或奇数中，最小个数的进行移动。
   *
   * @param position
   * @return
   */
  public int minCostToMoveChips(int[] position) {
    int even = 0;
    int odd = 0;
    for (int x : position) {
      if ((x & 1) == 0) {
        even++;
      } else {
        odd++;
      }
    }
    return Math.min(even, odd);
  }
}
