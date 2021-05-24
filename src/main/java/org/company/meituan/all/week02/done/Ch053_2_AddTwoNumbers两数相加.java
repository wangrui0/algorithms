package org.company.meituan.all.week02.done;

import org.ListNode;

/**
 * <p>2. 两数相加
 *
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：l1 = [2,4,3], l2 = [5,6,4]
 * <p>输出：[7,0,8]
 * <p>解释：342 + 465 = 807.
 *
 * <p>示例 2：
 *
 * <p>输入：l1 = [0], l2 = [0]
 * <p>输出：[0]
 *
 * <p>示例 3：
 *
 * <p>输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * <p>输出：[8,9,9,9,0,0,0,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    每个链表中的节点数在范围 [1, 100] 内
 * <p>    0 <= Node.val <= 9
 * <p>    题目数据保证列表表示的数字不含前导零
 *
 * <p>通过次数838,284
 * <p>提交次数2,087,317
 * <p>https://leetcode-cn.com/problems/add-two-numbers/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch053_2_AddTwoNumbers两数相加 {


  public ListNode addTwoNumbers_self(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(-1);
    ListNode current = head;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int a = 0;
      if (l1 != null) {
        a = l1.val;
        l1 = l1.next;
      }
      int b = 0;
      if (l2 != null) {
        b = l2.val;
        l2 = l2.next;
      }
      int sum = a + b + carry;
      carry = sum / 10;
      ListNode node = new ListNode(sum % 10);
      current.next = node;
      current = current.next;
    }
    return head.next;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(max(m,n))，其中 m 和 n 分别为两个链表的长度。我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
   *
   * <p>    空间复杂度：O(1)。注意返回值不计入空间复杂度。
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = null, tail = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int n1 = l1 != null ? l1.val : 0;
      int n2 = l2 != null ? l2.val : 0;
      int sum = n1 + n2 + carry;
      if (head == null) {
        head = tail = new ListNode(sum % 10);
      } else {
        tail.next = new ListNode(sum % 10);
        tail = tail.next;
      }
      carry = sum / 10;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry > 0) {
      tail.next = new ListNode(carry);
    }
    return head;
  }


}
