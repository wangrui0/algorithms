package org.company.meituan.all.week02.done;

import java.util.ArrayList;
import java.util.List;
import org.ListNode;

/**
 * <p>234. 回文链表
 * <p>请判断一个链表是否为回文链表。
 *
 * <p>示例 1:
 *
 * <p>输入: 1->2
 * <p>输出: false
 * <p>示例 2:
 *
 * <p>输入: 1->2->2->1
 * <p>输出: true
 * <p>进阶：
 * <p>你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * <p>通过次数246,392提交次数517,067
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/palindrome-linked-list/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 7:08 下午
 */
public class NCh078_234_palindromeLinkedList回文链表 {

  /**
   * <p>方法一：将值复制到数组中后用双指针法
   *
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n)
   * <p>  空间复杂度：O(n)
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

  /**
   * 方法二：递归
   * <p>  时间复杂度：O(n)
   * <p>  空间复杂度：O(n)
   *
   * @param head
   * @return
   */
  public boolean isPalindrome_2(ListNode head) {
    frontPointer = head;
    return recursivelyCheck(head);
  }

  /**
   * 方法三：快慢指针
   * <p>  时间复杂度：O(n)
   * <p>  空间复杂度：O(1)
   *
   * @param head
   * @return
   */
  public boolean isPalindrome_3(ListNode head) {
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
