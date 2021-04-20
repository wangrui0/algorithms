package org.leetcode.shunxu.leet1000.ch950;

/**
 * <p>925. 长按键入
 *
 * <p>你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *
 * <p>你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：name = "alex", typed = "aaleex"
 * <p>输出：true
 * <p>解释：'alex' 中的 'a' 和 'e' 被长按。
 *
 * <p>示例 2：
 *
 * <p>输入：name = "saeed", typed = "ssaaedd"
 * <p>输出：false
 * <p>解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 *
 * <p>示例 3：
 *
 * <p>输入：name = "leelee", typed = "lleeelee"
 * <p>输出：true
 *
 * <p>示例 4：
 *
 * <p>输入：name = "laiden", typed = "laiden"
 * <p>输出：true
 * <p>解释：长按名字中的字符并不是必要的。
 *
 *
 *
 * <p>提示：
 *
 * <p>    name.length <= 1000
 * <p>    typed.length <= 1000
 * <p>    name 和 typed 的字符都是小写字母。
 * <p>@author: wangrui
 * <p>@date: 2021/3/21
 */
public class Ch925LongPressedName {

  public static void main(String[] args) {
    System.out.println(isLongPressedName("alex", "aaleexx"));
  }

  public static boolean isLongPressedName(String name, String typed) {
    int i = 0, j = 0;
    while (j < typed.length()) {
      if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
        i++;
        j++;
      } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
        j++;
      } else {
        return false;
      }
    }
    return i >= name.length();
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N+M)，其中 M,NM,NM,N 分别为两个字符串的长度。
   *
   * <p> 空间复杂度：O(1)。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/long-pressed-name/solution/chang-an-jian-ru-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param name
   * @param typed
   * @return
   */
  public boolean isLongPressedName2(String name, String typed) {
    int i = 0, j = 0;
    while (j < typed.length()) {
      if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
        i++;
        j++;
      } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
        j++;
      } else {
        return false;
      }
    }
    return i == name.length();
  }

}
