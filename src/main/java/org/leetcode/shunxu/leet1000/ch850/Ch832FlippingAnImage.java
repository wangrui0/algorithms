package org.leetcode.shunxu.leet1000.ch850;

/**
 * <p> 832. 翻转图像
 *
 * <p> 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * <p> 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 *
 * <p> 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * <p> 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * <p> 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * <p>      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * <p> 示例 2：
 *
 * <p> 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * <p> 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * <p> 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * <p>      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 *
 *
 * <p> 提示：
 *
 * <p>     1 <= A.length = A[0].length <= 20
 * <p>     0 <= A[i][j] <= 1
 *
 * <p> 通过次数80,481
 * <p> 提交次数101,211
 * <p> 在真实的面试中遇到过这道题？
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch832FlippingAnImage {

  public static void main(String[] args) {
    System.out.println(flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
  }

  //1
  public static int[][] flipAndInvertImage(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = image[i].length - 1;
      while (left < right) {
        if (image[i][left] == image[i][right]) {
          image[i][left] ^= 1;
          image[i][right] ^= 1;
        }
        left++;
        right--;
      }
      if (left == right) {
        image[i][left] ^= 1;
      }
    }
    return image;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>     时间复杂度：O(n^2)，其中 n 是矩阵 image 的行数和列数。需要遍历矩阵一次，进行翻转操作。
   *
   * <p>    空间复杂度：O(1)。除了返回值以外，额外使用的空间为常数
   *
   * @param image
   * @return
   */
  public int[][] flipAndInvertImage_2(int[][] image) {
    int n = image.length;
    for (int i = 0; i < n; i++) {
      int left = 0, right = n - 1;
      while (left < right) {
        if (image[i][left] == image[i][right]) {
          image[i][left] ^= 1;
          image[i][right] ^= 1;
        }
        left++;
        right--;
      }
      if (left == right) {
        image[i][left] ^= 1;
      }
    }
    return image;
  }

}
