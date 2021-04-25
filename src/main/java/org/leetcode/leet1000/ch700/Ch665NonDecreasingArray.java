package org.leetcode.leet1000.ch700;

/**
 * <p>665. 非递减数列
 * <p>给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * <p>我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [4,2,3]
 * <p>输出: true
 * <p>解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * <p>示例 2:
 *
 * <p>输入: nums = [4,2,1]
 * <p>输出: false
 * <p>解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:22 下午
 */
public class Ch665NonDecreasingArray {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是数组 nums 的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/non-decreasing-array/solution/fei-di-jian-shu-lie-by-leetcode-solution-zdsm/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public boolean checkPossibility(int[] nums) {
    int n = nums.length, cnt = 0;
    for (int i = 0; i < n - 1; ++i) {
      int x = nums[i], y = nums[i + 1];
      if (x > y) {
        cnt++;
        if (cnt > 1) {
          return false;
        }
        //注意这点
        /**
         * <p>对于满足该条件的数组 [3,4,1,2] 而言，无论怎么修改也无法将其变成非递减数列。
         *
         * <p>因此，若找到了一个满足 nums[i]>nums[i+1]的 i，在修改 nums[i] 或 nums[i+1] 之后，还需要检查 nums 是否变成了非递减数列。
         *
         * <p>我们可以将 nums[i] 修改成小于或等于 nums[i+1] 的数，但由于还需要保证 nums[i] 不小于它之前的数，nums[i] 越大越好，所以将 nums[i] 修改成 nums[i+1] 是最佳的；同理，对于 nums[i+1]，修改成 nums[i] 是最佳的。
         *
         */
        if (i > 0 && y < nums[i - 1]) {
          nums[i + 1] = x;
        }
      }
    }
    return true;
  }
}
