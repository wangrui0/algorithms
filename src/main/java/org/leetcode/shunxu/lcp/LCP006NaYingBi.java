package org.leetcode.shunxu.lcp;

/**
 * <p>LCP 06. 拿硬币
 *
 * <p>桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * <p>示例 1：
 *
 * <p>    输入：[4,2,1]
 *
 * <p>    输出：4
 *
 * <p>    解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * <p>示例 2：
 *
 * <p>    输入：[2,3,10]
 *
 * <p>    输出：8
 *
 * <p>限制：
 *
 * <p>    1 <= n <= 4
 * <p>    1 <= coins[i] <= 10
 *
 * <p>通过次数35,115
 * <p>提交次数41,872
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/31
 */
public class LCP006NaYingBi {

  public static int minCount_self(int[] coins) {
    int num = 0;
    for (int coin : coins) {
      while (coin > 0) {
        num++;
        if (coin / 2 > 0) {
          coin -= 2;
        } else {
          coin--;
        }
      }
    }
    return num;
  }

  /**
   * <p> 非常好
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N)。遍历一次硬币数组，n为硬币堆数。
   * <p>    空间复杂度：O(1)。只使用了变量count存储拿取次数。
   *
   * @param coins
   * @return
   */
  public int minCount(int[] coins) {
    int count = 0;
    for (int coin : coins) {
      //右移一位相当于除以2，和1按位与相当于除2取余
      count += (coin >> 1) + (coin & 1);
    }
    return count;
  }
}
