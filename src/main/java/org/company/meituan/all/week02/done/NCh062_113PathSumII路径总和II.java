package org.company.meituan.all.week02.done;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.TreeNode;

import java.util.List;

/**
 * <p>113. 路径总和 II
 * <p>给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * <p>叶子节点 是指没有子节点的节点。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * <p>输出：[[5,4,11,2],[5,8,4,5]]
 * <p>示例 2：
 *
 *
 * <p>输入：root = [1,2,3], targetSum = 5
 * <p>输出：[]
 * <p>示例 3：
 *
 * <p>输入：root = [1,2], targetSum = 0
 * <p>输出：[]
 *
 *
 * <p>提示：
 *
 * <p>树中节点总数在范围 [0, 5000] 内
 * <p>-1000 <= Node.val <= 1000
 * <p>-1000 <= targetSum <= 1000
 * <p>通过次数138,605提交次数223,056
 * <p>https://leetcode-cn.com/problems/path-sum-ii/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:20 下午
 */
public class NCh062_113PathSumII路径总和II {

  List<List<Integer>> ret = new LinkedList<List<Integer>>();
  Deque<Integer> path = new LinkedList<Integer>();

  /**
   * 方法一：深度优先搜索(注意:深度优先遍历也就是前序遍历就是这样的)
   *
   * @param root
   * @param sum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    dfs(root, sum);
    return ret;
  }

  public void dfs(TreeNode root, int sum) {
    if (root == null) {
      return;
    }
    path.offerLast(root.val);
    sum -= root.val;
    if (root.left == null && root.right == null && sum == 0) {
      ret.add(new LinkedList<Integer>(path));
    }
    dfs(root.left, sum);
    dfs(root.right, sum);
    path.pollLast();
  }

  Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

  public List<List<Integer>> pathSum_2(TreeNode root, int sum) {
    if (root == null) {
      return ret;
    }

    Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
    Queue<Integer> queueSum = new LinkedList<Integer>();
    queueNode.offer(root);
    queueSum.offer(0);

    while (!queueNode.isEmpty()) {
      TreeNode node = queueNode.poll();
      int rec = queueSum.poll() + node.val;

      if (node.left == null && node.right == null) {
        if (rec == sum) {
          getPath(node);
        }
      } else {
        if (node.left != null) {
          map.put(node.left, node);
          queueNode.offer(node.left);
          queueSum.offer(rec);
        }
        if (node.right != null) {
          map.put(node.right, node);
          queueNode.offer(node.right);
          queueSum.offer(rec);
        }
      }
    }

    return ret;
  }

  public void getPath(TreeNode node) {
    List<Integer> temp = new LinkedList<Integer>();
    while (node != null) {
      temp.add(node.val);
      node = map.get(node);
    }
    Collections.reverse(temp);
    ret.add(new LinkedList<Integer>(temp));
  }


}


