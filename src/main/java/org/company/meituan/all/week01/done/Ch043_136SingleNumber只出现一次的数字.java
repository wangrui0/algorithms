package org.company.meituan.all.week01.done;

/**
 * <p>136. 只出现一次的数字
 *
 * <p>给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * <p>说明：
 *
 * <p>你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * <p>示例 1:
 *
 * <p>输入: [2,2,1]
 * <p>输出: 1
 *
 * <p>示例 2:
 *
 * <p>输入: [4,1,2,1,2]
 * <p>输出: 4
 *
 * <p>通过次数403,803
 * <p>提交次数565,096
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/single-number/
 *
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch043_136SingleNumber只出现一次的数字 {

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(n)O(n)O(n)，其中 nnn 是数组长度。只需要对数组遍历一次。
   *
   * <p>  空间复杂度：O(1)O(1)O(1)。
   *
   * @param nums
   * @return
   */
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int x : nums) {
      ans ^= x;
    }
    return ans;
  }
}
