package org.leetcode.shunxu.ch250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p> 中心对称数
 * <p>A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * <p> Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * <p> Example 1:
 *
 * <p> Input:  "69"
 * <p> Output: true
 * <p> Example 2:
 *
 * <p> Input:  "88"
 * <p> Output: true
 * <p> Example 3:
 *
 * <p> Input:  "962"
 * <p> Output: false
 * <p> 题解：
 *
 * <p> 把几种对应关系加到HashMap中，两个指针向中间夹逼.
 * <p>
 * Time Complexity: O(n). Space: O(1).
 *
 * @author: wangrui
 * @date: 2021/1/31
 */
public class Ch0246StrobogrammaticNumber {

  /**
   * <p>题解：
   *
   * <p>把几种对应关系加到HashMap中，两个指针向中间夹逼.
   *
   * <p>Time Complexity: O(n). Space: O(1).
   *
   * @param num
   * @return
   */
  public boolean isStrobogrammatic(String num) {
    if (num == null || num.length() == 0) {
      return true;

    }

    HashMap<Character, Character> hm = new HashMap<>();
    String cans = "0011886996";
    for (int i = 0; i < cans.length(); i += 2) {
      hm.put(cans.charAt(i), cans.charAt(i + 1));

    }
    int l = 0;
    int r = num.length() - 1;
    while (l <= r) {
      char left = num.charAt(l);
      char right = num.charAt(r);
      if (!hm.containsKey(left) || !hm.containsKey(right) || hm.get(left) != right || hm.get(right) != left) {
        return false;
      }
      l++;
      r--;
    }
    return true;

  }

  /**
   * <p>  来源：力扣（LeetCode）
   * <p>  链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
   * <p>  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
   *
   * @author: wangrui
   * @date: 2020/12/1
   */
  public static class Ch0017LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
      List<String> combinations = new ArrayList<String>();
      if (digits.length() == 0) {
        return combinations;
      }
      Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
      }};
      backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
      return combinations;
    }

    /**
     * 234 abc def ghi
     * adg
     * bdg
     * cdg
     * gc
     * @param combinations
     * @param phoneMap
     * @param digits
     * @param index
     * @param combination
     */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index,
        StringBuffer combination) {
      if (index == digits.length()) {
        combinations.add(combination.toString());
      } else {
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
          combination.append(letters.charAt(i));
          backtrack(combinations, phoneMap, digits, index + 1, combination);
          combination.deleteCharAt(index);
        }
      }
    }

  }
}
