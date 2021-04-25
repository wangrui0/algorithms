package org.leetcode.leet1000.ch1000;

/**
 * <p>985. 查询后的偶数和
 *
 * <p>给出一个整数数组 A 和一个查询数组 queries。
 *
 * <p>对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *
 * <p>（此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *
 * <p>返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * <p>输出：[8,6,2,4]
 * <p>解释：
 * <p>开始时，数组为 [1,2,3,4]。
 * <p>将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * <p>将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * <p>将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * <p>将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= A.length <= 10000
 * <p>    -10000 <= A[i] <= 10000
 * <p>    1 <= queries.length <= 10000
 * <p>    -10000 <= queries[i][0] <= 10000
 * <p>    0 <= queries[i][1] < A.length
 * <p>  https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries/
 * <p>通过次数14,270
 * <p>提交次数23,859
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch985SumOfEvenNumbersAfterQueries {

  /**
   * 时间复杂度太高了，没通过
   *
   * @param A
   * @param queries
   * @return
   */
  public int[] sumEvenAfterQueries_self(int[] A, int[][] queries) {
    int[] ans = new int[queries.length];
    int i = 0;
    for (int[] query : queries) {
      int val = query[0];
      int index = query[1];
      A[index] += val;
      for (int x : A) {
        if (x % 2 == 0) {
          ans[i] += x;
        }
      }
      i++;
    }
    return ans;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N+Q)，其中 N 是数组 A 的长度， Q 是询问 queries 的数量。
   *
   * <p>  空间复杂度：O(N+Q)，事实上我们只使用了 O(1) 的额外空间。
   *
   * @param A
   * @param queries
   * @return
   */
  public int[] sumEvenAfterQueries_1(int[] A, int[][] queries) {
    int S = 0;
    for (int x : A) {
      if (x % 2 == 0) {
        S += x;
      }
    }

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; ++i) {
      int val = queries[i][0], index = queries[i][1];
      if (A[index] % 2 == 0) {
        S -= A[index];
      }
      A[index] += val;
      if (A[index] % 2 == 0) {
        S += A[index];
      }
      ans[i] = S;
    }

    return ans;
  }
}


