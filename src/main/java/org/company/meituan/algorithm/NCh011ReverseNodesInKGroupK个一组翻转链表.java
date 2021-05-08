package org.company.meituan.algorithm;

import org.ListNode;

/**
 * <p>25. K 个一组翻转链表
 *
 * <p>给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * <p>k 是一个正整数，它的值小于或等于链表的长度。
 *
 * <p>如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * <p>进阶：
 *
 * <p>    你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * <p>    你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,4,5], k = 2
 * <p>输出：[2,1,4,3,5]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2,3,4,5], k = 3
 * <p>输出：[3,2,1,4,5]
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1,2,3,4,5], k = 1
 * <p>输出：[1,2,3,4,5]
 *
 * <p>示例 4：
 *
 * <p>输入：head = [1], k = 1
 * <p>输出：[1]
 *
 * <p>提示：
 *
 * <p>    列表中节点的数量在范围 sz 内
 * <p>    1 <= sz <= 5000
 * <p>    0 <= Node.val <= 1000
 * <p>    1 <= k <= sz
 *
 * <p>通过次数170,137
 * <p>提交次数262,568
 * <p>请问您在哪类招聘中遇到此题？
 * <p>|25. K 个一组翻转链表|1|https://leetcode-cn.com/problems/reverse-nodes-in-k-group|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class NCh011ReverseNodesInKGroupK个一组翻转链表 {

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
    System.out.println(reverseKGroup(l1, 2));
  }

  public static ListNode reverseKGroup_self(ListNode head, int k) {
    ListNode pre = new ListNode(-1);
    ListNode preHead = pre;
    //存储要转移的节点
    ListNode tempHead = new ListNode(-1);
    ListNode end = null;

    int i = 0;
    while (head != null || i == k) {
      if (i < k) {
        if (i == 0) {
          end = head;
        }
        ListNode temp = tempHead.next;

        tempHead.next = head;
        head = head.next;
        tempHead.next.next = temp;
        i++;
      } else {
        pre.next = tempHead.next;
        pre = end;
        i = 0;
        tempHead = new ListNode(-1);
      }

    }
    if (i != 0) {
      tempHead = tempHead.next;
      while (tempHead != null) {
        ListNode temp = pre.next;
        pre.next = tempHead;
        tempHead = tempHead.next;
        pre.next.next = temp;
      }
    }
    return preHead.next;
  }

  /**
   * <p>   复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 为链表的长度。head 指针会在 (⌊ n/k​⌋) 个节点上停留，每次停留需要进行一次 O(k) 的翻转操作。
   *
   * <p>    空间复杂度：O(1)，我们只需要建立常数个变量。
   *
   * @param head
   * @param k
   * @return
   */
  public static ListNode reverseKGroup(ListNode head, int k) {
    //我们新建一个节点，把它接到链表的头部，让它作为 pre 的初始值，这样 head 前面就有了一个节点，我们就可以避开链表头部的边界条件。
    // 这么做还有一个好处，下面我们会看到。（头节点的前面是头发）
    ListNode hair = new ListNode(0);
    hair.next = head;
    ListNode pre = hair;
    //head 是要遍历到的节点
    while (head != null) {
      ListNode tail = pre;
      // 查看剩余部分长度是否大于等于 k
      for (int i = 0; i < k; ++i) {
        tail = tail.next;
        if (tail == null) {
          return hair.next;
        }
      }
      //第k+1 个节点
      ListNode next = tail.next;

      ListNode[] reverse = myReverse(head, tail);
      head = reverse[0];
      tail = reverse[1];

      pre.next = head;
      tail.next = next;
      //pre 当前摇遍历到的节点的前一个节点
      pre = tail;
      //head 是当前要遍历到的节点
      head = tail.next;
    }

    return hair.next;
  }

  /**
   * <p>假设链表为 1→2→  3→4->   5->∅，我们想要把它改成 1→2→  4→3->   5->∅。
   * <-1<-2<-3
   *
   * <p>在遍历链表时，将当前节点的 next 指针改为指向前一个节点。由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
   * <p>在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
   *
   * @param head
   * @return
   */
  public static ListNode[] myReverse(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode p = head;
    while (prev != tail) {
      ListNode next = p.next;
      p.next = prev;
      prev = p;
      p = next;
    }
    return new ListNode[]{tail, head};
  }


}
