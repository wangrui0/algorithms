package org.leetcode.shunxu.ch150;

import java.util.LinkedList;
import java.util.Queue;
import org.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * <p>     1
 * <p>    / \
 * <p>   2   2
 * <p>  / \ / \
 * <p> 3  4 4  3
 * <p> 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>     1
 * <p>    / \
 * <p>   2   2
 * <p>    \   \
 * <p>    3    3
 * <p> 进阶：
 * <p> 你可以运用递归和迭代两种方法解决这个问题吗？
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/12
 */
public class Ch0101IsSymmetric {

  public static void main(String[] args) {

  }

  /**
   * 方法一：递归
   * <p>
   * 思路和算法
   * <p>
   * 如果一个树的左子树与右子树镜像对称，那么这个树是对称的。
   * <p>
   * 因此，该问题可以转化为：两个树在什么情况下互为镜像？
   * <p>
   * 如果同时满足下面的条件，两个树互为镜像：
   * <p>
   * 它们的两个根结点具有相同的值
   * <p>
   * 每个树的右子树都与另一个树的左子树镜像对称
   * <p>
   * 我们可以实现这样一个递归函数，通过「同步移动」两个指针的方法来遍历这棵树，p 指针和 q 指针一开始都指向这棵树的根，随后 p 右移时，q 左移，p 左移时，q 右移。
   * <p>
   * 每次检查当前 p 和 q节点的值是否相等，如果相等再判断左右子树是否对称。
   * <p>
   * =======================================================================================================================================================================
   * <p>
   * 复杂度分析
   * <p>
   * 假设树上一共 n 个节点。
   * <p>
   * 时间复杂度：这里遍历了这棵树，渐进时间复杂度为 O(n)。
   * <p>
   * 空间复杂度：这里的空间复杂度和递归使用的栈空间有关，这里递归层数不超过 n，故渐进空间复杂度为 O(n)。
   * <p>
   *
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    return check(root, root);
  }

  public boolean check(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
  }

  /**
   * 方法二：迭代
   * <p>
   * 思路和算法
   * <p>
   * 「方法一」中我们用递归的方法实现了对称性的判断，那么如何用迭代的方法实现呢？首先我们引入一个队列，这是把递归程序改写成迭代程序的常用方法。
   * <p>
   * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值（队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
   * <p>
   * 然后将两个结点的左右子结点按相反的顺序插入队列中。当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
   * <p>
   * ============================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，同「方法一」。
   * <p>
   * 空间复杂度：这里需要用一个队列来维护节点，每个节点最多进队一次，出队一次，队列中最多不会超过 n 个点，故渐进空间复杂度为 O(n)。
   * <p>
   *
   * @param root
   * @return
   */
  public static boolean isSymmetric2(TreeNode root) {
    return check2(root, root);
  }

  public static boolean check2(TreeNode u, TreeNode v) {
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(u);
    q.offer(v);
    while (!q.isEmpty()) {
      u = q.poll();
      v = q.poll();
      if (u == null && v == null) {
        continue;
      }
      if ((u == null || v == null) || (u.val != v.val)) {
        return false;
      }

      q.offer(u.left);
      q.offer(v.right);

      q.offer(u.right);
      q.offer(v.left);
    }
    return true;
  }
}
