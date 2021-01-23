package org.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
 * <p>
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p> 输入：19
 * <p> 输出：true
 * <p> 解释：
 * <p>1^2 + 9^2 = 82
 * <p>8^2 + 2^2 = 68
 * <p>6^2 + 8^2 = 100
 * <p>1^2 + 0^2 + 0^2 = 1
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/happy-number
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/22
 */
public class Ch0202HappyNumber {

  /*  根据我们的探索，我们猜测会有以下三种可能。

    最终会得到 111。
    最终会进入循环。
    值会越来越大，最后接近无穷大。*/
  private int getNext(int n) {
    int totalSum = 0;
    while (n > 0) {
      int d = n % 10;
      n = n / 10;
      totalSum += d * d;
    }
    return totalSum;
  }

  /**
   * 方法1：用 HashSet 检测循环
   * <p> 时间复杂度：O(logn)
   * <p>空间复杂度：O(logn)
   *
   * @param n
   * @return
   */
  public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (n != 1 && !seen.contains(n)) {
      seen.add(n);
      n = getNext(n);
    }
    return n == 1;
  }

  public boolean isHappy2(int n) {
    int slowRunner = n;
    int fastRunner = getNext(n);
    while (fastRunner != 1 && slowRunner != fastRunner) {
      slowRunner = getNext(slowRunner);
      fastRunner = getNext(getNext(fastRunner));
    }
    return fastRunner == 1;
  }

  public boolean isHappy3(int n) {
    int slowRunner = n;
    int fastRunner = getNext(n);
    while (fastRunner != 1 && slowRunner != fastRunner) {
      slowRunner = getNext(slowRunner);
      fastRunner = getNext(getNext(fastRunner));
    }
    return fastRunner == 1;
  }
}
