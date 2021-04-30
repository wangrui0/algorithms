package org.leetcode.lcp;

/**
 * <p>LCP 29. 乐团站位
 * <p>某乐团的演出场地可视作 num *num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。
 *
 * <p>为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。例如当 num = 5 时，站位如图所示
 *
 * <p>image.png
 *
 * <p>请返回位于场地坐标 [Xpos,Ypos] 的成员所持乐器编号。
 *
 * <p>示例 1：
 *
 * <p>输入：num = 3, Xpos = 0, Ypos = 2
 *
 * <p>输出：3
 *
 * <p>解释：
 * <p>image.png
 *
 * <p>示例 2：
 *
 * <p>输入：num = 4, Xpos = 1, Ypos = 2
 *
 * <p>输出：5
 *
 * <p>解释：
 * <p>image.png
 *
 * <p>提示：
 *
 * <p>1 <= num <= 10^9
 * <p>0 <= Xpos, Ypos < num
 * <p>通过次数2,834提交次数19,427
 * <p>https://leetcode-cn.com/problems/SNJvJP/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:22 下午
 */
public class LCP029SNJvJP {

  /**
   * <p>先确定成员所在的圈数，然后结合数学方法计算得到该圈左上角的起始值，再判断成员所在的边，计算得到乐器编号
   * <p>这道题卡人的地方就是时间复杂度，当矩形的边长比较小时我们甚至可以模拟建立一个二维数组来找到我们需要的位置。
   *
   * <p>但是当nums很大时，就会超时了，这个方法pass
   *
   * <p>数字排列的规律很好找到，可以看成一个一维数组一圈一圈向内卷成的二维数组，而目标坐标在一维数组中的位置取9的模就是答案。
   *
   * <p>1、找出目标点在第几圈，n=min(xPos,yPos,num-xPos-1,num-yPos-1)
   *
   * <p> 2、找出目标点的位置，上侧 or 下侧 or 左侧 or 右侧
   *
   * @param num
   * @param xPos
   * @param yPos
   * @return
   */
  public int orchestraLayout(int num, int xPos, int yPos) {
    //确定成员在第round圈
    int xRound = Math.min(xPos + 1, num - xPos);
    int yRound = Math.min(yPos + 1, num - yPos);
    int round = Math.min(xRound, yRound);
    int len = num - 1;//当前圈边的长度

    //确定成员所在圈左上角起始值
    long start = 1L;
    start = (start + (len - round + 2L) * (round - 1L) * 4L) % 9L;
    len -= ((round - 1) * 2);

    //确定成员乐器编号
    int ans;
    if (xPos + 1 == round) {//成员在上边
      ans = (int) ((start + yPos + 1 - round) % 9);
    } else if (num - yPos == round) {//成员在右边
      start = (start + (len % 9)) % 9;
      ans = (int) ((start + xPos + 1 - round) % 9);
    } else if (num - xPos == round) {//成员在下边
      start = (start + (len % 9) * 2) % 9;
      ans = (int) ((start + num - round - yPos) % 9);
    } else {//成员在左边
      start = (start + (len % 9) * 3) % 9;
      ans = (int) ((start + num - round - xPos) % 9);
    }
    return (ans == 0) ? 9 : ans;//也可将start初始值设置为0，返回ans%9+1
  }

  public int orchestraLayout2(int num, int xPos, int yPos) {
    long n = Math.min(Math.min(xPos, yPos), Math.min(num - xPos - 1, num - yPos - 1));
    long kinds = 0;
    kinds += 4 * n * num - 4 * n - 4 * n * (n - 1);
    if (n == xPos) {
      kinds += yPos - n + 1;
    } else if (n == yPos) {
      kinds += (num - 2 * n) * 3 - 3 + num - n - xPos;
    } else if (n == num - xPos - 1) {
      kinds += (num - 2 * n) * 2 - 2 + num - n - yPos;
    } else if (n == num - yPos - 1) {
      kinds += (num - 2 * n) * 1 - 1 + xPos - n + 1;
    }

    if (kinds % 9 == 0) {
      return 9;
    } else {
      return Integer.valueOf(String.valueOf(kinds % 9));
    }
  }
}