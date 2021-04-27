package org.leetcode.leet2000.ch1750;

/**
 * <p>1725. 可以形成最大正方形的矩形数目
 *
 * <p>给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *
 * <p>如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *
 * <p>设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 *
 * <p>请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：rectangles = [[5,8],[3,9],[5,12],[16,5]]
 * <p>输出：3
 * <p>解释：能从每个矩形中切出的最大正方形边长分别是 [5,3,5,5] 。
 * <p>最大正方形的边长为 5 ，可以由 3 个矩形切分得到。
 *
 * <p>示例 2：
 *
 * <p>输入：rectangles = [[2,3],[3,7],[4,3],[3,7]]
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= rectangles.length <= 1000
 * <p>    rectangles[i].length == 2
 * <p>    1 <= li, wi <= 109
 * <p>    li != wi
 *
 * <p>通过次数8,476
 * <p>提交次数10,757
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/number-of-rectangles-that-can-form-the-largest-square/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:00 下午
 */
public class Ch1725NumberOfRectanglesThatCanFormTheLargestSquare {

  public int countGoodRectangles(int[][] rectangles) {
    return -1;
  }
}
