package org.leetcode.shunxu.leet1000.ch1000;

import java.util.ArrayList;
import java.util.List;
import org.TreeNode;

/**
 * <p>965. 单值二叉树
 *
 * <p>如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 *
 * <p>只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[1,1,1,1,1,null,1]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：[2,2,2,5,2]
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定树的节点数范围是 [1, 100]。
 * <p>    每个节点的值都是整数，范围为 [0, 99] 。
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch965UnivaluedBinaryTree {

  boolean flag = true;

  public boolean isUnivalTree_self(TreeNode root) {
    dfs(root, root.val);
    return flag;
  }

  public void dfs(TreeNode root, int value) {
    if (root == null) {
      return;
    }
    if (root.val != value) {
      flag = false;
      return;
    }
    if (!flag) {
      return;
    }
    dfs(root.left, value);
    dfs(root.right, value);
  }

  List<Integer> vals;

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(N)，其中 N 是给定树中节点的数量。
   *
   * <p>  空间复杂度：O(N)。
   *
   * @param root
   * @return
   */
  public boolean isUnivalTree_1(TreeNode root) {
    vals = new ArrayList();
    dfs(root);
    for (int v : vals) {
      if (v != vals.get(0)) {
        return false;
      }
    }
    return true;
  }

  public void dfs(TreeNode node) {
    if (node != null) {
      vals.add(node.val);
      dfs(node.left);
      dfs(node.right);
    }
  }

  /**
   * <p> 复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是给定树中节点的数量。
   *
   * <p>   空间复杂度：O(H)，其中 H 是给定树的高度。
   *
   * @param root
   * @return
   */
  public boolean isUnivalTree(TreeNode root) {
    boolean leftCorrect = (root.left == null ||
        (root.val == root.left.val && isUnivalTree(root.left)));
    boolean rightCorrect = (root.right == null ||
        (root.val == root.right.val && isUnivalTree(root.right)));
    return leftCorrect && rightCorrect;
  }

}
