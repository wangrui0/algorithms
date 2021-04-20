package org.leetcode.shunxu.leet1000.ch850;

/**
 * <p> 836. 矩形重叠
 *
 * <p> 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。矩形的上下边平行于 x 轴，左右边平行于 y 轴。
 *
 * <p> 如果相交的面积为 正 ，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * <p> 给出两个矩形 rec1 和 rec2 。如果它们重叠，返回 true；否则，返回 false 。
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * <p> 输出：true
 * 左侧：rec1[2] <= rec2[0]；
 * <p>
 * 右侧：rec1[0] >= rec2[2]；
 * <p>
 * 上方：rec1[1] >= rec2[3]；
 * <p>
 * 下方：rec1[3] <= rec2[1]。
 * <p>
 * 作者：LeetCode-Solution 链接：https://leetcode-cn.com/problems/rectangle-overlap/solution/ju-xing-zhong-die-by-leetcode-solution/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p> 示例 2：
 *
 * <p> 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * <p> 输出：false
 *
 * <p> 示例 3：
 *
 * <p> 输入：rec1 = [0,0,1,1], rec2 = [2,2,3,3]
 * <p> 输出：false
 *
 *
 *
 * <p> 提示：
 *
 * <p>     rect1.length == 4
 * <p>     rect2.length == 4
 * <p>     -109 <= rec1[i], rec2[i] <= 109
 * <p>     rec1[0] <= rec1[2] 且 rec1[1] <= rec1[3]
 * <p>     rec2[0] <= rec2[2] 且 rec2[1] <= rec2[3]
 *
 * <p> 通过次数34,267
 * <p> 提交次数71,332
 * <p> @author: wangrui
 * <p> @date: 2021/3/30
 */
public class Ch836RectangleOverlap {


  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
      return false;
    }
    return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[3] <= rec2[1] || rec1[1] >= rec2[3]);
  }

  /**
   * <p> 复杂度分析
   *
   * <p> 时间复杂度：O(1)。
   *
   * <p> 空间复杂度：O(1)，不需要额外的空间。
   *
   * @param rec1
   * @param rec2
   * @return
   */
  public boolean isRectangleOverlap_1(int[] rec1, int[] rec2) {
    if (rec1[0] == rec1[2] || rec1[1] == rec1[3] || rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
      return false;
    }
    return !(rec1[2] <= rec2[0] ||   // left
        rec1[3] <= rec2[1] ||   // bottom
        rec1[0] >= rec2[2] ||   // right
        rec1[1] >= rec2[3]);    // top
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(1)。
   *
   * <p>    空间复杂度：O(1)，不需要额外的空间。
   *
   * @param rec1
   * @param rec2
   * @return
   */
  public boolean isRectangleOverlap_2(int[] rec1, int[] rec2) {
    return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) &&
        Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
  }

}
