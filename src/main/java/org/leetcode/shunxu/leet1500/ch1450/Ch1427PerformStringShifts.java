package org.leetcode.shunxu.leet1500.ch1450;

/**
 * <p>LeetCode 1427. 字符串的左右移
 * <p>2020-07-13阅读 1100
 * <p>1. 题目
 * <p>给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，其中 shift[i] = [direction, amount]：
 *
 * <p>direction 可以为 0 （表示左移）或 1 （表示右移）。
 * <p> amount 表示 s 左右移的位数。
 * <p> 左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
 * <p> 类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
 * <p> 对这个字符串进行所有操作后，返回最终结果。
 *
 * <p>示例 1：
 * <p>输入：s = "abc", shift = [[0,1],[1,2]]
 * <p>输出："cab"
 * <p>解释：
 * <p>[0,1] 表示左移 1 位。 "abc" -> "bca"
 * <p>[1,2] 表示右移 2 位。 "bca" -> "cab"
 *
 * <p>示例 2：
 * <p>输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * <p>输出："efgabcd"
 * <p>解释：
 * <p>[1,1] 表示右移 1 位。 "abcdefg" -> "gabcdef"
 * <p>[1,1] 表示右移 1 位。 "gabcdef" -> "fgabcde"
 * <p>[0,2] 表示左移 2 位。 "fgabcde" -> "abcdefg"
 * <p>[1,3] 表示右移 3 位。 "abcdefg" -> "efgabcd"
 *
 * <p>提示：
 * <p>1 <= s.length <= 100
 * <p>s 只包含小写英文字母
 * <p>1 <= shift.length <= 100
 * <p>shift[i].length == 2
 * <p>0 <= shift[i][0] <= 1
 * <p>0 <= shift[i][1] <= 100
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/perform-string-shifts
 * <p>@author: wangrui
 * <p>@date: 2021/4/20
 */
public class Ch1427PerformStringShifts {

  public static void main(String[] args) {
    System.out.println(stringShift("abc", new int[][]{{0, 1}, {1, 2}}));
    System.out.println(stringShift("abcdefg", new int[][]{{1, 1}, {1, 1}, {0, 2}, {1, 3}}));
  }

  public static String stringShift(String s, int[][] shifts) {
    int left = 0, right = 0;
    for (int[] shift : shifts) {
      int direction = shift[0];
      int number = shift[1];
      if (direction == 0) {//左移
        left += number;
      } else {//右移
        right += number;
      }
    }
    int sub = Math.abs(left - right);
    if (left > right) {
      return  s.substring(0, sub+1)+s.substring(sub+1);
    } else if (right > left) {
      return s.substring(sub+1)+s.substring(0, sub+1) ;
    }
    return s;
  }

}
