package org.other;

/**
 *<p>            *
 *<p>           * *
 *<p>          * * *
 *<p>         * * * *
 *<p>        * * * * *
 * @author: wangrui
 * @date: 2020/11/23
 */
public class Ch0004Triangle {

  public static void main(String[] args) {
    triangle(5);
  }

  public static void triangle(int n) {
    for (int i = 0; i < n; i++) {//第几行
      for (int j = 0; j < n - i - 1; j++) {//打印
        System.out.print(" ");
      }
      for (int k = 1; k <= 2 * i + 1; k++) {
        if (k % 2 == 0) {//偶数列打印空格
          System.out.print(" ");
        } else {//奇数列打印*
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }
}
