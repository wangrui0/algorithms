package org;

/**
 * @author: wangrui
 * @date: 2021/3/29
 */
public class Test {

  public static void main(String[] args) {
    System.out.println(similarRGB("#09f166"));
  }

  public static String similarRGB(String color) {
    return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
  }

  public static String f(String comp) {
    int num = Integer.parseInt(comp, 16);
    int i = num / 17;
    int j = num % 17;
    int ans;
    if (j > 8) {
      ans = i + 1;
    } else {
      ans = i;
    }
    int decResult = ans * 17; // 前面除以 17，现在乘回来
    return String.format("%02x",decResult);
  }
}
