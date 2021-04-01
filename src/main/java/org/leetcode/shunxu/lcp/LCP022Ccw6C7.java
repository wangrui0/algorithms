package org.leetcode.shunxu.lcp;

///**
// * <p>LCP 22. 黑白方格画
// *
// * <p>小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。画板上有 n *<p>n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色，所选行数、列数均可为 0。
// *
// * <p>小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
// *
// * <p>注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
// *
// * <p>示例 1：
// *
// * <p>    输入：n = 2, k = 2
// *
// * <p>    输出：4
// *
// * <p>    解释：一共有四种不同的方案：
// * <p>    第一种方案：涂第一列；
// * <p>    第二种方案：涂第二列；
// * <p>    第三种方案：涂第一行；
// * <p>    第四种方案：涂第二行。
// *
// * <p>示例 2：
// *
// * <p>    输入：n = 2, k = 1
// *
// * <p>    输出：0
// *
// * <p>    解释：不可行，因为第一次涂色至少会涂两个黑格。
// *
// * <p>示例 3：
// *
// * <p>    输入：n = 2, k = 4
// *
// * <p>    输出：1
// *
// * <p>    解释：共有 2*2=4 个格子，仅有一种涂色方案。
// *
// * <p>限制：
// *
// * <p>    1 <= n <= 6
// * <p>    0 <= k <= n *<p>n
// *
// * <p>通过次数6,876
// * <p>提交次数21,103
// * <p>@author: wangrui
// * <p>@date: 2021/3/31
// */
public class LCP022Ccw6C7 {

  int factorial[];//阶乘表

  public int paintingPlan(int n, int k) {
    if (k == n * n || k == 0) {
      return 1;//特殊判断，不涂或者全涂
    }
    factorial = new int[n + 1];
    factorial[0] = 1;
    //计算1!,2!,3!,4!....
    for (int i = 1; i <= n; i++) {
      factorial[i] = factorial[i - 1] * i;
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      //设i行,j列，则棋子数目k=i*n+j*(n-i)=i*n+j*n-i*j
      double j = 1.0 * (k - i * n) / (n - i);
      if (j >= 0 && j == (int) j) {
        //计算n 中选i 和 n中选j 的排列组合；（n的阶乘/（r的阶乘*（n-r）阶乘））
        count += combination(n, i) * combination(n, (int) j);
      }
    }
    return count;
  }

  private int combination(int n, int r) {
    return factorial[n] / (factorial[r] * factorial[n - r]);
  }

  /**
   * 方法2
   *
   * @param n
   * @param k
   * @return
   */
  int paintingPlan2(int n, int k) {
    if (k == 0 || k == n * n) {
      return 1;
    }
    int ans = 0;
    for (int a = 0; a <= n; a++) {
      for (int b = 0; b <= n; b++) {
        if ((a + b) * n - a * b == k) {
          ans = ans + C(n, a) * C(n, b);
        }
      }
    }
    return ans;
  }

  public int f(int num) {
    if (num == 0) {
      return 1;
    } else {
      return num * f(num - 1);
    }
  }                                                   //阶乘函数

  int C(int n, int m) {
    return f(n) / (f(m) * f(n - m));
  }                                               //组合数函数


}


