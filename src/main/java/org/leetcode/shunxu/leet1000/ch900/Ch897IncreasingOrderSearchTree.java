package org.leetcode.shunxu.leet1000.ch900;

import java.util.ArrayList;
import java.util.List;
import org.TreeNode;

/**
 * <p>897. 递增顺序查找树
 *
 * <p>给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 *
 *
 *
 * <p>示例 ：
 *
 * <p>输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 * <p>       5
 * <p>      / \
 * <p>    3    6
 * <p>   / \    \
 * <p>  2   4    8
 * <p> /        / \
 * <p>1        7   9
 *
 * <p>输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * <p> 1
 * <p>  \
 * <p>   2
 * <p>    \
 * <p>     3
 * <p>      \
 * <p>       4
 * <p>        \
 * <p>         5
 * <p>          \
 * <p>           6
 * <p>            \
 * <p>             7
 * <p>              \
 * <p>               8
 * <p>                \
 * <p>                 9
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定树中的结点数介于 1 和 100 之间。
 * <p>    每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * <p> https://leetcode-cn.com/problems/increasing-order-search-tree/
 * <p>通过次数26,229
 * <p>提交次数35,995
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/22
 */
public class Ch897IncreasingOrderSearchTree {

  public TreeNode increasingBST(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    inorder(root, ans);
    TreeNode treeNode = new TreeNode();
    treeNode.val = ans.get(0);
    TreeNode cur = treeNode;
    for (int i = 1; i < ans.size(); i++) {
      TreeNode treeNodeRight = new TreeNode(ans.get(i));
      cur.right = treeNodeRight;
      cur = treeNodeRight;
    }
    return treeNode;
  }

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N)，其中 N 是树上的节点个数。
   *
   * <p>     空间复杂度：O(N)。
   *
   * @param root
   * @return
   */
  public TreeNode increasingBST2(TreeNode root) {
    List<Integer> vals = new ArrayList();
    inorder(root, vals);
    TreeNode ans = new TreeNode(0), cur = ans;
    for (int v : vals) {
      cur.right = new TreeNode(v);
      cur = cur.right;
    }
    return ans.right;
  }

  public void inorder(TreeNode node, List<Integer> vals) {
    if (node == null) {
      return;
    }
    inorder(node.left, vals);
    vals.add(node.val);
    inorder(node.right, vals);
  }

  TreeNode cur;

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度：O(N)，其中 N 是树上的节点个数。
   *
   * <p> 空间复杂度：O(H)，其中 H 是数的高度。
   *
   * @param root
   * @return
   */
  public TreeNode increasingBST3(TreeNode root) {
    TreeNode ans = new TreeNode(0);
    cur = ans;
    inorder(root);
    return ans.right;
  }

  public void inorder(TreeNode node) {
    if (node == null) {
      return;
    }
    inorder(node.left);
    node.left = null;
    cur.right = node;
    cur = node;
    inorder(node.right);
  }

}
