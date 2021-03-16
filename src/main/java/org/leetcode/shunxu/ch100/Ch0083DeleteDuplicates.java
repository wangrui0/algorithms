package org.leetcode.shunxu.ch100;

import java.util.HashSet;
import org.ListNode;

/**
 * <p>
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * <p>
 * 输出: 1->2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * <p>
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/12
 */
public class Ch0083DeleteDuplicates {

  public static void main(String[] args) {
    ListNode listNode = new ListNode(1);
    ListNode listNode2 = new ListNode(1);
    ListNode listNode3 = new ListNode(2);
    listNode.next = listNode2;
    listNode2.next = listNode3;
    deleteDuplicates2(listNode);
  }

  public static ListNode deleteDuplicates(ListNode head) {
    HashSet<Integer> set = new HashSet<>();
    ListNode current = head;
    ListNode pre = head;
    while (current != null) {
      if (!set.contains(current.val)) {
        current = current.next;
        set.add(current.val);
        continue;
      }
      pre.next = current.next;
      current = current.next;
    }
    return head;
  }

  public static ListNode deleteDuplicates2(ListNode head) {
    ListNode current = head;
    ListNode pre = null;
    while (current != null) {
      if (pre != null && pre.val == current.val) {
        pre.next = current.next;
        current=current.next;
        continue;
      }
      pre = current;
      current = current.next;
    }
    return head;
  }

  /**
   * <p>
   * 方法：直接法
   * <p>
   * 算法
   * <p>
   * 这是一个简单的问题，仅测试你操作列表的结点指针的能力。由于输入的列表已排序，因此我们可以通过将结点的值与它之后的结点进行比较来确定它是否为重复结点。如果它是重复的，我们更改当前结点的 next
   * <p>
   * 指针，以便它跳过下一个结点并直接指向下一个结点之后的结点。
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，因为列表中的每个结点都检查一次以确定它是否重复，所以总运行时间为 O(n)，其中 n 是列表中的结点数。
   * <p>
   * 空间复杂度：O(1)，没有使用额外的空间。
   * <p>
   *
   * @param head
   * @return
   */
  public static ListNode deleteDuplicates3(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
      if (current.next.val == current.val) {
        current.next = current.next.next;
      } else {
        current = current.next;
      }
    }
    return head;
  }


}
