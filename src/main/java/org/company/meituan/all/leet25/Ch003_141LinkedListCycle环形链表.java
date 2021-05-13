package org.company.meituan.all.leet25;

import java.util.HashSet;
import java.util.Set;
import org.ListNode;

/**
 * <p>141. 环形链表
 *
 * <p>给定一个链表，判断链表中是否有环。
 *
 * <p>如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * <p>如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 *
 *
 * <p>进阶：
 *
 * <p>你能用 O(1)（即，常量）内存解决此问题吗？
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：head = [3,2,0,-4], pos = 1
 * <p>输出：true
 * <p>解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2], pos = 0
 * <p>输出：true
 * <p>解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1], pos = -1
 * <p>输出：false
 * <p>解释：链表中没有环。
 *
 *
 *
 * <p>提示：
 *
 * <p>    链表中节点的数目范围是 [0, 104]
 * <p>    -105 <= Node.val <= 105
 * <p>    pos 为 -1 或者链表中的一个 有效索引 。
 *
 * <p>通过次数405,454
 * <p>提交次数795,701
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/linked-list-cycle/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch003_141LinkedListCycle环形链表 {

  public boolean hasCycle_self(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }

    ListNode slow = head;
    ListNode fast = head.next.next;
    while (fast != null && fast.next != null && slow != null) {
      if (fast == slow) {
        return true;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  /**
   * 方法一：哈希表
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)O(N)O(N)，其中 NNN 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
   *
   * <p>   空间复杂度：O(N)O(N)O(N)，其中 NNN 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次
   *
   * @param head
   * @return
   */
  public boolean hasCycle(ListNode head) {
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
   * <p> 方法二：快慢指针
   * 1->2->3->->4
   * <p>   时间复杂度：O(N)
   * <p>  空间复杂度：O(1)
   *
   * @param head
   * @return
   */
  public boolean hasCycle_2(ListNode head) {
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


  public static boolean detectCycle_3(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head, fast = head;
    boolean flag = true;
    while (slow != fast || flag) {
      flag = false;
      if (slow == null || fast==null||fast.next == null) {
        return false;
      }
      slow = slow.next;
      fast = fast.next.next;
    }
    return true;
  }


}
