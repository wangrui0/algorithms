package org.company.meituan.all.leet25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <p>46. 全排列
 *
 * <p>给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [1,2,3]
 * <p>输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * <p>示例 2：
 *
 * <p>输入：nums = [0,1]
 * <p>输出：[[0,1],[1,0]]
 *
 * <p>示例 3：
 *
 * <p>输入：nums = [1]
 * <p>输出：[[1]]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= nums.length <= 6
 * <p>    -10 <= nums[i] <= 10
 * <p>    nums 中的所有整数 互不相同
 *
 * <p>通过次数315,432
 * <p>提交次数404,975
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/permutations/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class KCh019_46Permutations全排列 {

  /**
   * <p>  复杂度分析
   *
   * <p>     时间复杂度：O(n×n!)，其中 n 为序列的长度
   * <p>    空间复杂度：O(n)
   *
   * @param nums
   * @return
   */
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
      // 动态维护数组
      Collections.swap(output, first, i);
      // 继续递归填下一个数
      backtrack(n, output, res, first + 1);
      // 撤销操作
      Collections.swap(output, first, i);
    }
  }

  public void test() {

    List<String> list = new ArrayList() {{
      add("05-9");
      add("05-10");
    }};
    //日期， 月份 ，数量
    Map<String, Map<String, List>> map = new HashMap<>();
    List<Map<String, List<Integer>>> ans = new ArrayList<>();

    for (Entry<String, Map<String, List>> entry : map.entrySet()) {
      List<Integer> 数量统计 = new ArrayList<>();
      for (int i = 0; i < list.size(); i++) {
        String day = list.get(i);
        List<Integer> value = entry.getValue().get(day);
        //如果为空，给0值，否咋给1值
      }
    }
    
  }
}


