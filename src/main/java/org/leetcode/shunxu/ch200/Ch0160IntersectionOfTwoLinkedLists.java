package org.leetcode.shunxu.ch200;

import java.util.HashSet;
import java.util.Set;
import org.leetcode.ListNode;

/**
 * 相交链表
 *
 * @author: wangrui
 * @date: 2020/12/10
 */
public class Ch0160IntersectionOfTwoLinkedLists {

  /**
   * self
   *
   * @param headA
   * @param headB
   * @return
   */
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode currentA = headA;
    ListNode currentB = headB;
    Set<ListNode> setA = new HashSet<>();
    while (currentA != null) {
      setA.add(currentA);
      currentA = currentA.next;
    }
    while (currentB != null) {
      if (setA.contains(currentB)) {
        return currentB;
      }
      currentB = currentB.next;
    }
    return null;
  }
  /**
   * 方法一: 暴力法
   *<p> 对链表A中的每一个结点 a_i，遍历整个链表 B 并检查链表 B 中是否存在结点和 a_i相同。
   *<p>  复杂度分析
   *<p>  时间复杂度 : O(mn)。
   *<p>  空间复杂度 : O(1)。
   *<p> 作者：LeetCode
   *<p> 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
   *<p> 来源：力扣（LeetCode）
   *<p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */

  /**
   *<p> 方法二: 哈希表法
   *<p> 遍历链表 A 并将每个结点的地址/引用存储在哈希表中。然后检查链表 B 中的每一个结点 b_i是否在哈希表中。若在，则 b_i为相交结点。
   *<p> 复杂度分析
   *<p> 时间复杂度 : O(m+n)。
   *<p> 空间复杂度 : O(m) 或O(n)。
   *<p> 作者：LeetCode
   *<p> 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
   *<p> 来源：力扣（LeetCode）
   *<p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */

  /**
   * <p> 方法三：双指针法
   * <p> 创建两个指针 pA 和 pB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
   * <p> 当 pA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pB 到达链表的尾部时，将它重定位到链表 A 的头结点。
   * <p> 若在某一时刻 pA 和 pB 相遇，则 pA/pB 为相交结点。
   * <p> 想弄清楚为什么这样可行, 可以考虑以下两个链表: A={1,3,5,7,9,11} 和 B={2,4,9,11}，相交于结点 9。 由于 B.length (=4) < A.length (=6)，
   * <p>pB 比 pA 少经过 2 个结点，会先到达尾部。将 pB 重定向到 A 的头结点，pA 重定向到 B 的头结点后，
   * <p>pB 要比pA 多走 2 个结点。因此，它们会同时到达交点。
   * <p> 如果两个链表存在相交，它们末尾的结点必然相同。因此当 pA/pB 到达链表结尾时，记录下链表 A/B 对应的元素。若最后元素不相同，则两个链表不相交。
   *
   * <p> 作者：LeetCode
   * <p> 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/xiang-jiao-lian-biao-by-leetcode/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   */
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    /**
     * https://blog.csdn.net/ws948342046/article/details/87182365
     定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
     两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
     **/
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA, pB = headB;
    // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;

  }

  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    ListNode pA = headA;
    ListNode pB = headB;
    while (pA != pB) {
      pA = pA == null ? headB : pA.next;
      pB = pB == null ? headA : pB.next;
    }
    return pA;
  }
}
