package org.leetcode.shunxu.ch600;

import org.TreeNode;

/**
 * <p>572. 另一个树的子树
 *
 * <p>给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * <p>示例 1:
 * <p>给定的树 s:
 *
 * <p>     3
 * <p>    / \
 * <p>   4   5
 * <p>  / \
 * <p> 1   2
 *
 * <p>给定的树 t：
 *
 * <p>   4
 * <p>  / \
 * <p> 1   2
 *
 * <p>返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * <p>示例 2:
 * <p>给定的树 s：
 *
 * <p>     3
 * <p>    / \
 * <p>   4   5
 * <p>  / \
 * <p> 1   2
 * <p>    /
 * <p>   0
 *
 * <p>给定的树 t：
 *
 *
 * <p>   4
 * <p>  / \
 * <p> 1   2
 *
 * <p>返回 false。
 * <p>通过次数61,665
 * <p>提交次数130,425
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/subtree-of-another-tree/
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 */
public class Ch572SubtreeOfAnotherTree {

  public boolean isSubtree(TreeNode s, TreeNode t) {
    return true;
  }
}
