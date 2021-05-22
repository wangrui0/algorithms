package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>47. 全排列 II
 *
 * <p>给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,1,2]
 * <p>输出：
 * <p>[[1,1,2],
 * <p> [1,2,1],
 * <p> [2,1,1]]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [1,2,3]
 * <p>输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 8
 * <p>    -10 <= nums[i] <= 10
 *
 * <p>通过次数168,523
 * <p>提交次数266,651
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/permutations-ii/
 */
public class NCh019_47Permutations全排列II {


  boolean[] vis;

  /**
   * 方法一：搜索回溯
   * <p>   复杂度分析
   * <p>      时间复杂度：O(n×n!)
   * <p>   空间复杂度：O(n)
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> perm = new ArrayList<Integer>();
    vis = new boolean[nums.length];
    Arrays.sort(nums);
    backtrack(nums, ans, 0, perm);
    return ans;
  }

  public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
    if (idx == nums.length) {
      ans.add(new ArrayList<Integer>(perm));
      return;
    }
    for (int i = 0; i < nums.length; ++i) {
      if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
        continue;
      }
      perm.add(nums[i]);
      vis[i] = true;
      backtrack(nums, ans, idx + 1, perm);
      vis[i] = false;
      perm.remove(idx);
    }
  }

  boolean[] visited;

  public List<List<Integer>> permuteUnique_2(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ans;
    }

    visited = new boolean[nums.length];
    Arrays.sort(nums);
    List<Integer> elements = new ArrayList<>();
    backTrack(nums, 0, nums.length, ans, elements);
    return ans;
  }

  public void backTrack(int[] nums, int k, int n, List<List<Integer>> ans, List<Integer> elements) {
    if (k == n) {
      ans.add(new ArrayList<>(elements));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
        continue;
      }
      visited[i] = true;
      elements.add(nums[i]);
      backTrack(nums, k + 1, n, ans, elements);
      visited[i] = false;
      elements.remove(k);

    }
  }


}


