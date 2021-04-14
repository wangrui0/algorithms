package org.leetcode.shunxu.ch1200;

/**
 * <p>LeetCode 1176. 健身计划评估（滑动窗口）
 * <p>2020-07-13阅读 1270
 * <p>1. 题目
 * <p>你的好友是一位健身爱好者。前段日子，他给自己制定了一份健身计划。现在想请你帮他评估一下这份计划是否合理。
 *
 * <p>他会有一份计划消耗的卡路里表，其中 calories[i] 给出了你的这位好友在第 i 天需要消耗的卡路里总量。
 *
 * <p>为了更好地评估这份计划，对于卡路里表中的每一天，你都需要计算他 「这一天以及之后的连续几天」 （共 k 天）内消耗的总卡路里 T：
 *
 * <p>如果 T < lower，那么这份计划相对糟糕，并失去 1 分；
 * <p>如果 T > upper，那么这份计划相对优秀，并获得 1 分；
 * <p>否则，这份计划普普通通，分值不做变动。
 * <p>请返回统计完所有 calories.length 天后得到的总分作为评估结果。
 *
 * <p>注意：总分可能是负数。
 *
 * <p>示例 1：
 * <p>输入：calories = [1,2,3,4,5], k = 1, lower = 3, upper = 3
 * <p>输出：0
 * <p>解释：calories[0], calories[1] < lower
 * <p>	而 calories[3], calories[4] > upper, 总分 = 0.
 *
 * <p>示例 2：
 * <p>输入：calories = [3,2], k = 2, lower = 0, upper = 1
 * <p>输出：1
 * <p>解释：calories[0] + calories[1] > upper, 总分 = 1.
 *
 * <p>示例 3：
 * <p>输入：calories = [6,5,0,0], k = 2, lower = 1, upper = 5
 * <p>输出：0
 * <p>解释：calories[0] + calories[1] > upper,
 * <p>	calories[2] + calories[3] < lower, 总分 = 0.
 * https://leetcode-cn.com/problems/diet-plan-performance/
 * <p>提示：
 * <p>1 <= k <= calories.length <= 10^5
 * <p>0 <= calories[i] <= 20000
 * <p>0 <= lower <= upper
 * <p>@author: wangrui
 * <p>@date: 2021/4/10
 */
public class Ch1176DietPlanPerformance {

  public static void main(String[] args) {
    System.out.println(dietPlanPerformance_self(new int[]{1, 2, 3, 4, 5}, 0, 3, 3));
  }

  public static int dietPlanPerformance_self(int[] calories, int k, int lower, int upper) {
    int sum = 0;
    int start = 0;
    int end = 0;
    int T = 0;
    for (int i = 0; i < calories.length && end < calories.length; i++) {
      if (end - start < k) {
        T += calories[i];
        end++;
      }
      if (end - start == k) {
        if (T < lower) {
          sum -= 1;
        } else if (T > upper) {
          sum += 1;
        }
        T = 0;
        start = end;
      }
    }
    return sum;
  }

  public int dietPlanPerformance_2(int[] calories, int k, int lower, int upper) {

    int days = calories.length;
    int[] accumulate = new int[days];    // 第一天到第 n 天累计值
    accumulate[0] = calories[0];

    for (int i = 1; i < days; i++) {
      accumulate[i] = accumulate[i - 1] + calories[i];
    }

    int calory;
    int score = 0;
    for (int i = k - 1; i < days; i++) {
      if (i == k - 1) {
        calory = accumulate[i];
      } else {
        calory = accumulate[i] - accumulate[i - k];
      }
      if (calory < lower) {
        score--;
      } else if (calory > upper) {
        score++;
      }
    }
    return score;
  }

}