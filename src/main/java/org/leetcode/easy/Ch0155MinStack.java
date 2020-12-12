package org.leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。  
 * <p>
 * 示例:
 * <p>
 * 输入： ["MinStack","push","push","push","getMin","pop","top","getMin"] [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出： [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * <p>MinStack minStack = new MinStack();
 * <p>minStack.push(-2);
 * <p>minStack.push(0);
 * <p> minStack.push(-3);
 * <p>minStack.getMin();
 * --> 返回 -3. minStack.pop(); minStack.top();      --> 返回 0. minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/min-stack 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/10
 */
public class Ch0155MinStack {
/**
 * 方法一：辅助栈
 * 思路
 *
 * 要做出这道题目，首先要理解栈结构先进后出的性质。
 *
 * 对于栈来说，如果一个元素 a 在入栈时，栈里有其它的元素 b, c, d，那么无论这个栈在之后经历了什么操作，只要 a 在栈中，b, c, d 就一定在栈中，因为在 a 被弹出之前，b, c, d 不会被弹出。
 *
 * 因此，在操作过程中的任意一个时刻，只要栈顶的元素是 a，那么我们就可以确定栈里面现在的元素一定是 a, b, c, d。
 *
 * 那么，我们可以在每个元素 a 入栈时把当前栈的最小值 m 存储起来。在这之后无论何时，如果栈顶元素是 a，我们就可以直接返回存储的最小值 m。
 *
 * 算法
 *
 * 按照上面的思路，我们只需要设计一个数据结构，使得每个元素 a 与其相应的最小值 m 时刻保持一一对应。因此我们可以使用一个辅助栈，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
 *
 * 当一个元素要入栈时，我们取当前辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
 *
 * 当一个元素要出栈时，我们把辅助栈的栈顶元素也一并弹出；
 *
 * 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中
 *
 *
 */
  /**
   * initialize your data structure here.
   */
  Deque<Integer> xStack;
  Deque<Integer> minStack;

  public Ch0155MinStack() {
    xStack = new LinkedList<>();
    minStack = new LinkedList<>();
    minStack.push(Integer.MAX_VALUE);
  }

  public void push(int x) {
    xStack.push(x);
    minStack.push(Math.min(x, minStack.peek()));
  }

  public void pop() {
    xStack.pop();
    minStack.pop();
  }

  public int top() {
    return xStack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }


}
