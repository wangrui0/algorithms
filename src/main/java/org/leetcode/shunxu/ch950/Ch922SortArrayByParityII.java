package org.leetcode.shunxu.ch950;

/**
 * <p>922. 按奇偶排序数组 II
 *
 * <p>给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * <p>对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * <p>你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：[4,2,5,7]
 * <p>输出：[4,5,2,7]
 * <p>解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= A.length <= 20000
 * <p>    A.length % 2 == 0
 * <p>    0 <= A[i] <= 1000
 *
 *
 * <p>通过次数81,847
 * <p>提交次数114,451
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch922SortArrayByParityII {

  public static void main(String[] args) {
    System.out.println(sortArrayByParityII(new int[]{4, 2, 7, 5}));
  }

  public static int[] sortArrayByParityII(int[] nums) {
    for (int i = 0, j = 1; i < nums.length; i += 2) {
      if (nums[i] % 2 != 0) {
        while (nums[j] % 2 != 0) {
          j += 2;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    return nums;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是数组 A 的长度。
   *
   * <p> 空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public int[] sortArrayByParityII2(int[] A) {
    int n = A.length;
    int j = 1;
    for (int i = 0; i < n; i += 2) {
      if (A[i] % 2 == 1) {
        while (A[j] % 2 == 1) {
          j += 2;
        }
        swap(A, i, j);
      }
    }
    return A;
  }

  public void swap(int[] A, int i, int j) {
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
  }

}
