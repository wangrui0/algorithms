package org.leetcode.easy;


import java.util.Stack;

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
public class Ch0232ImplementQueueUsingStacks2 {

  private Stack<Integer> s1 = new Stack<>();
  private Stack<Integer> s2 = new Stack<>();
  private int front;

  /**
   * <p> s1 用于纯粹
   * <p>s2 是临时队列
   *
   * @param x
   */
  public void push(int x) {
    if (s1.empty()) {
      front = x;
    }
    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    s2.push(x);
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
  }

  public void pop() {
    s1.pop();
    if (!s1.empty()) {
      front = s1.peek();
    }
  }

  // Get the front element.
  public int peek() {
    return front;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return s1.isEmpty();
  }
}
