package org.leetcode.shunxu.leet1500.ch1450;

import java.util.Arrays;

/**
 * <p>LeetCode 1426. 数元素（哈希set）
 * <p>2020-07-13阅读 1100
 * <p>1. 题目
 * <p>给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
 *
 * <p>如果数组 arr 里有重复的数，每个重复的数单独计算。
 *
 * <p>示例 1：
 * <p>输入：arr = [1,2,3]
 * <p>输出：2
 * <p>解释：1 和 2 被计算次数因为 2 和 3 在数组 arr 里。
 *
 * <p>示例 2：
 * <p>输入：arr = [1,1,3,3,5,5,7,7]
 * <p>输出：0
 * <p>解释：所有的数都不算, 因为数组里没有 2、4、6、8。
 *
 * <p>示例 3：
 * <p>输入：arr = [1,3,2,3,5,0]
 * <p>输出：3
 * <p>解释：0、1、2 被计算了因为 1、2、3 在数组里。
 *
 * <p>示例 4：
 * <p>输入：arr = [1,1,2,2]
 * <p>输出：2
 * <p>解释：两个 1 被计算了因为有 2 在数组里。
 * https://leetcode-cn.com/problems/counting-elements
 * <p>提示：
 * <p>1 <= arr.length <= 1000
 * <p>0 <= arr[i] <= 1000
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1426CountingElements {

  public int countElements(int[] arr) {
    Arrays.sort(arr);
    int res = 0;
    int num = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i + 1] == arr[i]) {
        num++;
        continue;
      } else if (arr[i + 1] - arr[i] == 1) {
        res += num;
        num = 1;
      } else {
        num = 1;
      }
    }
    return res;
  }

  public int countElements_2(int[] arr) {
    int[] dic = new int[1001];
    int res = 0;
    for (int i = 0; i < arr.length; i++) {
      dic[arr[i]]++;
    }
    for (int i = 0; i < 1000; i++) {
      if (dic[i + 1] == 0) {
        continue;
      } else {
        res += dic[i];
      }
    }
    return res;
  }

  public static int countElements_3(int[] arr) {
    int[] dic = new int[101];
    for (int x : arr) {
      dic[x]++;
    }
    int ans = 0;
    for (int i = 0; i < dic.length - 1; i++) {
      if (dic[i] != 0 && dic[i + 1] != 0) {
        ans += dic[i];
      }
    }
    return ans;
  }

}
