package org.leetcode.leet1500.ch1300;

import org.ListNode;

/**
 * <p>1290. 二进制链表转整数
 *
 * <p>给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 *
 * <p>请你返回该链表所表示数字的 十进制值 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,0,1]
 * <p>输出：5
 * <p>解释：二进制数 (101) 转化为十进制数 (5)
 *
 * <p>示例 2：
 *
 * <p>输入：head = [0]
 * <p>输出：0
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1]
 * <p>输出：1
 *
 * <p>示例 4：
 *
 * <p>输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * <p>输出：18880
 *
 * <p>示例 5：
 *
 * <p>输入：head = [0,0]
 * <p>输出：0
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表不为空。
 * <p>    链表的结点总数不超过 30。
 * <p>    每个结点的值不是 0 就是 1。
 *
 * <p>通过次数45,659
 * <p>提交次数56,396
 * <p>https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * <p>@author: wangrui
 * <p>@date: 2021/4/12
 */
public class Ch1290ConvertBinaryNumberInALinkedListToInteger {

  /**
   * 很简单啊
   *
   * @param head
   * @return
   */
  public int getDecimalValue(ListNode head) {
    ListNode node = head;
    int num = 0;
    while (node != null) {
      num = num * 2 + node.val;
      node = node.next;
    }
    return num;
  }
}
