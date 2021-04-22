package org.leetcode.shunxu.leet1500.ch1500;

import org.ListNode;

/**
 * <p>LeetCode 1474. 删除链表 M 个节点之后的 N 个节点
 * <p>2020-07-13阅读 1280
 * <p>1. 题目
 * <p>给定链表 head 和两个整数 m 和 n. 遍历该链表并按照如下方式删除节点:
 *
 * <p>开始时以头节点作为当前节点.
 * <p> 保留以当前节点开始的前 m 个节点.
 * <p> 删除接下来的 n 个节点.
 * <p> 重复步骤 2 和 3, 直到到达链表结尾.
 * <p> 在删除了指定结点之后, 返回修改过后的链表的头节点.
 *
 * <p>进阶问题: 你能通过就地修改链表的方式解决这个问题吗?
 *
 * <p>示例 1:
 *
 *
 *
 * <p>输入: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
 * <p>输出: [1,2,6,7,11,12]
 * <p>解析: 保留前(m = 2)个结点,  也就是以黑色节点表示的从链表头结点开始的结点(1 ->2).
 * <p>删除接下来的(n = 3)个结点(3 -> 4 -> 5), 在图中以红色结点表示.
 * <p>继续相同的操作, 直到链表的末尾.
 * <p>返回删除结点之后的链表的头结点.
 * <p>示例 2:
 *
 *
 *
 * <p>输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
 * <p>输出: [1,5,9]
 * <p>解析: 返回删除结点之后的链表的头结点.
 *
 * <p>示例 3:
 * <p>输入: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
 * <p>输出: [1,2,3,5,6,7,9,10,11]
 *
 * <p>示例 4:
 * <p>输入: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
 * <p>输出: [9,7,8]
 *
 * <p>提示:
 * <p> 1 <= 链表结点数 <= 10^4.
 * <p>[1 <= 链表的每一个结点值 <=10^6].
 * <p>1 <= m,n <= 1000
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1474DeleteNNodesAfterMNodesOfALinkedList {

  public static void main(String[] args) {

    ListNode head = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);
    ListNode listNode4 = new ListNode(4);
    ListNode listNode5 = new ListNode(5);
    ListNode listNode6 = new ListNode(6);
    ListNode listNode7 = new ListNode(7);
    ListNode listNode8 = new ListNode(8);
    ListNode listNode9 = new ListNode(9);
    ListNode listNode10 = new ListNode(10);
    ListNode listNode11 = new ListNode(11);
    head.next = listNode2;
    listNode2.next = listNode3;
    listNode3.next = listNode4;
    listNode4.next = listNode5;
    listNode5.next = listNode6;
    listNode6.next = listNode7;
    listNode7.next = listNode8;
    listNode8.next = listNode9;
    listNode9.next = listNode10;
    listNode10.next = listNode11;
    System.out.println(deleteNodes(head, 3, 1));
  }

  public static ListNode deleteNodes(ListNode head, int m, int n) {
    ListNode temp = head;
    int mCount = 0;
    int nCount = 0;

    while (temp != null) {
      while (mCount < m - 1 && temp != null) {
        temp = temp.next;
        mCount++;
      }
      ListNode pre = temp;
      while (pre != null && nCount <= n) {
        pre = pre.next;
        nCount++;
      }
      temp.next = pre;
      temp = pre;
      mCount = 0;
      nCount = 0;
    }
    return head;
  }

  public ListNode deleteNodes_2(ListNode head, int m, int n) {
    ListNode pointer = new ListNode(0);
    pointer.next = head;
    while (pointer != null) {
      pointer = getPost(pointer, m);
      if (pointer == null) {
        break;
      }
      ListNode postNode = getPost(pointer, n + 1);
      pointer.next = postNode;
    }
    return head;
  }

  private ListNode getPost(ListNode node, int count) {
    for (int i = 0; i < count && node != null; i++) {
      node = node.next;
    }
    return node;
  }
}

