package org.leetcode.leet1500.ch1300;

/**
 * <p>1295. 统计位数为偶数的数字
 *
 * <p>给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [12,345,2,6,7896]
 * <p>输出：2
 * <p>解释：
 * <p>12 是 2 位数字（位数为偶数）
 * <p>345 是 3 位数字（位数为奇数）
 * <p>2 是 1 位数字（位数为奇数）
 * <p>6 是 1 位数字 位数为奇数）
 * <p>7896 是 4 位数字（位数为偶数）
 * <p>因此只有 12 和 7896 是位数为偶数的数字
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [555,901,482,1771]
 * <p>输出：1
 * <p>解释：
 * <p>只有 1771 是位数为偶数的数字。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 500
 * <p>    1 <= nums[i] <= 10^5
 *
 * <p>通过次数43,298
 * <p>提交次数53,393
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/find-numbers-with-even-number-of-digits/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1295FindNumbersWithEvenNumberOfDigits {

  public int findNumbers(int[] nums) {
    int ans = 0;
    for (int x : nums) {
      if (String.valueOf(x).length() % 2 == 0) {
        ans++;
      }
    }
    return ans;
  }
}
