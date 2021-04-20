package org.leetcode.shunxu.leet1000.ch600;

/**
 * <p> 598. 范围求和 II
 * <p>给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 *
 * <p>操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 *
 * <p>在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 *
 * <p>示例 1:
 *
 * <p> 输入:
 * <p>m = 3, n = 3
 * <p>operations = [[2,2],[3,3]]
 * <p>输出: 4
 * <p>解释:
 * <p>初始状态, M =
 * <p>[[0, 0, 0],
 * <p> [0, 0, 0],
 * <p> [0, 0, 0]]
 *
 * <p>执行完操作 [2,2] 后, M =
 * <p>[[1, 1, 0],
 * <p> [1, 1, 0],
 * <p>[0, 0, 0]]
 *
 * <p>执行完操作 [3,3] 后, M =
 * <p>[[2, 2, 1],
 * <p> [2, 2, 1],
 * <p>[1, 1, 1]]
 *
 * <p>M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>注意:
 *
 * <p>m 和 n 的范围是 [1,40000]。
 * <p> a 的范围是 [1,m]，b 的范围是 [1,n]。
 * <p>操作数目不超过 10000。
 * <p>通过次数12,117提交次数23,455
 * <p>https://leetcode-cn.com/problems/range-addition-ii/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:05 下午
 */
public class Ch598RangAdditionII {

  public static int maxCount1(int m, int n, int[][] ops) {
    int minX = m;
    int minY = n;
    for (int[] op : ops) {
      int x = op[0];
      int y = op[1];
      minX = Math.min(Math.min(x, minX), m);
      minY = Math.min(Math.min(y, minY), n);
    }
    return minX * minY;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(x)。只需要遍历所有操作一次，x 是操作的数目。
   *
   * <p>   空间复杂度：O(1)。不需要额外的数组空间。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/range-addition-ii/solution/fan-wei-qiu-he-ii-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param m
   * @param n
   * @param ops
   * @return
   */
  public int maxCount1_1(int m, int n, int[][] ops) {
    for (int[] op : ops) {
      m = Math.min(m, op[0]);
      n = Math.min(n, op[1]);
    }
    return m * n;
  }
}
