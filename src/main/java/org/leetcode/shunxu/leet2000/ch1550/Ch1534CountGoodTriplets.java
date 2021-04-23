package org.leetcode.shunxu.leet2000.ch1550;

/**
 * <p>1534. 统计好三元组
 *
 * <p>给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * <p>如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * <p>    0 <= i < j < k < arr.length
 * <p>    |arr[i] - arr[j]| <= a
 * <p>    |arr[j] - arr[k]| <= b
 * <p>    |arr[i] - arr[k]| <= c
 *
 * <p>其中 |x| 表示 x 的绝对值。
 *
 * <p>返回 好三元组的数量 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * <p>输出：4
 * <p>解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * <p>输出：0
 * <p>解释：不存在满足所有条件的三元组。
 *
 *
 *
 * <p>提示：
 *
 * <p>    3 <= arr.length <= 100
 * <p>    0 <= arr[i] <= 1000
 * <p>    0 <= a, b, c <= 1000
 *
 * <p>通过次数15,291
 * <p>提交次数19,430
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-good-triplets/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1534CountGoodTriplets {

  /**
   * 方法一:枚举
   *
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return
   */
  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int n = arr.length, cnt = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        for (int k = j + 1; k < n; ++k) {
          if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
            ++cnt;
          }
        }
      }
    }
    return cnt;
  }

  /**
   * <p> 枚举优化
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n^2+nS
   *
   * <p>   空间复杂度：O(S)。我们需要 O(S) 的空间维护 arr[i]频次数组的前缀和。
   *
   * @param arr
   * @param a
   * @param b
   * @param c
   * @return
   */
  public int countGoodTriplets_2(int[] arr, int a, int b, int c) {
    int ans = 0, n = arr.length;
    int[] sum = new int[1001];
    for (int j = 0; j < n; ++j) {
      for (int k = j + 1; k < n; ++k) {
        if (Math.abs(arr[j] - arr[k]) <= b) {
          int lj = arr[j] - a, rj = arr[j] + a;
          int lk = arr[k] - c, rk = arr[k] + c;
          int l = Math.max(0, Math.max(lj, lk)), r = Math.min(1000, Math.min(rj, rk));
          if (l <= r) {
            if (l == 0) {
              ans += sum[r];
            } else {
              ans += sum[r] - sum[l - 1];
            }
          }
        }
      }
      for (int k = arr[j]; k <= 1000; ++k) {
        ++sum[k];
      }
    }
    return ans;
  }

  public int countGoodTriplets_3(int[] arr, int a, int b, int c) {
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
            ans++;
          }
        }
      }
    }
    return ans;
  }
}
