package org.company.meituan.all.week02.done;

/**
 * <p>34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * <p>如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * <p>进阶：
 *
 * <p>你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [5,7,7,8,8,10], target = 8
 * <p>输出：[3,4]
 * <p>示例 2：
 *
 * <p>输入：nums = [5,7,7,8,8,10], target = 6
 * <p>输出：[-1,-1]
 * <p>示例 3：
 *
 * <p>输入：nums = [], target = 0
 * <p>输出：[-1,-1]
 *
 *
 * <p>提示：
 *
 * <p>0 <= nums.length <= 105
 * <p>-109 <= nums[i] <= 109
 * <p>nums 是一个非递减数组
 * <p>-109 <= target <= 109
 * <p>通过次数253,817提交次数597,843
 * <p>请问您在哪类招聘中遇到此题？
 * <p>贡献者
 * <p>LeetCode
 * <p>https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 7:10 下午
 */
public class NCh079_34_FindFirstAndLastPositionOfElementInSortedArray在排序数组中查找元素的第一个和最后一个位置 {
    /**
     * <p>复杂度分析
     *
     * <p>   时间复杂度： O(logn)
     *
     * <p>    空间复杂度：O(1) 。只需要常数空间存放若干变量。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }}
