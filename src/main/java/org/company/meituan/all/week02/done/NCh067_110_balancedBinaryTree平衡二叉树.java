package org.company.meituan.all.week02.done;

import org.TreeNode;

/**
 * <p>110. 平衡二叉树
 * <p>给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * <p>本题中，一棵高度平衡二叉树定义为：
 *
 * <p>一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [3,9,20,null,null,15,7]
 * <p>输出：true
 * <p>示例 2：
 *
 *
 * <p>输入：root = [1,2,2,3,3,null,null,4,4]
 * <p>输出：false
 * <p>示例 3：
 *
 * <p>输入：root = []
 * <p>输出：true
 *
 *
 * <p>提示：
 *
 * <p>树中的节点数在范围 [0, 5000] 内
 * <p>-104 <= Node.val <= 104
 * <p>通过次数208,360提交次数374,006
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:30 下午
 */
public class NCh067_110_balancedBinaryTree平衡二叉树 {

  boolean flag = true;

  public boolean isBalanced(TreeNode root) {
    depth(root);
    return flag;
  }

  public int depth(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int ldepth = depth(node.left);
    int rdepth = depth(node.right);
    if (Math.abs(ldepth - rdepth) > 1) {
      flag = false;
    }
    return Math.max(ldepth, rdepth) + 1;
  }

  /**
   * 方法一：自顶向下的递归 复杂度分析
   * <p>
   * <p>时间复杂度：O(n^2)，
   * <p>空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n。
   *
   * @param root
   * @return
   */
  public boolean isBalanced_2(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced_2(root.left) && isBalanced_2(
          root.right);
    }
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height(root.left), height(root.right)) + 1;
    }
  }

  /**
   * <p>方法二：
   * <p>自底向上的递归
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 是二叉树中的节点个数。使用自底向上的递归，每个节点的计算高度和判断是否平衡都只需要处理一次，最坏情况下需要遍历二叉树中的所有节点，因此时间复杂度是
   *
   * <p>  空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过 n
   * ====================================
   * <p>方法一由于是自顶向下递归，因此对于同一个节点，函数 hheight 会被重复调用，导致时间复杂度较高。如果使用自底向上的做法，
   * <p>则对于每个节点，函数 height 只会被调用一次。自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，
   *
   * <p>再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
   *
   * @param root
   * @return
   */
  public boolean isBalanced_3(TreeNode root) {
    return height2(root) >= 0;
  }

  public int height2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
      return -1;
    } else {
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }
}
