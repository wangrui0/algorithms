package org.company.meituan;

import org.ListNode;

/**
 * <p>21. 合并两个有序链表
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：l1 = [1,2,4], l2 = [1,3,4]
 * <p>输出：[1,1,2,3,4,4]
 * <p>示例 2：
 *
 * <p>输入：l1 = [], l2 = []
 * <p>输出：[]
 * <p>示例 3：
 *
 * <p>输入：l1 = [], l2 = [0]
 * <p>输出：[0]
 *
 *
 * <p>提示：
 *
 * <p>两个链表的节点数目范围是 [0, 50]
 * <p>-100 <= Node.val <= 100
 * <p>l1 和 l2 均按 非递减顺序 排列
 * <p>通过次数556,664提交次数844,299
 * <p>|21. 合并两个有序链表|1|https://leetcode-cn.com/problems/merge-two-sorted-lists|
 * <p>@author: wangrui
 * <p>@date: 2021/5/6
 */
public class Ch006MergeTwoSortedLists合并两个有序链表 {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l14 = new ListNode(4);
    l1.next = l12;
    l12.next = l14;

    ListNode l2 = new ListNode(1);
    ListNode l23 = new ListNode(3);
    ListNode l24 = new ListNode(4);
    l2.next = l23;
    l23.next = l24;

    ListNode listNode = mergeTwoLists(l1, l2);
    System.out.println(listNode);

  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode headPre = head;
    while (l1 != null || l2 != null) {
      if (l1 != null && l2 != null && l1.val >= l2.val) {
        head.next = l2;
        l2 = l2.next;
      } else if (l1 != null && l2 != null && l1.val < l2.val) {
        head.next = l1;
        l1 = l1.next;
      } else if (l1 == null) {
        head.next = l2;
        l2 = l2.next;
      } else {
        head.next = l1;
        l1 = l1.next;
      }
      head = head.next;
    }
    return headPre.next;
  }

  public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    } else if (l2 == null) {
      return l1;
    } else if (l1.val < l2.val) {
      l1.next = mergeTwoLists_2(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists_2(l1, l2.next);
      return l2;
    }

  }

  public ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {
    ListNode prehead = new ListNode(-1);

    ListNode prev = prehead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
    prev.next = l1 == null ? l2 : l1;

    return prehead.next;
  }

}
