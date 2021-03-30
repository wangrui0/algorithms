package org.leetcode.shunxu.ch850;

/**
 * <p> 844. 比较含退格的字符串
 *
 * <p> 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * <p> 注意：如果对空文本输入退格字符，文本继续为空。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：S = "ab#c", T = "ad#c"
 * <p> 输出：true
 * <p> 解释：S 和 T 都会变成 “ac”。
 *
 * <p> 示例 2：
 *
 * <p> 输入：S = "ab##", T = "c#d#"
 * <p> 输出：true
 * <p> 解释：S 和 T 都会变成 “”。
 *
 * <p> 示例 3：
 *
 * <p> 输入：S = "a##c", T = "#a#c"
 * <p> 输出：true
 * <p> 解释：S 和 T 都会变成 “c”。
 *
 * <p> 示例 4：
 *
 * <p> 输入：S = "a#c", T = "b"
 * <p> 输出：false
 * <p> 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 *
 *
 * <p> 提示：
 *
 * <p>     1 <= S.length <= 200
 * <p>     1 <= T.length <= 200
 * <p>     S 和 T 只含有小写字母以及字符 '#'。
 *
 *
 *
 * <p> 进阶：
 *
 * <p>     你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch844BackspaceStringCompare {

  public boolean backspaceCompare(String S, String T) {
    return true;
  }
}
