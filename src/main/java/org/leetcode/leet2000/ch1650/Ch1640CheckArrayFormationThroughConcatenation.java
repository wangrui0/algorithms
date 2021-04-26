package org.leetcode.leet2000.ch1650;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>1640. 能否连接形成数组
 *
 * <p>给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组
 * pieces[i] 中的整数重新排序。
 *
 * <p>如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [85], pieces = [[85]]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [15,88], pieces = [[88],[15]]
 * <p>输出：true
 * <p>解释：依次连接 [15] 和 [88]
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [49,18,16], pieces = [[16,18,49]]
 * <p>输出：false
 * <p>解释：即便数字相符，也不能重新排列 pieces[0]
 *
 * <p>示例 4：
 *
 * <p>输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * <p>输出：true
 * <p>解释：依次连接 [91]、[4,64] 和 [78]
 *
 * <p>示例 5：
 *
 * <p>输入：arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= pieces.length <= arr.length <= 100
 * <p>    sum(pieces[i].length) == arr.length
 * <p>    1 <= pieces[i].length <= arr.length
 * <p>    1 <= arr[i], pieces[i][j] <= 100
 * <p>    arr 中的整数 互不相同
 * <p>    pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 *
 * <p>通过次数11,002
 * <p>提交次数16,205
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/check-array-formation-through-concatenation/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:28 下午
 */
public class Ch1640CheckArrayFormationThroughConcatenation {

  public static boolean canFormArray(int[] arr, int[][] pieces) {
    /*
     * 利用map集合key存放二维数组中每一个一维数组的第一个元素
     * value用于存放该一维数组,拿arr[i]和map集合中的key进比较
     * 若相同,则通过key获取value即该一维数组,将一维数组中的元素
     * 和arr[i]的元素再一一比较
     */

    Map<Integer, int[]> map = new HashMap<>();
    for (int[] p : pieces) {
      map.put(p[0], p);
    }
    int i = 0;
    while (i < arr.length) {
      if (map.containsKey(arr[i])) {
        //通过key获取到该一维数组
        int[] priece = map.get(arr[i]);
        for (int val : priece) {
          if (arr[i] == val) {
            i++;
          } else {
            return false;
          }
        }
      } else {
        return false;
      }
    }
    return true;
  }

  public boolean canFormArray_2(int[] arr, int[][] pieces) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < pieces.length; j++) {
        if (arr[i] == pieces[j][0]) {
          for (int k = 0; k < pieces[j].length; k++) {
            if (i + k < arr.length && arr[i + k] == pieces[j][k]) {
              list.add(arr[i + k]);
            } else {
              return false;
            }
          }
        }
      }
    }
    if (list.size() < arr.length) {
      return false;
    }
    return true;
  }
}
