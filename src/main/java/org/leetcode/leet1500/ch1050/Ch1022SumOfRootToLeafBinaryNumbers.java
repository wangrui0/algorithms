package org.leetcode.leet1500.ch1050;

import java.util.LinkedList;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>1022. 从根到叶的二进制数之和
 *
 * <p>给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 *
 * <p>对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 *
 * <p>返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,0,1,0,1,0,1]
 * <p>输出：22
 * <p>解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * <p>示例 2：
 *
 * <p>输入：root = [0]
 * <p>输出：0
 *
 * <p>示例 3：
 *
 * <p>输入：root = [1]
 * <p>输出：1
 *
 * <p>示例 4：
 *
 * <p>输入：root = [1,1]
 * <p>输出：3
 *
 *
 *
 * <p>提示：
 *
 * <p>    树中的结点数介于 1 和 1000 之间。
 * <p>    Node.val 为 0 或 1 。
 *
 * <p>通过次数16,304
 * <p>提交次数23,529
 * <p>https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 * <p>@author: wangrui
 * <p>@date: 2021/4/5
 */
public class Ch1022SumOfRootToLeafBinaryNumbers {

  /**
   * 方法一：
   *
   * @param root
   * @return
   */
  public int sumRootToLeaf(TreeNode root) {
    return helper(root, 0);
  }

  public int helper(TreeNode root, int sum) {
    //空节点，返回0
    if (root == null) {
      return 0;
    }
    //进位更新
    sum = (sum << 1) + root.val;
    //叶子节点直接返回当前和(末节点或者是空节点才是结束条件)
    if (root.left == null && root.right == null) {
      return sum;
    }
    //递归
    return helper(root.left, sum) + helper(root.right, sum);
  }

  /**
   * 方法二：
   *
   * @param root
   * @return
   */
  public int sumRootToLeaf_2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int res = 0;
    Queue<TreeNode> nodeQueue = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();
    nodeQueue.add(root);
    queue.add(root.val);
    while (!nodeQueue.isEmpty()) {
      // 同时维护两个队列
      TreeNode node = nodeQueue.poll();
      int tmp = queue.poll();

      // 如果该节点是叶子节点，加到res中
      if (node.left == null && node.right == null) {
        res += tmp;
      } else {
        // 左节点不为空时，左节点进入队列，左节点对应的值是当前节点tmp<<1+node.left.val
        if (node.left != null) {
          nodeQueue.add(node.left);
          queue.add((tmp << 1) + node.left.val);
        }
        if (node.right != null) {
          nodeQueue.add(node.right);
          queue.add((tmp << 1) + node.right.val);
        }
      }
    }
    return res;
  }

  int res = 0;

  /**
   * 方法3
   *
   * @param root
   * @return
   */
  public int sumRootToLeaf_3(TreeNode root) {
    preOrder(root, 0);
    return res;
  }

  public void preOrder(TreeNode root, int val) {
    if (root != null) {
      // 值先移位，后相加
      int tmp = (val << 1) + root.val;

      // 当前节点是叶子节点
      if (root.left == null && root.right == null) {
        res += tmp;
      } else {
        // 当前节点的左子节点不为空，继续递归，val的值是父节点的值，也就是tmp
        if (root.left != null) {
          preOrder(root.left, tmp);
        }
        if (root.right != null) {
          preOrder(root.right, tmp);
        }
      }
    }
  }


}
