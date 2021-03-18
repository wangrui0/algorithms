package org.leetcode.shunxu.ch650;

/**
 * <p>605. 种花问题
 * <p>假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * <p>给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：flowerbed = [1,0,0,0,1], n = 1
 * <p>输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>1 <= flowerbed.length <= 2 * 104
 * <p>flowerbed[i] 为 0 或 1
 * <p> flowerbed 中不存在相邻的两朵花
 * <p> 0 <= n <= flowerbed.length
 * <p>通过次数83,027提交次数244,817
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/can-place-flowers/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:13 下午
 */
public class Ch605CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    int pre = -1;
    int length = flowerbed.length;
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (flowerbed[i] == 1) {
        if (pre == -1) {
          count += i / 2;
        } else {
          count += (i - pre - 2) / 2;
        }
        pre = i;
        if (count >= n) {
          return true;
        }
      }
    }

    if (pre == -1) {
      count += (length + 1) / 2;
    } else {
      count += (length - 1 - pre) / 2;
    }
    return count >= n;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(m)，其中 m 是数组 flowerbed 的长度。需要遍历数组一次。
   *
   * <p>   空间复杂度:O(1)。额外使用的空间为常数。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/can-place-flowers/solution/chong-hua-wen-ti-by-leetcode-solution-sojr/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param flowerbed
   * @param n
   * @return
   */
  public boolean canPlaceFlowers2(int[] flowerbed, int n) {
    int count = 0;
    int m = flowerbed.length;
    int prev = -1;
    for (int i = 0; i < m; i++) {
      if (flowerbed[i] == 1) {
        if (prev < 0) {
          count += i / 2;
        } else {
          count += (i - prev - 2) / 2;
        }
        if (count >= n) {
          return true;
        }
        prev = i;
      }
    }
    if (prev < 0) {
      count += (m + 1) / 2;
    } else {
      count += (m - prev - 1) / 2;
    }
    return count >= n;
  }
}


