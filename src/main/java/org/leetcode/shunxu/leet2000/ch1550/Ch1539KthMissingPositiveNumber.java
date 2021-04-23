package org.leetcode.shunxu.leet2000.ch1550;

/**
 * <p>1539. 第 k 个缺失的正整数
 *
 * <p>给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * <p>请你找到这个数组里第 k 个缺失的正整数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [2,3,4,7,11], k = 5
 * <p>输出：9
 * <p>解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2,3,4], k = 2
 * <p>输出：6
 * <p>解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 1000
 * <p>    1 <= arr[i] <= 1000
 * <p>    1 <= k <= 1000
 * <p>    对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
 *
 * <p>通过次数12,656
 * <p>提交次数23,615
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/kth-missing-positive-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1539KthMissingPositiveNumber {

  public static int findKthPositive_self(int[] arr, int k) {
    int num = 1;
    int i = 0;
    while (true) {
      if (k == 0) {
        return num - 1;
      }
      if (i >= arr.length || arr[i] != num) {
        k--;
      } else {
        i++;
      }
      num++;
    }
  }

  /**
   * <p>复杂度分析
   * <p>
   * <p>    时间复杂度：O(n+k)。最坏情况下遍历完整个数组都没有缺失正整数，还要再将 current 递增 k 次，才能找到最终的答案。
   * <p>   空间复杂度：O(1)。
   *
   * @param arr
   * @param k
   * @return
   */
  public int findKthPositive_1(int[] arr, int k) {
    int missCount = 0, lastMiss = -1, current = 1, ptr = 0;
    for (missCount = 0; missCount < k; ++current) {
      if (current == arr[ptr]) {
        ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
      } else {
        ++missCount;
        lastMiss = current;
      }
    }
    return lastMiss;
  }

  /**
   * <p>二分：
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(logn)。即二分的时间复杂度。
   * <p>   空间复杂度：O(1)。
   *
   * @param arr
   * @param k
   * @return
   */
  public int findKthPositive_2(int[] arr, int k) {
    if (arr[0] > k) {
      return k;
    }

    int l = 0, r = arr.length;
    while (l < r) {
      int mid = (l + r) >> 1;
      int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
      if (x - mid - 1 >= k) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return k - (arr[l - 1] - (l - 1) - 1) + arr[l - 1];
  }


}
