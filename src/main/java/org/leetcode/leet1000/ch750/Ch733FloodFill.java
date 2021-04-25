package org.leetcode.leet1000.ch750;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>733. 图像渲染
 *
 * <p>有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *
 * <p>给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 *
 * <p>为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * <p>接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *
 * <p>最后返回经过上色渲染后的图像。
 *
 * <p>示例 1:
 *
 * <p>输入:
 * <p>image = [[1,1,1],[1,1,0],[1,0,1]]
 * <p>sr = 1, sc = 1, newColor = 2
 * <p>输出: [[2,2,2],[2,2,0],[2,0,1]]
 * <p>解析:
 * <p>在图像的正中间，(坐标(sr,sc)=(1,1)),
 * <p>在路径上所有符合条件的像素点的颜色都被更改成2。
 * <p>注意，右下角的像素没有更改为2，
 * <p>因为它不是在上下左右四个方向上与初始点相连的像素点。
 *
 * <p>注意:
 *
 * <p>    image 和 image[0] 的长度在范围 [1, 50] 内。
 * <p>    给出的初始点将满足 0 <= sr < image.length 和 0 <= sc < image[0].length。
 * <p>    image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535]内。
 *
 * <p>通过次数42,974
 * <p>提交次数74,247
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/flood-fill/
 * <p>@author: wangrui
 * <p>@date: 2021/3/24
 */
public class Ch733FloodFill {

  int[] dx = {1, 0, 0, -1};
  int[] dy = {0, 1, -1, 0};

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int current = image[sr][sc];
    if (current == newColor) {
      return image;
    }
    int num = image[sr][sc];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{sr, sc});
    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int x = poll[0];
      int y = poll[1];
      image[x][y] = newColor;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && nx <= image.length - 1 && ny >= 0 && ny <= image[0].length - 1 && image[nx][ny] == num) {
          queue.offer(new int[]{nx, ny});
        }
      }
    }
    return image;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
   *
   * <p> 空间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。主要为队列的开销。
   *
   * @param image
   * @param sr
   * @param sc
   * @param newColor
   * @return
   */
  public int[][] floodFill_1(int[][] image, int sr, int sc, int newColor) {
    int currColor = image[sr][sc];
    if (currColor == newColor) {
      return image;
    }
    int n = image.length, m = image[0].length;
    Queue<int[]> queue = new LinkedList<int[]>();
    queue.offer(new int[]{sr, sc});
    image[sr][sc] = newColor;
    while (!queue.isEmpty()) {
      int[] cell = queue.poll();
      int x = cell[0], y = cell[1];
      for (int i = 0; i < 4; i++) {
        int mx = x + dx[i], my = y + dy[i];
        if (mx >= 0 && mx < n && my >= 0 && my < m && image[mx][my] == currColor) {
          queue.offer(new int[]{mx, my});
          image[mx][my] = newColor;
        }
      }
    }
    return image;
  }

  /**
   * <p>复杂度分析
   *
   * <p>     时间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
   *
   * <p>     空间复杂度：O(n×m)，其中 n 和 m 分别是二维数组的行数和列数。主要为栈空间的开销。
   *
   * @param image
   * @param sr
   * @param sc
   * @param newColor
   * @return
   */
  public int[][] floodFill_2(int[][] image, int sr, int sc, int newColor) {
    int currColor = image[sr][sc];
    if (currColor != newColor) {
      dfs(image, sr, sc, currColor, newColor);
    }
    return image;
  }

  public void dfs(int[][] image, int x, int y, int color, int newColor) {
    if (image[x][y] == color) {
      image[x][y] = newColor;
      for (int i = 0; i < 4; i++) {
        int mx = x + dx[i], my = y + dy[i];
        if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
          dfs(image, mx, my, color, newColor);
        }
      }
    }
  }

}
