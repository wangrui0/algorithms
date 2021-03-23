package org.leetcode.shunxu.ch900;

import org.ListNode;

/**
 * <p>876. 链表的中间结点
 *
 * <p>给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * <p>如果有两个中间结点，则返回第二个中间结点。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,2,3,4,5]
 * <p>输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * <p>返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * <p>注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * <p>ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 *
 * <p>示例 2：
 *
 * <p>输入：[1,2,3,4,5,6]
 * <p>输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * <p>由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定链表的结点数介于 1 和 100 之间。
 * <p> https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * <p>通过次数97,766
 * <p>提交次数139,785
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch876MiddleOfTheLinkedList {

  /**
   * 快慢指针
   *
   * @param head
   * @return
   */
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是给定链表中的结点数目。
   *
   * <p>  空间复杂度：O(N)，即数组 A 用去的空间。
   *
   * @param head
   * @return
   */
  public ListNode middleNode1(ListNode head) {
    ListNode[] A = new ListNode[100];
    int t = 0;
    while (head != null) {
      A[t++] = head;
      head = head.next;
    }
    return A[t / 2];
  }


  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)，其中 N 是给定链表的结点数目。
   * <p>
   * 空间复杂度：O(1)，只需要常数空间存放变量和指针。
   * <p>
   *
   * @param head
   * @return
   */
  public ListNode middleNode2(ListNode head) {
    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      ++n;
      cur = cur.next;
    }
    int k = 0;
    cur = head;
    while (k < n / 2) {
      ++k;
      cur = cur.next;
    }
    return cur;
  }


  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)，其中 N 是给定链表的结点数目。
   * <p>
   * 空间复杂度：O(1)，只需要常数空间存放 slow 和 fast 两个指针。
   * <p>
   *
   * @param head
   * @return
   */
  public ListNode middleNode3(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
