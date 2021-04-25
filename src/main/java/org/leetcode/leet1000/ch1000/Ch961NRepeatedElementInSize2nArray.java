package org.leetcode.leet1000.ch1000;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>961. 重复 N 次的元素
 *
 * <p>在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * <p>返回重复了 N 次的那个元素。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,2,3,3]
 * <p>输出：3
 *
 * <p>示例 2：
 *
 * <p>输入：[2,1,2,5,3,2]
 * <p>输出：2
 *
 * <p>示例 3：
 *
 * <p>输入：[5,1,5,2,5,3,5,4]
 * <p>输出：5
 *
 *
 *
 * <p>提示：
 *
 * <p>    4 <= A.length <= 10000
 * <p>    0 <= A[i] < 10000
 * <p>    A.length 为偶数
 *
 * <p>通过次数31,885
 * <p>提交次数47,352
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch961NRepeatedElementInSize2nArray {

  public static int repeatedNTimes(int[] A) {
    int N = A.length;
    for (int k = 1; k <= 3; k++) {
      for (int j = 0; j + k < N; j++) {
        if (A[j] == A[j + k]) {
          return A[j];
        }
      }
    }
    return -1;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是 A 的长度。
   * <p>   空间复杂度：O(N)。
   *
   * @param A
   * @return
   */
  public int repeatedNTimes_1(int[] A) {
    Map<Integer, Integer> count = new HashMap();
    for (int x : A) {
      count.put(x, count.getOrDefault(x, 0) + 1);
    }

    for (int k : count.keySet()) {
      if (count.get(k) > 1) {
        return k;
      }
    }

    throw null;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是 A 的长度。
   * <p>   空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public int repeatedNTimes_2(int[] A) {
    for (int k = 1; k <= 3; ++k) {
      for (int i = 0; i < A.length - k; ++i) {
        if (A[i] == A[i + k]) {
          return A[i];
        }
      }
    }

    throw null;
  }


}


