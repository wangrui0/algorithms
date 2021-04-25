package org.leetcode.shunxu.leet2000.ch1650;

import java.util.Arrays;

/**
 * <p>1608. 特殊数组的特征值
 * <p>给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * <p><p>
 * <p>注意： x 不必 是 nums 的中的元素。
 * <p><p>
 * <p>如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 * <p><p>
 * <p><p>
 * <p><p>
 * <p>示例 1：
 * <p><p>
 * <p>输入：nums = [3,5]
 * <p>输出：2
 * <p>解释：有 2 个元素（3 和 5）大于或等于 2 。
 * <p>示例 2：
 * <p><p>
 * <p>输入：nums = [0,0]
 * <p>输出：-1
 * <p>解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
 * <p>如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
 * <p>如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
 * <p>如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
 * <p>x 不能取更大的值，因为 nums 中只有两个元素。
 * <p>示例 3：
 * <p><p>
 * <p>输入：nums = [0,4,3,0,4]
 * <p>输出：3
 * <p>解释：有 3 个元素大于或等于 3 。
 * <p>示例 4：
 * <p><p>
 * <p>输入：nums = [3,6,7,7,0]
 * <p>输出：-1
 * <p><p>
 * <p><p>
 * <p>提示：
 * <p><p>
 * <p>1 <= nums.length <= 100
 * <p>0 <= nums[i] <= 1000
 * <p>通过次数8,124提交次数12,703
 *
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:07 下午
 */
public class Ch1608SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        for (int i = 1; i <= nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                return i;
            }
        }
        return -1;
    }

    public int specialArray_2(int[] nums) {
        /**
         * small -> too many
         * big -> too few
         * binarySearch
         */
        int size = nums.length;
        if (size == 0) return -1;
        Arrays.sort(nums);

        int i = 0, j = size, m;
        if (nums[size - 1] == 0) return -1;
        if (nums[0] >= j) return j;

        while (i <= j) {
            m = (i + j) >> 1;
            if (m == 0) i++;
            else if (nums[size - m] >= m)
                if (size - m - 1 < 0 || nums[size - m - 1] < m)
                    return m;
                else i++;
            else j--;

        }
        return -1;
    }

}
