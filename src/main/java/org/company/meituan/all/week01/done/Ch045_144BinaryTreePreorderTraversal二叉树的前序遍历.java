package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>144. 二叉树的前序遍历
 * <p>给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [1,null,2,3]
 * <p>输出：[1,2,3]
 * <p>示例 2：
 *
 * <p>输入：root = []
 * <p>输出：[]
 * <p>示例 3：
 *
 * <p>输入：root = [1]
 * <p>输出：[1]
 * <p>示例 4：
 *
 *
 * <p>输入：root = [1,2]
 * <p>输出：[1,2]
 * <p>示例 5：
 *
 *
 * <p>输入：root = [1,null,2]
 * <p>输出：[1,2]
 *
 *
 * <p>提示：
 *
 * <p>树中节点数目在范围 [0, 100] 内
 * <p>-100 <= Node.val <= 100
 *
 *
 * <p>进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * <p>通过次数321,493提交次数460,894
 * <p>https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode-solution/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class Ch045_144BinaryTreePreorderTraversal二叉树的前序遍历 {

  List<Integer> ans = new ArrayList<>();

  public List<Integer> preorderTraversal_self(TreeNode root) {
    if (root == null) {
      return ans;
    }
    ans.add(root.val);
    preorderTraversal_self(root.left);
    preorderTraversal_self(root.right);
    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
    System.out.println(preorderTraversal_self2(root));

  }

  public static List<Integer> preorderTraversal_self2(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      result.add(pop.val);
      if (pop.right != null) {
        stack.push(pop.right);
      }
      if (pop.left != null) {
        stack.push(pop.left);
      }
    }
    return result;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)O(n)O(n)，其中 nnn 是二叉树的节点数。每一个节点恰好被遍历一次。
   *
   * <p>  空间复杂度：O(n)O(n)O(n)，为递归过程中栈的开销，平均情况下为 O(log⁡n)O(\log n)O(logn)，最坏情况下树呈现链状，为 O(n)O(n)O(n)。
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversal_1(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    preorder(root, res);
    return res;
  }

  public void preorder(TreeNode root, List<Integer> res) {
    if (root == null) {
      return;
    }
    res.add(root.val);
    preorder(root.left, res);
    preorder(root.right, res);
  }

  public List<Integer> preorderTraversal_2(TreeNode root) {
    List<Integer> res = new ArrayList<Integer>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode node = root;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        res.add(node.val);
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      node = node.right;
    }
    return res;
  }


}
