package org.leetcode.shunxu.leet1500.ch1450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>1403. 非递增顺序的最小子序列
 *
 * <p>给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 *
 * <p>如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 *
 * <p>与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 *
 * <p>注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [4,3,10,9,8]
 * <p>输出：[10,9]
 * <p>解释：子序列 [10,9] 和 [10,8] 是最小的、满足元素之和大于其他各元素之和的子序列。但是 [10,9] 的元素之和最大。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [4,4,7,6,7]
 * <p>输出：[7,7,6]
 * <p>解释：子序列 [7,7] 的和为 14 ，不严格大于剩下的其他元素之和（14 = 4 + 4 + 6）。因此，[7,6,7] 是满足题意的最小子序列。注意，元素按非递增顺序返回。
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [6]
 * <p>输出：[6]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 500
 * <p>    1 <= nums[i] <= 100
 *
 * <p>通过次数18,504
 * <p>提交次数26,884
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1403MinimumSubsequenceInNonIncreasingOrder {

  public List<Integer> minSubsequence(int[] nums) {
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums);
    int sum = 0;
    int temp = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum = sum + nums[i];
      temp = 0;
      for (int j = 0; j < nums.length && j != i; j++) {
        temp += nums[j];
      }
      if (sum > temp) {
        for (int z = nums.length - 1; z >= i; z--) {
          list.add(nums[z]);
        }
        break;
      }
    }
    return list;
  }

  public List<Integer> minSubsequence_2(int[] nums) {
    //排序
    Arrays.sort(nums);
    int sum = 0;
    for (int i : nums) {
      sum = sum + i;
    }
    //先获得总和
    int index = nums.length - 1;
    //从最大处开始遍历
    List<Integer> list = new ArrayList<>();
    int sum2 = 0;
    while (sum2 <= sum / 2) {
      list.add(nums[index]);
      //边添加边求和
      sum2 = sum2 + nums[index];
      index--;
    }
    return list;
  }
  public static List<Integer> minSubsequence_3(int[] nums) {
    Arrays.sort(nums);
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    int sum0 = 0;
    List<Integer> ans = new ArrayList<>();
    int index = nums.length - 1;
    while (sum0 < sum / 2) {
      ans.add(nums[index]);
      sum0 += nums[index];
      index--;
    }
    return ans;
  }



}
