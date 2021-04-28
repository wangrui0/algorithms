package org.leetcode.leet2000.ch1750;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>1742. 盒子中小球的最大数量
 *
 * <p>你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit +
 * 1）。另有无限数量的盒子，编号从 1 到 infinity 。
 *
 * <p>你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 *
 * <p>给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量。如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：lowLimit = 1, highLimit = 10
 * <p>输出：2
 * <p>解释：
 * <p>盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
 * <p>小球数量：2 1 1 1 1 1 1 1 1 0  0  ...
 * <p>编号 1 的盒子放有最多小球，小球数量为 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：lowLimit = 5, highLimit = 15
 * <p>输出：2
 * <p>解释：
 * <p>盒子编号：1 2 3 4 5 6 7 8 9 10 11 ...
 * <p>小球数量：1 1 1 1 2 2 1 1 1 0  0  ...
 * <p>编号 5 和 6 的盒子放有最多小球，每个盒子中的小球数量都是 2 。
 *
 * <p>示例 3：
 *
 * <p>输入：lowLimit = 19, highLimit = 28
 * <p>输出：2
 * <p>解释：
 * <p>盒子编号：1 2 3 4 5 6 7 8 9 10 11 12 ...
 * <p>小球数量：0 1 1 1 1 1 1 1 1 2  0  0  ...
 * <p>编号 10 的盒子放有最多小球，小球数量为 2 。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= lowLimit <= highLimit <= 105
 *
 * <p>通过次数6,682
 * <p>提交次数9,447
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-number-of-balls-in-a-box/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:03 下午
 */
public class Ch1742MaximumNumberOfBallsInABox {

  public int countBalls_self(int lowLimit, int highLimit) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = lowLimit; i <= highLimit; i++) {
      int box = digitSum(i);
      map.put(box, map.getOrDefault(box, 0) + 1);
    }
    int maxValue = 0;
    for (Integer key : map.keySet()) {
      Integer num = map.get(key);
      if (num > maxValue) {
        maxValue = num;
      }
    }
    return maxValue;
  }

  public int digitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  public int countBalls_self_2(int lowLimit, int highLimit) {
    Map<Integer, Integer> map = new HashMap<>();
    int digitNum = digitSum(lowLimit);
    map.put(digitNum, 1);
    int preNum = digitNum;
    for (int i = lowLimit + 1; i <= highLimit; i++) {
      if (i % 10 == 0) {
        digitNum = digitSum(i);
      } else {
        digitNum = preNum + 1;
      }
      map.put(digitNum, map.getOrDefault(digitNum, 0) + 1);
      preNum = digitNum;
    }
    int maxValue = 0;
    for (Integer key : map.keySet()) {
      Integer num = map.get(key);
      if (num > maxValue) {
        maxValue = num;
      }
    }
    return maxValue;
  }

  public int countBalls(int lowLimit, int highLimit) {
    int[] ans = new int[46];
    for (int i = lowLimit; i <= highLimit; i++) {
      int a = i;
      int sum = 0;
      //计算位数之和
      while (a != 0) {
        sum += a % 10;
        a /= 10;
      }
      ans[sum]++;
    }
    //排序返回最后一个
    Arrays.sort(ans);
    return ans[ans.length - 1];
  }

  public int countBalls_2(int lowLimit, int highLimit) {
    // 盒子所有可能编号为下标组成的数组
    int[] arr = new int[46];
    // 第一个小球对应的盒子的编号
    int index = sum(lowLimit);
    arr[index]++;
    // 将小球放入对应编号的盒子中
    for (int i = lowLimit + 1; i <= highLimit; i++) {
      // 利用前一个小球对应盒子的编号，
      // 求出后一个小球对应盒子的编号
      int endZeroCount = endZeroCount(i);
      index += 1 - 9 * endZeroCount;
      arr[index]++;
    }
    // 找出最多小球的盒子中的小球数量
    int maxNum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxNum) {
        maxNum = arr[i];
      }
    }
    return maxNum;
  }

  //数字的各个位之和
  public int sum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num = num / 10;
    }
    return sum;
  }

  //数字末尾连续0的个数
  public int endZeroCount(int num) {
    int endZeroCount = 0;
    while (num % 10 == 0) {
      num = num / 10;
      endZeroCount++;
    }
    return endZeroCount;
  }
}
