package org.leetcode.shunxu.ch1200;

import java.util.Arrays;

/**
 * <p>LeetCode 1196. 最多可以买到的苹果数量（贪心）
 * <p>2020-07-13阅读 1200
 * <p>1. 题目
 * <p>楼下水果店正在促销，你打算买些苹果，arr[i] 表示第 i 个苹果的单位重量。
 *
 * <p>你有一个购物袋，最多可以装 5000 单位重量的东西，算一算，最多可以往购物袋里装入多少苹果。
 *
 * <p>示例 1：
 * <p>输入：arr = [100,200,150,1000]
 * <p>输出：4
 * <p>解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
 *
 * <p>示例 2：
 * <p>输入：arr = [900,950,800,1000,700,800]
 * <p>输出：5
 * <p>解释：6 个苹果的总重量超过了 5000，所以我们只能从中任选 5 个。
 *
 * <p>提示：
 * <p>1 <= arr.length <= 10^3
 * <p>1 <= arr[i] <= 10^3
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1196HowManyApplesCanYouPutIntoTheBasket {

  public int maxNumberOfApples(int[] arr) {
    int total = 5000;
    Arrays.sort(arr);
    int count = 0;
    for (int x : arr) {
      total -= x;
      if (total >= 0) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
