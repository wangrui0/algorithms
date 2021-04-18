package org.leetcode.shunxu.ch1350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>1331. 数组序号转换
 *
 * <p>给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * <p>序号代表了一个元素有多大。序号编号的规则如下：
 *
 * <p>    序号从 1 开始编号。
 * <p>    一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * <p>    每个数字的序号都应该尽可能地小。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [40,10,20,30]
 * <p>输出：[4,1,2,3]
 * <p>解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [100,100,100]
 * <p>输出：[1,1,1]
 * <p>解释：所有元素有相同的序号。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [37,12,28,9,100,56,80,5,12]
 * <p>输出：[5,3,4,2,8,6,7,1,3]
 *
 *
 *
 * <p>提示：
 *
 * <p>    0 <= arr.length <= 105
 * <p>    -109 <= arr[i] <= 109
 *
 * <p>通过次数9,621
 * <p>提交次数18,045
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/rank-transform-of-an-array/
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1331RankTransformOfAnArray {

  /**
   * <p>常规思路是数组去重后进行排序，然后迭代arr数组中的元素，在排序的数组中利用二分查找寻找索引值。
   *
   * <p>此处采用桶排序的思路，先遍历arr数组，找到数组中的最大值和最小值。
   *
   * <p>然后建立桶数组，将arr数组中出现过的元素在桶中设置为1。
   *
   * <p>接下来利用前缀和统计出每个元素前面出现过的次数，即该元素的序号。
   *
   * @param arr
   * @return
   */
  public int[] arrayRankTransform(int[] arr) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : arr) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    int[] count = new int[max - min + 1];
    for (int num : arr) {
      count[num - min] = 1;
    }

    int[] preSum = new int[count.length + 1];
    for (int i = 1; i < preSum.length; i++) {
      preSum[i] = preSum[i - 1] + count[i - 1];
    }

    int[] ans = new int[arr.length];
    int index = 0;
    for (int num : arr) {
      ans[index++] = preSum[num - min] + 1;
    }
    return ans;
  }

  public static int[] arrayRankTransform_2(int[] arr) {
    int a[] = new int[arr.length];
    a = arr.clone();
    Arrays.sort(a);
    Map<Integer, Integer> map = new HashMap<>();
    int index = 1;
    for (int i = 0; i < a.length; i++) {
      if (i > 0 && a[i] != a[i - 1]) {
        map.put(a[i], index);
        index++;
      }
      if (i == 0) {
        map.put(a[i], index);
        index++;
      }
    }
    for (int i = 0; i < arr.length; i++) {
      arr[i] = map.get(arr[i]);
    }
    return arr;
  }

  public int[] arrayRankTransform_3(int[] arr) {
    int[] clone = arr.clone(); // clone克隆，生成一个复本
    Map<Integer, Integer> map = new HashMap<>();
    Arrays.sort(clone);
    int k = 1;
    for (int i = 0; i < arr.length; i++) {
      if (!map.keySet().contains(clone[i])) { // keySet() -> [key,value]
        map.put(clone[i], k);
        k++;
      }
    }
    for (int i = 0; i < clone.length; i++) {
      arr[i] = map.get(arr[i]); // get(a[i]); key=a[i]时对应的value；
    }
    return arr;
  }
}
