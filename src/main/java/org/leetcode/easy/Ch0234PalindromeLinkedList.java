package org.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import org.leetcode.ListNode;

/**
 * <p> 请判断一个链表是否为回文链表。
 *
 * <p> 示例 1:
 *
 * <p> 输入: 1->2
 * <p> 输出: false
 *
 * <p> 示例 2:
 *
 * <p> 输入: 1->2->2->1
 * <p> 输出: true
 *
 * <p> 进阶：
 * <p> 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0234PalindromeLinkedList {

  /**
   * <p> 时间复杂度：O(n)，其中 n 指的是链表的元素个数。
   * <p>第一步： 遍历链表并将值复制到数组中，O(n)。
   * <p>第二步：双指针判断是否为回文，执行了O(n/2) 次的判断，即 O(n)。
   * <p>总的时间复杂度：O(2n)=O(n)。
   *
   * <p>空间复杂度：O(n)，其中 n 指的是链表的元素个数，我们使用了一个数组列表存放链表的元素值。
   *
   * @param head
   * @return
   */
  public boolean isPalindrome(ListNode head) {
    List<Integer> vals = new ArrayList<Integer>();

    // 将链表的值复制到数组中
    ListNode currentNode = head;
    while (currentNode != null) {
      vals.add(currentNode.val);
      currentNode = currentNode.next;
    }

    // 使用双指针判断是否回文
    int front = 0;
    int back = vals.size() - 1;
    while (front < back) {
      if (!vals.get(front).equals(vals.get(back))) {
        return false;
      }
      front++;
      back--;
    }
    return true;
  }


  /**
   * 第二种：递归
   */
  private ListNode frontPointer;

  private boolean recursivelyCheck(ListNode currentNode) {
    if (currentNode != null) {
      if (!recursivelyCheck(currentNode.next)) {
        return false;
      }
      if (currentNode.val != frontPointer.val) {
        return false;
      }
      frontPointer = frontPointer.next;
    }
    return true;
  }

  public boolean isPalindrome2(ListNode head) {
    frontPointer = head;
    return recursivelyCheck(head);
  }

  /**
   * 第三种：快慢指针
   *
   * @param head
   * @return
   */
  public boolean isPalindrome3(ListNode head) {
    if (head == null) {
      return true;
    }

    // 找到前半部分链表的尾节点并反转后半部分链表
    ListNode firstHalfEnd = endOfFirstHalf(head);
    ListNode secondHalfStart = reverseList(firstHalfEnd.next);

    // 判断是否回文
    ListNode p1 = head;
    ListNode p2 = secondHalfStart;
    boolean result = true;
    while (result && p2 != null) {
      if (p1.val != p2.val) {
        result = false;
      }
      p1 = p1.next;
      p2 = p2.next;
    }

    // 还原链表并返回结果
    firstHalfEnd.next = reverseList(secondHalfStart);
    return result;
  }

  /**
   * <p> 翻转一个链表
   * <p> 4->3->2->1
   * <p> 4->5
   *
   * @param head
   * @return
   */
  private ListNode reverseList(ListNode head) {
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

  private ListNode endOfFirstHalf(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
