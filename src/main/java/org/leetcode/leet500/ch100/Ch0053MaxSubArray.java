package org.leetcode.leet500.ch100;

/**
 * <p>
 * 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * <p>
 * 输出: 6
 * <p>
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/10
 */
public class Ch0053MaxSubArray {

  public static void main(String[] args) {
    System.out.println(maxSubArray(new int[]{1}));
  }

  /**
   * @param nums
   * @return
   */
  public static int maxSubArray(int[] nums) {
    int pre = 0;
    int result = nums[0];
    for (int i = 0; i < nums.length; i++) {
      pre = Math.max(pre + nums[i], nums[i]);
      result = Math.max(pre, result);
    }

    return result;

  }

  /**
   * 官方：
   * <p>
   * 方法一：动态规划
   * <p>
   * 思路和算法
   * <p>
   * 假设 nums 数组的长度是 n，下标从 0 到 n−1。
   * <p>
   * 我们用 a_i 代表 nums[i]，用 f(i) 代表以第 i 个数结尾的「连续子数组的最大和」，那么很显然我们要求的答案就是：
   * <p>
   * max  {f(i)}
   * <p>
   * 0≤i≤n−1
   * <p>
   * 因此我们只需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i) 呢？我们可以考虑 a_i 单独成为一段还是加入 f(i−1) 对应的那一段，
   * <p>
   * 这取决于 a_i和 f(i - 1) + a_i
   * <p>
   * 的大小，我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：
   * <p>
   * f(i)=max{f(i - 1) + a_i， a_i}
   * <p>
   * 不难给出一个时间复杂度 O(n)、空间复杂度 O(n) 的实现，即用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。考虑到 f(i) 只和 f(i−1)
   * <p>
   * 相关，于是我们可以只用一个变量 pre 来维护对于当前 f(i) 的 f(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。
   * <p>
   * =================================================
   * <p>
   * 复杂度
   * <p>
   * 时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
   * <p>
   * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
   * <p>
   *
   * @param nums
   * @return
   */
  public int maxSubArray2(int[] nums) {
    int pre = 0, maxAns = nums[0];
    for (int x : nums) {
      pre = Math.max(pre + x, x);
      maxAns = Math.max(maxAns, pre);
    }
    return maxAns;
  }

}
