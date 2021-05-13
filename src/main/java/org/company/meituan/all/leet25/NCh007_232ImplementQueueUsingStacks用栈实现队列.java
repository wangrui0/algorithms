package org.company.meituan.all.leet25;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>232. 用栈实现队列
 *
 * <p>请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * <p>实现 MyQueue 类：
 *
 * <p>    void push(int x) 将元素 x 推到队列的末尾
 * <p>    int pop() 从队列的开头移除并返回元素
 * <p>    int peek() 返回队列开头的元素
 * <p>    boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *
 *
 *
 * <p>说明：
 *
 * <p>    你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * <p>    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 *
 *
 * <p>进阶：
 *
 * <p>    你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 * <p>["MyQueue", "push", "push", "peek", "pop", "empty"]
 * <p>[[], [1], [2], [], [], []]
 * <p>输出：
 * <p>[null, null, null, 1, 1, false]
 *
 * <p>解释：
 * <p>MyQueue myQueue = new MyQueue();
 * <p>myQueue.push(1); // queue is: [1]
 * <p>myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * <p>myQueue.peek(); // return 1
 * <p>myQueue.pop(); // return 1, queue is [2]
 * <p>myQueue.empty(); // return false
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= x <= 9
 * <p>    最多调用 100 次 push、pop、peek 和 empty
 * <p>    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * <p>通过次数124,037
 * <p>提交次数180,410
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class NCh007_232ImplementQueueUsingStacks用栈实现队列 {

  Deque<Integer> inStack;
  Deque<Integer> outStack;


  /**
   * Initialize your data structure here.
   * <p>复杂度分析
   *
   * <p> 时间复杂度：push 和 empty 为 O(1)，pop 和
   * peek 为均摊 O(1)。对于每个元素，至多入栈和出栈各两次，故均摊复杂度为 O(1)。
   *
   * <p>空间复杂度：O(n)。其中 n是操作总数。对于有 n push 操作的情况，队列中会有 n 个元素，故空间复杂度为 O(n)。
   */
  public NCh007_232ImplementQueueUsingStacks用栈实现队列() {
    inStack = new LinkedList<Integer>();
    outStack = new LinkedList<Integer>();
  }


  public void push(int x) {
    inStack.push(x);
  }

  public int pop() {
    if (outStack.isEmpty()) {
      in2out();
    }
    return outStack.pop();
  }

  public int peek() {
    if (outStack.isEmpty()) {
      in2out();
    }
    return outStack.peek();
  }

  public boolean empty() {
    return inStack.isEmpty() && outStack.isEmpty();
  }

  private void in2out() {
    while (!inStack.isEmpty()) {
      outStack.push(inStack.pop());
    }
  }

}
