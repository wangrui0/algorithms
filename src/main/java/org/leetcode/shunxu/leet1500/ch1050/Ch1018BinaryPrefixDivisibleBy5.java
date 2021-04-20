package org.leetcode.shunxu.leet1500.ch1050;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1018. 可被 5 整除的二进制前缀
 *
 * <p>给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * <p>返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[0,1,1]
 * <p>输出：[true,false,false]
 * <p>解释：
 * <p>输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 *
 * <p>示例 2：
 *
 * <p>输入：[1,1,1]
 * <p>输出：[false,false,false]
 *
 * <p>示例 3：
 *
 * <p>输入：[0,1,1,1,1,1]
 * <p>输出：[true,false,false,false,true,false]
 *
 * <p>示例 4：
 *
 * <p>输入：[1,1,1,0,1]
 * <p>输出：[false,false,false,false,false]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 30000
 * <p>    A[i] 为 0 或 1
 *
 * <p>通过次数41,916
 * <p>提交次数80,932
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * <p>@author: wangrui
 * <p>@date: 2021/4/3
 */
public class Ch1018BinaryPrefixDivisibleBy5 {

  public static void main(String[] args) {
    System.out.println(prefixesDivBy5(
        new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0,
            1, 0, 0, 0, 1}));
  }

  //可能会溢出
  public static List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> ans = new ArrayList<>();
    int num = 0;
    for (int i = 0; i < A.length; i++) {
      num = (num << 1) + A[i];
      ans.add(num % 5 == 0);
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是数组 A 的长度。需要遍历数组一次并计算前缀。
   *
   * <p> 空间复杂度：O(1)。除了返回值以外，额外使用的空间为常数。
   *
   * @param A
   * @return
   */
  public List<Boolean> prefixesDivBy5_2(int[] A) {
    List<Boolean> answer = new ArrayList<Boolean>();
    int prefix = 0;
    int length = A.length;
    for (int i = 0; i < length; i++) {
      prefix = ((prefix << 1) + A[i]) % 5;
      answer.add(prefix == 0);
    }
    return answer;
  }

  public List<Boolean> prefixesDivBy5_3(int[] A) {
    List<Boolean> answer = new ArrayList<Boolean>();
    int prefix = 0;
    int length = A.length;
    for (int i = 0; i < length; i++) {
      prefix = ((prefix << 1) + A[i]) % 5;
      answer.add(prefix % 5 == 0);
    }
    return answer;
  }


}
