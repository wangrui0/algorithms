package org.company.meituan.all.leet25;

import org.ListNode;

/**
 * <p>21. 合并两个有序链表
 *
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：l1 = [1,2,4], l2 = [1,3,4]
 * <p>输出：[1,1,2,3,4,4]
 *
 * <p>示例 2：
 *
 * <p>输入：l1 = [], l2 = []
 * <p>输出：[]
 *
 * <p>示例 3：
 *
 * <p>输入：l1 = [], l2 = [0]
 * <p>输出：[0]
 *
 *
 *
 * <p>提示：
 *
 * <p>    两个链表的节点数目范围是 [0, 50]
 * <p>    -100 <= Node.val <= 100
 * <p>    l1 和 l2 均按 非递减顺序 排列
 * <p>https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>通过次数557,813
 * <p>提交次数845,889
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch008_21MergeTwoSortedLists合并两个有序链表 {

  public ListNode mergeTwoLists_self(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode curr = head;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    if (l1 != null) {
      curr.next = l1;
      return head.next;
    }
    if (l2 != null) {
      curr.next = l2;
      return head.next;
    }
    return head.next;
  }

  /**
   * <p>  复杂度分析
   *
   * <p>   时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， 因此 while
   * 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
   *
   * <p>   空间复杂度：O(1)。我们只需要常数的空间存放若干变量。
   *
   * @param l1
   * @param l2
   * @return
   */
  public ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
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

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList
   * 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
   *
   * <p>  空间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用
   * n+m次，因此空间复杂度为 O(n+m)。
   *
   * @param l1
   * @param l2
   * @return
   */
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


}
