package org.leetcode.leet1000.ch700;

/**
 * <p>674. 最长连续递增序列
 * <p>给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * <p>连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ...,
 * nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 *
 *
 * <p>示例 1：
 *
 * <p> 输入：nums = [1,3,5,4,7]
 * <p>输出：3
 * <p>解释：最长连续递增序列是 [1,3,5], 长度为3。
 * <p>尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * <p>示例 2：
 *
 * <p>输入：nums = [2,2,2,2,2]
 * <p>输出：1
 * <p>解释：最长连续递增序列是 [2], 长度为1。
 *
 *
 * <p>提示：
 *
 * <p>0 <= nums.length <= 104
 * <p>-109 <= nums[i] <= 109
 * <p>https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:26 下午
 */
public class Ch674LongestContinuousIncreasingSubsequence {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是数组 nums 的长度。需要遍历数组一次。
   *
   * <p>   空间复杂度：O(1)。额外使用的空间为常数。
   *
   * <p>作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/zui-chang-lian-xu-di-zeng-xu-lie-by-leet-dmb8/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int findLengthOfLCIS(int[] nums) {
    int ans = 0;
    int n = nums.length;
    int start = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] <= nums[i - 1]) {
        start = i;
      }
      ans = Math.max(ans, i - start + 1);
    }
    return ans;
  }


}