package org.leetcode.leet1000.ch650;

import java.util.Arrays;

/**
 * <p>628. 三个数的最大乘积
 * <p>给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3]
 * <p>输出：6
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3,4]
 * <p>输出：24
 * <p>示例 3：
 *
 * <p>输入：nums = [-1,-2,-3]
 * <p>输出：-6
 *
 *
 * <p>提示：
 *
 * <p>3 <= nums.length <= 104
 * <p>-1000 <= nums[i] <= 1000
 * <p>通过次数68,180提交次数130,687
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:28 下午
 */
public class Ch628MaximumProductOfThreeNumbers {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(NlogN)，其中 N 为数组长度。排序需要O(NlogN) 的时间。
   *
   * <p>   空间复杂度：O(logN)，主要为排序的空间开销。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maximumProduct(int[] nums) {
    Arrays.sort(nums);
    int length = nums.length;
    return Math.max(nums[length - 1] * nums[length - 2] * nums[length - 3], nums[0] * nums[1] * nums[length - 1]);
  }

  public static int maximumProduct2(int[] nums) {
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      if (num < min1) {
        min2 = min1;
        min1 = num;
      } else if (num < min2) {
        min2 = num;
      }
      if (num > max1) {
        max3 = max2;
        max2 = max1;
        max1 = num;
      } else if (num > max2) {
        max3 = max2;
        max2 = num;
      } else if (num > max3) {
        max3 = num;
      }
    }
    return Math.max(max1 * max2 * max3, max1 * min1 * min2);
  }

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 NNN 为数组长度。我们仅需遍历数组一次。
   *
   * <p>   空间复杂度：O(1)。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/solution/san-ge-shu-de-zui-da-cheng-ji-by-leetcod-t9sb/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maximumProduct3(int[] nums) {
    // 最小的和第二小的
    int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    // 最大的、第二大的和第三大的
    int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

    for (int x : nums) {
      if (x < min1) {
        min2 = min1;
        min1 = x;
      } else if (x < min2) {
        min2 = x;
      }

      if (x > max1) {
        max3 = max2;
        max2 = max1;
        max1 = x;
      } else if (x > max2) {
        max3 = max2;
        max2 = x;
      } else if (x > max3) {
        max3 = x;
      }
    }

    return Math.max(min1 * min2 * max1, max1 * max2 * max3);
  }

}
