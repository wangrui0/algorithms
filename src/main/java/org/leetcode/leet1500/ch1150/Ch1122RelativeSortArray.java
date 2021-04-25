package org.leetcode.leet1500.ch1150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>1122. 数组的相对排序
 *
 * <p>给你两个数组，arr1 和 arr2，
 *
 * <p>    arr2 中的元素各不相同
 * <p>    arr2 中的每个元素都出现在 arr1 中
 *
 * <p>对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * <p>输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr1.length, arr2.length <= 1000
 * <p>    0 <= arr1[i], arr2[i] <= 1000
 * <p>    arr2 中的元素 arr2[i] 各不相同
 * <p>    arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>https://leetcode-cn.com/problems/relative-sort-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/9
 */
public class Ch1122RelativeSortArray {

  /**
   * <p>自定义排序
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(mlogm+n)，其中 m 和 n 分别是数组 arr1​ 和 arr2​ 的长度。构造哈希表 rank 的时间复杂度为 O(n)，排序的时间复杂度为O(mlogm)。
   * <p>
   * <p> 空间复杂度：O(logm+n)，哈希表 rank 需要的空间为 O(n)，排序需要的栈空间为 O(logm)
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] relativeSortArray_1(int[] arr1, int[] arr2) {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    for (int num : arr1) {
      list.add(num);
    }
    for (int i = 0; i < arr2.length; i++) {
      map.put(arr2[i], i);
    }
    Collections.sort(list, (x, y) -> {
      if (map.containsKey(x) || map.containsKey(y)) {
        return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
      }
      return x - y;
    });
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = list.get(i);
    }
    return arr1;
  }

  /**
   * <p>  计数排序
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(m+n+upper)，其中 mmm 和 nnn 分别是数组 arr1​ 和 arr2​ 的长度，upper 是数组 arr1​ 中的最大值，在本题中 upper 不会超过
   * 100010001000。遍历数组 arr2​ 的时间复杂度为 O(n)，遍历数组 frequency 的时间复杂度为 O(upper)，而在遍历的过程中，我们一共需要 O(m) 的时间得到答案数组。
   *
   * <p>   空间复杂度：O(upper)，即为数组 frequency 需要使用的空间。注意到与方法一不同的是，方法二的代码使用了额外的空间（而不是直接覆盖数组
   * arr1存放答案，但我们一般不将存储返回答案的数组计入空间复杂度，并且在我们得到数组 frequency 之后，实际上也是可以将返回答案覆盖在数组 arr1​ 上的。如果在面试中遇到了本题，这些细节都可以和面试官进行确认。
   *
   * @param arr1
   * @param arr2
   * @return
   */
  public int[] relativeSortArray(int[] arr1, int[] arr2) {
    //把要排序的放到桶里面
    int upper = 0;
    for (int x : arr1) {
      upper = Math.max(upper, x);
    }
    int[] frequency = new int[upper + 1];
    for (int x : arr1) {
      ++frequency[x];
    }
    //按arr2排序
    int[] ans = new int[arr1.length];
    int index = 0;
    for (int x : arr2) {
      for (int i = 0; i < frequency[x]; ++i) {
        ans[index++] = x;
      }
      frequency[x] = 0;
    }
    //排序arr2中没有的
    for (int x = 0; x <= upper; ++x) {
      for (int i = 0; i < frequency[x]; ++i) {
        ans[index++] = x;
      }
    }
    return ans;
  }

  public static int[] relativeSortArray_self(int[] arr1, int[] arr2) {
    int maxValue = 0;
    for (int x : arr1) {
      if (x > maxValue) {
        maxValue = x;
      }
    }
    int[] frequency = new int[maxValue + 1];
    for (int i = 0; i < arr1.length; i++) {
      frequency[arr1[i]]++;
    }
    int[] ans = new int[arr1.length];
    int index = 0;
    for (int i = 0; i < arr2.length; i++) {
      for (int j = 0; j < frequency[arr2[i]]; j++) {
        ans[index++] = arr2[i];
      }
      frequency[arr2[i]] = 0;
    }
    for (int i = 0; i < frequency.length; i++) {
      for (int j = 0; j < frequency[i]; j++) {
        ans[index++] = i;
      }
    }
    return ans;
  }
}
