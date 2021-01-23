package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p></p>
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * <p>
 * 输出: 1->2->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/22
 */
public class Ch0203RemoveLinkedListElements {

  public ListNode removeElements(ListNode node, int val) {
    ListNode head = new ListNode(-1);
    head.next = node;

    ListNode prev = head, curr = node;
    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = curr.next;
    }
    return head.next;
  }
}
