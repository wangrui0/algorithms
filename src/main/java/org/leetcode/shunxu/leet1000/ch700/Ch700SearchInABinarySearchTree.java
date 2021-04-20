package org.leetcode.shunxu.leet1000.ch700;


import org.TreeNode;

/**
 * <p>700. 二叉搜索树中的搜索
 * <p>给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * <p>例如，
 *
 * <p>给定二叉搜索树:
 *
 * <p>         4
 * <p>        / \
 * <p>       2   7
 * <p>      / \
 * <p>     1   3
 *
 * <p>和值: 2
 * <p>你应该返回如下子树:
 *
 * <p>       2
 * <p>      / \
 * <p>    1   3
 * <p> 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * <p> 通过次数52,652提交次数69,739
 * <p>https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:38 下午
 */
public class Ch700SearchInABinarySearchTree {

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    } else if (root.val > val) {
      return searchBST(root.left, val);
    } else {
      return searchBST(root.right, val);
    }
  }

  /**
   * 复杂度分析
   * <p>
   * <p>时间复杂度：O(H)，其中 H 是树高。平均时间复杂度为 O(logN)，最坏时间复杂度为
   * <p>O(N)。
   * <p>
   * <p>空间复杂度：O(H)，递归栈的深度为 H。平均情况下深度为 O(logN)，最坏情况下深度为
   * <p>O(N)
   * <p>
   *
   * @param root
   * @param val
   * @return
   */
  public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null || val == root.val) {
      return root;
    }

    return val < root.val ? searchBST2(root.left, val) : searchBST2(root.right, val);
  }

  /**
   * <p>复杂度分析
   * <p>时间复杂度：O(H)，其中 HHH 是树高。平均时间复杂度为 O(logN)，最坏时间复杂度为O(N)。
   * <p>空间复杂度：O(1)，恒定的额外空间。
   * <p>
   *
   * @param root
   * @param val
   * @return
   */
  public TreeNode searchBST3(TreeNode root, int val) {
    while (root != null && val != root.val) {
      root = val < root.val ? root.left : root.right;
    }
    return root;
  }
}
