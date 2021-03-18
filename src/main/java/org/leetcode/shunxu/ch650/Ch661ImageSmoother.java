package org.leetcode.shunxu.ch650;

/**
 * <p>661. 图片平滑器
 *
 * <p>包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 *
 * <p>示例 1:
 *
 * <p>输入:
 * <p>[[1,1,1],
 * <p> [1,0,1],
 * <p> [1,1,1]]
 * <p>输出:
 * <p>[[0, 0, 0],
 * <p> [0, 0, 0],
 * <p> [0, 0, 0]]
 * <p>解释:
 * <p>对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * <p>对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * <p>对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 * <p>注意:
 *
 * <p>    给定矩阵中的整数范围为 [0, 255]。
 * <p>    矩阵的长和宽的范围均为 [1, 150]。
 * <p> https://leetcode-cn.com/problems/image-smoother/
 * <p>通过次数13,411
 * <p>提交次数24,198
 * <p>@author: wangrui
 * <p>@date: 2021/3/18
 */
public class Ch661ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;

        int[][] ans = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = 0;
                for (int ii = i - 1; ii <= i + 1; ii++) {
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                        if (ii >= 0 && jj >= 0 && ii < r && jj < c) {
                            ans[i][j] += M[ii][jj];
                            count++;
                        }
                    }
                }
                ans[i][j] = ans[i][j] / count;
            }
        }
        return ans;
    }

    /**
     * <p>官方：
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N)，其中 N 是图片中像素的数目。我们需要将每个像素都遍历一遍。
     *
     * <p>空间复杂度：O(N)，我们答案的大小。
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother2(int[][] M) {
        int R = M.length, C = M[0].length;
        int[][] ans = new int[R][C];

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int count = 0;
                for (int nr = r - 1; nr <= r + 1; ++nr)
                    for (int nc = c - 1; nc <= c + 1; ++nc) {
                        if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                            ans[r][c] += M[nr][nc];
                            count++;
                        }
                    }
                ans[r][c] /= count;
            }
        return ans;
    }
}
