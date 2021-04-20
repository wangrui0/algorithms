package org.leetcode.shunxu.leet1000.ch900;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>888. 公平的糖果棒交换
 *
 * <p>爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 根糖果棒的大小，B[j] 是鲍勃拥有的第 j 根糖果棒的大小。
 *
 * <p>因为他们是朋友，所以他们想交换一根糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * <p>返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
 *
 * <p>如果有多个答案，你可以返回其中任何一个。保证答案存在。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：A = [1,1], B = [2,2]
 * <p>输出：[1,2]
 *
 * <p>示例 2：
 *
 * <p>输入：A = [1,2], B = [2,3]
 * <p>输出：[1,2]
 *
 * <p>示例 3：
 *
 * <p>输入：A = [2], B = [1,3]
 * <p>输出：[2,3]
 *
 * <p>示例 4：
 *
 * <p>输入：A = [1,2,5], B = [2,4]
 * <p>输出：[5,4]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 10000
 * <p>    1 <= B.length <= 10000
 * <p>    1 <= A[i] <= 100000
 * <p>    1 <= B[i] <= 100000
 * <p>    保证爱丽丝与鲍勃的糖果总量不同。
 * <p>    答案肯定存在。
 * <p> https://leetcode-cn.com/problems/fair-candy-swap/
 * <p>通过次数49,901
 * <p>提交次数78,194
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch888FairCandySwap {

  public int[] fairCandySwap(int[] A, int[] B) {
    int sumA = Arrays.stream(A).sum();
    int sumB = Arrays.stream(B).sum();
    int delta = (sumA - sumB) / 2;
    Set<Integer> rec = new HashSet<>();
    for (int a : A) {
      rec.add(a);
    }
    for (int x : B) {
      int y = x + delta;
      if (rec.contains(y)) {
        return new int[]{y, x};
      }
    }
    return null;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n+m)，其中 n 是序列 A 的长度，m 是序列 B 的长度。
   *
   * <p> 空间复杂度：O(n)，其中 n 是序列 A 的长度。我们需要建立一个和序列 A 等大的哈希表。
   *
   * @param A
   * @param B
   * @return
   */
  public int[] fairCandySwap2(int[] A, int[] B) {
    int sumA = Arrays.stream(A).sum();
    int sumB = Arrays.stream(B).sum();
    int delta = (sumA - sumB) / 2;
    Set<Integer> rec = new HashSet<Integer>();
    for (int num : A) {
      rec.add(num);
    }
    int[] ans = new int[2];
    for (int y : B) {
      int x = y + delta;
      if (rec.contains(x)) {
        ans[0] = x;
        ans[1] = y;
        break;
      }
    }
    return ans;
  }
}
