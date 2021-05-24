package org.company.meituan.all.week01.done;

import java.util.List;
import org.ListNode;

/**
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 2 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 3 输出：[3,2,1,4,5]
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1,2,3,4,5], k = 1 输出：[1,2,3,4,5]
 * <p>
 * 示例 4：
 * <p>
 * 输入：head = [1], k = 1 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 列表中节点的数量在范围 sz 内 1 <= sz <= 5000 0 <= Node.val <= 1000 1 <= k <= sz
 * <p>
 * 通过次数171,644 提交次数264,754 请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author: wangrui
 * @date: 2021/5/10
 */
public class NCh040_25_ReverseNodesInKGroupK个一组翻转链表 {

  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode hair = new ListNode(0);
    hair.next = head;
    ListNode pre = hair;

    while (head != null) {
      ListNode tail = pre;
      // 查看剩余部分长度是否大于等于 k
      for (int i = 0; i < k; ++i) {
        tail = tail.next;
        if (tail == null) {
          return hair.next;
        }
      }
      ListNode nex = tail.next;
      //k 个节点,翻转k 个节点
      ListNode[] reverse = myReverse(head, tail);
      head = reverse[0];
      tail = reverse[1];
      // 把子链表重新接回原链表
      pre.next = head;
      tail.next = nex;
      pre = tail;
      head = tail.next;
    }

    return hair.next;
  }

  /**
   * <p> 翻转链表
   * <p>other1->2->3->4->5->other2
   * 头插法,顺序的遍历，将一个个节点插入头结点(顺序的，所有的箭头往前)
   * <p>other2<-2  3->4->5->
   * <p>other2<-2<-3   4->5->
   * <p>other2<-2-<3-<4   5->
   * <p>5->4->3->2
   *
   * @param head
   * @param tail
   * @return
   */
  public ListNode[] myReverse(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode p = head;
    while (prev != tail) {
      ListNode nex = p.next;
      p.next = prev;
      prev = p;
      p = nex;
    }
    return new ListNode[]{tail, head};
  }
}
