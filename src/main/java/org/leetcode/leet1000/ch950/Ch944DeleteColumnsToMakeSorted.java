package org.leetcode.leet1000.ch950;

/**
 * <p>944. 删列造序
 *
 * <p>给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * <p>这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * <p>abc
 * <p>bce
 * <p>cae
 *
 * <p>你需要找出并删除 不是按字典序升序排列的 列。
 * 在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * <p>返回你需要删除的列数。
 * <p>@author: wangrui
 * <p>@date: 2021/4/1
 */
public class Ch944DeleteColumnsToMakeSorted {

  public int minDeletionSize_self(String[] A) {
    int ans = 0;
    for (int i = 0; i < A[0].length(); i++) {
      for (int j = 0; j < A.length - 1; j++) {
        if (A[j].charAt(i) > A[j + 1].charAt(i)) {
          ans++;
          break;
        }
      }
    }
    return ans;
  }

  /**
   * <p复杂度分析
   * <p>
   * <p    时间复杂度：O(N)，其中 N 是数组 A 中的元素个数。
   * <p>
   * <p   空间复杂度：O(1)。
   *
   * @param A
   * @return
   */
  public int minDeletionSize(String[] A) {
    int ans = 0;
    for (int c = 0; c < A[0].length(); ++c) {
      for (int r = 0; r < A.length - 1; ++r) {
        if (A[r].charAt(c) > A[r + 1].charAt(c)) {
          ans++;
          break;
        }
      }
    }

    return ans;
  }
}


