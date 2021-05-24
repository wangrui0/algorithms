package org.company.meituan.all.week02.done;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>56. 合并区间
 *
 * <p>以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * <p>输出：[[1,6],[8,10],[15,18]]
 * <p>解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * <p>示例 2：
 *
 * <p>输入：intervals = [[1,4],[4,5]]
 * <p>输出：[[1,5]]
 * <p>解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= intervals.length <= 104
 * <p>    intervals[i].length == 2
 * <p>    0 <= starti <= endi <= 104
 *
 * <p>通过次数236,656
 * <p>提交次数518,879
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/merge-intervals/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh059_56MergeIntervals合并区间 {

  public static void main(String[] args) {
//    System.out.println(merge(new int[][]{{1, 3}, {2, 6}, {4, 10}, {5, 18}}));
//    System.out.println(merge(new int[][]{{1, 4}, {2, 3}}));
    System.out.println(merge_self(new int[][]{{1, 4}, {0, 2}, {3, 5}}));
//    System.out.println(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
  }

  public static int[][] merge_self(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      int[] interval = intervals[i];
      int maxValue = interval[1];
      int end = interval[0];
      for (int j = i + 1; j < intervals.length; j++) {
        int[] intervalInner = intervals[j];
        if (intervalInner[0] < end || intervalInner[0] > maxValue) {
          i = j - 1;
          break;
        } else {
          i = j;
        }
        if (intervalInner[1] > maxValue) {
          maxValue = intervalInner[1];
        }
      }

      list.add(new int[]{interval[0], maxValue});
    }
    int[][] ans = new int[list.size()][2];
    for (int i = 0; i < list.size(); i++) {
      ans[i] = list.get(i);
    }
    return ans;
  }

  /**
   * <p> 排序
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(nlogn)，其中 n 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 (nlogn)。
   *
   * <p>   空间复杂度：O(logn)，其中 n 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn) 即为排序所需要的空间复杂度。
   *
   * @param intervals
   * @return
   */
  public int[][] merge_1(int[][] intervals) {
    if (intervals.length == 0) {
      return new int[0][2];
    }
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    List<int[]> merged = new ArrayList<int[]>();
    for (int i = 0; i < intervals.length; ++i) {
      int L = intervals[i][0], R = intervals[i][1];
      if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
        merged.add(new int[]{L, R});
      } else {
        merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }
}
