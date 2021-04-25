package org.leetcode.leet1500.ch1500;

/**
 * <p>1470. 重新排列数组
 *
 * <p>给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 *
 * <p>请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [2,5,1,3,4,7], n = 3
 * <p>输出：[2,3,5,4,1,7]
 * <p>解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * <p>输出：[1,4,2,3,3,2,4,1]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,1,2,2], n = 2
 * <p>输出：[1,2,1,2]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= n <= 500
 * <p>    nums.length == 2n
 * <p>    1 <= nums[i] <= 10^3
 * https://leetcode-cn.com/problems/shuffle-the-array/
 * <p>通过次数47,562
 * <p>提交次数56,299
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1470ShuffleTheArray {

  public int[] shuffle(int[] nums, int n) {
    int[] res = new int[nums.length];
    int index = 0;
//按照题意分别添加元素
    for (int i = 0; i < nums.length / 2; i++) {
      res[index++] = nums[i];
      res[index++] = nums[i + n];
    }
    return res;
  }

  public int[] shuffle_2(int[] nums, int n) {
    int[] ret = new int[2 * n];
    for (int i = 0; i < n; i++) {
      ret[i * 2] = nums[i];
      ret[i * 2 + 1] = nums[n + i];
    }
    return ret;
  }

  public static int[] shuffle_3(int[] nums, int n) {
    int[] ans = new int[2 * n];
    for (int i = 0; i < n; i++) {
      ans[i * 2] = nums[i];
      ans[i * 2 + 1] = nums[n + i];
    }
    return ans;
  }

  public int[] shuffle_4(int[] nums, int n) {
    int index = 0;
    int[] result = new int[nums.length];
    for (int i = 0; i < n; i++) {
      result[index++] = nums[i];
      result[index++] = nums[n+i];
    }
    return result;
  }


}
