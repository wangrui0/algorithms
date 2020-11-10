package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangrui
 * @date: 2020/11/4
 */
public class Ch0015ThreeSum {

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -2, 3};
    ArrayList<List<Integer>> fanhui = fanhui(nums);
  }

  /**
   * self
   *
   * @param nums
   * @return
   */
  public static ArrayList<List<Integer>> fanhui(int[] nums) {
    Map<Integer, Integer> objectObjectHashMap = new HashMap<>();

    for (int index = 0; index < nums.length; index++) {
      objectObjectHashMap.put(nums[index], index);
    }
    ArrayList<List<Integer>> arrs = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j < nums.length; j++) {
        int result = 0 - nums[i] - nums[j];
        Integer index = objectObjectHashMap.get(result);
        if (index != null && index != i && index != j && i != j) {
          ArrayList<Integer> arr = new ArrayList<>();
          arr.add(nums[i]);
          arr.add(nums[j]);
          arr.add(result);
          boolean flag = true;
          for (int l = 0; l < arrs.size(); l++) {
            if (arrs.get(l).containsAll(arr)) {
              flag = false;
              break;
            }
          }
          if (flag) {
            arrs.add(arr);
          }
        }
      }
    }
    return arrs;
  }
}
