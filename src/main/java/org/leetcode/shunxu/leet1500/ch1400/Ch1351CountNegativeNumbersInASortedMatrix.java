package org.leetcode.shunxu.leet1500.ch1400;


/**
 * <p>1351. 统计有序矩阵中的负数
 *
 * <p>给你一个 m *<p>n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 *
 * <p>请你统计并返回 grid 中 负数 的数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * <p>输出：8
 * <p>解释：矩阵中共有 8 个负数。
 *
 * <p>示例 2：
 *
 * <p>输入：grid = [[3,2],[1,0]]
 * <p>输出：0
 *
 * <p>示例 3：
 *
 * <p>输入：grid = [[1,-1],[-1,-1]]
 * <p>输出：3
 *
 * <p>示例 4：
 *
 * <p>输入：grid = [[-1]]
 * <p>输出：1
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == grid.length
 * <p>    n == grid[i].length
 * <p>    1 <= m, n <= 100
 * <p>    -100 <= grid[i][j] <= 100
 *
 *
 *
 * <p>进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 *
 *
 * <p>通过次数26,030
 * <p>提交次数34,388
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1351CountNegativeNumbersInASortedMatrix {

  public static void main(String[] args) {
    System.out.println(countNegatives_2(new int[][]{{4, 3}, {2, 1}}));
  }

  public static int countNegatives(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    int ans = 0;
    for (int i = 0; i < r; i++) {
      ans = ans + (c - binarySearch(grid[i]));
    }
    return ans;
  }


  public static int binarySearch(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right + 1;
  }


  /**
   * 方法二：倒序遍历
   *
   * @param grid
   * @return
   */
  public static int countNegatives_2(int[][] grid) {
    int r = grid.length;
    int c = grid[0].length;
    int ans = 0;
    int last = -1;
    for (int i = 0; i < r; i++) {
      last = binarySearch_2(grid[i], (last != -1 ? last-1 : c - 1));
      ans = ans + (c - last);
    }
    return ans;
  }

  public static int binarySearch_2(int[] nums, int right) {
    int left = 0;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right + 1;
  }

}
