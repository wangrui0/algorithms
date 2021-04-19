package org.leetcode.shunxu.ch1350;

import java.util.Arrays;

/**
 * <p>1337. 矩阵中战斗力最弱的 K 行
 *
 * <p>给你一个大小为 m*n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * <p>请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * <p>如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * <p>军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：mat =
 * <p>[[1,1,0,0,0],
 * <p> [1,1,1,1,0],
 * <p> [1,0,0,0,0],
 * <p> [1,1,0,0,0],
 * <p> [1,1,1,1,1]],
 * <p>k = 3
 * <p>输出：[2,0,3]
 * <p>解释：
 * <p>每行中的军人数目：
 * <p>行 0 -> 2
 * <p>行 1 -> 4
 * <p>行 2 -> 1
 * <p>行 3 -> 2
 * <p>行 4 -> 5
 * <p>从最弱到最强对这些行排序后得到 [2,0,3,1,4]
 *
 * <p>示例 2：
 *
 * <p>输入：mat =
 * <p>[[1,0,0,0],
 * <p> [1,1,1,1],
 * <p> [1,0,0,0],
 * <p> [1,0,0,0]],
 * <p>k = 2
 * <p>输出：[0,2]
 * <p>解释：
 * <p>每行中的军人数目：
 * <p>行 0 -> 1
 * <p>行 1 -> 4
 * <p>行 2 -> 1
 * <p>行 3 -> 1
 * <p>从最弱到最强对这些行排序后得到 [0,2,3,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    m == mat.length
 * <p>    n == mat[i].length
 * <p>    2 <= n, m <= 100
 * <p>    1 <= k <= m
 * <p>    matrix[i][j] 不是 0 就是 1
 *
 * <p>通过次数11,981
 * <p>提交次数18,228
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1337TheKWeakestRowsInAMatrix {

  public int[] kWeakestRows(int[][] mat, int k) {
    int[] list = new int[mat.length];
    for (int i = 0; i < mat.length; i++) {
      //很精妙，这个地方*100，后期再除以100取余，正好为索引
      list[i] = count(mat[i]) * 100 + i;
    }
    Arrays.sort(list);
    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = list[i] % 100;
    }
    return ans;
  }

  public int count(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        return sum;
      }
      sum++;
    }
    return sum;
  }

  public int[] kWeakestRows_2(int[][] mat, int k) {
    int n = mat.length;
    // 存储每一行的战斗力和下标对应值，[战斗力，下标]
    int[][] strength = new int[n][2];
    for (int i = 0; i < n; ++i) {
      strength[i][0] = binarySearch(mat[i]);
      strength[i][1] = i;
    }
    // 然后根据战斗力升序排列，如果战斗力相同，就让下标升序排列
    Arrays.sort(strength, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    // 找到前 k 个，进行处理
    int[] ans = new int[k];
    for (int i = 0; i < k; ++i) {
      ans[i] = strength[i][1];
    }
    return ans;
  }

  // 使用二分查找，找到最后一个 1 的位置 idx ，那么 idx - 0 就是当前行中 1 的个数
  private int binarySearch(int[] vector) {
    int left = 0, right = vector.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      // 如果 mid 指针指向的位置是 1 ，那么说明 mid 往左全部是 1，因此把left 指针往右移动一点
      if (vector[mid] == 1) {
        left = mid + 1;
      }
      // 否则的话，就把 right 指针往左移动
      else {
        right = mid;
      }
    }
    // 需要额外注意的是，如果当前行全部为 1， 因为 left 指针不会跑到数组外面，所以需要 + 1
    return vector[left] == 1 ? left + 1 : left - vector.length;
  }
}
