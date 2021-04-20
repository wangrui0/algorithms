package org.leetcode.shunxu.leet500.ch50;

/**
 * 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * <p>
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * <p>
 * 输出: 1
 * <p>
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * <p>
 * 输出: 4
 * <p>
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * <p>
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/10
 */
public class Ch0035SearchInsert {

  /**
   * 1 3 5 6     2
   *
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (left + right + 1) / 2;

  }

  /**
   * 这个比较容易理解，恰当
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert3(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    int ans=nums.length;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        ans=mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;

  }

  /**
   * 方法一：
   * <p>
   * 二分查找
   * <p>
   * 思路与算法
   * <p>
   * 假设题意是叫你在排序数组中寻找是否存在一个目标值，那么训练有素的读者肯定立马就能想到利用二分法在 O(logn) 的时间内找到是否存在目标值。
   * <p>
   * 但这题还多了个额外的条件，即如果不存在数组中的时候需要返回按顺序插入的位置，那我们还能用二分法么？答案是可以的，我们只需要稍作修改即可。
   * <p>
   * 考虑这个插入的位置 pos，它成立的条件为：
   * <p>
   * {nums}[pos-1]<target≤nums[pos]
   * <p>
   * 其中  nums 代表排序数组。由于如果存在这个目标值，我们返回的索引也是 pos，因此我们可以将两个条件合并得出最后的目标：「在一个有序数组中找第一个大于等于target 的下标」。
   * <p>
   * 问题转化到这里，直接套用二分法即可，即不断用二分法逼近查找第一个大于等于 target 的下标 。下文给出的代码是笔者习惯的二分写法，ans
   * <p>
   * 初值设置为数组长度可以省略边界条件的判断，因为存在一种情况是 target 大于数组中的所有数，此时需要插入到数组长度的位置。
   * <p>
   * ===========================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(logn)，其中 nn 为数组的长度。二分查找所需的时间复杂度为 O(logn)。
   * <p>
   * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
   * <p>
   *
   * @param nums
   * @param target
   * @return
   */
  public int searchInsert2(int[] nums, int target) {
    int n = nums.length;
    int left = 0, right = n - 1, ans = n;
    while (left <= right) {
      int mid = ((right - left) >> 1) + left;
      if (target <= nums[mid]) {
        ans = mid;
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
