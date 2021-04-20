package org.leetcode.shunxu.leet500.ch500;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>496. 下一个更大元素 I
 *
 * <p>给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * <p>请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * <p>nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *
 *
 * <p> 示例 1:
 *
 * <p>输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * <p>输出: [-1,3,-1]
 * <p>解释:
 * <p>    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 * <p>   对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 * <p>   对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * <p>示例 2:
 *
 *
 *
 * <p>输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * <p>输出: [3,-1]
 * <p>解释:
 * <p>    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 * <p>   对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 *
 *
 * <p>提示：
 *
 * <p>   1 <= nums1.length <= nums2.length <= 1000
 * <p>   0 <= nums1[i], nums2[i] <= 104
 * <p>   nums1和nums2中所有整数 互不相同
 * <p>   nums1 中的所有整数同样出现在 nums2 中
 *
 *
 *
 * <p>进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
 * <p> https://leetcode-cn.com/problems/next-greater-element-i/
 *
 * @author: wangrui
 * @date: 2021/3/11
 */
public class Ch496NextGreaterElementI {


  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack();
    Map<Integer, Integer> map = new HashMap<>();

    int[] array = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      while (!stack.isEmpty() && stack.peek() < nums2[i]) {
        map.put(stack.pop(), nums2[i]);
      }
      stack.push(nums2[i]);
    }

    while (!stack.isEmpty()) {
      map.put(stack.pop(), -1);
    }
    for (int i = 0; i < nums1.length; i++) {
      array[i] = map.get(nums1[i]);
    }
    return array;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(M+N)，其中 MMM 和 NNN 分别是数组 nums1 和 nums2 的长度。
   *
   * <p>   空间复杂度：O(N)。我们在遍历 nums2 时，需要使用栈，以及哈希映射用来临时存储答案。
   *
   * <p>作者：LeetCode
   * <p>链接：https://leetcode-cn.com/problems/next-greater-element-i/solution/xia-yi-ge-geng-da-yuan-su-i-by-leetcode/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param findNums
   * @param nums
   * @return
   */
  public int[] nextGreaterElement2(int[] findNums, int[] nums) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    int[] res = new int[findNums.length];
    for (int i = 0; i < nums.length; i++) {
      while (!stack.empty() && nums[i] > stack.peek()) {
        map.put(stack.pop(), nums[i]);
      }
      stack.push(nums[i]);
    }
    while (!stack.empty()) {
      map.put(stack.pop(), -1);
    }
    for (int i = 0; i < findNums.length; i++) {
      res[i] = map.get(findNums[i]);
    }
    return res;
  }
}
