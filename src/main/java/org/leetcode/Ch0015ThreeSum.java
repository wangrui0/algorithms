package org.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * <p>
 * [
 * <p>
 * [-1, 0, 1],
 * <p>
 * [-1, -1, 2]
 * <p>
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
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
