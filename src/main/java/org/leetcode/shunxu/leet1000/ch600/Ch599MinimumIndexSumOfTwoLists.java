package org.leetcode.shunxu.leet1000.ch600;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>599. 两个列表的最小索引总和
 * <p>假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * <p>你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
 *
 * <p>示例 1:
 *
 * <p>输入:
 * <p>["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * <p>["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * <p>输出: ["Shogun"]
 * <p>解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * <p>示例 2:
 *
 * <p>输入:
 * <p>["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * <p>["KFC", "Shogun", "Burger King"]
 * <p>输出: ["Shogun"]
 * <p>解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * <p>提示:
 *
 * <p>两个列表的长度范围都在 [1, 1000]内。
 * <p>两个列表中的字符串的长度将在[1，30]的范围内。
 * <p>下标从0开始，到列表的长度减1。
 * <p>两个列表都没有重复的元素。
 * <p>通过次数22,445提交次数43,091
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:08 下午
 */
public class Ch599MinimumIndexSumOfTwoLists {

  public String[] findRestaurant1(String[] list1, String[] list2) {
    int length1 = list1.length;
    int length2 = list2.length;

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < length1; i++) {
      map.put(list1[i], i);
    }
    int minCount = Integer.MAX_VALUE;
    List<String> list = new ArrayList<>();

    for (int i = 0; i < length2 && i < minCount; i++) {
      Integer num = map.get(list2[i]);
      if (num == null) {
        continue;
      }
      int sum = num + i;
      if (sum == minCount) {
        list.add(list2[i]);
      } else if (sum < minCount) {
        list.clear();
        list.add(list2[i]);
        minCount = sum;
      }
    }
    return list.toArray(new String[list.size()]);
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(l1​∗l2​∗x)。list1 中的每个字符串都与 list2 中的字符串进行了比较。l1​ 和 l2​ 是 list1 和 list2 列表的长度，x 是字符串的平均长度。
   *
   *     空间复杂度：O(l1​∗l2​∗x) 。最坏情况下，list1 和 list2 中所有字符串都相同，那么哈希表最大会变成 l1∗l2∗x，其中 x 是字符串的平均长度。
   *
   * 作者：LeetCode
   * 链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/solution/liang-ge-lie-biao-de-zui-xiao-suo-yin-zong-he-by-l/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param list1
   * @param list2
   * @return
   */
  public String[] findRestaurant1_1(String[] list1, String[] list2) {
    HashMap<Integer, List<String>> map = new HashMap<>();
    for (int i = 0; i < list1.length; i++) {
      for (int j = 0; j < list2.length; j++) {
        if (list1[i].equals(list2[j])) {
          if (!map.containsKey(i + j)) {
            map.put(i + j, new ArrayList<String>());
          }
          map.get(i + j).add(list1[i]);
        }
      }
    }
    int min_index_sum = Integer.MAX_VALUE;
    for (int key : map.keySet()) {
      min_index_sum = Math.min(min_index_sum, key);
    }
    String[] res = new String[map.get(min_index_sum).size()];
    return map.get(min_index_sum).toArray(res);
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O((l1​+l2​)^2∗x)。两重嵌套循环，每一层最多到 l1​+l2​，比较字符串需要花费 x 的时间，这里 x 是字符串的平均长度。
   *
   * <p>   空间复杂度：O(r∗x)。res 是结果字符串列表，r 是 res 的长度。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/solution/liang-ge-lie-biao-de-zui-xiao-suo-yin-zong-he-by-l/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param list1
   * @param list2
   * @return
   */
  public String[] findRestaurant2_2(String[] list1, String[] list2) {
    List<String> res = new ArrayList<>();
    for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
      for (int i = 0; i <= sum; i++) {
        if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i])) {
          res.add(list1[i]);
        }
      }
      if (res.size() > 0) {
        break;
      }
    }
    return res.toArray(new String[res.size()]);
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(l1​+l2​)。list2 中的每一个字符串都会在 list1 的映射表中查找，l1​ 和 l2​ 分别是 list1 和 list2 的长度。
   *
   * <p>   空间复杂度：O(l1​×x)。hashmap 的大小为 l1​×x，其中 x 是字符串的平均长度。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/solution/liang-ge-lie-biao-de-zui-xiao-suo-yin-zong-he-by-l/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param list1
   * @param list2
   * @return
   */
  public String[] findRestaurant3_3(String[] list1, String[] list2) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }
    List<String> res = new ArrayList<>();
    int min_sum = Integer.MAX_VALUE, sum;
    for (int j = 0; j < list2.length && j <= min_sum; j++) {
      if (map.containsKey(list2[j])) {
        sum = j + map.get(list2[j]);
        if (sum < min_sum) {
          res.clear();
          res.add(list2[j]);
          min_sum = sum;
        } else if (sum == min_sum) {
          res.add(list2[j]);
        }
      }
    }
    return res.toArray(new String[res.size()]);
  }


}