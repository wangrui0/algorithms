package org.leetcode.leet1000.ch750;

import java.util.Stack;

/**
 * 思路:
 * <p>
 * <p>这道题让我们实现一个最大栈，包含一般栈的功能，但是还新加了两个功能peekMax()和popMax()，随时随地可以查看和返回最大值。之前有一道很类似的题Min
 * <p>Stack，所以我们可以借鉴那道题的解法，使用两个栈来模拟，s1为普通的栈，用来保存所有的数字，而s2为最大栈，用来保存出现的最大的数字。
 * <p>
 * <p>在push()函数中，我们先来看s2，如果s2为空，或者s2的栈顶元素小于等于x，将x压入s2中。因为s2保存的是目前为止最大的数字，所以一旦新数字大于等于栈顶元素，
 * <p>说明遇到更大的数字了，压入栈。然后将数组压入s1，s1保存所有的数字，所以都得压入栈。
 * <p>
 * <p>在pop()函数中，当s2的栈顶元素和s1的栈顶元素相同时，我们要移除s2的栈顶元素，因为一个数字不在s1中了，就不能在s2中。然后取出s1的栈顶元素，并移除s1，
 * <p>返回即可。
 * <p>
 * <p>在top()函数中，直接返回s1的top()函数即可。
 * <p>
 * <p>在peekMax()函数中，直接返回s2的top()函数即可。
 * <p>
 * <p>在popMax()函数中，先将s2的栈顶元素保存到一个变量mx中，然后我们要在s1中删除这个元素，由于栈无法直接定位元素，所以我们用一个临时栈t，将s1的出栈元素保存到临时栈t中，当s1的栈顶元素和s2的栈顶元素相同时退出while循环，此时我们在s1中找到了s2的栈顶元素，分别将s1和s2的栈顶元素移除，然后要做的是将临时栈t中的元素加回s1中，注意此时容易犯的一个错误是，没有同时更新s2，所以我们直接调用push()函数即可
 *
 * @author: wangrui
 * @date: 2021/3/23
 */
public class Ch716MaxStack {


  private Stack<Integer> s = new Stack<>();
  private Stack<Integer> maxStack = new Stack<>();


  Ch716MaxStack() {

  }

  /**
   * <p>在push()函数中，我们先来看s2，如果s2为空，或者s2的栈顶元素小于等于x，将x压入s2中。因为s2保存的是目前为止最大的数字，
   * <p>所以一旦新数字大于等于栈顶元素，说明遇到更大的数字了，压入栈。然后将数组压入s1，s1保存所有的数字，所以都得压入栈。
   *
   * @param x
   */
  public void push(int x) {
    if (maxStack.isEmpty() || x >= maxStack.peek()) {
      maxStack.push(x);
    }
    s.push(x);
  }

  /**
   * 在top()函数中，直接返回s1的top()函数即可。
   *
   * @return
   */
  public int top() {
    return s.peek();
  }

  /**
   * <p>在pop()函数中，当s2的栈顶元素和s1的栈顶元素相同时，我们要移除s2的栈顶元素，因为一个数字不在s1中了，
   * <p>就不能在s2中。然后取出s1的栈顶元素，并移除s1，返回即可。
   *
   * @return
   */
  public int pop() {
    if (!maxStack.isEmpty() && s.peek() == maxStack.peek()) {
      maxStack.pop();
    }
    int t = s.pop();
    return t;
  }

  /**
   * 在peekMax()函数中，直接返回s2的top()函数即可。
   *
   * @return
   */
  public int peekMax() {
    return maxStack.peek();
  }

  /**
   * <p>在popMax()函数中，先将s2的栈顶元素保存到一个变量mx中，然后我们要在s1中删除这个元素，由于栈无法直接定位元素，
   * <p>所以我们用一个临时栈t，将s1的出栈元素保存到临时栈t中，当s1的栈顶元素和s2的栈顶元素相同时退出while循环，此时我们在s1中找到了s2的栈顶元素，
   * <p>分别将s1和s2的栈顶元素移除，然后要做的是将临时栈t中的元素加回s1中，注意此时容易犯的一个错误是，没有同时更新s2，所以我们直接调用push()函数即可
   *
   * @return
   */
  public int popMax() {
    int mx = maxStack.peek();
    Stack<Integer> tmp = new Stack<>();
    while (s.peek() != mx) {
      tmp.push(s.pop());
    }
    s.pop();
    maxStack.pop();
    while (!tmp.isEmpty()) {
      push(tmp.pop());
    }
    return mx;
  }


  public static void main(String[] args) {
    Ch716MaxStack s = new Ch716MaxStack();
    s.push(5);
    s.push(1);
    s.push(5);
    System.out.println(s.top());//-> 5
    System.out.println(s.popMax());//-> 5
    System.out.println(s.top());//-> 1
    System.out.println(s.peekMax());// -> 5
    System.out.println(s.pop());//-> 1
    System.out.println(s.top());// -> 5
  }

}
