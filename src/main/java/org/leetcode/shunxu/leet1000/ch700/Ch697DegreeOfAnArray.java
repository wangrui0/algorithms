package org.leetcode.shunxu.leet1000.ch700;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>697. 数组的度
 * <p>给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * <p>你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1, 2, 2, 3, 1]
 * <p>输出：2
 * <p>解释：
 * <p> 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * <p>连续子数组里面拥有相同度的有如下所示:
 * <p>[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * <p>最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>示例 2：
 *
 * <p>输入：[1,2,2,3,1,4,2]
 * <p>输出：6
 *
 *
 * <p>提示：
 *
 * <p>nums.length 在1到 50,000 区间范围内。
 * <p>nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>通过次数58,307提交次数95,947
 * <p>https://leetcode-cn.com/problems/degree-of-an-array/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:37 下午
 */
public class Ch697DegreeOfAnArray {

  public int findShortestSubArray(int[] nums) {
    Map<Integer, int[]> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        int[] array = map.get(nums[i]);
        array[0] = array[0] + 1;
        array[2] = i;
        map.put(nums[i], array);
      } else {
        map.put(nums[i], new int[]{1, i, i});
      }
    }
    int minLength = 0;
    int maxNum = 0;
    for (int key : map.keySet()) {
      int[] array = map.get(key);
      int num = array[0];
      int start = array[1];
      int end = array[2];
      if (num > maxNum) {
        maxNum = num;
        minLength = end - start + 1;
      } else if (num == maxNum && end - start + 1 < minLength) {
        minLength = end - start + 1;
      }
    }
    return minLength;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n)，其中 n 是原数组的长度，我们需要遍历原数组和哈希表各一次，它们的大小均为 O(n)。
   *
   * <p>   空间复杂度：O(n)，其中 n 是原数组的长度，最坏情况下，哈希表和原数组等大。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/degree-of-an-array/solution/shu-zu-de-du-by-leetcode-solution-ig97/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int findShortestSubArray2(int[] nums) {
    Map<Integer, int[]> map = new HashMap<Integer, int[]>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i])[0]++;
        map.get(nums[i])[2] = i;
      } else {
        map.put(nums[i], new int[]{1, i, i});
      }
    }
    int maxNum = 0, minLen = 0;
    for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
      int[] arr = entry.getValue();
      if (maxNum < arr[0]) {
        maxNum = arr[0];
        minLen = arr[2] - arr[1] + 1;
      } else if (maxNum == arr[0]) {
        if (minLen > arr[2] - arr[1] + 1) {
          minLen = arr[2] - arr[1] + 1;
        }
      }
    }
    return minLen;
  }


}
