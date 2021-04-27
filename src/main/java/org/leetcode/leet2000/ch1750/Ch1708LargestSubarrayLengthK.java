package org.leetcode.leet2000.ch1750;

/**
 * <p>1708. 长度为K的最大子数组
 * <p>数组A大于数组B, 也就是从第一个不相等的位置i起(A[i] != B[i]), A[i]大于B[i]
 *
 * <p>例如，以下数组(从下标0开始)
 *
 * <p>For example, consider 0-indexing:
 *
 * <p>[1,3,2,4] > [1,2,2,4], 在下标1, 3 > 2. [1,4,4,4] < [2,1,1,1], 在下标0, 1 < 2.
 *
 * <p>子数组是Array[i:j]连续的元素
 *
 * <p>给一个不重复的数组，返回最大的长度为k的子数组
 *
 * <p>示例 1：
 *
 * <p>输入: nums = [1,4,5,2,3], k = 3
 * <p>输出: [5,2,3]
 * <p>解释: 长度为3的子数组有: [1,4,5], [4,5,2], and [5,2,3]。 其中[5,2,3]是最大的.
 * <p>示例 2:
 *
 * <p>输入: nums = [1,4,5,2,3], k = 4
 * <p>输出: [4,5,2,3]
 * <p>解释: 长度为4的子数组有: [1,4,5,2], and [4,5,2,3]。其中[4,5,2,3]是最大的.
 * <p>示例 3:
 *
 * <p>输入: nums = [1,4,5,2,3], k = 1
 * <p>输出: [5]
 * <p>提示：
 *
 * <p>1 <= k <= nums.length <= 105
 * <p>1 <= nums[i] <= 109
 * <p>所有元素都是独一无二的
 * <p>Follow up: 如果有重复元素, 何解？
 *
 * <p>来源：力扣（LeetCode）
 *
 * <p>链接：https://leetcode-cn.com/problems/largest-subarray-length-k/
 *
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:35 下午
 */
public class Ch1708LargestSubarrayLengthK {

  /**
   * 所有的元素都不重复
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] largestSubarray(int[] arr, int k) {
    int maxIndex = 0;
    int maxValue = Integer.MIN_VALUE;
    for (int j = 0; j < arr.length - k; j++) {
      if (arr[j] > maxValue) {
        maxIndex = j;
        maxValue = arr[j];
      }
    }
    int[] ans = new int[k];
    for (int i = maxIndex; i < k; i++) {
      ans[i] = arr[i];
    }
    return ans;
  }

  /**
   * 如果有重复的
   *
   * @param arr
   * @param k
   * @return
   */
  public int[] largestSubarray_2(int[] arr, int k) {
    int maxIndex = 0;
    for (int j = 1; j < arr.length - k; j++) {
      if (!help(arr, maxIndex, j, k)) {
        maxIndex = j;
      }
    }
    int[] ans = new int[k];
    for (int i = maxIndex; i < k; i++) {
      ans[i] = arr[i];
    }
    return ans;
  }

  public boolean help(int[] arr, int index1, int index2, int k) {
    for (int i = 0; i < k; i++) {
      if (arr[index1 + i] > arr[index2 + i]) {
        return true;
      } else if (arr[index1 + i] < arr[index2 + i]) {
        return false;
      }
    }
    return false;
  }

//  def largestSubarray(self, nums: List[int], k: int) -> List[int]:
//
//  res = nums[:k]
//      for i in range(1, len(nums) - k + 1):
//  tmp = nums[i: i + k]
//      if self.larger(tmp, res):
//  res = tmp
//
//        return res
//
//
//  def larger(self, a: List[int], b: List[int]) -> bool:
//
//      for i in range(len(a)):
//      if a[i] == b[i]:
//      continue
//
//  elif a[i] > b[i]:
//      return True
//            else:
//                return False
//
//        return False

}
