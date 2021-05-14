package org.company.meituan.all.week01.done;

import java.util.HashSet;
import java.util.Set;
import org.ListNode;

/**
 * <p>160. 相交链表
 *
 * <p>编写一个程序，找到两个单链表相交的起始节点。
 *
 * <p>如下面的两个链表：
 *
 * <p>在节点 c1 开始相交。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * <p>输出：Reference of the node with value = 8
 * <p>输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B
 * 中，相交节点前有 3 个节点。
 *
 *
 *
 * <p>示例 2：
 *
 * <p>输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * <p>输出：Reference of the node with value = 2
 * <p>输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1
 * 个节点。
 *
 *
 *
 * <p>示例 3：
 *
 * <p>输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * <p>输出：null
 * <p>输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * <p>解释：这两个链表不相交，因此返回 null。
 *
 *
 *
 * <p>注意：
 *
 * <p>    如果两个链表没有交点，返回 null.
 * <p>    在返回结果后，两个链表仍须保持原有的结构。
 * <p>    可假定整个链表结构中没有循环。
 * <p>    程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * <p>通过次数233,987
 * <p>提交次数399,290
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh027_160IntersectionOfTwoLinkedLists相交链表 {

  /*
   *方法一: 暴力法
   * 对链表A中的每一个结点 ai​，遍历整个链表 B 并检查链表 B 中是否存在结点和 ai​ 相同。
   * 代码省略。
   * 复杂度分析
   *时间复杂度 : O(mn)。
   *空间复杂度 : O(1)。
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    return null;
  }

  /**
   * <p>方法二: 哈希表法
   * <p>复杂度分析
   *
   * <p>  时间复杂度 : O(m+n)。
   * <p>  空间复杂度 : O(m) 或 O(n)。
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
    Set<ListNode> hashSet = new HashSet<>();

    ListNode curNode = headA;
    while (curNode != null) {
      hashSet.add(curNode);
      curNode = curNode.next;
    }

    curNode = headB;
    while (curNode != null) {
      if (hashSet.contains(curNode)) {
        return curNode;
      }
      curNode = curNode.next;
    }
    return null;
  }

  /**
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
    // 特判
    if (headA == null || headB == null) {
      return null;
    }

    ListNode head1 = headA;
    ListNode head2 = headB;

    while (head1 != head2) {
      if (head1 != null) {
        head1 = head1.next;
      } else {
        head1 = headB;
      }
      if (head2 != null) {
        head2 = head2.next;
      } else {
        head2 = headA;
      }
    }
    return head1;
  }
}
