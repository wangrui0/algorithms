package org.leetcode.easy;

import org.leetcode.ListNode;

/**
 * <p> 反转一个单链表。
 *
 * <p> 示例:
 *
 * <p> 输入: 1->2->3->4->5->NULL
 * <p> 输出: 5->4->3->2->1->NULL
 *
 * <p> 进阶:
 * <p> 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/22
 */
public class Ch0206ReverseLinkedList {

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
   *
   * <p>     空间复杂度：O(1)。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
   *
   * <p>     空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param head
   * @return
   */
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

}
