package org.leetcode.shunxu.leet1500.ch1500;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>LeetCode 1469. 寻找所有的独生节点
 * <p>2020-07-13阅读 1540
 * <p>1. 题目
 * <p>二叉树中，如果一个节点是其父节点的唯一子节点，则称这样的节点为 “独生节点” 。
 * <p> 二叉树的根节点不会是独生节点，因为它没有父节点。
 *
 * <p>给定一棵二叉树的根节点 root ，返回树中 所有的独生节点的值所构成的数组 。
 * <p> 数组的顺序 不限 。
 *
 * <p>示例 1：
 * <p>      1
 * <p>     / \
 * <p>    2   3
 * <p>     \
 * <p>      4
 * <p>输入：root = [1,2,3,null,4]
 * <p>输出：[4]
 * <p>解释：浅蓝色的节点是唯一的独生节点。
 * <p>节点 1 是根节点，不是独生的。
 * <p>节点 2 和 3 有共同的父节点，所以它们都不是独生的。
 *
 * <p>提示：
 * <p>tree 中节点个数的取值范围是 [1, 1000]。
 * <p>每个节点的值的取值范围是 [1, 10^6]。
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/find-all-the-lonely-nodes
 * <p>@author: wangrui
 * <p>@date: 2021/4/22
 */
public class Ch1469FindAllTheLonelyNodes {

  public static List<Integer> getLonelyNodes_1(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      TreeNode left = pop.left;
      TreeNode right = pop.right;
      if (left != null && right != null) {
        stack.push(left);
        stack.push(right);
      } else if (left != null) {
        stack.push(left);
        ans.add(left.val);
      } else if (right != null) {
        stack.push(right);
        ans.add(right.val);
      }
    }
    return ans;
  }

  List<Integer> ans = new ArrayList<>();

  public List<Integer> getLonelyNodes_2(TreeNode root) {
    helper(root);
    return ans;
  }

  private void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right != null) {
      ans.add(root.right.val);
    }
    if (root.left != null && root.right == null) {
      ans.add(root.left.val);
    }

    helper(root.left);
    helper(root.right);
  }
}
