package org.leetcode.leet500.ch500;

/**
 * <p>461. 汉明距离
 *
 * <p>两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * <p>给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * <p>注意：
 * <p>0 ≤ x, y < 231.
 *
 * <p>示例:
 *
 * <p>输入: x = 1, y = 4
 *
 * <p>输出: 2
 *
 * <p>解释:
 * <p>1   (0 0 0 1)
 * <p>4   (0 1 0 0)
 * <p>       ↑   ↑
 *
 * <p>上面的箭头指出了对应二进制位不同的位置。
 * <p>https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch461HammingDistance {

  public static int hammingDistance(int x, int y) {
    int num = x ^ y;
    int count = 0;
    while (num != 0) {
      int remainder = num % 2;
      if (remainder == 1) {
        count++;
      }
      num = num >> 1;
    }
    return count;
  }

  /**
   * <p>复杂度分析
   * <p>   时间复杂度：O(1)，在 Python 和 Java 中 Integer 的大小是固定的，处理时间也是固定的。 32 位整数需要 32 次迭代。
   * <p>   空间复杂度：O(1)，使用恒定大小的空间。
   *
   * @param x
   * @param y
   * @return
   */
  public int hammingDistance2(int x, int y) {
    int xor = x ^ y;
    int distance = 0;
    while (xor != 0) {
      if (xor % 2 == 1) {
        distance += 1;
      }
      xor = xor >> 1;
    }
    return distance;
  }

}

