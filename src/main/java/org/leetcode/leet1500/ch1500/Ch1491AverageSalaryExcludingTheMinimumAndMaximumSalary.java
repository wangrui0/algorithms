package org.leetcode.leet1500.ch1500;

/**
 * <p>1491. 去掉最低工资和最高工资后的工资平均值
 *
 * <p>给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *
 * <p>请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：salary = [4000,3000,1000,2000]
 * <p>输出：2500.00000
 * <p>解释：最低工资和最高工资分别是 1000 和 4000 。
 * <p>去掉最低工资和最高工资以后的平均工资是 (2000+3000)/2= 2500
 *
 * <p>示例 2：
 *
 * <p>输入：salary = [1000,2000,3000]
 * <p>输出：2000.00000
 * <p>解释：最低工资和最高工资分别是 1000 和 3000 。
 * <p>去掉最低工资和最高工资以后的平均工资是 (2000)/1= 2000
 *
 * <p>示例 3：
 *
 * <p>输入：salary = [6000,5000,4000,3000,2000,1000]
 * <p>输出：3500.00000
 *
 * <p>示例 4：
 *
 * <p>输入：salary = [8000,9000,2000,3000,6000,1000]
 * <p>输出：4750.00000
 *
 *
 *
 * <p>提示：
 *
 * <p>    3 <= salary.length <= 100
 * <p>    10^3 <= salary[i] <= 10^6
 * <p>    salary[i] 是唯一的。
 * <p>    与真实值误差在 10^-5 以内的结果都将视为正确答案。
 *
 * <p>通过次数16,889
 * <p>提交次数25,152
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1491AverageSalaryExcludingTheMinimumAndMaximumSalary {

  public static void main(String[] args) {
    System.out.println(average(new int[]{4000, 3000, 1000, 2000}));
  }

  public static double average(int[] salary) {
    double sum = 0;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;
    for (int i = 0; i < salary.length; i++) {
      sum += salary[i];
      maxValue = Math.max(maxValue, salary[i]);
      minValue = Math.min(minValue, salary[i]);
    }
    return (sum - maxValue - minValue) / (salary.length - 2);
  }

  /**
   * <p>复杂度
   *
   * <p>   时间复杂度：O(n)。选取最大值、最小值和求和的过程的时间代价都是 O(n)，故渐进时间复杂度为 O(n)。
   *
   * <p>  空间复杂度：O(1)。这里只用到了常量级别的辅助空间。
   *
   * @param salary
   * @return
   */
  public double average_2(int[] salary) {
    double sum = 0;
    double maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
    for (int num : salary) {
      sum += num;
      maxValue = Math.max(maxValue, num);
      minValue = Math.min(minValue, num);
    }
    return (sum - maxValue - minValue) / (salary.length - 2);
  }


}
