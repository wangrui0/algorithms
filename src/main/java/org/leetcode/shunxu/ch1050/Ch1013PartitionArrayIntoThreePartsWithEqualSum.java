package org.leetcode.shunxu.ch1050;

/**
 * <p>1013. 将数组分成和相等的三个部分
 *
 * <p>给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * <p>形式上，如果可以找出索引 i+1 < j 且满足 A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... +
 * A[A.length - 1] 就可以将数组三等分。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * <p>输出：true
 * <p>解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * <p>示例 2：
 *
 * <p>输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * <p>输出：false
 *
 * <p>示例 3：
 *
 * <p>输入：[3,3,6,5,-2,2,5,1,-9,4]
 * <p>输出：true
 * <p>解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 *
 *
 * <p>提示：
 *
 * <p>    3 <= A.length <= 50000
 * <p>    -10^4 <= A[i] <= 10^4
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/
 * <p>通过次数42,575
 * <p>提交次数105,829
 * <p>@author: wangrui
 * <p>@date: 2021/4/3
 */
public class Ch1013PartitionArrayIntoThreePartsWithEqualSum {

  public boolean canThreePartsEqualSum_self(int[] arr) {
    int sum = 0;
    for (int x : arr) {
      sum += x;
    }
    if (sum % 3 != 0) {
      return false;
    }

    int target = sum / 3;
    int preSum = 0;
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      preSum += arr[i];
      if (preSum == target) {
        index = i;
        break;
      }
    }
    if (preSum != target) {
      return false;
    }
    for (int i = index + 1; i < arr.length; i++) {
      preSum += arr[i];
      if (preSum == target * 2) {
        index = i;
        break;
      }
    }
    return preSum == target * 2 && index < arr.length - 1;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：O(N)，其中 N 是数组 A 的长度。我们最多只需要遍历一遍数组就可以得到答案。
   *
   * <p>   空间复杂度：O(1)。我们只需要使用额外的索引变量 i，j 以及一些存储数组信息的变量。
   *
   * @param A
   * @return
   */
  public boolean canThreePartsEqualSum(int[] A) {
    int s = 0;
    for (int num : A) {
      s += num;
    }
    if (s % 3 != 0) {
      return false;
    }
    int target = s / 3;
    int n = A.length, i = 0, cur = 0;
    while (i < n) {
      cur += A[i];
      if (cur == target) {
        break;
      }
      ++i;
    }
    if (cur != target) {
      return false;
    }
    int j = i + 1;
    while (j + 1 < n) {  // 需要满足最后一个数组非空
      cur += A[j];
      if (cur == target * 2) {
        return true;
      }
      ++j;
    }
    return false;
  }


}
