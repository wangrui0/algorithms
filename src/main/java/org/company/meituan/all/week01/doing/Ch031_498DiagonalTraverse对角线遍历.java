package org.company.meituan.all.week01.doing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>498. 对角线遍历
 *
 * <p>给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 *
 *
 * <p>示例:
 *
 * <p>输入:
 * 0,0; 0,1; 1,0;2,0;1,1;0,2;1,2;2,1;2,2
 * <p>[
 * <p> [ 1, 2, 3 ],
 * <p> [ 4, 5, 6 ],
 * <p> [ 7, 8, 9 ]
 * <p>]
 *
 * <p>输出:  [1,2,4,7,5,3,6,8,9]
 *
 * <p>解释:
 *
 *
 *
 * <p>说明:
 *
 * <p>    给定矩阵中的元素总数不会超过 100000 。
 *
 * <p>通过次数34,456
 * <p>提交次数78,524
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/diagonal-traverse/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class Ch031_498DiagonalTraverse对角线遍历 {
    /**
     * <p>方法一：对角线迭代和翻转
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N⋅M)，数组有 N 行 M 列。对于所有奇数对角线上的元素，需要两次处理，迭代和翻转。为了节省空间，需要遍历新对角线之前清除中间使用的空间，
     * <p>该操作需要 O(K) 的复杂度度，其中 K 是数组长度。因此至少处理两次数组中的元素，渐进复杂度为 O(N⋅M)。
     *
     * <p>空间复杂度：O(min(N, M))，额外空间用于存储每条对角线的中间数组，该数组长度为 N 和 M 的最小值。注意：对角线延伸到索引超出范围结束。
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // The two arrays as explained in the algorithm
        int[] result = new int[N * M];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for (int d = 0; d < N + M - 1; d++) {

            // Clear the intermediate array every time we start
            // to process another diagonal
            intermediate.clear();

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            int r = d < M ? 0 : d - M + 1;
            int c = d < M ? d : M - 1;

            // Iterate until one of the indices goes out of scope
            // Take note of the index math to go down the diagonal
            while (r < N && c > -1) {

                intermediate.add(matrix[r][c]);
                ++r;
                --c;
            }

            // Reverse even numbered diagonals. The
            // article says we have to reverse odd
            // numbered articles but here, the numbering
            // is starting from 0 :P
            if (d % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int i = 0; i < intermediate.size(); i++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    /**
     * <p>方法二：模拟
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N⋅M)，每个元素只处理一次。
     *
     * <p> 空间复杂度：O(1)，不使用额外空间。注意：输出数组空间不计入空间复杂度，因为这是题目要求的空间。空间复杂度应该指除了最终数组以外的空间。上一个方法中是中间数组，该方法中只有几个变量。
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder_2(int[][] matrix) {

        // Check for empty matrices
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }

        // Variables to track the size of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        // Incides that will help us progress through
        // the matrix, one element at a time.
        int row = 0, column = 0;

        // As explained in the article, this is the variable
        // that helps us keep track of what direction we are
        // processing the current diaonal
        int direction = 1;

        // The final result array
        int[] result = new int[N * M];
        int r = 0;

        // The uber while loop which will help us iterate over all
        // the elements in the array.
        while (row < N && column < M) {

            // First and foremost, add the current element to
            // the result matrix.
            result[r++] = matrix[row][column];

            // Move along in the current diagonal depending upon
            // the current direction.[i, j] -> [i - 1, j + 1] if
            // going up and [i, j] -> [i + 1][j - 1] if going down.
            int new_row = row + (direction == 1 ? -1 : 1);
            int new_column = column + (direction == 1 ? 1 : -1);

            // Checking if the next element in the diagonal is within the
            // bounds of the matrix or not. If it's not within the bounds,
            // we have to find the next head.
            if (new_row < 0 || new_row == N || new_column < 0 || new_column == M) {

                // If the current diagonal was going in the upwards
                // direction.
                if (direction == 1) {

                    // For an upwards going diagonal having [i, j] as its tail
                    // If [i, j + 1] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i + 1, j] becomes the next head
                    row += (column == M - 1 ? 1 : 0);
                    column += (column < M - 1 ? 1 : 0);

                } else {

                    // For a downwards going diagonal having [i, j] as its tail
                    // if [i + 1, j] is within bounds, then it becomes
                    // the next head. Otherwise, the element directly below
                    // i.e. the element [i, j + 1] becomes the next head
                    column += (row == N - 1 ? 1 : 0);
                    row += (row < N - 1 ? 1 : 0);
                }

                // Flip the direction
                direction = 1 - direction;

            } else {

                row = new_row;
                column = new_column;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDiagonalOrder_3(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    public static int[] findDiagonalOrder_3(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int r = matrix.length, c = matrix[0].length;
        int[] ans = new int[r * c];
        List<Integer> list = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < r + c - 1; i++) {
            list.clear();
            int row = i < c ? 0 : i - c + 1;
            int column = i < c ? i : c - 1;
            while (row < r && column >= 0) {
                list.add(matrix[row++][column--]);
            }
            if (i % 2 == 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    ans[k++] = list.get(j);
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    ans[k++] = list.get(j);
                }
            }
        }
        return ans;


    }


}
