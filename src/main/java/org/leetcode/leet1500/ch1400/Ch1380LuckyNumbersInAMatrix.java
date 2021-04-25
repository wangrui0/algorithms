package org.leetcode.leet1500.ch1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>1380. 矩阵中的幸运数
 *
 * <p>给你一个 m *<p>n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 *
 * <p>幸运数是指矩阵中满足同时下列两个条件的元素：
 *
 * <p>    在同一行的所有元素中最小
 * <p>    在同一列的所有元素中最大
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * <p>输出：[15]
 * <p>解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * <p>示例 2：
 *
 * <p>输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * <p>输出：[12]
 * <p>解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 *
 * <p>示例 3：
 *
 * <p>输入：matrix = [[7,8],[1,2]]
 * <p>输出：[7]
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == mat.length
 * <p>    n == mat[i].length
 * <p>    1 <= n, m <= 50
 * <p>    1 <= matrix[i][j] <= 10^5
 * <p>    矩阵中的所有元素都是不同的
 *
 * <p>通过次数14,571
 * <p>提交次数20,136
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/lucky-numbers-in-a-matrix/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1380LuckyNumbersInAMatrix {

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：预处理的时间代价是O(mn)，统计答案的时间代价也是 O(mn)，故渐进时间复杂度为 O(mn)。
   *
   * <p>  空间复杂度：这里用到了两个辅助数组 rMin 和 cMax，长度分别为 m 和 n，故渐进空间复杂度为 O(m+n)。
   *
   * @param matrix
   * @return
   */
  public List<Integer> luckyNumbers(int[][] matrix) {
    int r = matrix.length, c = matrix[0].length;
    int[] rMin = new int[r];
    Arrays.fill(rMin, Integer.MAX_VALUE);
    int[] cMax = new int[c];
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        rMin[i] = Math.min(rMin[i], matrix[i][j]);
        cMax[j] = Math.max(cMax[j], matrix[i][j]);
      }
    }

    List<Integer> ans = new ArrayList<Integer>();
    for (int i = 0; i < r; ++i) {
      for (int j = 0; j < c; ++j) {
        if (matrix[i][j] == rMin[i] && matrix[i][j] == cMax[j]) {
          ans.add(matrix[i][j]);
        }
      }
    }
    return ans;
  }

}
