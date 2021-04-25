package org.leetcode.leet1500.ch1250;

/**
 * <p>LeetCode 1228. 等差数列中缺失的数字
 * <p>2020-07-13阅读 1150
 * <p>1. 题目
 * <p>有一个数组，其中的值符合等差数列的数值规律，也就是说：
 *
 * <p>在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
 * <p>我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组  arr。
 *
 * <p>给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。
 *
 * <p>示例 1：
 * <p>输入：arr = [5,7,11,13]
 * <p>输出：9
 * <p>解释：原来的数组是 [5,7,9,11,13]。
 *
 * <p>示例 2：
 * <p>输入：arr = [15,13,12]
 * <p>输出：14
 * <p>解释：原来的数组是 [15,14,13,12]。
 *
 * <p>提示：
 * <p>3 <= arr.length <= 1000
 * <p>0 <= arr[i] <= 10^5
 * <p>https://leetcode-cn.com/problems/missing-number-in-arithmetic-progression/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1228MIssingNumberInArithmeticProgression {

  public static int missingNumber(int[] arr) {
    int sumArr = 0;
    for (int x : arr) {
      sumArr += x;
    }
    int length = arr.length;
    int sum = (arr[0] + arr[length - 1]) * (length + 1)/2;
    return sum - sumArr;
  }
}
