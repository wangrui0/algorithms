package org.company.meituan.all.week01.done;

/**
 * <p>剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 *
 * <p>输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：nums = [1,2,3,4]
 * <p>输出：[1,3,2,4]
 * <p>注：[3,1,2,4] 也是正确的答案之一。
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= nums.length <= 50000
 * <p>    1 <= nums[i] <= 10000
 *
 * <p>通过次数138,065
 * <p>提交次数215,368
 * <p>https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch049_offer_21_DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof调整数组顺序使奇数位于偶数前面 {

  public int[] exchange_self(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return nums;
    }
    int left = 0, right = nums.length - 1;
    while (left < right) {
      while (left < right && nums[left] % 2 == 1) {
        left++;
      }
      while (left < right && nums[right] % 2 == 0) {
        right--;
      }
      if (left < right && nums[left] % 2 == 0 && nums[right] % 2 == 1) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;
      }
    }
    return nums;
  }

  public void swap(int a, int b, int[] nums) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  public int[] exchange(int[] nums) {
    int l = 0;
    int r = nums.length - 1;
    while (l < r) {
      if ((nums[l] & 1) == 1 && (nums[r] & 1) == 0) {
        l++;
        r--;
      } else if ((nums[l] & 1) == 0 && (nums[r] & 1) == 1) {
        swap(l++, r--, nums);
      } else if ((nums[l] & 1) == 1) {
        l++;
      } else {
        r--;
      }
    }
    return nums;
  }
}
