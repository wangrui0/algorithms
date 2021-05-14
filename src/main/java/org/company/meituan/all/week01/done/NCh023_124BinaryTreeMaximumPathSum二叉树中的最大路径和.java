package org.company.meituan.all.week01.done;

import org.TreeNode;

/**
 * <p>124. 二叉树中的最大路径和
 *
 * <p>路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * <p>路径和 是路径中各节点值的总和。
 *
 * <p>给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,2,3]
 * <p>输出：6
 * <p>解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * <p>示例 2：
 *
 * <p>输入：root = [-10,9,20,null,null,15,7]
 * <p>输出：42
 * <p>解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 *
 *
 * <p>提示：
 *
 * <p>    树中节点数目范围是 [1, 3 *<p>104]
 * <p>    -1000 <= Node.val <= 1000
 *
 * <p>通过次数119,865
 * <p>提交次数274,429
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh023_124BinaryTreeMaximumPathSum二叉树中的最大路径和 {

  int maxSum = Integer.MIN_VALUE;

  /**
   * <p>方法一：递归
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(N)，其中 N 是二叉树中的节点个数。对每个节点访问不超过 2 次。
   *
   * <p>  空间复杂度：O(N)，其中 N 是二叉树中的节点个数。空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，
   * <p> 最坏情况下，二叉树的高度等于二叉树中的节点个数。
   *
   * @param root
   * @return
   */
  public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
  }

  /**
   * 该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
   *
   * @param node
   * @return
   */
  public int maxGain(TreeNode node) {
    if (node == null) {
      return 0;
    }

    // 递归计算左右子节点的最大贡献值
    // 只有在最大贡献值大于 0 时，才会选取对应子节点
    int leftGain = Math.max(maxGain(node.left), 0);
    int rightGain = Math.max(maxGain(node.right), 0);

    // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
    int priceNewpath = node.val + leftGain + rightGain;

    // 更新答案
    maxSum = Math.max(maxSum, priceNewpath);

    // 返回节点的最大贡献值
    return node.val + Math.max(leftGain, rightGain);
  }
}


