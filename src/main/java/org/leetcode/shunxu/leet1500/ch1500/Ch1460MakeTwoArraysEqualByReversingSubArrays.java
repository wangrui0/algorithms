package org.leetcode.shunxu.leet1500.ch1500;

import java.util.Arrays;

/**
 * <p>1460. 通过翻转子数组使两个数组相等
 *
 * <p>给你两个长度相同的整数数组 target 和 arr 。
 *
 * <p>每一步中，你可以选择 arr 的任意 非空子数组 并将它翻转。你可以执行此过程任意次。
 *
 * <p>如果你能让 arr 变得与 target 相同，返回 True；否则，返回 False 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：target = [1,2,3,4], arr = [2,4,1,3]
 * <p>输出：true
 * <p>解释：你可以按照如下步骤使 arr 变成 target：
 * <p>1- 翻转子数组 [2,4,1] ，arr 变成 [1,4,2,3]
 * <p>2- 翻转子数组 [4,2] ，arr 变成 [1,2,4,3]
 * <p>3- 翻转子数组 [4,3] ，arr 变成 [1,2,3,4]
 * <p>上述方法并不是唯一的，还存在多种将 arr 变成 target 的方法。
 *
 * <p>示例 2：
 *
 * <p>输入：target = [7], arr = [7]
 * <p>输出：true
 * <p>解释：arr 不需要做任何翻转已经与 target 相等。
 *
 * <p>示例 3：
 *
 * <p>输入：target = [1,12], arr = [12,1]
 * <p>输出：true
 *
 * <p>示例 4：
 *
 * <p>输入：target = [3,7,9], arr = [3,7,11]
 * <p>输出：false
 * <p>解释：arr 没有数字 9 ，所以无论如何也无法变成 target 。
 *
 * <p>示例 5：
 *
 * <p>输入：target = [1,1,1,1,1], arr = [1,1,1,1,1]
 * <p>输出：true
 *
 *
 *
 * <p>提示：
 *
 * <p>    target.length == arr.length
 * <p>    1 <= target.length <= 1000
 * <p>    1 <= target[i] <= 1000
 * <p>    1 <= arr[i] <= 1000
 *
 * <p>通过次数13,107
 * <p>提交次数17,664
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1460MakeTwoArraysEqualByReversingSubArrays {

  public boolean canBeEqual(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    return Arrays.equals(target, arr);
  }

  public boolean canBeEqual_2(int[] target, int[] arr) {
    int len1 = target.length;
    int len2 = arr.length;
    if (len1 != len2) {
      return false;
    }
    if (len1 == 1 && target[0] == arr[0]) {
      return true;
    }

    int[] count1 = new int[1001];
    int[] count2 = new int[1001];
    for (int i = 0; i < len1; i++) {
      count1[target[i]]++;
      count2[arr[i]]++;
    }
    for (int i = 0; i < 1001; i++) {
      if (count1[i] != count2[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean canBeEqual_3(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    for (int i = 0; i < target.length; i++) {
      if (target[i] != arr[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean canBeEqual_4(int[] target, int[] arr) {
    int[] targetCount = new int[1001];
    int[] arrCount = new int[1001];
    for (int i = 0; i < 1001; i++) {
      targetCount[target[i]]++;
      arrCount[arrCount[i]]++;
    }
    for (int i = 0; i < 1001; i++) {
      if (targetCount[i] != arrCount[i]) {
        return false;
      }
    }
    return true;
  }


}


