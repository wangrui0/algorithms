package org.leetcode.leet1500.ch1050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>1030. 距离顺序排列矩阵单元格
 *
 * <p>给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * <p>另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * <p>返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 -
 * c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：R = 1, C = 2, r0 = 0, c0 = 0
 * <p>输出：[[0,0],[0,1]]
 * <p>解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 *
 * <p>示例 2：
 *
 * <p>输入：R = 2, C = 2, r0 = 0, c0 = 1
 * <p>输出：[[0,1],[0,0],[1,1],[1,0]]
 * <p>解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * <p>[[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 *
 * <p>示例 3：
 *
 * <p>输入：R = 2, C = 3, r0 = 1, c0 = 2
 * <p>输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * <p>解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * <p>其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 *
 *
 * <p>提示：
 *
 * <p>    1 <= R <= 100
 * <p>    1 <= C <= 100
 * <p>    0 <= r0 < R
 * <p>    0 <= c0 < C
 *
 * <p>通过次数38,368
 * <p>提交次数53,747
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1030MatrixCellsInDistanceOrder {

  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    int[][] ans = new int[R * C][];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        ans[i * C + j] = new int[]{i, j};
      }
    }
    Arrays.sort(ans, Comparator.comparingInt(o -> (Math.abs(o[0] - r0) + Math.abs(o[1] - c0))));
    return ans;
  }

  /**
   * <p>方法一：直接排序
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(RClog(RC))，存储所有点时间复杂度 O(RC)，排序时间复杂度 O(RClog(RC))。
   *
   * <p>空间复杂度：O(log(RC))，即为排序需要使用的栈空间，不考虑返回值的空间占用。
   *
   * @param R
   * @param C
   * @param r0
   * @param c0
   * @return
   */
  public int[][] allCellsDistOrder_1(int R, int C, int r0, int c0) {
    int[][] ret = new int[R * C][];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        ret[i * C + j] = new int[]{i, j};
      }
    }
    Arrays.sort(ret, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0)) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
      }
    });
    return ret;
  }

  /**
   * <p> 方法二：桶排序
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(RC)，存储所有点时间复杂度 O(RC)，桶排序时间复杂度 O(RC)。
   *
   * <p>    空间复杂度：O(RC)，需要存储矩阵内所有点。
   *（桶排序，是先用某个桶list,来装某个值的元素有哪些，然后开始遍历值）
   * @param R
   * @param C
   * @param r0
   * @param c0
   * @return
   */
  public int[][] allCellsDistOrder_2(int R, int C, int r0, int c0) {
    int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
    List<List<int[]>> bucket = new ArrayList<List<int[]>>();
    for (int i = 0; i <= maxDist; i++) {
      bucket.add(new ArrayList<int[]>());
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        int d = dist(i, j, r0, c0);
        bucket.get(d).add(new int[]{i, j});
      }
    }
    int[][] ret = new int[R * C][];
    int index = 0;
    for (int i = 0; i <= maxDist; i++) {
      for (int[] it : bucket.get(i)) {
        ret[index++] = it;
      }
    }
    return ret;
  }

  public int dist(int r1, int c1, int r2, int c2) {
    return Math.abs(r1 - r2) + Math.abs(c1 - c2);
  }

  int[] dr = {1, 1, -1, -1};
  int[] dc = {1, -1, -1, 1};

  /**
   * <p> 方法三：几何法
   * <p>  复杂度分析
   *
   * <p>     时间复杂度：O((R+C)2)，我们需要遍历矩阵内所有点，同时也会遍历部分超过矩阵部分的点。在最坏情况下，给定的单元格位于矩阵的一个角，例如 (0,0)，此时最大的曼哈顿距离为 R+C−2，需要遍历的点数为
   * 2(R+C−2)(R+C−1)+1，因此时间复杂度为 O((R+C)2)。
   *
   * <p>    空间复杂度：O(1)，不考虑返回值的空间占用。
   *
   * @param R
   * @param C
   * @param r0
   * @param c0
   * @return
   */
  public int[][] allCellsDistOrder_3(int R, int C, int r0, int c0) {
    int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
    int[][] ret = new int[R * C][];
    int row = r0, col = c0;
    int index = 0;
    ret[index++] = new int[]{row, col};
    for (int dist = 1; dist <= maxDist; dist++) {
      row--;
      for (int i = 0; i < 4; i++) {
        while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
          if (row >= 0 && row < R && col >= 0 && col < C) {
            ret[index++] = new int[]{row, col};
          }
          row += dr[i];
          col += dc[i];
        }
      }
    }
    return ret;
  }


}
