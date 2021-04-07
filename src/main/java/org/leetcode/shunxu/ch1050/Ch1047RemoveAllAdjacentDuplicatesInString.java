package org.leetcode.shunxu.ch1050;

/**
 * <p>1047. 删除字符串中的所有相邻重复项
 *
 * <p>给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * <p>在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * <p>在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入："abbaca"
 * <p>输出："ca"
 * <p>解释：
 * <p>例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= S.length <= 20000
 * <p>    S 仅由小写英文字母组成。
 *
 * <p>通过次数84,035
 * <p>提交次数115,930
 * <p>https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1047RemoveAllAdjacentDuplicatesInString {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是字符串的长度。我们只需要遍历该字符串一次。
   *
   * <p>    空间复杂度：O(n) 或 O(1)，取决于使用的语言提供的字符串类是否提供了类似「入栈」和「出栈」的接口。注意返回值不计入空间复杂度。
   *
   * @param S
   * @return
   */
  public String removeDuplicates(String S) {
    StringBuffer stack = new StringBuffer();
    int top = -1;
    for (int i = 0; i < S.length(); ++i) {
      char ch = S.charAt(i);
      if (top >= 0 && stack.charAt(top) == ch) {
        stack.deleteCharAt(top);
        --top;
      } else {
        stack.append(ch);
        ++top;
      }
    }
    return stack.toString();
  }


}
