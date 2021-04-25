package org.leetcode.leet500.ch500;

/**
 * 485. 最大连续 1 的个数
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,0,1,1,1] 输出：3 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的数组只包含 0 和 1 。 输入数组的长度是正整数，且不超过 10,000。
 * <p>
 * 通过次数96,658 提交次数160,971 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 *
 * @author: wangrui
 * @date: 2021/3/11
 */
public class Ch485MaxConsecutiveOnes {

  /**
   *
   * 复杂度分析
   *
   *     时间复杂度：O(n)，其中 nnn 是数组的长度。需要遍历数组一次。
   *
   *     空间复杂度：O(1)。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/max-consecutive-ones/solution/zui-da-lian-xu-1de-ge-shu-by-leetcode-so-252a/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param nums
   * @return
   */
  public int findMaxConsecutiveOnes(int[] nums) {
    int maxCount = 0, count = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1) {
        count++;
      } else {
        maxCount = Math.max(maxCount, count);
        count = 0;
      }
    }
    maxCount = Math.max(maxCount, count);
    return maxCount;
  }

  public int findMaxConsecutiveOnes2(int[] nums) {
    int n = nums.length;
    int ans = 0;
    for (int i = 0, j = 0; i < n; j = i) {
      if (nums[i] == 1) {
        while (j + 1 < n && nums[j + 1] == 1) j++;
        ans = Math.max(ans, j - i + 1);
        i = j + 1;
      } else {
        i++;
      }
    }
    return ans;
  }

}
