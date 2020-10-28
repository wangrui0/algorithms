package org.leetcode;

/**
 * @author: wangrui
 * @date: 2020/10/26
 */
public class StringTest {

  public static void main(String[] args) {
    String num = "123456";
    for (int i = 0; i < num.length(); i++) {
      int tem = num.charAt(i);
      System.out.println(tem);
    }
    System.out.println("=====================");
    int temp0 = '0';
    System.out.println(temp0);
    //字符与int 之间的转换是'0'
    System.out.println("=====================");
    for (int i = 0; i < num.length(); i++) {
      int tem = num.charAt(i)-'0';
      System.out.println(tem);
    }

  }
}
