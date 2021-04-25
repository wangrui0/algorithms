package org.leetcode.leet500.ch350;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>349. 两个数组的交集
 *
 * <p>给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * <p>输出：[2]
 *
 * <p>示例 2：
 *
 * <p>输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * <p>输出：[9,4]
 *
 *
 *
 * <p>说明：
 *
 * <p>    输出结果中的每个元素一定是唯一的。
 * <p>   我们可以不考虑输出结果的顺序。
 * <p>https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch349IntersectionOfTwoArrays {

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。使用两个集合分别存储两个数组中的元素需要 O(m+n) 的时间，
   * <p>遍历较小的集合并判断元素是否在另一个集合中需要 O(min(m,n)) 的时间，因此总时间复杂度是 O(m+n)。
   *
   * <p>     空间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。空间复杂度主要取决于两个集合
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersection(int[] nums1, int[] nums2) {
    Set<Integer> set1 = new HashSet<Integer>();
    Set<Integer> set2 = new HashSet<Integer>();
    for (int num : nums1) {
      set1.add(num);
    }
    for (int num : nums2) {
      set2.add(num);
    }
    return getIntersection(set1, set2);
  }

  public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
    if (set1.size() > set2.size()) {
      return getIntersection(set2, set1);
    }
    Set<Integer> intersectionSet = new HashSet<Integer>();
    for (int num : set1) {
      if (set2.contains(num)) {
        intersectionSet.add(num);
      }
    }
    int[] intersection = new int[intersectionSet.size()];
    int index = 0;
    for (int num : intersectionSet) {
      intersection[index++] = num;
    }
    return intersection;
  }

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(mlogm+nlogn)，其中 m 和 n 分别是两个数组的长度。对两个数组排序的时间复杂度分别是O(mlogm) 和 O(nlogn)，
   * <p>双指针寻找交集元素的时间复杂度是O(m+n)，因此总时间复杂度是 O(mlogm+nlogn)。
   * <p>
   * <p>    空间复杂度：O(logm+logn)，其中 m 和 n 分别是两个数组的长度。空间复杂度主要取决于排序使用的额外空间。
   *
   * <p>作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays/solution/liang-ge-shu-zu-de-jiao-ji-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *122
   *012
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersection2(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int length1 = nums1.length, length2 = nums2.length;
    int[] intersection = new int[length1 + length2];
    int index = 0, index1 = 0, index2 = 0;
    while (index1 < length1 && index2 < length2) {
      int num1 = nums1[index1], num2 = nums2[index2];
      if (num1 == num2) {
        // 保证加入元素的唯一性
        if (index == 0 || num1 != intersection[index - 1]) {
          intersection[index++] = num1;
        }
        index1++;
        index2++;
      } else if (num1 < num2) {
        index1++;
      } else {
        index2++;
      }
    }
    return Arrays.copyOfRange(intersection, 0, index);
  }
}
