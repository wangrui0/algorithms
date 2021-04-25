package org.leetcode.leet500.ch150;

import java.util.HashSet;
import java.util.Set;
import org.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * <p>
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1 输出：true 解释：链表中有一个环，其尾部连接到第二个节点。 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0 输出：true 解释：链表中有一个环，其尾部连接到第一个节点。 示例 3：
 * <p>
 * 输入：head = [1], pos = -1 输出：false 解释：链表中没有环。  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 104] -105 <= Node.val <= 105 pos 为 -1 或者链表中的一个 有效索引 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/10
 */
public class Ch0141LinkedListCycle {

  /**
   * hash 表
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    Set<ListNode> set = new HashSet<>();
    set.add(head);
    ListNode node = head;
    while (node != null) {
      node = node.next;
      if (set.contains(node)) {
        return true;
      }
      set.add(node);
    }
    return false;
  }

  /**
   * 官方 O(N) O(N)
   *
   * @param head
   * @return
   */
  public boolean hasCycle2(ListNode head) {
    Set<ListNode> seen = new HashSet<ListNode>();
    while (head != null) {
      if (!seen.add(head)) {
        return true;
      }
      head = head.next;
    }
    return false;
  }

  /**
   * @param head
   * @return
   */
  public boolean hasCycle3(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

  public boolean hasCycle4(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while (slow != fast) {
      if (fast == null || fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }

}
