package org.leetcode.leet500.ch150;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * <p>
 * 输出:
 * <p>
 * <p>[
 * <p>      [1],
 * <p>     [1,1],
 * <p>    [1,2,1],
 * <p>   [1,3,3,1],
 * <p>  [1,4,6,4,1]
 * <p> ]
 * <p> 通过次数117,491提交次数173,093
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/pascals-triangle
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/26
 */
public class Ch0118PascalsTriangle {

  public static void main(String[] args) {
    List<List<Integer>> result = generate(5);
    System.out.println(result);
  }

  /**
   * 自己
   *
   * @param numRows
   * @return
   */
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 1; i <= numRows; i++) {
      List<Integer> columns = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (j == 0 || j == i - 1) {
          columns.add(1);
        } else {
          List<Integer> beforeColumn = result.get(i - 2);
          Integer num = beforeColumn.get(j) + beforeColumn.get(j - 1);
          columns.add(num);
        }
      }
      result.add(columns);
    }
    return result;
  }

  /**
   * 官方
   *
   * @param numRows
   * @return
   */
  public List<List<Integer>> generate2(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();

    // First base case; if user requests zero rows, they get zero rows.
    if (numRows == 0) {
      return triangle;
    }

    // Second base case; first row is always [1].
    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for (int rowNum = 1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum - 1);

      // The first row element is always 1.
      row.add(1);

      // Each triangle element (other than the first and last of each row)
      // is equal to the sum of the elements above-and-to-the-left and
      // above-and-to-the-right.
      for (int j = 1; j < rowNum; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j));
      }

      // The last row element is always 1.
      row.add(1);

      triangle.add(row);
    }

    return triangle;
  }
}
