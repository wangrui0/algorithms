package org.company.meituan.all.week01.done;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>169. 多数元素
 *
 * <p>给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[3,2,3]
 * <p>输出：3
 *
 * <p>示例 2：
 *
 * <p>输入：[2,2,1,1,1,2,2]
 * <p>输出：2
 *
 *
 *
 * <p>进阶：
 *
 * <p>    尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * <p>通过次数312,459
 * <p>提交次数473,491
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/majority-element/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh042_169MajorityElement多数元素 {

  public int majorityElement_self(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }


  /**
   * <p>方法一：哈希表
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n)
   *
   * <p> 空间复杂度：O(n)。
   */
  public int majorityElement(int[] nums) {
    Map<Integer, Integer> counts = countNums(nums);

    Map.Entry<Integer, Integer> majorityEntry = null;
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
        majorityEntry = entry;
      }
    }

    return majorityEntry.getKey();
  }

  private Map<Integer, Integer> countNums(int[] nums) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int num : nums) {
      if (!counts.containsKey(num)) {
        counts.put(num, 1);
      } else {
        counts.put(num, counts.get(num) + 1);
      }
    }
    return counts;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(nlogn)。将数组排序的时间复杂度为O(nlogn)。
   *
   * <p>   空间复杂度：O(logn)。如果使用语言自带的排序算法，需要使用 O(logn) 的栈空间。如果自己编写堆排序，则只需要使用 O(1) 的额外空间
   *
   * @param nums
   * @return
   */
  public int majorityElement_2(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  /**
   * 方法五：Boyer-Moore 投票算法
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
   *
   * <p>空间复杂度：O(1)。Boyer-Moore 算法只需要常数级别的额外空间
   *
   * @param nums
   * @return
   */
  public int majorityElement_3(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }


}
