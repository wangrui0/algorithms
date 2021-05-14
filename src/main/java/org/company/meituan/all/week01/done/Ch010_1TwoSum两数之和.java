package org.company.meituan.all.week01.done;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1. 两数之和
 *
 * <p>给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * <p>你可以按任意顺序返回答案。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [2,7,11,15], target = 9
 * <p>输出：[0,1]
 * <p>解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [3,2,4], target = 6
 * <p>输出：[1,2]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [3,3], target = 6
 * <p>输出：[0,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= nums.length <= 103
 * <p>    -109 <= nums[i] <= 109
 * <p>    -109 <= target <= 109
 * <p>    只会存在一个有效答案
 *
 * <p>通过次数2,028,770
 * <p>提交次数3,971,700
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch010_1TwoSum两数之和 {

  public int[] twoSum_self(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{i, map.get(target - nums[i])};
      } else {
        map.put(nums[i], i);
      }
    }
    return null;
  }

  public int[] twoSum_1(int[] nums, int target) {
    int n = nums.length;
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[0];
  }

  public int[] twoSum_2(int[] nums, int target) {
    Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
      if (hashtable.containsKey(target - nums[i])) {
        return new int[]{hashtable.get(target - nums[i]), i};
      }
      hashtable.put(nums[i], i);
    }
    return new int[0];
  }


}
