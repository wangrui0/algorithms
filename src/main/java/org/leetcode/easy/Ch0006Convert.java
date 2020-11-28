package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * <p>
 * E T O E S I I G
 * <p>
 * E   D   H   N
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * <p>
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * <p>
 * 输出: "LDREOEIIECIHNTSG"
 * <p>
 * 解释:
 * <p>
 * L     D     R
 * <p>
 * E   O E   I I
 * <p>
 * E C   I H   N
 * <p>
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/10/28
 */
public class Ch0006Convert {

  public static void main(String[] args) {

  }

  /**
   * 官方:
   * <p>
   * 方法一：按行排序
   * <p>
   * 思路
   * <p>
   * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
   * <p>
   * 算法
   * <p>
   * 我们可以使用 min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
   * <p>
   * 从左到右迭代 s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
   * <p>
   * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
   * <p>
   * ==========================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n==len(s)
   * <p>
   * 空间复杂度：O(n)
   *
   * @param s
   * @param numRows
   * @return
   */
  public static String convert(String s, int numRows) {

    if (numRows == 1) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<>();

    for (int i = 0; i < Math.min(numRows, s.length()); i++) {
      rows.add(new StringBuilder());
    }

    int curRow = 0;
    boolean goingDown = false;

    for (char c : s.toCharArray()) {
      rows.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows - 1) {
        goingDown = !goingDown;
      }
      curRow += goingDown ? 1 : -1;
    }

    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) {
      ret.append(row);
    }
    return ret.toString();
  }

  /**
   * 0123456789 LEETCODEISHIRING L   C   I   R
   * <p>
   * E T O E S I I G
   * <p>
   * E   D   H   N 思路
   * <p>
   * 按照与逐行读取 Z 字形图案相同的顺序访问字符串。
   * <p>
   * 算法
   * <p>
   * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
   * <p>
   * 对于所有整数 k，
   * <p>
   * 行 0 中的字符位于索引 k(2⋅numRows−2)+0 处;
   * <p>
   * 行 numRows−1 中的字符位于索引 k(2⋅numRows−2)+numRows−1处;
   * <p>
   * 内部的 行 i 中的字符位于索引 k(2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i 处
   *
   * <p>
   * ==================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n == len(s)。每个索引被访问一次。
   * <p>
   * 空间复杂度：O(n)。对于 C++ 实现，如果返回字符串不被视为额外空间，则复杂度为 O(1)。
   *
   * @param s
   * @param numRows
   * @return
   */
  public static String convert2(String s, int numRows) {

    if (numRows == 1) {
      return s;
    }

    StringBuilder ret = new StringBuilder();
    int n = s.length();
    int cycleLen = 2 * numRows - 2;

    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j + i < n; j += cycleLen) {
        ret.append(s.charAt(j + i));
        if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
          ret.append(s.charAt(j + cycleLen - i));
        }
      }
    }
    return ret.toString();
  }
}
