package org.company.meituan.all.week02.done;

import org.ListNode;

/**
 * <p>24. 两两交换链表中的节点
 * <p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p><p>
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p><p>
 * <p><p>
 * <p><p>
 * <p>示例 1：
 * <p><p>
 * <p><p>
 * <p>输入：head = [1,2,3,4]
 * <p>输出：[2,1,4,3]
 * <p>示例 2：
 * <p><p>
 * <p>输入：head = []
 * <p>输出：[]
 * <p>示例 3：
 * <p><p>
 * <p>输入：head = [1]
 * <p>输出：[1]
 * <p><p>
 * <p><p>
 * <p>提示：
 * <p><p>
 * <p>链表中节点的数目在范围 [0, 100] 内
 * <p>0 <= Node.val <= 100
 * <p><p>
 * <p><p>
 * <p>进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 * <p><p>
 * <p>通过次数258,977提交次数371,769
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:28 下午
 */
public class NCh066_24_swapNodesInPairs两两交换链表中的节点 {

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int val)
   * { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
   */
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode hair = new ListNode(-1, head);
    ListNode pre = hair;
    while (head != null) {
      ListNode tail = pre;
      for (int i = 0; i < 2; i++) {
        tail = tail.next;
        if (tail == null) {
          return hair.next;
        }
      }
      ListNode next = tail.next;
      ListNode[] reverseList = reverse(head, tail);
      head = reverseList[0];
      tail = reverseList[1];
      pre.next = head;
      tail.next = next;
      pre = tail;
      head = tail.next;
    }
    return hair.next;
  }

  private ListNode[] reverse(ListNode head, ListNode tail) {
    ListNode pre = tail.next;
    ListNode current = head;
    while (pre != tail) {
      ListNode next = current.next;
      current.next = pre;
      pre = current;
      current = next;
    }
    return new ListNode[]{tail, head};
  }

  /**
   * 递归
   *
   * @param head
   * @return
   */
  public ListNode swapPairs_1(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = head.next;
    head.next = swapPairs_1(newHead.next);
    newHead.next = head;
    return newHead;
  }

  /**
   * 遍历
   *
   * @param head
   * @return
   */
  public ListNode swapPairs_2(ListNode head) {
    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode temp = dummyHead;
    while (temp.next != null && temp.next.next != null) {
      ListNode node1 = temp.next;
      ListNode node2 = temp.next.next;
      temp.next = node2;
      node1.next = node2.next;
      node2.next = node1;
      temp = node1;
    }
    return dummyHead.next;
  }

}
