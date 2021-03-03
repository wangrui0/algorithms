package org.leetcode.shunxu.ch350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>350. 两个数组的交集 II
 *
 * <p>给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * <p>输出：[2,2]
 *
 * <p>示例 2:
 *
 * <p>输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * <p>输出：[4,9]
 *
 *
 *
 * <p>说明：
 *
 * <p>   输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * <p>    我们可以不考虑输出结果的顺序。
 *
 * <p>进阶：
 *
 * <p>    如果给定的数组已经排好序呢？你将如何优化你的算法？
 * <p>    如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * <p>   如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * <p>通过次数173,713
 * <p>提交次数322,190
 * <p> https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author: wangrui
 * @date: 2021/2/28
 */
public class Ch350IntersectionOfTwoArraysII {

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(m+n)，其中 m 和 n 分别是两个数组的长度。需要遍历两个数组并对哈希表进行操作，
   * <p>哈希表操作的时间复杂度是 O(1)，因此总时间复杂度与两个数组的长度和呈线性关系。
   *
   * <p>    空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。对较短的数组进行哈希表的操作，
   * <p>哈希表的大小不会超过较短的数组的长度。为返回值创建一个数组 intersection，其长度为较短的数组的长度。
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return intersect(nums2, nums1);
    }
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int num : nums1) {
      int count = map.getOrDefault(num, 0) + 1;
      map.put(num, count);
    }
    int[] intersection = new int[nums1.length];
    int index = 0;
    for (int num : nums2) {
      int count = map.getOrDefault(num, 0);
      if (count > 0) {
        intersection[index++] = num;
        count--;
        if (count > 0) {
          map.put(num, count);
        } else {
          map.remove(num);
        }
      }
    }
    return Arrays.copyOfRange(intersection, 0, index);
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(mlogm+nlogn)，其中 m 和 n 分别是两个数组的长度。对两个数组进行排序的时间复杂度是 O(mlogm+nlogn)，
   * <p>遍历两个数组的时间复杂度是 O(m+n)，因此总时间复杂度是 O(mlogm+nlogn)。
   *
   * <p>  空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个数组的长度。为返回值创建一个数组 intersection，其长度为较短的数组的长度。
   * <p>不过在 C++ 中，我们可以直接创建一个 vector，不需要把答案临时存放在一个额外的数组中，所以这种实现的空间复杂度为 O(1)
   *
   * @param nums1
   * @param nums2
   * @return
   */
  public int[] intersect2(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int length1 = nums1.length, length2 = nums2.length;
    int[] intersection = new int[Math.min(length1, length2)];
    int index1 = 0, index2 = 0, index = 0;
    while (index1 < length1 && index2 < length2) {
      if (nums1[index1] < nums2[index2]) {
        index1++;
      } else if (nums1[index1] > nums2[index2]) {
        index2++;
      } else {
        intersection[index] = nums1[index1];
        index1++;
        index2++;
        index++;
      }
    }
    return Arrays.copyOfRange(intersection, 0, index);
  }

  /**
   * self
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
  public int[] intersect3(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
    for (int num : nums1) {
      int count = map1.getOrDefault(num, 0) + 1;
      map1.put(num, count);
    }

    Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
    for (int num : nums2) {
      int count = map2.getOrDefault(num, 0) + 1;
      map2.put(num, count);
    }
    return getIntersection3(map1, map2, nums1.length + nums2.length);

  }

  public int[] getIntersection3(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int num) {
    if (map1.size() > map1.size()) {
      return getIntersection3(map2, map1, num);
    }
    int[] result = new int[num];
    int index = 0;
    for (Integer key : map1.keySet()) {
      Integer value1 = map1.get(key);
      Integer value2 = map2.getOrDefault(key, 0);
      if (value2 > 0) {
        int min = value1 > value2 ? value2 : value1;
        for (int i = 0; i < min; i++) {
          result[index++] = key;
        }
      }
    }
    return Arrays.copyOfRange(result, 0, index);
  }
}
