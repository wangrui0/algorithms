package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 232. 用栈实现队列
 *
 * <p> 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * <p> 实现 MyQueue 类：
 *
 * <p>     void push(int x) 将元素 x 推到队列的末尾
 * <p>     int pop() 从队列的开头移除并返回元素
 * <p>     int peek() 返回队列开头的元素
 * <p>     boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 *
 *
 * <p> 说明：
 *
 * <p>     你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * <p>     你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 *
 * <p> 进阶：
 *
 * <p>     你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *
 *
 *
 * <p> 示例：
 *
 * <p> 输入：
 * <p> ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * <p> [[], [1], [2], [], [], []]
 * <p> 输出：
 * <p> [null, null, null, 1, 1, false]
 *
 * <p> 解释：
 * <p> MyQueue myQueue = new MyQueue();
 * <p> myQueue.push(1); // queue is: [1]
 * <p> myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * <p> myQueue.peek(); // return 1
 * <p> myQueue.pop(); // return 1, queue is [2]
 * <p> myQueue.empty(); // return false
 *
 *
 *
 * <p> 提示：
 *
 * <p>     1 <= x <= 9
 * <p>     最多调用 100 次 push、pop、peek 和 empty
 * <p>     假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * <p> 通过次数78,051
 * <p> 提交次数118,643
 * <p> 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/implement-queue-using-stacks/
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0232ImplementQueueUsingStacks {

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
