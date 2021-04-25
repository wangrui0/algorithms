package org.leetcode.lcp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>LCP 18. 早餐组合
 *
 * <p>小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 *
 * <p>注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * <p>示例 1：
 *
 * <p>    输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 *
 * <p>    输出：6
 *
 * <p>    解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * <p>    第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * <p>    第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * <p>    第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * <p>    第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * <p>    第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * <p>    第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 *
 * <p>示例 2：
 *
 * <p>    输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
 *
 * <p>    输出：8
 *
 * <p>    解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * <p>    第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
 * <p>    第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
 * <p>    第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
 * <p>    第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
 * <p>    第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
 * <p>    第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
 * <p>    第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
 * <p>    第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
 *
 * <p>提示：
 *
 * <p>    1 <= staple.length <= 10^5
 * <p>    1 <= drinks.length <= 10^5
 * <p>    1 <= staple[i],drinks[i] <= 10^5
 * <p>    1 <= x <= 2*10^5
 * <p>@author: wangrui
 * <p>@date: 2021/3/31
 */
public class LCP018_2vYnGI {

  public int breakfastNumber(int[] staple, int[] drinks, int x) {
    int count = 0;
    for (int i = 0; i < staple.length; i++) {
      for (int j = 0; j < drinks.length; j++) {
        if (staple[i] + drinks[j] <= x) {
          count++;
        }
      }
    }
    return count % 1000000008;
  }

  /**
   * 1 2 3 4 5 2 3 4 5 6 双指针法
   *
   * @param staple
   * @param drinks
   * @param x
   * @return
   */
  public int breakfastNumber_2(int[] staple, int[] drinks, int x) {
    Arrays.sort(staple);
    Arrays.sort(drinks);
    int left = 0;
    int right = drinks.length - 1;
    int count = 0;
    while (left < staple.length && right >= 0) {
      if (staple[left] + drinks[right] <= x) {
        count = (count + right + 1) % 1000000007;
        left++;
      } else {
        right--;
      }
    }
    return count % 1000000007;
  }

  public int breakfastNumber_3(int[] staple, int[] drinks, int x) {
    Arrays.sort(staple);
    Arrays.sort(drinks);
    int cnt = 0;
    int m = staple.length, n = drinks.length;
    for (int i = 0; i < m; i++) {
      int temp = x - staple[i];
      int idx = binarySearch(drinks, temp);
      if (idx == 0) {
        break;
      }
      cnt = (cnt + idx) % 1000000007;
    }
    return cnt % 1000000007;
  }

  public int binarySearch(int[] nums, int target) {
    int i = 0, j = nums.length;
    while (i < j) {
      int mid = i + (j - i) / 2;
      if (nums[mid] > target) {
        j = mid;
      } else {
        i = mid + 1;
      }
    }
    return i;
  }
}
