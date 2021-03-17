package org.leetcode.shunxu.ch600;

/**
 * <p>566. 重塑矩阵
 *
 * <p>在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * <p>给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * <p>重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * <p>如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * <p>示例 1:
 *
 * <p>输入:
 * <p>nums =
 * <p>[[1,2],
 * <p> [3,4]]
 * <p>r = 1, c = 4
 * <p>输出:
 * <p>[[1,2,3,4]]
 * <p>解释:
 * <p>行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 *4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 * <p>示例 2:
 *
 * <p>输入:
 * <p>nums =
 * <p>[[1,2],
 * <p> [3,4]]
 * <p>r = 2, c = 4
 * <p>输出:
 * <p>[[1,2],
 * <p> [3,4]]
 * <p>解释:
 * <p>没有办法将 2 *2 矩阵转化为 2 *4 矩阵。 所以输出原矩阵。
 *
 *
 * <p>注意：
 *
 * <p>    给定矩阵的宽和高范围在 [1, 100]。
 * <p>    给定的 r 和 c 都是正数。
 * <p>https://leetcode-cn.com/problems/reshape-the-matrix/
 * <p>通过次数50,018
 * <p>提交次数70,844
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 */
public class Ch566ReshapeTheMatrix {
    /**
     * <p>[[1,2],
     * <p> [3,4]
     * [5,6]]
     * 1 2 3 4
     * <p>r = 2, c = 4
     * <p>输出:
     * <p>[[1,2],
     * <p> [3,4]]
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (n * m != r * c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            ans[x / c][x % c] = nums[x / n][x % n];
        }
        return ans;
    }
}
