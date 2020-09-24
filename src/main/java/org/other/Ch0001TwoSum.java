package org.other;


/**
 * 计算2个大整数的和
 * 135767678110
 */
public class Ch0001TwoSum {

  public static void main(String[] args) {
    String num1 = "12323233333";
    String num2 = "123444444777";
    //6674434342006
    String sum = twoSum(num1, num2);
    System.out.println(sum);
  }

  /**
   * @param num1
   * @param num2
   * @return
   */
  public static String twoSum(String num1, String num2) {
    if (num1 == null || num1.length() == 0) {
      return num2;
    }
    if (num2 == null || num2.length() == 0) {
      return num1;
    }

    char[] num1Chars = num1.toCharArray();
    char[] num2Chars = num2.toCharArray();

    int num1Length = num1Chars.length;
    int num2Length = num2Chars.length;

    int i = num1Length - 1, j = num2Length - 1, carry = 0;

    int max = num1Length > num2Length ? num1Length : num2Length;

    int[] result = new int[max + 1];
    int index = -1;
    while (i >= 0 || j >= 0) {
      index++;
      int num1Temp = i >= 0 ? num1Chars[i] - 48 : 0;
      int num2Temp = j >= 0 ? num2Chars[j] - 48 : 0;

      int sum = num1Temp + num2Temp + carry;
      carry = sum / 10;
      result[index] = sum % 10;
      if (i >= 0) {
        i--;
      }
      if (j >= 0) {
        j--;
      }

    }

    if (carry > 0) {
      result[index] = carry;
    }
    StringBuilder sb = new StringBuilder();
    for (int temp = index; temp >= 0; temp--) {
      sb.append(result[temp]);
    }
    return sb.toString();
  }
}
