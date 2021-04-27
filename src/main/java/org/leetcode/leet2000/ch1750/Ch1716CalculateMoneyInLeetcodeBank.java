package org.leetcode.leet2000.ch1750;

/**
 * 1716. 计算力扣银行的钱
 * <p>
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * <p>
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * <p>
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4 输出：10 解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 10 输出：37 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 20 输出：96 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) =
 * 96 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 通过次数5,809 提交次数8,532 请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 *
 * @Author: shenpei
 * @Date: 2021/4/25 9:58 下午
 */
public class Ch1716CalculateMoneyInLeetcodeBank {

  public static int totalMoney_1(int n) {
    int money = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      if (i % 7 == 0) {
        money++;
      }
      ans += (money + i % 7);
    }
    return ans;
  }

  public int totalMoney_3(int n) {
    int day = n % 7, week = n / 7;
    return ((day + 1) * day) / 2 + day * week + (((week + 7) * week) / 2) * 7;
  }

  //  此处撰写解题思路
//  算出有几个整星期零几天。
//  第一周28，35，42·····所以和为28a +a(a-1)7/2
//  然后零散的几天，第一天是n/7+1,最后一天n/7+n%7,一共是(n/7+1+n/7+n%7)(n%7)/2
  public int totalMoney(int n) {
    int a = n / 7, b = n % 7;
    int ans = 28 * a + a * (a - 1) * 7 / 2 + (a + 1 + a + b) * b / 2;
    return ans;
  }

}
