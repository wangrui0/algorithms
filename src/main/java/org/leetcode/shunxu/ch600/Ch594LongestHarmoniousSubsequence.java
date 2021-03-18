package org.leetcode.shunxu.ch600;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>594. 最长和谐子序列
 *
 * <p>和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *
 * <p>现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * <p>数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,3,2,2,5,2,3,7]
 * <p>输出：5
 * <p>解释：最长的和谐子序列是 [3,2,2,2,3]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3,4]
 * <p>输出：2
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1,1,1,1]
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 2 *<p>104
 * <p>    -109 <= nums[i] <= 109
 *
 * <p>通过次数21,511
 * <p>提交次数42,832
 * <p>https://leetcode-cn.com/problems/longest-harmonious-subsequence/
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 */
public class Ch594LongestHarmoniousSubsequence {

  public static int findLHS1(int[] nums) {
    int count = 0;
    int length = nums.length;
    int maxCount = 0;
    boolean flag = false;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if ((nums[i] == nums[j] || nums[i] == nums[j] - 1)) {
          if (nums[i] == nums[j] - 1) {
            flag = true;
          }
          count++;
        }
      }
      if (count > maxCount && flag) {
        maxCount = count;
      }
      count = 0;
      flag = false;
    }
    return maxCount;
  }

  public static int findLHS2(int[] nums) {
    int maxCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Integer num : map.keySet()) {
      if (map.get(num + 1) != null) {
        int count = map.get(num) + map.get(num + 1);
        if (count > maxCount) {
          maxCount = count;
        }
      }
    }
    return maxCount;
  }

  public static int findLHS3(int[] nums) {
    int maxCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      int count = map.getOrDefault(num, 0) + 1;
      map.put(num, count);
      if (map.containsKey(num + 1)) {
        maxCount = Math.max(maxCount, map.get(num + 1) + count);
      }
      if (map.containsKey(num - 1)) {
        maxCount = Math.max(maxCount, map.get(num - 1) + count);
      }
    }
    return maxCount;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N^2)，其中 N 是数组的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param nums
   * @return
   */
  public int findLHS1_1(int[] nums) {
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      int count = 0;
      boolean flag = false;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] == nums[i]) {
          count++;
        } else if (nums[j] + 1 == nums[i]) {
          count++;
          flag = true;
        }
      }
      if (flag) {
        res = Math.max(count, res);
      }
    }
    return res;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是数组的长度。
   *
   * <p>  空间复杂度：O(N)，用来存储哈希映射。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence/solution/zui-chang-he-xie-zi-xu-lie-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int findLHS2_2(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int key : map.keySet()) {
      if (map.containsKey(key + 1)) {
        res = Math.max(res, map.get(key) + map.get(key + 1));
      }
    }
    return res;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是数组的长度。
   *
   * <p>    空间复杂度：O(N)，用来存储哈希映射。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/longest-harmonious-subsequence/solution/zui-chang-he-xie-zi-xu-lie-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int findLHS3_3(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      if (map.containsKey(num + 1)) {
        res = Math.max(res, map.get(num) + map.get(num + 1));
      }
      if (map.containsKey(num - 1)) {
        res = Math.max(res, map.get(num) + map.get(num - 1));
      }
    }
    return res;
  }
}
