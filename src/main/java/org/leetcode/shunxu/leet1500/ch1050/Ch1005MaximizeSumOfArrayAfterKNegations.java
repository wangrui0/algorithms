package org.leetcode.shunxu.leet1500.ch1050;

import java.util.Arrays;

/**
 * <p>1005. K 次取反后最大化的数组和
 *
 * <p>给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * <p>以这种方式修改数组后，返回数组可能的最大和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：A = [4,2,3], K = 1
 * <p>输出：5
 * <p>解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 *
 * <p>示例 2：
 *
 * <p>输入：A = [3,-1,0,2], K = 3
 * <p>输出：6
 * <p>解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 *
 * <p>示例 3：
 *
 * <p>输入：A = [2,-3,-1,5,-4], K = 2
 * <p>输出：13
 * <p>解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 10000
 * <p>    1 <= K <= 10000
 * <p>    -100 <= A[i] <= 100
 * https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations/
 * <p>通过次数16,917
 * <p>提交次数31,440
 * <p>@author: wangrui
 * <p>@date: 2021/4/3
 */
public class Ch1005MaximizeSumOfArrayAfterKNegations {

  public int largestSumAfterKNegations(int[] A, int K) {
    Arrays.sort(A);
    int sum = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < A.length; i++) {
      if (A[i] < 0 && K-- > 0) {
        A[i] = -1 * A[i];
      }
      sum += A[i];
      min = Math.min(min, A[i]);
    }
    if (K > 0 && K % 2 == 1) {
      sum = sum - min + (-1 * min);
    }
    return sum;
  }

  public int largestSumAfterKNegations_2(int[] arr, int k) {
    Arrays.sort(arr); // asc: 负数...0..0..正数
    int sum = 0, len = arr.length, minIndex = 0; // 初始第一个最小
    while (k > 0) {
      arr[minIndex] = -arr[minIndex]; // 最小者取反
      k--;
      // 维护最小值索引
      // 若后面还有数，则看当前的与下一个谁更小
      if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) {
        minIndex++;
      }
    }
    for (int i : arr) {
      sum += i;
    }
    return sum;
  }
}
