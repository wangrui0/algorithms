package org.leetcode.leet1500.ch1050;

/**
 * <p>1033. 移动石子直到连续
 *
 * <p>三枚石子放置在数轴上，位置分别为 a，b，c。
 *
 * <p>每一回合，你可以从两端之一拿起一枚石子（位置最大或最小），并将其放入两端之间的任一空闲位置。形式上，假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。那么就可以从位置 x 或者是位置 z
 * 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。
 *
 * <p>当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。
 *
 * <p>要使游戏结束，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回答案：answer = [minimum_moves, maximum_moves]
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：a = 1, b = 2, c = 5
 * <p>输出：[1, 2]
 * <p>解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。
 *
 * <p>示例 2：
 *
 * <p>输入：a = 4, b = 3, c = 2
 * <p>输出：[0, 0]
 * <p>解释：我们无法进行任何移动。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= a <= 100
 * <p>    1 <= b <= 100
 * <p>    1 <= c <= 100
 * <p>    a != b, b != c, c != a
 *
 * <p>通过次数9,531
 * <p>提交次数24,747
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/moving-stones-until-consecutive/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1033MovingStonesUntilConsecutive {

  /**
   * <p>思路：
   *
   * <p>先将最小数给a，最大数给c（用于判断相对位置）
   * <p>最大移动次数很简单就是将a,c一步步向b靠拢也就是移动(c-b-1)+(b-a-1)=c-a-2 次
   * <p>下面讨论最小移动次数即可：
   * <p>情况I 若a,b,c相邻则无法移动 返回[0,0]
   * <p>情况II 若a,b,c中有两个相邻 最少移动一次 返回[1,c-a-2]
   * <p> 情况III 若a,b,c中有两个想近（隔一位，也就是a_b或b_c）,最少移动一次，填在空中即可。返回[1,c-a-2]
   * <p> 其他情况都是最少移动两次，先创造一个相近的位置，达到情况III然后填空。返回[2,c-a-2]
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public int[] numMovesStones(int a, int b, int c) {
    int t;
    if (a > b) {
      t = a;
      a = b;
      b = t;
    }
    if (a > c) {
      t = a;
      a = c;
      c = t;
    }
    if (b > c) {
      t = b;
      b = c;
      c = t;
    }   //将最小值给a，最大值给c
    if (a == b - 1 && a == c - 2)  //a，b，c相邻无法移动
    {
      return new int[]{0, 0};
    }
    if (b == a + 1 || c == b + 1 || b == a + 2 || b == c - 2)  //有两个数相邻或相近（隔一位）注意我们上面已经排除了3个数相邻情况
    {
      return new int[]{1, c - a - 2};
    }
    return new int[]{2, c - a - 2};  //其他情况
  }
}
