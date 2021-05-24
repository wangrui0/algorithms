package org.company.meituan.all.week02.done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>94. 二叉树的中序遍历
 *
 * <p>给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,null,2,3]
 * <p>输出：[1,3,2]
 *
 * <p>示例 2：
 *
 * <p>输入：root = []
 * <p>输出：[]
 *
 * <p>示例 3：
 *
 * <p>输入：root = [1]
 * <p>输出：[1]
 *
 * <p>示例 4：
 *
 * <p>输入：root = [1,2]
 * <p>输出：[2,1]
 *
 * <p>示例 5：
 *
 * <p>输入：root = [1,null,2]
 * <p>输出：[1,2]
 *
 *
 *
 * <p>提示：
 *
 * <p>    树中节点数目在范围 [0, 100] 内
 * <p>    -100 <= Node.val <= 100
 *
 *
 *
 * <p>进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>通过次数433,476
 * <p>提交次数574,932
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */


public class NCh052_94_BinaryTreeInorderTraversal二叉树的中序遍历 {

  List<Integer> ans = new ArrayList<>();

  public List<Integer> inorderTraversal_self(TreeNode root) {
    inorder(root);
    return ans;
  }

  public void inorder(TreeNode root) {
    if (root == null) {
      return;
    }
    inorder(root.left);
    ans.add(root.val);
    inorder(root.right);
  }

  /**
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
   * <p>
   * 空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal_1(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    inorder(root, res);
    return res;
  }

  public void inorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    inorder(root.left, res);
    res.add(root.val);
    inorder(root.right, res);
  }

  /**
   * <p>复杂度分析
   * <p>
   * <p>时间复杂度：O(n)，其中 nnn 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
   * <p>
   * <p>空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n)O(n)O(n) 的级别。
   * 1 2 3
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal_2(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> stk = new LinkedList<TreeNode>();
    while (root != null || !stk.isEmpty()) {
      while (root != null) {
        stk.push(root);
        root = root.left;
      }
      root = stk.pop();
      res.add(root.val);
      root = root.right;
    }
    return res;
  }

  /**
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(n)，其中 nnn 为二叉搜索树的节点个数。Morris 遍历中每个节点会被访问两次，因此总时间复杂度为 O(2n)=O(n)O(2n)=O(n)O(2n)=O(n)。
   *
   * <p>  空间复杂度：O(1)。
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversal_3(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    TreeNode predecessor = null;

    while (root != null) {
      if (root.left != null) {
        // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
        predecessor = root.left;
        while (predecessor.right != null && predecessor.right != root) {
          predecessor = predecessor.right;
        }

        // 让 predecessor 的右指针指向 root，继续遍历左子树
        if (predecessor.right == null) {
          predecessor.right = root;
          root = root.left;
        }
        // 说明左子树已经访问完了，我们需要断开链接
        else {
          res.add(root.val);
          predecessor.right = null;
          root = root.right;
        }
      }
      // 如果没有左孩子，则直接访问右孩子
      else {
        res.add(root.val);
        root = root.right;
      }
    }
    return res;
  }
}
