package org.leetcode.leet1000.ch1000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>989. 数组形式的整数加法
 *
 * <p>对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * <p>给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：A = [1,2,0,0], K = 34
 * <p>输出：[1,2,3,4]
 * <p>解释：1200 + 34 = 1234
 *
 * <p>示例 2：
 *
 * <p>输入：A = [2,7,4], K = 181
 * <p>输出：[4,5,5]
 * <p>解释：274 + 181 = 455
 *
 * <p>示例 3：
 *
 * <p>输入：A = [2,1,5], K = 806
 * <p>输出：[1,0,2,1]
 * <p>解释：215 + 806 = 1021
 *
 * <p>示例 4：
 *
 * <p>输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * <p>输出：[1,0,0,0,0,0,0,0,0,0,0]
 * <p>解释：9999999999 + 1 = 10000000000
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 10000
 * <p>    0 <= A[i] <= 9
 * <p>    0 <= K <= 10000
 * <p>    如果 A.length > 1，那么 A[0] != 0
 *
 * <p>通过次数46,583
 * <p>提交次数97,101
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch989AddToArrayFormOfInteger {


  public List<Integer> addToArrayForm_self(int[] A, int K) {
    List<Integer> list = new ArrayList<>();
    for (int i = A.length - 1; i >= 0; i--, K = K / 10) {
      K = K + A[i];
      list.add(K % 10);
    }
    while (K > 0) {
      list.add(K % 10);
      K /= 10;
    }
    Collections.reverse(list);
    return list;
  }

  /**
   * @param A
   * @param K
   * @return
   */
  public List<Integer> addToArrayForm_1(int[] A, int K) {
    List<Integer> res = new ArrayList<Integer>();
    int n = A.length;
    for (int i = n - 1; i >= 0; --i) {
      int sum = A[i] + K % 10;
      K /= 10;
      if (sum >= 10) {
        K++;
        sum -= 10;
      }
      res.add(sum);
    }
    for (; K > 0; K /= 10) {
      res.add(K % 10);
    }
    Collections.reverse(res);
    return res;
  }


  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(max(n,logK))，其中 n 为数组的长度。
   *
   * <p>   空间复杂度：O(1)。除了返回值以外，使用的空间为常数。
   *
   * @param A
   * @param K
   * @return
   */
  public List<Integer> addToArrayForm_2(int[] A, int K) {
    List<Integer> res = new ArrayList<Integer>();
    int n = A.length;
    for (int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
      if (i >= 0) {
        K += A[i];
      }
      res.add(K % 10);
    }
    Collections.reverse(res);
    return res;
  }

}
