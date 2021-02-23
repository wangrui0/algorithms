package org.leetcode.shunxu.ch250;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 225. 用队列实现栈
 *
 * <p> 使用队列实现栈的下列操作：
 *
 * <p>     push(x) -- 元素 x 入栈
 * <p>     pop() -- 移除栈顶元素
 * <p>     top() -- 获取栈顶元素
 * <p>     empty() -- 返回栈是否为空
 *
 * <p> 注意:
 *
 * <p>     你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * <p>     你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>     你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * <p> 通过次数89,092
 * <p> 提交次数134,170
 * <p> 在真实的面试中遇到过这道题？
 * <p>贡献https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0225ImplementStackUsingQueues {

  Queue<Integer> queue1;
  Queue<Integer> queue2;

  /**
   * 复杂度分析
   *
   *     时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
   *     入栈操作需要将 queue1​ 中的 n 个元素出队，并入队 n+1 个元素到 queue2​，共有 n+1 次操作，每次出队和入队操作的时间复杂度都是O(1)，因此入栈操作的时间复杂度是 O(n)。
   *     出栈操作对应将 queue1​ 的前端元素出队，时间复杂度是 O(1)。
   *     获得栈顶元素操作对应获得 queue1​ 的前端元素，时间复杂度是 O(1)。
   *     判断栈是否为空操作只需要判断 queue1​ 是否为空，时间复杂度是 O(1)。
   *
   *     空间复杂度：O(n)，其中n 是栈内的元素。需要使用两个队列存储栈内的元素。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public Ch0225ImplementStackUsingQueues() {
    queue1 = new LinkedList<Integer>();
    queue2 = new LinkedList<Integer>();
  }

  /**
   * Push element x onto stack.
   */
  public void push(int x) {
    queue2.offer(x);//满了，元素不报错，和add 区别
    while (!queue1.isEmpty()) {
      queue2.offer(queue1.poll());//和remove 的区别，没有元素不报错
    }
    Queue<Integer> temp = queue1;
    queue1 = queue2;
    queue2 = temp;
  }

  /**
   * Removes the element on top of the stack and returns that element.
   */
  public int pop() {
    return queue1.poll();//和remove的区别，没有元素不报错
  }

  /**
   * Get the top element.
   */
  public int top() {
    return queue1.peek();//获取顶元素，没有元素不报错
  }

  /**
   * Returns whether the stack is empty.
   */
  public boolean empty() {
    return queue1.isEmpty();
  }

}

/**
 * 复杂度分析
 *
 *     时间复杂度：入栈操作 O(n)，其余操作都是 O(1)。
 *     入栈操作需要将队列中的 n 个元素出队，并入队 n+1 个元素到队列，共有 n+1 次操作，每次出队和入队操作的时间复杂度都是 O(1)，因此入栈操作的时间复杂度是 O(n)。
 *     出栈操作对应将队列的前端元素出队，时间复杂度是 O(1)。
 *     获得栈顶元素操作对应获得队列的前端元素，时间复杂度是 O(1)。
 *     判断栈是否为空操作只需要判断队列是否为空，时间复杂度是 O(1)。
 *
 *     空间复杂度：O(n)，其中n 是栈内的元素。需要使用一个队列存储栈内的元素。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class MyStack {
  Queue<Integer> queue;

  /** Initialize your data structure here. */
  public MyStack() {
    queue = new LinkedList<Integer>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    int n = queue.size();
    queue.offer(x);
    for (int i = 0; i < n; i++) {
      queue.offer(queue.poll());
    }
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return queue.poll();
  }

  /** Get the top element. */
  public int top() {
    return queue.peek();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return queue.isEmpty();
  }
}
