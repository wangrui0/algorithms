package org.leetcode.shunxu.leet500.ch450;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p> 412. Fizz Buzz
 *
 * <p> 写一个程序，输出从 1 到 n 数字的字符串表示。
 *
 * <p>1. 如果 n 是3的倍数，输出“Fizz”；
 *
 * <p>2. 如果 n 是5的倍数，输出“Buzz”；
 *
 * <p>3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 *
 * <p>示例：
 *
 * <p>n = 15,
 *
 * <p>返回:
 * <p>[
 * <p>    "1",
 * <p>    "2",
 * <p>    "Fizz",
 * <p>    "4",
 * <p>    "Buzz",
 * <p>    "Fizz",
 * <p>   "7",
 * <p>  "8",
 * <p>   "Fizz",
 * <p>   "Buzz",
 * <p>    "11",
 * <p>    "Fizz",
 * <p>    "13",
 * <p>    "14",
 * <p>    "FizzBuzz"
 * <p> ]
 * <p>https://leetcode-cn.com/problems/fizz-buzz/
 *
 * @author: wangrui
 * @date: 2021/3/3
 */
public class Ch412FizzBuzz {

  /**
   * <p> 时间复杂度： O(N)，这里 N 是输入字符串的长度；
   * <p> 空间复杂度： O(1)，保存结果集的空间不计算在内。
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz1(int n) {
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        result.add("FizzBuzz");
      } else if (i % 3 == 0) {
        result.add("Fizz");
      } else if (i % 5 == 0) {
        result.add("Buzz");
      } else {
        result.add(String.valueOf(i));
      }
    }
    return result;
  }

  /**
   * <p> 时间复杂度： O(N)，这里 N 是输入字符串的长度；
   * <p> 空间复杂度： O(1)，保存结果集的空间不计算在内。
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz2(int n) {
    // ans list
    List<String> ans = new ArrayList<String>();

    for (int num = 1; num <= n; num++) {

      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);

      String numAnsStr = "";

      if (divisibleBy3) {
        // Divides by 3, add Fizz
        numAnsStr += "Fizz";
      }

      if (divisibleBy5) {
        // Divides by 5, add Buzz
        numAnsStr += "Buzz";
      }

      if (numAnsStr.equals("")) {
        // Not divisible by 3 or 5, add the number
        numAnsStr += Integer.toString(num);
      }

      // Append the current answer str to the ans list
      ans.add(numAnsStr);
    }

    return ans;
  }

  /**
   * <p> 时间复杂度： O(N)，这里 N 是输入字符串的长度；
   * <p> 空间复杂度： O(1)，保存结果集的空间不计算在内。
   *
   * @param n
   * @return
   */
  public List<String> fizzBuzz3(int n) {

    // ans list
    List<String> ans = new ArrayList<String>();

    for (int num = 1; num <= n; num++) {

      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);

      if (divisibleBy3 && divisibleBy5) {
        // Divides by both 3 and 5, add FizzBuzz
        ans.add("FizzBuzz");
      } else if (divisibleBy3) {
        // Divides by 3, add Fizz
        ans.add("Fizz");
      } else if (divisibleBy5) {
        // Divides by 5, add Buzz
        ans.add("Buzz");
      } else {
        // Not divisible by 3 or 5, add the number
        ans.add(Integer.toString(num));
      }
    }

    return ans;
  }
  public List<String> fizzBuzz(int n) {

    // ans list
    List<String> ans = new ArrayList<String>();

    // Hash map to store all fizzbuzz mappings.
    HashMap<Integer, String> fizzBizzDict =
        new HashMap<Integer, String>() {
          {
            put(3, "Fizz");
            put(5, "Buzz");
          }
        };

    for (int num = 1; num <= n; num++) {

      String numAnsStr = "";

      for (Integer key : fizzBizzDict.keySet()) {

        // If the num is divisible by key,
        // then add the corresponding string mapping to current numAnsStr
        if (num % key == 0) {
          numAnsStr += fizzBizzDict.get(key);
        }
      }

      if (numAnsStr.equals("")) {
        // Not divisible by 3 or 5, add the number
        numAnsStr += Integer.toString(num);
      }

      // Append the current answer str to the ans list
      ans.add(numAnsStr);
    }
    return ans;
  }


}
