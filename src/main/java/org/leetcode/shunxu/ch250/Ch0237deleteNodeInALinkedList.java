package org.leetcode.shunxu.ch250;

import org.leetcode.ListNode;

/**
 * <p> 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
 *
 *
 *
 * <p> 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 *
 * <p> 4->5->1->9
 *
 * <p> 示例 1：
 *
 * <p> 输入：head = [4,5,1,9], node = 5
 * <p> 输出：[4,1,9]
 * <p> 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * <p> 示例 2：
 *
 * <p> 输入：head = [4,5,1,9], node = 1
 * <p> 输出：[4,5,9]
 * <p> 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 *
 * <p> 提示：
 *
 * <p>     链表至少包含两个节点。
 * <p>     链表中所有节点的值都是唯一的。
 * <p>     给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * <p>     不要从你的函数中返回任何结果。
 *
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/27
 */
public class Ch0237deleteNodeInALinkedList {

  /**
   * 4->5->1->9
   *
   * @param node
   */
  public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }

}
