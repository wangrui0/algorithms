package org.company.meituan.all.week01.done;

import org.ListNode;

/**
 * <p>82. 删除排序链表中的重复元素 II
 *
 * <p>存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * <p>返回同样按升序排列的结果链表。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,3,4,4,5]
 * <p>输出：[1,2,5]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,1,1,2,3]
 * <p>输出：[2,3]
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点数目在范围 [0, 300] 内
 * <p>    -100 <= Node.val <= 100
 * <p>    题目数据保证链表已经按升序排列
 *
 * <p>通过次数141,268
 * <p>提交次数270,038
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh048_82RemoveDuplicatesFromSortedListII删除排序链表中的重复元素II {

  //[1,2,3,3,4,4,5]
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(3);
    ListNode l14 = new ListNode(3);
    ListNode l15 = new ListNode(4);
    ListNode l16 = new ListNode(4);
    ListNode l17 = new ListNode(5);
    l1.next = l12;
    l12.next = l13;
    l13.next = l14;
    l14.next = l15;
    l15.next = l16;
    l16.next = l17;
    System.out.println(deleteDuplicates(l1));
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode dumpy = new ListNode(-1, head);
    ListNode current = dumpy;
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val) {
        int x = current.next.val;
        while (current.next != null && current.next.val == x) {
          current.next = current.next.next;
        }
      } else {
        current = current.next;
      }
    }
    return dumpy.next;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是链表的长度。
   *
   * <p>   空间复杂度：O(1)。
   *
   * @param head
   * @return
   */
  public ListNode deleteDuplicates_2(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode cur = head;
    while (cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }

    return head;
  }
}
