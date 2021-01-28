package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 *  <p> 给定一个无重复元素的有序整数数组 nums 。i
 *
 * <p> 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * <p> 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * <p>     "a->b" ，如果 a != b
 * <p>     "a" ，如果 a == b
 *
 *
 *
 * <p> 示例 1：
 *
 * <p> 输入：nums = [0,1,2,4,5,7]
 * <p> 输出：["0->2","4->5","7"]
 * <p> 解释：区间范围是：
 * <p> [0,2] --> "0->2"
 * <p> [4,5] --> "4->5"
 * <p> [7,7] --> "7"
 *
 * <p> 示例 2：
 *
 * <p> 输入：nums = [0,2,3,4,6,8,9]
 * <p> 输出：["0","2->4","6","8->9"]
 * <p> 解释：区间范围是：
 * <p> [0,0] --> "0"
 * <p> [2,4] --> "2->4"
 * <p> [6,6] --> "6"
 * <p> [8,9] --> "8->9"
 *
 * <p> 示例 3：
 *
 * <p> 输入：nums = []
 * <p> 输出：[]
 *
 * <p> 示例 4：
 *
 * <p> 输入：nums = [-1]
 * <p> 输出：["-1"]
 *
 * <p> 示例 5：
 *
 * <p> 输入：nums = [0]
 * <p> 输出：["0"]
 *
 *
 *
 * <p> 提示：
 *
 * <p>     0 <= nums.length <= 20
 * <p>     -231 <= nums[i] <= 231 - 1
 * <p>     nums 中的所有值都 互不相同
 * <p>     nums 按升序排列
 *
 * <p> 通过次数42,580
 * <p> 提交次数72,641
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/summary-ranges
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/27
 */
public class Ch0228SummaryRanges {
  /**
   * <p> 我们从数组的位置 0 出发，向右遍历。每次遇到相邻元素之间的差值大于 1 时，我们就找到了一个区间。遍历完数组之后，就能得到一系列的区间的列表。
   *
   * <p> 在遍历过程中，维护下标 low 和 high 分别记录区间的起点和终点，对于任何区间都有 low≤high。当得到一个区间时，根据 low 和 high 的值生成区间的字符串表示。
   *
   * <p>     当 low<high 时，区间的字符串表示为 ‘‘low→high"；
   *
   * <p>     当 low=high 时，区间的字符串表示为 ‘‘low"。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/summary-ranges/solution/hui-zong-qu-jian-by-leetcode-solution-6zrs/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * <p> ========================================
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 nnn 为数组的长度。
   *
   * <p>     空间复杂度：O(1)。除了用于输出的空间外，额外使用的空间为常数。
   *
   * @param nums
   * @return
   */
  public List<String> summaryRanges2(int[] nums) {
    List<String> result = new ArrayList<String>();
    int i = 0;
    int n = nums.length;
    while (i < n) {
      int low = i;
      i++;
      while (i < n && nums[i] == nums[i - 1] + 1) {
        i++;
      }
      int height = i - 1;
      StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
      if (low < height) {
        sb.append("->").append(String.valueOf(nums[height]));
      }
      result.add(sb.toString());
    }
    return result;
  }
}
