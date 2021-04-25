package org.leetcode.leet1500.ch1400;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>1365. 有多少小于当前数字的数字
 *
 * <p>给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * <p>换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * <p>以数组形式返回答案。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [8,1,2,2,3]
 * <p>输出：[4,0,1,1,3]
 * <p>解释：
 * <p>对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * <p>对于 nums[1]=1 不存在比它小的数字。
 * <p>对于 nums[2]=2 存在一个比它小的数字：（1）。
 * <p>对于 nums[3]=2 存在一个比它小的数字：（1）。
 * <p>对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [6,5,4,8]
 * <p>输出：[2,1,0,3]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [7,7,7,7]
 * <p>输出：[0,0,0,0]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= nums.length <= 500
 * <p>    0 <= nums[i] <= 100
 *
 * <p>通过次数78,343
 * <p>提交次数94,865
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1365HowManyNumbersAreSmallerThanTheCurrentNumber {

  /**
   * <p> 方法一：暴力
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N^2)，其中 N 为数组的长度。
   * <p>  空间复杂度：O(1)。注意我们不计算答案数组的空间占用
   *
   * @param nums
   * @return
   */
  public int[] smallerNumbersThanCurrent(int[] nums) {
    int n = nums.length;
    int[] ret = new int[n];
    for (int i = 0; i < n; i++) {
      int cnt = 0;
      for (int j = 0; j < n; j++) {
        if (nums[j] < nums[i]) {
          cnt++;
        }
      }
      ret[i] = cnt;
    }
    return ret;
  }

  /**
   * 方法二：排序
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(NlogN)，其中 N 为数组的长度。排序需要 O(NlogN) 的时间，随后需要 O(N) 时间来遍历。
   *
   * <p> 空间复杂度：O(N)。因为要额外开辟一个数组。
   *
   * @param nums
   * @return
   */
  public int[] smallerNumbersThanCurrent_2(int[] nums) {
    int n = nums.length;
    int[][] data = new int[n][2];
    for (int i = 0; i < n; i++) {
      data[i][0] = nums[i];
      data[i][1] = i;
    }
    Arrays.sort(data, Comparator.comparingInt(data2 -> data2[0]));

    int[] ret = new int[n];
    int prev = -1;
    for (int i = 0; i < n; i++) {
      if (prev == -1 || data[i][0] != data[i - 1][0]) {
        prev = i;
      }
      ret[data[i][1]] = prev;
    }
    return ret;
  }

  public static void main(String[] args) {
    System.out.println(smallerNumbersThanCurrent_3(new int[]{8, 1, 2, 2, 3}));
  }

  public static int[] smallerNumbersThanCurrent_3(int[] nums) {
    int[] cnt = new int[101];
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      cnt[nums[i]]++;
    }
    for (int i = 1; i <= 100; i++) {
      cnt[i] += cnt[i - 1];
    }
    int[] ret = new int[n];
    for (int i = 0; i < n; i++) {
      ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
    }
    return ret;
  }


  public static int[] smallerNumbersThanCurrent_4(int[] nums) {
    int[] cnt = new int[101];
    for (int x : nums) {
      cnt[x]++;
    }

    for (int i = 1; i < 101; i++) {
      cnt[i] += cnt[i - 1];
    }
    int[] ans = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      ans[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
    }
    return ans;
  }

}
