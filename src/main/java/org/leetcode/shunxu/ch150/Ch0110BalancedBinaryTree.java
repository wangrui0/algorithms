package org.leetcode.shunxu.ch150;

import org.leetcode.TreeNode;

/**
 * <p>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/26
 */
public class Ch0110BalancedBinaryTree {

  /**
   * 方法一由于是自顶向下递归，因此对于同一个节点，函数 height 会被重复调用，导致时间复杂度较高。如果使用自底向上的做法，则对于每个节点，函数 height 只会被调用一次。
   * <p>
   * 自底向上递归的做法类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡。如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回
   * −1。如果存在一棵子树不平衡，则整个二叉树一定不平衡。
   * <p>
   * 作者：LeetCode-Solution 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public boolean isBalanced(TreeNode root) {
    return height(root) >= 0;
  }

  public int height(TreeNode root) {
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

  /**
   * 这道题中的平衡二叉树的定义是：二叉树的每个节点的左右子树的高度差的绝对值不超过 1，则二叉树是平衡二叉树。
   * <p>
   * 根据定义，一棵二叉树是平衡二叉树，当且仅当其所有子树也都是平衡二叉树，因此可以使用递归的方式判断二叉树是不是平衡二叉树，
   * <p>
   * 递归的顺序可以是自顶向下或者自底向上。
   * <p>
   * 方法一：自顶向下的递归
   * <p>
   * 定义函数 height，用于计算二叉树中的任意一个节点 p 的高度：
   * <p>               0                                         p 是空节点
   * <p> height(p)={
   * <p>              max(height(p.left),height(p.right))+1      p 是非空节点
   *
   * <p> 有了计算节点高度的函数，即可判断二叉树是否平衡。具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，
   *
   * <p> 首先计算左右子树的高度，如果左右子树的高度差是否不超过 11，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡。这是一个自顶向下的递归的过程。
   *
   * <p> 作者：LeetCode-Solution
   * <p> 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
   * <p> 来源：力扣（LeetCode）
   * <p> 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * <p>
   * <p>时间复杂度：O(n ^ 2)
   * <p>空间复杂度：O(n)
   *
   * @param root
   * @return
   */
  public boolean isBalanced2(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return Math.abs(height2(root.left) - height2(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(
          root.right);
    }
  }

  public int height2(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height2(root.left), height2(root.right)) + 1;
    }
  }

  public boolean isBalanced3(TreeNode root) {
    return height3(root) >= 0;
  }

  public int height3(TreeNode root) {
    if(root==null){
      return  0;
    }
    int leftHeight=height3(root.left);
    int rightHeight=height3(root.right);

    if(leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1){
      return -1;
    }
    return  Math.max(leftHeight,rightHeight)+1;
  }
}
