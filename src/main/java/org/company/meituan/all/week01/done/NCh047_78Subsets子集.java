package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 78. 子集
 *
 * <p> 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * <p> 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：nums = [1,2,3]
 * <p> 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * <p> 示例 2：
 *
 * <p> 输入：nums = [0]
 * <p> 输出：[[],[0]]
 *
 *
 *
 * <p> 提示：
 *
 * <p>     1 <= nums.length <= 10
 * <p>     -10 <= nums[i] <= 10
 * <p>     nums 中的所有元素 互不相同
 *
 * <p> 通过次数249,638
 * <p> 提交次数312,677
 * <p> 请问您在哪类招聘中遇到此题？
 * <p> https://leetcode-cn.com/problems/subsets/
 * <p> @author: wangrui
 * <p> @date: 2021/5/14
 */
public class NCh047_78Subsets子集 {

  List<Integer> t = new ArrayList<Integer>();
  List<List<Integer>> ans = new ArrayList<List<Integer>>();

  /**
   * 方法一：迭代法实现子集枚举
   * <p>复杂度分析
   * <p>
   * 时间复杂度：O(n×2^n)。一共 2^n 个状态，每种状态需要 O(n) 的时间来构造子集。
   * <p>
   * <p>空间复杂度：O(n)。即构造子集使用的临时数组 t 的空间代价。
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets_1(int[] nums) {
    int n = nums.length;
    for (int mask = 0; mask < (1 << n); ++mask) {
      t.clear();
      for (int i = 0; i < n; ++i) {
        if ((mask & (1 << i)) != 0) {
          t.add(nums[i]);
        }
      }
      ans.add(new ArrayList<Integer>(t));
    }
    return ans;
  }

  /**
   * 方法二：递归法实现子集枚举(这道题目采用我最讨厌的递归+回溯来做。)
   * <p>复杂度分析
   * <p>
   * 时间复杂度：O(n×2^n)。一共 2^n 个状态，每种状态需要 O(n) 的时间来构造子集。
   * <p>
   * <p>空间复杂度：O(n)。即构造子集使用的临时数组 t 的空间代价。
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets_2(int[] nums) {
    dfs(0, nums);
    return ans;
  }

  public void dfs(int cur, int[] nums) {
    if (cur == nums.length) {
      ans.add(new ArrayList<Integer>(t));
      return;
    }
    t.add(nums[cur]);
    dfs(cur + 1, nums);
    t.remove(t.size() - 1);
    dfs(cur + 1, nums);
  }

  /**
   * <p>思路：
   * <p>[1,2,3]
   * <p>(1)[[]] 先加入一个空的集合
   * <p>(2)[[],[1]]  将原先的集合[[]]进行复制[[],[]],然后在新的集合中加入1，[[],[1]]
   * <p>(3)[[],[1],[2],[1,2]] 将原先的集合[[],[1]] 进行复制[[],[1],[],[1]]然后在新的集合中加入2，[[],[1],[2],[1,2]]
   * <p>(4)[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] 将原先的集合[[],[1],[2],[1,2]] 进行复制[[],[1],[2],[1,2],[],[1],[2],[1,2]]然后在新的集合中加入3，[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
   *
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets_3(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    for (int num : nums) {
      List<List<Integer>> newSubsets = new ArrayList<>();
      for (List<Integer> subset : result) {
        List<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(num);
        newSubsets.add(newSubset);
      }
      result.addAll(newSubsets);
    }
    return result;
  }

  public static List<List<Integer>> subsets_4(int[] nums) {
    return recurse(nums.length, nums);
  }


  public static List<List<Integer>> recurse(int n, int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (n == 0) {
      ans.add(new ArrayList<>());
      return ans;
    }
    List<List<Integer>> recurseList = recurse(n - 1, nums);
    ans.addAll(recurseList);
    for (List<Integer> recurse : recurseList) {
      List<Integer> newSub = new ArrayList<>(recurse);
      newSub.add(nums[n - 1]);
      ans.add(newSub);
    }
    return ans;
  }

  int n;

  public List<List<Integer>> subsets_5(int[] nums) {
    n = nums.length;
    for (int k = 0; k <= nums.length; k++) {
      backTrack(0, k, new ArrayList<>(), nums);
    }
    return ans;
  }

  public void backTrack(int start, int k, List<Integer> curr, int[] nums) {
    if (k == 0) {
      ans.add(new ArrayList<Integer>(curr));
      return;
    }
    for (int i = start; i < n; i++) {
      curr.add(nums[i]);
      backTrack(i + 1, k - 1, curr, nums);
      curr.remove(curr.size() - 1);
    }
  }
}
