package org.company.meituan.all.week01.done;

import java.util.Deque;
import java.util.LinkedList;
import org.ListNode;

/**
 * <p>19. 删除链表的倒数第 N 个结点
 *
 * <p>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * <p>进阶：你能尝试使用一趟扫描实现吗？
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,4,5], n = 2
 * <p>输出：[1,2,3,5]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1], n = 1
 * <p>输出：[]
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1,2], n = 1
 * <p>输出：[1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中结点的数目为 sz
 * <p>    1 <= sz <= 30
 * <p>    0 <= Node.val <= 100
 * <p>    1 <= n <= sz
 *
 * <p>通过次数384,345
 * <p>提交次数920,284
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh033_19RemoveNthNodeFromEndOfList删除链表的倒数第N个结点 {

  /**
   * <p> 方法一：计算链表长度
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(L)，其中 L 是链表的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    int length = getLength(head);
    ListNode cur = dummy;
    for (int i = 1; i < length - n + 1; ++i) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    ListNode ans = dummy.next;
    return ans;
  }

  public int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      ++length;
      head = head.next;
    }
    return length;
  }

  /**
   * <p>  方法二：栈
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(L)，其中 L 是链表的长度。
   *
   * <p>   空间复杂度：O(L)，其中 L 是链表的长度。主要为栈的开销。
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd_2(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    Deque<ListNode> stack = new LinkedList<ListNode>();
    ListNode cur = dummy;
    while (cur != null) {
      stack.push(cur);
      cur = cur.next;
    }
    for (int i = 0; i < n; ++i) {
      stack.pop();
    }
    ListNode prev = stack.peek();
    prev.next = prev.next.next;
    ListNode ans = dummy.next;
    return ans;
  }

  /**
   * <p>方法三：双指针
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(L)，其中 L 是链表的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd_3(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    ListNode first = head;
    ListNode second = dummy;
    for (int i = 0; i < n; ++i) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    ListNode ans = dummy.next;
    return ans;
  }


}
