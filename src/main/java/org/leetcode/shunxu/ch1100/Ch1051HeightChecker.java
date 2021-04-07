package org.leetcode.shunxu.ch1100;

/**
 * <p>1051. 高度检查器
 *
 * <p>学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 *
 * <p>请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
 *
 * <p>注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：heights = [1,1,4,2,1,3]
 * <p>输出：3
 * <p>解释：
 * <p>当前数组：[1,1,4,2,1,3]
 * <p>目标数组：[1,1,1,2,3,4]
 * <p>在下标 2 处（从 0 开始计数）出现 4 vs 1 ，所以我们必须移动这名学生。
 * <p>在下标 4 处（从 0 开始计数）出现 1 vs 3 ，所以我们必须移动这名学生。
 * <p>在下标 5 处（从 0 开始计数）出现 3 vs 4 ，所以我们必须移动这名学生。
 *
 * <p>示例 2：
 *
 * <p>输入：heights = [5,1,2,3,4]
 * <p>输出：5
 *
 * <p>示例 3：
 *
 * <p>输入：heights = [1,2,3,4,5]
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= heights.length <= 100
 * <p>    1 <= heights[i] <= 100
 * https://leetcode-cn.com/problems/height-checker/
 * <p>通过次数28,148
 * <p>提交次数37,680
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1051HeightChecker {

  /**
   * <p>复杂度分析:
   *
   * <p>时间复杂度：O(n) ，计数过程为 O(n)，比较过程外层循环次数固定为 100，里层循环一共也只会执行 n 次，O(100+n)，即 O(n)
   * <p>空间复杂度：O(1) ，其中一个固定长度的计数数组与一个统计变量，与输入 NNN 的大小无关
   * <p>运行结果:
   *
   * <p>执行用时 : 1 ms, 在所有 Java 提交中击败了 100.00% 的用户
   * <p>内存消耗 : 34.3 MB, 在所有 Java 提交中击败了 100.00% 的用户
   *
   * <p>作者：holy-sword
   * <p>链接：https://leetcode-cn.com/problems/height-checker/solution/onjie-fa-yong-shi-yu-nei-cun-ji-bai-100-javayong-h/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param heights
   * @return
   */
  public int heightChecker(int[] heights) {
    int[] arr = new int[101];
    for (int height : heights) {
      arr[height]++;
    }
    int count = 0;
    for (int i = 1, j = 0; i < arr.length; i++) {
      while (arr[i]-- > 0) {
        if (heights[j++] != i) {
          count++;
        }
      }
    }
    return count;
  }

}
