package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.List;
import org.ListNode;

/**
 * <p>143. 重排链表
 *
 * <p>给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * <p>将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * <p>示例 1:
 *
 * <p>给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * <p>示例 2:
 *
 * <p>给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * <p>通过次数94,863
 * <p>提交次数157,125
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/reorder-list/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh038_143_ReorderList重排链表 {

  /**
   * <p>方法一：线性表
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)，其中 N 是链表中的节点数。
   *
   * <p> 空间复杂度：O(N)，其中 N 是链表中的节点数。主要为线性表的开销。
   *
   * @param head
   */
  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    List<ListNode> list = new ArrayList<ListNode>();
    ListNode node = head;
    while (node != null) {
      list.add(node);
      node = node.next;
    }
    int i = 0, j = list.size() - 1;
    while (i < j) {
      list.get(i).next = list.get(j);
      i++;
      if (i == j) {
        break;
      }
      list.get(j).next = list.get(i);
      j--;
    }
    list.get(i).next = null;
  }

  /**
   * <p>方法二：寻找链表中点 + 链表逆序 + 合并链表
   * <p>时间复杂度：O(N)，其中 N 是链表中的节点数。
   * <p> 空间复杂度：O(1)
   *
   * @param head
   */
  public void reorderList_2(ListNode head) {
    if (head == null) {
      return;
    }
    //寻找链表的中间节点
    ListNode mid = middleNode(head);
    ListNode l1 = head;
    ListNode l2 = mid.next;
    //将两个链表断开
    mid.next = null;
    //链表逆序
    l2 = reverseList(l2);
    //合并链表
    mergeList(l1, l2);
  }

  /**
   * 快慢指针方法寻找链表的中点
   *
   * @param head
   * @return
   */
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  /**
   * 翻转链表
   *
   * @param head
   * @return
   */
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

  /**
   * <p>合并链表
   * <p>1->3->5
   * <p>2->4->6
   *
   * @param l1
   * @param l2
   */
  public void mergeList(ListNode l1, ListNode l2) {
    ListNode l1_tmp;
    ListNode l2_tmp;
    while (l1 != null && l2 != null) {
      l1_tmp = l1.next;
      l2_tmp = l2.next;

      l1.next = l2;
      l1 = l1_tmp;

      l2.next = l1;
      l2 = l2_tmp;
    }
  }


}
