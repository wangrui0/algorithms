package org.leetcode.leet2000.ch1600;

/**
 * <p>1582. 二进制矩阵中的特殊位置
 *
 * <p>给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 *
 * <p>特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：mat = [[1,0,0],
 * <p>            [0,0,1],
 * <p>            [1,0,0]]
 * <p>输出：1
 * <p>解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 *
 * <p>示例 2：
 *
 * <p>输入：mat = [[1,0,0],
 * <p>            [0,1,0],
 * <p>            [0,0,1]]
 * <p>输出：3
 * <p>解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 *
 * <p>示例 3：
 *
 * <p>输入：mat = [[0,0,0,1],
 * <p>            [1,0,0,0],
 * <p>            [0,1,1,0],
 * <p>            [0,0,0,0]]
 * <p>输出：2
 *
 * <p>示例 4：
 *
 * <p>输入：mat = [[0,0,0,0,0],
 * <p>            [1,0,0,0,0],
 * <p>            [0,1,0,0,0],
 * <p>            [0,0,1,0,0],
 * <p>            [0,0,0,1,1]]
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    rows == mat.length
 * <p>    cols == mat[i].length
 * <p>    1 <= rows, cols <= 100
 * <p>    mat[i][j] 是 0 或 1
 *
 * <p>通过次数8,131
 * <p>提交次数12,097
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1582SpecialPositionsInABinaryMatrix {
    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }

    public static int numSpecial(int[][] mat) {
        int count = 0;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
