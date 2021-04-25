package org.leetcode.leet500.ch300;

/**
 * <p> 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p> 示例:
 *
 * <p> 输入: [0,1,0,3,12]
 * <p> 输出: [1,3,12,0,0]
 *
 * <p> 说明:
 *
 * <p>     必须在原数组上操作，不能拷贝额外的数组。
 * <p>     尽量减少操作次数。
 *
 * <p> 通过次数316,213
 * <p> 提交次数496,340
 * <p> 在真实的面试中遇到过这道题？
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/move-zeroes
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch0283MoveZeroes {

  /**
   * 1,1,3,12,0,0,0,0
   *
   * @param nums
   */
  public void moveZeroes(int[] nums) {
    int left = 0;
    int right = 0;
    int length = nums.length;
    while (right < length) {
      if (nums[right] != 0) {
        Integer temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
        left++;
      }
      right++;
    }
  }

  /**
   *<p> 复杂度分析
   *
   *<p>     时间复杂度：O(n)，其中 n 为序列长度。每个位置至多被遍历两次。
   *
   *<p>     空间复杂度：O(1)。只需要常数的空间存放若干变量。
   *
   *<p> 作者：LeetCode-Solution
   *<p> 链接：https://leetcode-cn.com/problems/move-zeroes/solution/yi-dong-ling-by-leetcode-solution/
   *<p> 来源：力扣（LeetCode）
   *<p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param nums
   */
  public void moveZeroes2(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    while (right < n) {
      if (nums[right] != 0) {
        swap(nums, left, right);
        left++;
      }
      right++;
    }
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}