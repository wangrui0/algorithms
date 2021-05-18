package org.company.meituan.all.week01.done;

/**
 * <p>121. 买卖股票的最佳时机
 *
 * <p>给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * <p>你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * <p>返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[7,1,5,3,6,4]
 * <p>输出：5
 * <p>解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * <p>     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * <p>示例 2：
 *
 * <p>输入：prices = [7,6,4,3,1]
 * <p>输出：0
 * <p>解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= prices.length <= 105
 * <p>    0 <= prices[i] <= 104
 *
 * <p>通过次数443,902
 * <p>提交次数782,579
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh041_121BestTimeToBuyAndSellStock买卖股票的最佳时机 {

  /**
   * 暴力法
   *
   * @param prices
   * @return
   */
  public int maxProfit_1(int prices[]) {
    int maxprofit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit > maxprofit) {
          maxprofit = profit;
        }
      }
    }
    return maxprofit;
  }


  /**
   * 方法二：一次遍历
   * <p> 一次遍历
   * <p>  复杂度分析
   *
   * <p>   时间复杂度：O(n)，只需要遍历一次。
   * <p>  空间复杂度：O(1)，只使用了常数个变量。
   * [7,1,5,3,6,4]
   *
   * @param prices
   * @return
   */
  public int maxProfit(int prices[]) {
    int minprice = Integer.MAX_VALUE;
    int maxprofit = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minprice) {
        minprice = prices[i];
      } else if (prices[i] - minprice > maxprofit) {
        maxprofit = prices[i] - minprice;
      }
    }
    return maxprofit;
  }
}


