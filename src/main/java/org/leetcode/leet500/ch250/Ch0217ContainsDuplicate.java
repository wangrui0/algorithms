package org.leetcode.leet500.ch250;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p> 217. 存在重复元素
 *
 * <p> 给定一个整数数组，判断是否存在重复元素。
 *
 * <p> 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *
 *
 * <p> 示例 1:
 *
 * <p> 输入: [1,2,3,1]
 * <p> 输出: true
 *
 * <p> 示例 2:
 *
 * <p> 输入: [1,2,3,4]
 * <p> 输出: false
 *
 * <p> 示例 3:
 *
 * <p> 输入: [1,1,1,3,3,4,3,2,4,2]
 * <p> 输出: true
 *
 * <p> 通过次数227,284
 * <p> 提交次数412,946
 * <p>https://leetcode-cn.com/problems/contains-duplicate/
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0217ContainsDuplicate {

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    for (int x : nums) {
      if (!set.add(x)) {
        return true;
      }
    }
    return false;
  }

  /**
   *<p> 时间复杂度：O(NlogN)，其中 NNN 为数组的长度。需要对数组进行排序。
   *<p> 空间复杂度：O(logN)，其中 NNN 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
   * @param nums
   * @return
   */
  public boolean containsDuplicate3(int[] nums) {
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * <p> 时间复杂度：O(N)，其中 N 为数组的长度
   * <p>> 空间复杂度：O(N)，其中 N为数组的长度。
   *
   * @param nums
   * @return
   */
  public boolean containsDuplicate2(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }

}
