package org.leetcode.shunxu.leet1500.ch1450;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>1431. 拥有最多糖果的孩子
 *
 * <p>给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 *
 * <p>对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：candies = [2,3,5,1,3], extraCandies = 3
 * <p>输出：[true,true,true,false,true]
 * <p>解释：
 * <p>孩子 1 有 2 个糖果，如果他得到所有额外的糖果（3个），那么他总共有 5 个糖果，他将成为拥有最多糖果的孩子。
 * <p>孩子 2 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 * <p>孩子 3 有 5 个糖果，他已经是拥有最多糖果的孩子。
 * <p>孩子 4 有 1 个糖果，即使他得到所有额外的糖果，他也只有 4 个糖果，无法成为拥有糖果最多的孩子。
 * <p>孩子 5 有 3 个糖果，如果他得到至少 2 个额外糖果，那么他将成为拥有最多糖果的孩子。
 *
 * <p>示例 2：
 *
 * <p>输入：candies = [4,2,1,1,2], extraCandies = 1
 * <p>输出：[true,false,false,false,false]
 * <p>解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 *
 * <p>示例 3：
 *
 * <p>输入：candies = [12,1,12], extraCandies = 10
 * <p>输出：[true,false,true]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= candies.length <= 100
 * <p>    1 <= candies[i] <= 100
 * <p>    1 <= extraCandies <= 50
 *
 * <p>通过次数73,116
 * <p>提交次数86,428
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1431KidsWithTheGreatestNumberOfCandies {

  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int max = 0;
    for (int candie : candies) {
      max = Math.max(max, candie);
    }
    List<Boolean> ans = new ArrayList<>();
    for (int candie : candies) {
      if (candie + extraCandies >= max) {
        ans.add(true);
      } else {
        ans.add(false);
      }
    }
    return ans;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>  假设小朋友的总数为 n。
   *
   * <p>    时间复杂度：我们首先使用 O(n) 的时间预处理出所有小朋友拥有的糖果数目最大值。对于每一个小朋友，我们需要 O(1) 的时间判断这个小朋友是否可以拥有最多的糖果，故渐进时间复杂度为
   * O(n)。
   *
   * <p>   空间复杂度：这里只用了常数个变量作为辅助空间，与 n 的规模无关，故渐进空间复杂度为 O(1)
   *
   * @param candies
   * @param extraCandies
   * @return
   */
  public List<Boolean> kidsWithCandies_2(int[] candies, int extraCandies) {
    int n = candies.length;
    int maxCandies = 0;
    for (int i = 0; i < n; ++i) {
      maxCandies = Math.max(maxCandies, candies[i]);
    }
    List<Boolean> ret = new ArrayList<Boolean>();
    for (int i = 0; i < n; ++i) {
      ret.add(candies[i] + extraCandies >= maxCandies);
    }
    return ret;
  }

}
