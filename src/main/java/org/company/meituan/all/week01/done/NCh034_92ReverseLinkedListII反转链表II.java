package org.company.meituan.all.week01.done;

import org.ListNode;

/**
 * <p>92. 反转链表 II
 * <p>给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,4,5], left = 2, right = 4
 * <p>输出：[1,4,3,2,5]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [5], left = 1, right = 1
 * <p>输出：[5]
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点数目为 n
 * <p>    1 <= n <= 500
 * <p>    -500 <= Node.val <= 500
 * <p>    1 <= left <= right <= n
 *
 *
 *
 * <p>进阶： 你可以使用一趟扫描完成反转吗？
 * <p>通过次数161,989
 * <p>提交次数299,110
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh034_92ReverseLinkedListII反转链表II {


  public ListNode reverseBetween(ListNode head, int left, int right) {
    // 设置 dummyNode 是这一类问题的一般做法
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode pre = dummyNode;
    for (int i = 0; i < left - 1; i++) {
      pre = pre.next;
    }

    /**
     * curr：指向待反转区域的第一个节点 left；
     * next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化；
     * pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     */
    ListNode cur = pre.next;
    ListNode next;
    for (int i = 0; i < right - left; i++) {
      next = cur.next;
      cur.next = next.next;
      next.next = pre.next;
      pre.next = next;
    }
    return dummyNode.next;
  }
}
