package org.company.meituan.Collect;

import java.util.HashSet;
import java.util.Set;
import org.ListNode;

/**
 * <p>142. 环形链表 II
 *
 * <p>给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * <p>为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * <p>说明：不允许修改给定的链表。
 *
 * <p>进阶：
 *
 * <p>    你是否可以使用 O(1) 空间解决此题？
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [3,2,0,-4], pos = 1
 * <p>输出：返回索引为 1 的链表节点
 * <p>解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2], pos = 0
 * <p>输出：返回索引为 0 的链表节点
 * <p>解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1], pos = -1
 * <p>输出：返回 null
 * <p>解释：链表中没有环。
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点的数目范围在范围 [0, 104] 内
 * <p>    -105 <= Node.val <= 105
 * <p>    pos 的值为 -1 或者链表中的一个有效索引
 *
 * <p>通过次数224,269
 * <p>提交次数410,740
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch017_142LinkedListCycleII环形链表II {

  /**
   * 方法一：哈希表
   *
   * @param head
   * @return
   */
  public ListNode detectCycle(ListNode head) {
    ListNode pos = head;
    Set<ListNode> visited = new HashSet<ListNode>();
    while (pos != null) {
      if (visited.contains(pos)) {
        return pos;
      } else {
        visited.add(pos);
      }
      pos = pos.next;
    }
    return null;
  }

  /**
   * 方法二：快慢指针
   *
   * @param head
   * @return
   */
  public ListNode detectCycle_2(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head, fast = head;
    while (fast != null) {
      slow = slow.next;
      if (fast.next != null) {
        fast = fast.next.next;
      } else {
        return null;
      }
      if (fast == slow) {
        ListNode ptr = head;
        while (ptr != slow) {
          ptr = ptr.next;
          slow = slow.next;
        }
        return ptr;
      }
    }
    return null;
  }


}


