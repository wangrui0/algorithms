package org.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * <p>  示例:
 *
 * <p>  输入: [1,2,3]
 * <p>  输出:
 * <p>  [
 * <p>    [1,2,3],
 * <p>    [1,3,2],
 * <p>    [2,1,3],
 * <p>    [2,3,1],
 * <p>    [3,1,2],
 * <p>    [3,2,1]
 * <p>  ]
 * <p> 来源：力扣（LeetCode）
 * <p>  链接：https://leetcode-cn.com/problems/permutations
 * <p>  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/1
 */
public class Ch0046Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    List<Integer> output = new ArrayList<Integer>();
    for (int num : nums) {
      output.add(num);
    }

    int n = nums.length;
    backtrack(n, output, res, 0);
    return res;
  }

  public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
    // 所有数都填完了
    if (first == n) {
      res.add(new ArrayList<Integer>(output));
    }
    for (int i = first; i < n; i++) {
      // 动态维护数组(output 中第i个和第first 个交换位置)
      Collections.swap(output, first, i);
      // 继续递归填下一个数
      backtrack(n, output, res, first + 1);
      // 撤销操作
      Collections.swap(output, first, i);
    }
  }
}
