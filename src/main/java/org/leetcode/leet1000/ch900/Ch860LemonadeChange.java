package org.leetcode.leet1000.ch900;

/**
 * <p> 860. 柠檬水找零
 *
 * <p> 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * <p> 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * <p> 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * <p> 注意，一开始你手头没有任何零钱。
 *
 * <p> 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * <p> 示例 1：
 *
 * <p> 输入：[5,5,5,10,20]
 * <p> 输出：true
 * <p> 解释：
 * <p> 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * <p> 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * <p> 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * <p> 由于所有客户都得到了正确的找零，所以我们输出 true。
 *
 * <p> 示例 2：
 *
 * <p> 输入：[5,5,10]
 * <p> 输出：true
 *
 * <p> 示例 3：
 *
 * <p> 输入：[10,10]
 * <p> 输出：false
 *
 * <p> 示例 4：
 *
 * <p> 输入：[5,5,10,10,20]
 * <p> 输出：false
 * <p> 解释：
 * <p> 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * <p> 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * <p> 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * <p> 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 *
 *
 * <p> 提示：
 *
 * <p>     0 <= bills.length <= 10000
 * <p>     bills[i] 不是 5 就是 10 或是 20
 *
 * <p> 通过次数74,049
 * <p> 提交次数126,998
 * <p> 在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/lemonade-change/
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch860LemonadeChange {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是 bills 的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param bills
   * @return
   */
  public boolean lemonadeChange(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
      if (bill == 5) {
        five++;
      } else if (bill == 10) {
        if (five == 0) {
          return false;
        }
        five--;
        ten++;
      } else {
        if (five > 0 && ten > 0) {
          five--;
          ten--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  public boolean lemonadeChange_self(int[] bills) {
    int five = 0, ten = 0;
    for (int bill : bills) {
      if (bill == 5) {
        five++;
      } else if (bill == 10) {
        if (five == 0) {
          return false;
        }
        ten++;
        five--;
      } else {
        if (five >= 1 && ten >= 1) {
          five--;
          ten--;
        } else if (five >= 3) {
          five -= 3;
        } else {
          return false;
        }
      }
    }
    return true;
  }
}


