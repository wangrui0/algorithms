package org.leetcode.leet1500.ch1150;

/**
 * <p>1128. 等价多米诺骨牌对的数量
 *
 * <p>给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * <p>如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * <p>形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * <p>在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * <p>输出：1
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= dominoes.length <= 40000
 * <p>    1 <= dominoes[i][j] <= 9
 *
 * <p>通过次数35,196
 * <p>提交次数64,605
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1128NumberOfEquivalentDominoPairs {

  /**
   * 桶排序+二维降一维（二元组表示 + 计数）
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是多米诺骨牌的数量。我们至多只需要遍历一次该数组。
   *
   * <p>  空间复杂度：O(1)，我们只需要常数的空间存储若干变量。
   *
   * @param dominoes
   * @return
   */
  public int numEquivDominoPairs(int[][] dominoes) {
    int[] num = new int[100];
    int ret = 0;
    for (int[] domino : dominoes) {
      int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];
      ret += num[val];
      num[val]++;
    }
    return ret;
  }
}
