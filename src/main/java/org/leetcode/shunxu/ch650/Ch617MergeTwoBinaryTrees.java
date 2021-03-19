package org.leetcode.shunxu.ch650;

import java.util.LinkedList;
import java.util.Queue;
import org.TreeNode;

/**
 * <p> 617. 合并二叉树
 * <p> 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * <p> 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * <p>否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * <p> 示例 1:
 *
 * <p> 输入:
 * <p> 	Tree 1                     Tree 2
 * <p>           1                         2
 * <p>          / \                       / \
 * <p>         3   2                     1   3
 * <p>        /                           \   \
 * <p>       5                             4   7
 * <p> 输出:
 * <p> 合并后的树:
 * <p> 	     3
 * <p> 	    / \
 * <p> 	   4   5
 * <p> 	  / \   \
 * <p> 	 5   4   7
 * <p> 注意: 合并必须从两个树的根节点开始。
 *
 * <p> 通过次数129,979提交次数165,023
 * <p> 在真实的面试中遇到过这道题？
 * <p> https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:26 下午
 */
public class Ch617MergeTwoBinaryTrees {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。对两个二叉树同时进行深度优先搜索，
   * <p> 只有当两个二叉树中的对应节点都不为空时才会对该节点进行显性合并操作，因此被访问到的节点数不会超过较小的二叉树的节点数。
   *
   * <p>空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。空间复杂度取决于递归调用的层数，
   * <p>递归调用的层数不会超过较小的二叉树的最大高度，最坏情况下，二叉树的高度等于节点数。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @return
   */
  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) {
      return root2;
    }
    if (root2 == null) {
      return root1;
    }
    TreeNode treeNode = new TreeNode(root1.val + root2.val);
    treeNode.left = mergeTrees(root1.left, root2.left);
    treeNode.right = mergeTrees(root1.right, root2.right);
    return treeNode;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。对两个二叉树同时进行广度优先搜索，
   * <p>  只有当两个二叉树中的对应节点都不为空时才会访问到该节点，因此被访问到的节点数不会超过较小的二叉树的节点数。
   *
   * <p>  空间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。空间复杂度取决于队列中的元素个数，
   * <p>  队列中的元素个数不会超过较小的二叉树的节点数。
   *
   * <p>作者：LeetCode-Solution
   * <p>链接：https://leetcode-cn.com/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
   * <p>来源：力扣（LeetCode）
   * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param t1
   * @param t2
   * @return
   */
  public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    TreeNode merged = new TreeNode(t1.val + t2.val);
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
    Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
    queue.offer(merged);
    queue1.offer(t1);
    queue2.offer(t2);
    while (!queue1.isEmpty() && !queue2.isEmpty()) {
      TreeNode node = queue.poll(), node1 = queue1.poll(), node2 = queue2.poll();
      TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
      if (left1 != null || left2 != null) {
        if (left1 != null && left2 != null) {
          TreeNode left = new TreeNode(left1.val + left2.val);
          node.left = left;
          queue.offer(left);
          queue1.offer(left1);
          queue2.offer(left2);
        } else if (left1 != null) {
          node.left = left1;
        } else if (left2 != null) {
          node.left = left2;
        }
      }
      if (right1 != null || right2 != null) {
        if (right1 != null && right2 != null) {
          TreeNode right = new TreeNode(right1.val + right2.val);
          node.right = right;
          queue.offer(right);
          queue1.offer(right1);
          queue2.offer(right2);
        } else if (right1 != null) {
          node.right = right1;
        } else {
          node.right = right2;
        }
      }
    }
    return merged;
  }
}
