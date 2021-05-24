package org.company.meituan.all.week02.done;

import java.util.LinkedList;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>104. 二叉树的最大深度
 *
 * <p>给定一个二叉树，找出其最大深度。
 *
 * <p>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * <p>说明: 叶子节点是指没有子节点的节点。
 *
 * <p>示例：
 * <p>给定二叉树 [3,9,20,null,null,15,7]，
 *
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>    /  \
 * <p>   15   7
 *
 * <p>返回它的最大深度 3 。
 * <p>通过次数421,070
 * <p>提交次数552,646
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh055_104MaximumDepthOfBinaryTree二叉树的最大深度 {

  int depth = 0;

  public int maxDepth_self(TreeNode root) {
    depth(root);
    return depth;
  }

  private int depth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = depth(root.left);
    int r = depth(root.right);
    depth = Math.max(depth, Math.max(l, r) + 1);
    return Math.max(l, r) + 1;
  }

  /**
   * <p>方法一：深度优先搜索
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
   *
   * <p> 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
   *
   * @param root
   * @return
   */
  public int maxDepth_1(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth_1(root.left);
      int rightHeight = maxDepth_1(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  /**
   * <p> 方法二：广度优先搜索
   * <p>复杂度分析
   *
   * <p>   时间复杂度：(n)，其中 nnn 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
   *
   * <p>  空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
   *
   * @param root
   * @return
   */
  public int maxDepth_2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
  }


}
