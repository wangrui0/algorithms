package org.leetcode.shunxu.ch1050;

/**
 * <p>1025. 除数博弈
 *
 * <p>爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * <p>最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * <p>    选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * <p>    用 N - x 替换黑板上的数字 N 。
 *
 * <p>如果玩家无法执行这些操作，就会输掉游戏。
 *
 * <p>只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：2
 * <p>输出：true
 * <p>解释：爱丽丝选择 1，鲍勃无法进行操作。
 *
 * <p>示例 2：
 *
 * <p>输入：3
 * <p>输出：false
 * <p>解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= N <= 1000
 * https://leetcode-cn.com/problems/divisor-game/
 * <p>通过次数68,235
 * <p>提交次数95,844
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1025DivisorGame {

  /**
   * <p>方法一：数学：
   * <p>会发现这样一个现象：N 为奇数的时候 Alice（先手）必败，N 为偶数的时候 Alice 必胜。 这个猜想是否正确呢？下面我们来想办法证明它
   *
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(1)。
   * <p> 空间复杂度：O(1)。
   *
   * @param n
   * @return
   */
  public boolean divisorGame(int n) {
    return n % 2 == 0;
  }

  /**
   * <p>方法二：动态规划
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n^2)。递推的时候一共有 n 个状态要计算，每个状态需要 O(n) 的时间枚举因数，因此总时间复杂度为 O(n^2)。
   * <p> 空间复杂度：O(n)。我们需要 O(n) 的空间存储递推数组 f 的值。
   *
   * @param N
   * @return
   */
  public boolean divisorGame_2(int N) {
    boolean[] f = new boolean[N + 5];

    f[1] = false;
    f[2] = true;
    for (int i = 3; i <= N; ++i) {
      for (int j = 1; j < i; ++j) {
        if ((i % j) == 0 && !f[i - j]) {
          f[i] = true;
          break;
        }
      }
    }

    return f[N];

  }
}
