package org.leetcode.leet2000.ch1850;

/**
 * <p>1822. 数组元素积的符号
 *
 * <p>已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *
 * <p>    如果 x 是正数，返回 1 。
 * <p>    如果 x 是负数，返回 -1 。
 * <p>    如果 x 是等于 0 ，返回 0 。
 *
 * <p>给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 *
 * <p>返回 signFunc(product) 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [-1,-2,-3,-4,3,2,1]
 * <p>输出：1
 * <p>解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,5,0,2,-3]
 * <p>输出：0
 * <p>解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [-1,1,-1,1,-1]
 * <p>输出：-1
 * <p>解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 1000
 * <p>    -100 <= nums[i] <= 100
 *
 * <p>通过次数15,102
 * <p>提交次数17,375
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:19 下午
 */
public class Ch1822SignOfTheProductOfAnArray {

  public int arraySign(int[] nums) {
    int signal = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        return 0;
      } else if (nums[i] < 0) {
        signal *= -1;
      }
    }
    return signal;
  }

  public int arraySign_2(int[] nums) {
    int temp = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        temp++;
      }
      if (nums[i] > 0) {
        continue;
      }
      if (nums[i] == 0) {
        return 0;
      }
    }
    if (temp % 2 == 0) {
      return 1;
    }
    return -1;
  }

  public int arraySign_3(int[] nums) {
    int answer = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        answer = 0;
        break;
      }
      if (nums[i] < 0) {
        answer = answer * (-1);
      }
    }
    return answer;
  }
}
