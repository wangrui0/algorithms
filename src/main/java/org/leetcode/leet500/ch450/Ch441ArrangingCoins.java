package org.leetcode.leet500.ch450;

/**
 * <p>441. 排列硬币
 *
 * <p>你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 *
 * <p>给定一个数字 n，找出可形成完整阶梯行的总行数。
 *
 * <p>n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * <p>示例 1:
 *
 * <p>n = 5
 *
 * <p>硬币可排列成以下几行:
 * <p>¤
 * <p> ¤ ¤
 * <p>¤ ¤
 *
 * <p>因为第三行不完整，所以返回2.
 *
 * <p>示例 2:
 *
 * <p>n = 8
 *
 * <p>硬币可排列成以下几行:
 * <p>¤
 * <p>¤ ¤
 * <p>¤ ¤ ¤
 * <p>¤ ¤
 *
 * <p>因为第四行不完整，所以返回3.
 *
 * <p>https://leetcode-cn.com/problems/arranging-coins/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch441ArrangingCoins {
  public  int arrangeCoins1(int n) {
    if(n==0){
      return 0;
    }
    long left = 1;
    long right = n;
    while (left <= right) {
      long mid = left + (right - left) / 2;
      long target = (1 + mid) * mid / 2;
      if (target == n) {
        return (int)mid;
      } else if (target < n) {
        left = mid+1;
      } else {
        right = mid - 1;
      }
    }
    return (int)(left-1);
  }

  public int arrangeCoins2(int n) {
    if (n <= 1) {
      return n;
    }
    long low = 1, high = n;
    while (low < high) {
      long mid = low + (high - low) / 2;
      if (mid * (mid + 1) / 2 <= n) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return (int) (low - 1);
  }
}
