package org.leetcode.shunxu.ch1050;

import java.util.PriorityQueue;

/**
 * <p>1046. 最后一块石头的重量
 *
 * <p>有一堆石头，每块石头的重量都是正整数。
 *
 * <p>每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * <p>    如果 x == y，那么两块石头都会被完全粉碎；
 * <p>    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 * <p>最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：[2,7,4,1,8,1]
 * <p>输出：1
 * <p>解释：
 * <p>先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * <p>再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * <p>接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * <p>最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= stones.length <= 30
 * <p>    1 <= stones[i] <= 1000
 *
 * <p>通过次数56,612
 * <p>提交次数86,001
 * <p>https://leetcode-cn.com/problems/last-stone-weight/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1046LastStoneWeight {

  /**
   * <p> 方法一：最大堆
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(nlogn)，其中 n 是石头数量。每次从队列中取出元素需要花费 O(logn) 的时间，最多共需要粉碎 n−1 次石头。
   *
   * <p>  空间复杂度：O(n)
   *
   * @param stones
   * @return
   */
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
    for (int stone : stones) {
      pq.offer(stone);
    }

    while (pq.size() > 1) {
      int a = pq.poll();
      int b = pq.poll();
      if (a > b) {
        pq.offer(a - b);
      }
    }
    return pq.isEmpty() ? 0 : pq.poll();
  }


}
