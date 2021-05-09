package org.company.meituan.Collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>102. 二叉树的层序遍历
 *
 * <p>给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 *
 * <p>示例：
 * <p>二叉树：[3,9,20,null,null,15,7],
 *
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>    /  \
 * <p>   15   7
 *
 * <p>返回其层序遍历结果：
 *
 * <p>[
 * <p>  [3],
 * <p>  [9,20],
 * <p>  [15,7]
 * <p>]
 *
 * <p>通过次数304,175
 * <p>提交次数474,043
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>@author: wangrui
 * <p>@date: 2021/5/7
 */
public class Ch014_102BinaryTreeLevelOrderTraversal二叉树的层序遍历 {

  public List<List<Integer>> levelOrder_self(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    Queue<TreeNode> queues = new LinkedList<>();
    queues.add(root);
    List<List<Integer>> ans = new ArrayList<>();
    while (!queues.isEmpty()) {

      int size = queues.size();
      List<Integer> level = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode poll = queues.poll();
        level.add(poll.val);
        if (poll.left != null) {
          queues.add(poll.left);
        }
        if (poll.right != null) {
          queues.add(poll.right);
        }
      }
      ans.add(level);
    }
    return ans;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ret = new ArrayList<List<Integer>>();
    if (root == null) {
      return ret;
    }

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<Integer>();
      int currentLevelSize = queue.size();
      for (int i = 1; i <= currentLevelSize; ++i) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      ret.add(level);
    }

    return ret;
  }

}
