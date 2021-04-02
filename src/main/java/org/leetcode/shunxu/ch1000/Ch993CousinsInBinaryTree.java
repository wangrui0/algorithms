package org.leetcode.shunxu.ch1000;

import java.util.HashMap;
import java.util.Map;
import org.TreeNode;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

/**
 * <p>993. 二叉树的堂兄弟节点
 *
 * <p>在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 * <p>如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 * <p>我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 * <p>只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,2,3,4], x = 4, y = 3
 * <p>输出：false
 *
 * <p>示例 2：
 *
 * <p>输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * <p>输出：true
 *
 * <p>示例 3：
 *
 * <p>输入：root = [1,2,3,null,4], x = 2, y = 3
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    二叉树的节点数介于 2 到 100 之间。
 * <p>    每个节点的值都是唯一的、范围为 1 到 100 的整数。
 * <p>@author: wangrui
 * <p>@date: 2021/4/2
 */
public class Ch993CousinsInBinaryTree {

  Map<Integer, Integer> depth;
  Map<Integer, TreeNode> parent;

  /**
   * <p>  复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是给定树中节点的数量。
   *
   * <p>   空间复杂度：O(N)
   *
   * @param root
   * @param x
   * @param y
   * @return
   */
  public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap();
    parent = new HashMap();
    dfs(root, null);
    return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
  }

  public void dfs(TreeNode node, TreeNode par) {
    if (node != null) {
      depth.put(node.val, par != null ? 1 + depth.get(par.val) : 0);
      parent.put(node.val, par);
      dfs(node.left, node);
      dfs(node.right, node);
    }
  }
}
