package org.leetcode.shunxu.leet2000.ch1550;

/**
 * <p>1518. 换酒问题
 *
 * <p>小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 *
 * <p>如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 *
 * <p>请你计算 最多 能喝到多少瓶酒。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：numBottles = 9, numExchange = 3
 * <p>输出：13
 * <p>解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * <p>所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 *
 * <p>示例 2：
 *
 * <p>输入：numBottles = 15, numExchange = 4
 * <p>输出：19
 * <p>解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * <p>所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 *
 * <p>示例 3：
 *
 * <p>输入：numBottles = 5, numExchange = 5
 * <p>输出：6
 *
 * <p>示例 4：
 *
 * <p>输入：numBottles = 2, numExchange = 3
 * <p>输出：2
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= numBottles <= 100
 * <p>    2 <= numExchange <= 100
 *
 * <p>通过次数21,030
 * <p>提交次数31,160
 *
 * <p>https://leetcode-cn.com/problems/water-bottles/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1518WaterBottles {

  public static int numWaterBottles(int numBottles, int numExchange) {
    int ans = numBottles;
    while (numBottles / numExchange > 0) {
      ans += (numBottles / numExchange);
      numBottles = numBottles % numExchange + numBottles / numExchange;
    }
    return ans;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(b/e)。因为 e≥2e ，而循环迭代时，每次 b 的变化为 e−1，故这里的渐进上界为 O(b/e)。
   * <p>   空间复杂度：O(1)。
   *
   * @param numBottles
   * @param numExchange
   * @return
   */
  public int numWaterBottles_2(int numBottles, int numExchange) {
    int bottle = numBottles, ans = numBottles;
    while (bottle >= numExchange) {
      bottle -= numExchange;
      ++ans;
      ++bottle;
    }
    return ans;
  }
  /**
   * <p>   第一步，首先我们一定可以喝到 b 瓶酒，剩下 b 个空瓶。
   *
   * <p>  第二步，接下来我们来考虑空瓶换酒，换完再喝，喝完再换的过程——每次换到一瓶酒就意味着多一个空瓶，所以每次损失的瓶子的数量为 e−1，我们要知道这个过程能得到多少瓶酒，即希望知道第一个打破下面这个条件的 n 是多少：
   *
   * <p>   b−n(e−1)≥e
   *
   * <p>   即我们要找到最小的 n 使得：
   *
   * <p>  b−n(e−1)<e
   *
   * <p>  我们得到 nmin⁡=⌊(b−e/e−1)+1⌋。
   *
   * <p>  当然我们要特别注意这里的前提条件是 b≥e，试想如果 b<e，没有足够的瓶子再换酒了，就不能进行第二步了。
   * <p>  复杂度分析
   *
   * <p>  时间复杂度：O(1)。
   * <p>  空间复杂度：O(1)。
   *
   * @param numBottles
   * @param numExchange
   * @return
   */
  public int numWaterBottles_3(int numBottles, int numExchange) {
    return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
  }


}
