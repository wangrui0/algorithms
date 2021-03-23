package org.leetcode.shunxu.ch750;

/**
 * <p>703. 数据流中的第 K 大元素
 *
 * <p>设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * <p>请实现 KthLargest 类：
 *
 * <p>    KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * <p>    int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>["KthLargest", "add", "add", "add", "add", "add"]
 * <p>[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * <p>输出：
 * <p>[null, 4, 5, 5, 8, 8]
 *
 * <p>解释：
 * <p>KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * <p>kthLargest.add(3);   // return 4
 * <p>kthLargest.add(5);   // return 5
 * <p>kthLargest.add(10);  // return 5
 * <p>kthLargest.add(9);   // return 8
 * <p>kthLargest.add(4);   // return 8
 *
 *
 * <p>提示：
 *
 * <p>    1 <= k <= 104
 * <p>    0 <= nums.length <= 104
 * <p>    -104 <= nums[i] <= 104
 * <p>    -104 <= val <= 104
 * <p>    最多调用 add 方法 104 次
 * <p>    题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * <p>通过次数50,220
 * <p>提交次数98,879
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class NCh703KthLargestElementInAStream {

  public NCh703KthLargestElementInAStream(int k, int[] nums) {

  }

  public int add(int val) {
    return -1;
  }
}
