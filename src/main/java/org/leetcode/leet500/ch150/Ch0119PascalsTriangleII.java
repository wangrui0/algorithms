package org.leetcode.leet500.ch150;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * <p>        1
 * <p>      1   1
 * <p>     1  2  1
 * <p>    1  3  3   1
 * <p>  1  4  6  4   1
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 3 输出: [1,3,3,1] 进阶：
 * <p>
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/27
 */
public class Ch0119PascalsTriangleII {

  public static void main(String[] args) {
    List<Integer> row = getRow2(4);
    System.out.println(row);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> preList;
    List<Integer> currList = new ArrayList<>();

    for (int i = 0; i <= rowIndex; i++) {
      preList = currList;
      currList = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          currList.add(1);
        } else {
          Integer num = preList.get(j) + preList.get(j - 1);
          currList.add(num);
        }
      }
    }
    return currList;
  }

  /**
   * 方法二： 官方：秒啊，从后往前，太棒了。要记住这种思想，从后往前，充分利用数据的思想
   */
  public static List<Integer> getRow2(int rowIndex) {
    List<Integer> cur = new ArrayList<>();
    cur.add(1);
    for (int i = 1; i <= rowIndex; i++) {
      for (int j = i - 1; j > 0; j--) {
        cur.set(j, cur.get(j - 1) + cur.get(j));
      }
      cur.add(1);//补上每层的最后一个 1
    }
    return cur;
  }
}
