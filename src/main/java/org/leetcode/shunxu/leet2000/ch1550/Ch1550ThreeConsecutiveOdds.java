package org.leetcode.shunxu.leet2000.ch1550;

/**
 * <p>1550. 存在连续三个奇数的数组
 *
 * <p>给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [2,6,4,1]
 * <p>输出：false
 * <p>解释：不存在连续三个元素都是奇数的情况。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,2,34,3,4,5,7,23,12]
 * <p>输出：true
 * <p>解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 1000
 * <p>    1 <= arr[i] <= 1000
 *
 * <p>通过次数18,746
 * <p>提交次数28,436
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/three-consecutive-odds/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1550ThreeConsecutiveOdds {

  public boolean threeConsecutiveOdds(int[] arr) {
    for (int i = 0; i < arr.length - 2; i++) {
      if ((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
        return true;
      }
    }
    return false;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 记原序列的长度为 n。
   *
   * <p>   时间复杂度：O(n)。
   * <p>   空间复杂度：O(1)。
   *
   * @param arr
   * @return
   */
  public boolean threeConsecutiveOdds_2(int[] arr) {
    int n = arr.length;
    for (int i = 0; i <= n - 3; ++i) {
      if ((arr[i] & 1) != 0 && (arr[i + 1] & 1) != 0 && (arr[i + 2] & 1) != 0) {
        return true;
      }
    }
    return false;
  }

}
