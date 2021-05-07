package org.company.meituan.Collect;

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
 * <p>通过次数536,245
 * <p>提交次数748,728
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reverse-linked-list/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch002_206ReverseLinkedList翻转链表 {

  public static void main(String[] args) {
    ListNode listNode1 = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    listNode1.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    System.out.println(reverseList(listNode1));

  }

  public static ListNode reverseList(ListNode head) {
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

  /**
   * <p>方法二：递归
   *
   * <p>递归版本稍微复杂一些，其关键在于反向工作。假设链表的其余部分已经被反转，现在应该如何反转它前面的部分？
   *
   * <p>假设链表为：
   *
   * <p> n1→…→nk−1→nk→nk+1→…→nm→∅
   *
   * <p> 若从节点 nk+1 到 nm​ 已经被反转，而我们正处于 nk​。
   *
   * <p> n1→…→nk−1→nk→nk+1←…←nm
   *
   * <p>我们希望 nk+1​ 的下一个节点指向 nk​。
   *
   * <p>所以，nk.next.next=nk​。
   *
   * <p> 需要注意的是 n1 的下一个节点必须指向 ∅。如果忽略了这一点，链表中可能会产生环。
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
   *
   * <p>  空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
   *
   * @param head
   * @return
   */
  public ListNode reverseList_2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList_2(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
