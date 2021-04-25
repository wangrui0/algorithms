package org.leetcode.leet1000.ch850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>830. 较大分组的位置
 *
 * <p>在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * <p>例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * <p>分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * <p>我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * <p>找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：s = "abbxxxxzzy"
 * <p>输出：[[3,6]]
 * <p>解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * <p>示例 2：
 *
 * <p>输入：s = "abc"
 * <p>输出：[]
 * <p>解释："a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * <p>示例 3：
 *
 * <p>输入：s = "abcdddeeeeaabbbcd"
 * <p>输出：[[3,5],[6,9],[12,14]]
 * <p>解释：较大分组为 "ddd", "eeee" 和 "bbb"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "aba"
 * <p>输出：[]
 * <p>@author: wangrui
 * <p>@date: 2021/3/30
 */
public class Ch830PositionsOfLargeGroups {

  public static List<List<Integer>> largeGroupPositions(String s) {
    List<List<Integer>> ans = new ArrayList<>();
    int start = 0, end = 0;
    char pre = s.charAt(0);
    for (int i = 1; i < s.length(); i++) {
      if (pre == s.charAt(i)) {
        end++;
      } else {
        if (end - start + 1 >= 3) {
          List<Integer> list = new ArrayList<>();
          list.add(start);
          list.add(end);
          ans.add(list);
        }
        start = i;
        end = i;
      }
      pre = s.charAt(i);
    }
    if (end - start + 1 >= 3) {
      List<Integer> list = new ArrayList<>();
      list.add(start);
      list.add(end);
      ans.add(list);
    }
    return ans;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是字符串的长度。我们只需要遍历一次该数组。
   *
   * <p>  空间复杂度：O(1)。我们只需要常数的空间来保存若干变量，注意返回值不计入空间复杂度。
   *
   * @param s
   * @return
   */
  public List<List<Integer>> largeGroupPositions_1(String s) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    int n = s.length();
    int num = 1;
    for (int i = 0; i < n; i++) {
      if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
        if (num >= 3) {
          ret.add(Arrays.asList(i - num + 1, i));
        }
        num = 1;
      } else {
        num++;
      }
    }
    return ret;
  }


}
