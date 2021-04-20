package org.leetcode.shunxu.leet500.ch250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>219. 存在重复元素 II
 * <p> 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 *
 *
 * <p> 示例 1:
 *
 * <p> 输入: nums = [1,2,3,1], k = 3
 * <p> 输出: true
 *
 * <p> 示例 2:
 *
 * <p> 输入: nums = [1,0,1,1], k = 1
 * <p> 输出: true
 *
 * <p> 示例 3:
 *
 * <p> 输入: nums = [1,2,3,1,2,3], k = 2
 * <p> 输出: false
 *
 * <p> 通过次数76,464
 * <p> 提交次数186,394
 * <p> 在真实的面试中遇到过这道题？
 * <p> 贡献者
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0219ContainsDuplicateII {

  public static void main(String[] args) {
    int[] nums = {1, 1};
    containsNearbyDuplicate(nums, 2);

  }

  public static boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        List<Integer> indexList = map.get(nums[i]);
        for (int j = 0; j < indexList.size(); j++) {
          if (i - indexList.get(j) <= k) {
            return true;
          }
        }
        indexList.add(i);
      } else {
        List<Integer> indexList = new ArrayList<>();
        indexList.add(i);
        map.put(nums[i], indexList);
      }
    }
    return false;
  }

  /**
   *<p> 思路
   *
   *<p> 用散列表来维护这个k大小的滑动窗口。
   *
   *<p> 算法
   *
   *<p> 在之前的方法中，我们知道了对数时间复杂度的 搜索 操作是不够的。在这个方法里面，我们需要一个支持在常量时间内完成 搜索，删除，插入 操作的数据结构，那就是散列表。这个算法的实现跟方法二几乎是一样的。
   *
   *<p>     遍历数组，对于每个元素做以下操作：
   *<p>         在散列表中搜索当前元素，如果找到了就返回 true。
   *<p>         在散列表中插入当前元素。
   *<p>         如果当前散列表的大小超过了 k， 删除散列表中最旧的元素。
   *<p>     返回 false。
   *
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii/solution/cun-zai-zhong-fu-yuan-su-ii-by-leetcode/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param nums
   * @param k
   * @return
   */
  public boolean containsNearbyDuplicate2(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; ++i) {
      if (set.contains(nums[i])) {
        return true;
      }
      set.add(nums[i]);
      if (set.size() > k) {
        set.remove(nums[i - k]);
      }
    }
    return false;
  }

























}
