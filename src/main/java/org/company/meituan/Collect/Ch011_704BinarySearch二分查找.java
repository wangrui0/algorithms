package org.company.meituan.Collect;

/**
 * <p>704. 二分查找
 *
 * <p>给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * <p>示例 1:
 *
 * <p>输入: nums = [-1,0,3,5,9,12], target = 9
 * <p>输出: 4
 * <p>解释: 9 出现在 nums 中并且下标为 4
 *
 * <p>示例 2:
 *
 * <p>输入: nums = [-1,0,3,5,9,12], target = 2
 * <p>输出: -1
 * <p>解释: 2 不存在 nums 中因此返回 -1
 *
 *
 *
 * <p>提示：
 *
 * <p>    你可以假设 nums 中的所有元素是不重复的。
 * <p>    n 将在 [1, 10000]之间。
 * <p>    nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * <p>通过次数119,096
 * <p>提交次数211,635
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch011_704BinarySearch二分查找 {


  public static int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    System.out.println(search(new int[]{1, 5, 5, 6, 6}, 5));
//    System.out.println(search(new int[]{5, 5, 5, 6, 6}, 5));
  }

  /**
   * <p> System.out.println(search(new int[]{1, 5, 5, 6, 6}, 8));
   * <p>  System.out.println(search(new int[]{5, 5, 5, 6, 6}, 5));
   * <p> 寻找第一个
   *
   * @param nums
   * @param target
   * @return
   */
  public static int firstSearch(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) {
      return -1;
    }
    int left = 0, right = len - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        right = mid;//缩小边界，不断向左边界靠近
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      }
    }
    //反之区间只有两个元素时，且刚好是两个相同的元素
    return nums[left] == target ? left : -1;
  }

  /**
   * <p> System.out.println(search(new int[]{1, 5, 5, 6, 6}, 8));
   * <p>  System.out.println(search(new int[]{5, 5, 5, 6, 6}, 5));
   *
   * @param nums
   * @param target
   * @return
   */
  public static int lastSearch(int[] nums, int target) {
    int len = nums.length;
    if (len == 0) {
      return -1;
    }
    int left = 0, right = len-1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        left = mid+1;//缩小边界，不断向左边界靠近
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      }
    }
    //反之区间只有两个元素时，且刚好是两个相同的元素
    return nums[right] == target ? right : -1;
  }
}
