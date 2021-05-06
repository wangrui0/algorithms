package org.company.meituan.algorithm;

import org.ListNode;

/**
 * <p>206. 反转链表
 * <p>给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,4,5]
 * <p>输出：[5,4,3,2,1]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2]
 * <p>输出：[2,1]
 *
 * <p>示例 3：
 *
 * <p>输入：head = []
 * <p>输出：[]
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点的数目范围是 [0, 5000]
 * <p>    -5000 <= Node.val <= 5000
 *
 *
 *
 * <p>进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>通过次数535,492
 * <p>提交次数747,751
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch024ReverseLinkedList反转链表 {

  /**
   * <p>方法一：迭代
   *
   * <p>假设链表为 1→2→3→∅，我们想要把它改成 ∅←1←2←3。
   * <-1<-2<-3
   *
   * <p>在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(3);
    ListNode l14 = new ListNode(4);
    ListNode l15 = new ListNode(5);
    l1.next = l12;
    l12.next = l13;
    l13.next = l14;
    l14.next = l15;
    System.out.println(reverseList2(l1));
  }


  public static ListNode reverseList2(ListNode head) {
    ListNode pre = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }


}
