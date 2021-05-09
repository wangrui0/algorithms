package org.company.meituan.Collect;

import java.util.HashMap;
import java.util.Map;
import org.ListNode;

/**
 * <p>剑指 Offer 22. 链表中倒数第k个节点
 *
 * <p>输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * <p>例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *
 *
 * <p>示例：
 *
 * <p>给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * <p>返回链表 4->5.
 *
 * <p>通过次数166,633
 * <p>提交次数212,010
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch016_offer_22LianBiaoZhongDaoShuDiKgeJieDianLcof剑指Offer22链表中倒数第k个节点 {

  public static ListNode getKthFromEnd_self(ListNode head, int k) {
    Map<Integer, ListNode> map = new HashMap<>();
    int index = 1;
    ListNode currentNode = head;
    while (currentNode != null) {
      map.put(index++, currentNode);
      currentNode = currentNode.next;
    }
    return map.size() < k ? null : map.get(map.size() - k + 1);
  }

  /**
   * <p>算法流程：
   *
   * <p>初始化： 前指针 former 、后指针 latter ，双指针都指向头节点 head​ 。
   * <p>构建双指针距离： 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
   * <p> 双指针共同移动： 循环中，双指针 former 和 latter 每轮都向前走一步，直至 former 走过链表 尾节点 时跳出（跳出后， latter 与尾节点距离为 k−1，即 latter 指向倒数第
   * kkk 个节点）。
   * <p> 返回值： 返回 latter 即可。
   *
   * @param head
   * @param k
   * @return
   */
  public ListNode getKthFromEnd(ListNode head, int k) {
    ListNode former = head, latter = head;
    for (int i = 0; i < k; i++) {
      former = former.next;
    }
    while (former != null) {
      former = former.next;
      latter = latter.next;
    }
    return latter;
  }

  public static ListNode getKthFromEnd_1(ListNode head, int k) {
    ListNode fast = head;
    for (int i = 1; i <= k; i++) {
      fast = fast.next;
    }
    ListNode slow = head;
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }


  public ListNode getKthFromEnd_2(ListNode head, int k) {
    ListNode slow = head, fast = head;
    int t = 0;
    while (fast != null) {
      if (t >= k) {
        slow = slow.next;
      }
      fast = fast.next;
      t++;
    }
    return slow;
  }


}
