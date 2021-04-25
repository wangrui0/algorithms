package org.leetcode.leet2000.ch1600;

/**
 * <p>1566. 重复至少 K 次且长度为 M 的模式
 *
 * <p>给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 *
 * <p>模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
 *
 * <p>如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [1,2,4,4,4,4], m = 1, k = 3
 * <p>输出：true
 * <p>解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * <p>输出：true
 * <p>解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [1,2,1,2,1,3], m = 2, k = 3
 * <p>输出：false
 * <p>解释：模式 (1,2) 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
 *
 * <p>示例 4：
 *
 * <p>输入：arr = [1,2,3,1,2], m = 2, k = 2
 * <p>输出：false
 * <p>解释：模式 (1,2) 出现 2 次但并不连续，所以不能算作连续重复 2 次。
 *
 * <p>示例 5：
 *
 * <p>输入：arr = [2,2,2,2], m = 2, k = 3
 * <p>输出：false
 * <p>解释：长度为 2 的模式只有 (2,2) ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= arr.length <= 100
 * <p>    1 <= arr[i] <= 100
 * <p>    1 <= m <= 100
 * <p>    2 <= k <= 100
 *
 * <p>通过次数6,871
 * <p>提交次数15,599
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1566DetectPatternOfLengthMRepeatedKOrMoreTimes {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n×m×k)。最外层循环 l 的取值个数为 n−m×k，内层循环 offset 的取值个数为 m×k，故渐进时间复杂度为 O(n×m×k)。
   * <p>   空间复杂度：O(1)。
   *
   * @param arr
   * @param m
   * @param k
   * @return
   */
  public boolean containsPattern(int[] arr, int m, int k) {
    int n = arr.length;
    for (int l = 0; l <= n - m * k; ++l) {
      int offset;
      for (offset = 0; offset < m * k; ++offset) {
        if (arr[l + offset] != arr[l + offset % m]) {
          break;
        }
      }
      if (offset == m * k) {
        return true;
      }
    }
    return false;
  }


}
