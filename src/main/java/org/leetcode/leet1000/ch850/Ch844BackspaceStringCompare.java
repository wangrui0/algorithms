package org.leetcode.leet1000.ch850;

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

  public static void main(String[] args) {
    System.out.println(backspaceCompare("bxj##tw",
        "bxj###tw"
    ));
  }

  public static boolean backspaceCompare(String S, String T) {
    int si = S.length() - 1;
    int ti = T.length() - 1;
    int skipS = 0;
    int skipT = 0;
    while (si >= 0 || ti >= 0) {
      while (si >= 0) {
        if (S.charAt(si) == '#') {
          si--;
          skipS++;
        } else if (skipS > 0) {
          si--;
          skipS--;
        } else {
          break;
        }
      }
      while (ti >= 0) {
        if (T.charAt(ti) == '#') {
          ti--;
          skipT++;
        } else if (skipT > 0) {
          ti--;
          skipT--;
        } else {
          break;
        }
      }
      if (si >= 0 && ti >= 0) {
        if (S.charAt(si) != T.charAt(ti)) {
          return false;
        }
      } else if (si >= 0 || ti >= 0) {
        return false;
      } else {
        return true;
      }
      si--;
      ti--;
    }
    return true;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N+M)，其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次。
   *
   * <p>  空间复杂度：O(N+M)，其中 N 和 M 分别为字符串 S 和 T 的长度。主要为还原出的字符串的开销。
   *
   * @param S
   * @param T
   * @return
   */
  public boolean backspaceCompare_1(String S, String T) {
    return build(S).equals(build(T));
  }

  public String build(String str) {
    StringBuffer ret = new StringBuffer();
    int length = str.length();
    for (int i = 0; i < length; ++i) {
      char ch = str.charAt(i);
      if (ch != '#') {
        ret.append(ch);
      } else {
        if (ret.length() > 0) {
          ret.deleteCharAt(ret.length() - 1);
        }
      }
    }
    return ret.toString();
  }


  /**
   * <p> 复杂度分析
   *
   * <p>  时间复杂度：O(N+M)，其中 N 和 M 分别为字符串 S 和 T 的长度。我们需要遍历两字符串各一次。
   *
   * <p>空间复杂度：O(1)。对于每个字符串，我们只需要定义一个指针和一个计数器即可
   *
   * @param S
   * @param T
   * @return
   */
  public boolean backspaceCompare_2(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) {
      while (i >= 0) {
        if (S.charAt(i) == '#') {
          skipS++;
          i--;
        } else if (skipS > 0) {
          skipS--;
          i--;
        } else {
          break;
        }
      }
      while (j >= 0) {
        if (T.charAt(j) == '#') {
          skipT++;
          j--;
        } else if (skipT > 0) {
          skipT--;
          j--;
        } else {
          break;
        }
      }
      if (i >= 0 && j >= 0) {
        if (S.charAt(i) != T.charAt(j)) {
          return false;
        }
      } else {
        if (i >= 0 || j >= 0) {
          return false;
        }
      }
      i--;
      j--;
    }
    return true;
  }

}
