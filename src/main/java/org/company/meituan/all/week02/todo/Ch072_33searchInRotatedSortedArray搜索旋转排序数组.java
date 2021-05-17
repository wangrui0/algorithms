package org.company.meituan.all.week02.todo;

/**
 * <p>33. 搜索旋转排序数组
 * <p>整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * <p>给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [4,5,6,7,0,1,2], target = 0
 * <p>输出：4
 * <p>示例 2：
 *
 * <p>输入：nums = [4,5,6,7,0,1,2], target = 3
 * <p>输出：-1
 * <p>示例 3：
 *
 * <p>输入：nums = [1], target = 0
 * <p>输出：-1
 *
 *
 * <p>提示：
 *
 * <p>1 <= nums.length <= 5000
 * <p>-10^4 <= nums[i] <= 10^4
 * <p>nums 中的每个值都 独一无二
 * <p>题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * <p>-10^4 <= target <= 10^4
 *
 *
 * <p>进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 *
 * <p>通过次数278,877提交次数668,982
 * <p>请问您在哪类招聘中遇到此题？
 * <p>贡献者
 * <p>LeetCode
 * <p>https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:40 下午
 */
public class Ch072_33searchInRotatedSortedArray搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        return -1;
    }
}
