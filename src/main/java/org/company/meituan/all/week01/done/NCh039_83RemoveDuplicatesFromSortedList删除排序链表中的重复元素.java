package org.company.meituan.all.week01.done;

import org.ListNode;

/**
 * <p>83. 删除排序链表中的重复元素
 *
 * <p>存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * <p>返回同样按升序排列的结果链表。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,1,2]
 * <p>输出：[1,2]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,1,2,3,3]
 * <p>输出：[1,2,3]
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点数目在范围 [0, 300] 内
 * <p>    -100 <= Node.val <= 100
 * <p>    题目数据保证链表已经按升序排列
 *
 * <p>通过次数253,940
 * <p>提交次数472,934
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh039_83RemoveDuplicatesFromSortedList删除排序链表中的重复元素 {

  public static ListNode deleteDuplicates_self(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummyNode = new ListNode(-1);
    dummyNode.next = head;
    ListNode currentHeadNode = head.next;
    ListNode currentDummyNode = dummyNode.next;
    while (currentHeadNode != null) {
      if (currentHeadNode.val != currentDummyNode.val) {
        currentDummyNode.next = currentHeadNode;
        currentDummyNode = currentDummyNode.next;
      }
      currentHeadNode = currentHeadNode.next;
    }
    currentDummyNode.next = null;
    return dummyNode.next;
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
  public ListNode deleteDuplicates(ListNode head) {
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
