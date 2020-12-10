package org.leetcode.easy;

/**
 * <p>买卖股票的最佳时机
 *
 * <p> 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * <p> 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * <p> 注意：你不能在买入股票前卖出股票。
 *
 * <p> 示例 1:
 *
 * <p> 输入: [7,1,5,3,6,4]
 * <p> 输出: 5
 * <p> 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * <p>      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p> 示例 2:
 *
 * <p> 输入: [7,6,4,3,1]
 * <p> 输出: 0
 * <p> 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p> 通过次数320,725提交次数580,965
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/27
 */
public class Ch0121BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    System.out.println(maxProfit2(new int[]{7, 6, 4, 3, 1}));
  }

  public static int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = 1; j < prices.length; j++) {
        if (i != j && prices[i] < prices[j] && i < j) {
          int sub = prices[j] - prices[i];
          if (max < sub) {
            max = sub;
          }
        }
      }
    }
    return max;
  }

  /**
   * 官方
   *
   * @param prices
   * @return
   */
  public static int maxProfit2(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
      for (int j = i + 1; j < prices.length; j++) {
        if (prices[i] < prices[j]) {
          int sub = prices[j] - prices[i];
          if (max < sub) {
            max = sub;
          }
        }
      }
    }
    return max;
  }

  /**
   * [7,1,5,3,6,4]
   *
   * @param prices
   * @return
   */
  public static int maxProfit3(int[] prices) {
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

  /**
   * [7,1,5,3,6,4]
   *
   * @param prices
   * @return
   */
  public static int maxProfit4(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfile = 0;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfile) {
        maxProfile = prices[i] - minPrice;

      }
    }
    return maxProfile;
  }
}