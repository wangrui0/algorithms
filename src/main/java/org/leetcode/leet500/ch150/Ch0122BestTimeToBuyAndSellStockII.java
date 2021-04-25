package org.leetcode.leet500.ch150;


/**
 * <p>买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 *  
 *
 * <p> 示例 1:
 *
 * <p> 输入: [7,1,5,3,6,4]
 * <p> 输出: 7
 * <p> 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * <p>      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * <p> 示例 2:
 *
 * <p> 输入: [1,2,3,4,5]
 * <p> 输出: 4
 * <p> 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * <p>      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * <p>      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * <p> 示例 3:
 *
 * <p> 输入: [7,6,4,3,1]
 * <p> 输出: 0
 * <p> 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * <p> 提示：
 *
 * <p> 1 <= prices.length <= 3 * 10 ^ 4
 * <p> 0 <= prices[i] <= 10 ^ 4
 * <p> 通过次数265,591提交次数407,000
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/28
 */
public class Ch0122BestTimeToBuyAndSellStockII {

  public static void main(String[] args) {
    String str="13你1好";
    for (int i = 0; i <str.length() ; i++) {
      System.out.println(str.charAt(i));
    }
  }

  /**
   * 方法一：动态规划
   *
   * 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
   *
   * 定义状态 dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润，dp[i][1] 表示第 ii 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
   *
   * 考虑 dp[i][0] 的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即 dp[i−1][0]，或者前一天结束的时候手里持有一支股票，即 dp[i−1][1]，这时候我们要将其卖出，并获得 prices[i] 的收益。因此为了收益最大化，我们列出如下的转移方程：
   *
   * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
   *
   * 再来考虑 dp[i][1]，按照同样的方式考虑转移状态，那么可能的转移状态为前一天已经持有一支股票，即 dp[i−1][1]，或者前一天结束时还没有股票，即 dp[i−1][0]，这时候我们要将其买入，并减少 prices[i] 的收益。可以列出如下的转移方程：
   *
   * dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
   *
   * 对于初始状态，根据状态定义我们可以知道第 0 天交易结束的时候 dp[0][0]=0，dp[0][1]=−prices[0]。
   *
   * 因此，我们只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，因此这时候 dp[n−1][0] 的收益必然是大于 dp[n−1][1] 的，最后的答案即为 dp[n−1][0]。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * =========================================
   * 复杂度分析
   *
   * 时间复杂度：O(n)，其中 n 为数组的长度。一共有 2n 个状态，每次状态转移的时间复杂度为 O(1)，因此时间复杂度为 O(2n)=O(n)。
   *
   * 空间复杂度：O(n)。我们需要开辟 O(n) 空间存储动态规划中的所有状态。如果使用空间优化，空间复杂度可以优化至 O(1)。
   *
   * @param prices
   * @return
   */
  public int maxProfit(int[] prices) {
    int n = prices.length;
    //第0天，不持有股票钱为0；第一天持有股票，钱为-prices[0]
    int dp0 = 0, dp1 = -prices[0];
    for (int i = 1; i < n; ++i) {
      int newDp0 = Math.max(dp0, dp1 + prices[i]);
      int newDp1 = Math.max(dp1, dp0 - prices[i]);
      dp0 = newDp0;
      dp1 = newDp1;
    }
    return dp0;
  }

  /**
   * 贪心算法
   * @param prices
   * @return
   */
  public int maxProfit2(int[] prices) {
    int ans = 0;
    int n = prices.length;
    for (int i = 1; i < n; ++i) {
      ans += Math.max(0, prices[i] - prices[i - 1]);
    }
    return ans;
  }

  public int maxProfit3(int[] prices) {
    int ans=0;
    int n=prices.length;
    for (int i = 1; i <n ; i++) {
      ans+= Math.max(0,prices[i]-prices[i-1]);
    }
    return ans;
  }

}
