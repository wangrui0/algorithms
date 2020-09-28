package org.other;


/**
 * 将一个Integer 类型的数倒置
 * <p>
 * 如：
 * <p>
 * 123 321
 * <p>
 * -127  -721
 */
public class Ch0002IntegerToInvert {

  public static void main(String[] args) {
//    Integer num = 1234567;
    Integer num = 0;
//    Integer num=-1234567;
    Integer result = IntegerToInvert(num);
    System.out.println(result);
  }

  /**
   * @return
   */
  public static Integer IntegerToInvert(Integer num) {
    if (num == null || num == 0) {
      return num;
    }

    if (num > 0) {
      return reverse(num);
    } else {
      num = Math.abs(num);
      return 0 - reverse(num);
    }
  }

  public static Integer reverse(Integer num) {
    Integer result = 0;
    while (true) {
      int q = num % 10;
      result = result * 10 + q;
      num = num / 10;
      if (num <= 0) {
        break;
      }
    }
    return result;
  }
}
