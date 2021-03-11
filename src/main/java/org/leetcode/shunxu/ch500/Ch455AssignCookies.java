package org.leetcode.shunxu.ch500;

import java.util.Arrays;

/**
 * <p>455. 分发饼干
 *
 * <p>假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * <p>对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i
 * ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *
 * <p>示例 1:
 *
 * <p>输入: g = [1,2,3], s = [1,1]
 * <p>输出: 1
 * <p>解释:
 * <p>你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * <p>虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * <p>所以你应该输出1。
 *
 * <p>示例 2:
 *
 * <p> 输入: g = [1,2], s = [1,2,3]
 * <p>输出: 2
 * <p>解释:
 * <p>你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * <p>你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * <p>所以你应该输出2.
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= g.length <= 3 * 104
 * <p>   0 <= s.length <= 3 * 104
 * <p>   1 <= g[i], s[j] <= 231 - 1
 * <p>https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author: wangrui
 * @date: 2021/3/4
 */
public class Ch455AssignCookies {

  /**
   * self
   *
   * @param g
   * @param s
   * @return
   */
  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int sIndex = 0;
    int count = 0;
    for (int gIndex = 0; gIndex <= g.length - 1; gIndex++) {
      while (sIndex <= s.length - 1 && g[gIndex] > s[sIndex]) {
        sIndex++;
      }
      if (sIndex <= s.length - 1) {
        count++;
      }
      sIndex++;
    }
    return count;
  }

  /**
   * 复杂度分析
   *
   *     时间复杂度：O(mlogm+nlogn)，其中 m 和 n 分别是数组 g 和 s 的长度。对两个数组排序的时间复杂度是 O(mlogm+nlogn)，遍历数组的时间复杂度是 O(m+n)，因此总时间复杂度是 O(mlogm+nlogn)。
   *
   *     空间复杂度：O(logm+logn)，其中 m 和 n 分别是数组 g 和 s 的长度。空间复杂度主要是排序的额外空间开销。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/assign-cookies/solution/fen-fa-bing-gan-by-leetcode-solution-50se/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param g
   * @param s
   * @return
   */
  public int findContentChildren2(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int numOfChildren = g.length, numOfCookies = s.length;
    int count = 0;
    for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
      while (j < numOfCookies && g[i] > s[j]) {
        j++;
      }
      if (j < numOfCookies) {
        count++;
      }
    }
    return count;
  }
}

