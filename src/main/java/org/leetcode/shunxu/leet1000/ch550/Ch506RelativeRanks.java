package org.leetcode.shunxu.leet1000.ch550;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>506. 相对名次
 *
 * <p>给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 *
 * <p>(注：分数越高的选手，排名越靠前。)
 *
 * <p>示例 1:
 *
 * <p>输入: [5, 4, 3, 2, 1]
 * <p>输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * <p>解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * <p>余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * <p>提示:
 *
 * <p>    N 是一个正整数并且不会超过 10000。
 * <p>    所有运动员的成绩都不相同。
 * <p>  https://leetcode-cn.com/problems/relative-ranks/
 * <p>通过次数15,241
 * <p>提交次数27,316
 *
 * @author: wangrui
 * @date: 2021/3/13
 */
public class Ch506RelativeRanks {

  /**
   * <p> 方法一：排序 + 二分查找
   * <p>要想知道指定成绩的排名，第一想法就是对成绩进行排序。首先拷贝成绩数组并对其进行排序，接着使用二分查找，查找每个成绩排第几名即可。
   *
   * <p>   执行用时：4 ms, 在所有 Java 提交中击败了97.37%的用户
   * <p>  内存消耗：39.6 MB, 在所有 Java 提交中击败了53.12%的用户
   *
   * @param nums
   * @return
   */
  public String[] findRelativeRanks(int[] nums) {
    int n = nums.length;
    int[] array = new int[n];
    // 拷贝数组
    System.arraycopy(nums, 0, array, 0, n);
    // 对数组进行排序
    Arrays.sort(array);
    String[] result = new String[n];
    for (int i = 0; i < n; i++) {
      // 查找当前成绩排第几名
      int index = n - Arrays.binarySearch(array, nums[i]);
      switch (index) {
        case 1:
          result[i] = "Gold Medal";
          break;
        case 2:
          result[i] = "Silver Medal";
          break;
        case 3:
          result[i] = "Bronze Medal";
          break;
        default:
          result[i] = String.valueOf(index);
      }
    }
    return result;
  }

  /**
   * <p>方法二：TreeMap
   * <p>使用 TreeMap 来实现对成绩得到排序，key 存储成绩，value 存储成绩在数组中的下标。TreeMap 是按照升序进行排序的，所以在遍历集合时，
   * <p>通过计算可以得出当前成绩的排名。
   * <p>执行用时：12 ms, 在所有 Java 提交中击败了53.80%的用户
   * <p>内存消耗：40 MB, 在所有 Java 提交中击败了5.13%的用户
   *
   * @param nums
   * @return
   */
  public String[] findRelativeRanks2(int[] nums) {
    int n = nums.length;
    String[] result = new String[n];
    // key 为成绩，value 为成绩在数组中的下标，TreeMap 是按照升序进行排序的
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      map.put(nums[i], i);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> set : map.entrySet()) {
      // 计算成绩的排名
      int ranking = n - count++;
      switch (ranking) {
        case 1:
          result[set.getValue()] = "Gold Medal";
          break;
        case 2:
          result[set.getValue()] = "Silver Medal";
          break;
        case 3:
          result[set.getValue()] = "Bronze Medal";
          break;
        default:
          result[set.getValue()] = String.valueOf(ranking);
      }
    }
    return result;
  }

  /**
   * <p>方法三：计数排序
   * <p>首先寻找数组中最大的值（成绩最高的），创建一个 int[] array = new int[max + 1]; 的数组用来实现计数排序。array 数组的下标对应成绩，
   * <p>值为该成绩所在的原数组的下标。由于 array 数组的值默认为 0，所以在存储成绩的下标时，应对下标加 1，取时减 1 即可。
   * <p>执行用时：2 ms, 在所有 Java 提交中击败了100.00%的用户
   * <p>内存消耗：39.3 MB, 在所有 Java 提交中击败了89.32%的用户
   *
   * @param nums
   * @return
   */
  public String[] findRelativeRanks3(int[] nums) {
    int n = nums.length;
    String[] result = new String[n];
    int max = 0;
    // 找出找出最高的成绩
    for (int num : nums) {
      if (max < num) {
        max = num;
      }
    }
    // 下标为成绩，值为成绩在 nums 数组的下标
    int[] array = new int[max + 1];
    for (int i = 0; i < n; i++) {
      array[nums[i]] = i + 1;
    }
    // 记录当前成绩的排名
    int count = 1;
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] != 0) {
        // 根据排名进行赋值
        switch (count) {
          case 1:
            result[array[i] - 1] = "Gold Medal";
            break;
          case 2:
            result[array[i] - 1] = "Silver Medal";
            break;
          case 3:
            result[array[i] - 1] = "Bronze Medal";
            break;
          default:
            result[array[i] - 1] = String.valueOf(count);
        }
        count++;
      }
    }
    return result;
  }
}
