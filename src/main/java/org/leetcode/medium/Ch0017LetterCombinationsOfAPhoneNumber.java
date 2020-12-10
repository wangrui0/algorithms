package org.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>  来源：力扣（LeetCode）
 * <p>  链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * <p>  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/1
 */
public class Ch0017LetterCombinationsOfAPhoneNumber {

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
