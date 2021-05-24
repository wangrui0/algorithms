package org.company.meituan.all.week01.done;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.TreeNode;

/**
 * <p>236. 二叉树的最近公共祖先
 * <p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p>百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * <p>输出：3
 * <p>解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>示例 2：
 *
 *
 * <p>输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * <p>输出：5
 * <p>解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>示例 3：
 *
 * <p>输入：root = [1,2], p = 1, q = 2
 * <p>输出：1
 *
 *
 * <p>提示：
 *
 * <p>树中节点数目在范围 [2, 105] 内。
 * <p>-109 <= Node.val <= 109
 * <p>所有 Node.val 互不相同 。
 * <p>p != q
 * <p>p 和 q 均存在于给定的二叉树中。
 * <p>通过次数200,374提交次数298,398
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh044_236LowestCommonAncestorOfABinaryTree二叉树的最近公共祖先 {

  private TreeNode ans;


  /**
   * 方法一：递归 树的问题一般都可以用递归解决，最重要的是定义子问题
   *
   * @param root
   * @param p
   * @param q
   * @return
   */
  public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root, p, q);
    return this.ans;
  }

  private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return false;
    }

    boolean lFlag = dfs(root.left, p, q);
    boolean rFlag = dfs(root.right, p, q);

    if ((lFlag && rFlag) || ((root.val == p.val || root.val == q.val) && (lFlag || rFlag))) {
      ans = root;
    }
    return lFlag || rFlag || root.val == p.val || root.val == q.val;
  }

  Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
  Set<Integer> visited = new HashSet<Integer>();

  public void dfs(TreeNode root) {
    if (root.left != null) {
      parent.put(root.left.val, root);
      dfs(root.left);
    }
    if (root.right != null) {
      parent.put(root.right.val, root);
      dfs(root.right);
    }
  }

  public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
    dfs(root);
    while (p != null) {
      visited.add(p.val);
      p = parent.get(p.val);
    }
    while (q != null) {
      if (visited.contains(q.val)) {
        return q;
      }
      q = parent.get(q.val);
    }
    return null;
  }


}
