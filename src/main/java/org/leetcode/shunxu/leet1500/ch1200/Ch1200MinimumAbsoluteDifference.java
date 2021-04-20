package org.leetcode.shunxu.leet1500.ch1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>1200. 最小绝对差
 *
 * <p>给你个整数数组 arr，其中每个元素都 不相同。
 *
 * <p>请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [4,2,1,3]
 * <p>输出：[[1,2],[2,3],[3,4]]
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1,3,6,10,15]
 * <p>输出：[[1,3]]
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [3,8,-10,23,19,-4,-14,27]
 * <p>输出：[[-14,-10],[19,23],[23,27]]
 *
 *
 *
 * <p>提示：
 *
 * <p>    2 <= arr.length <= 10^5
 * <p>    -10^6 <= arr[i] <= 10^6
 * <p>https://leetcode-cn.com/problems/minimum-absolute-difference/
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1200MinimumAbsoluteDifference {

  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    List<List<Integer>> ans = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      int sub = arr[i + 1] - arr[i];
      if (sub < min) {
        min = sub;
        ans.clear();
      }
      if (sub == min) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        list.add(arr[i + 1]);
        ans.add(list);
      }
    }
    return ans;
  }
}
