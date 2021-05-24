package org.company.meituan.all.week01.done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>103. 二叉树的锯齿形层序遍历
 *
 * <p>给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * <p>例如：
 * <p>给定二叉树 [3,9,20,null,null,15,7],
 *
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>    /  \
 * <p>   15   7
 *
 * <p>返回锯齿形层序遍历如下：
 *
 * <p>[
 * <p>  [3],
 * <p>  [20,9],
 * <p>  [15,7]
 * <p>]
 *
 * <p>通过次数137,024
 * <p>提交次数239,902
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh036_103_BinaryTreeZigzagLevelOrderTraversal二叉树的锯齿形层序遍历 {

  public static void main(String[] args) {
    TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    System.out.println(zigzagLevelOrder_self(treeNode));
  }

  public static List<List<Integer>> zigzagLevelOrder_self(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();

    if (root == null) {
      return ans;
    }

    Deque<TreeNode> deque = new LinkedList<TreeNode>();
    deque.add(root);
    int index = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      List<Integer> elements = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        if (index % 2 == 0) {
          TreeNode pop = deque.pollLast();
          elements.add(pop.val);
          if (pop.left != null) {
            deque.addFirst(pop.left);
          }
          if (pop.right != null) {
            deque.addFirst(pop.right);
          }
        } else {
          TreeNode pop = deque.pollFirst();
          elements.add(pop.val);
          if (pop.right != null) {
            deque.add(pop.right);
          }
          if (pop.left != null) {
            deque.add(pop.left);
          }
        }
      }
      index++;
      ans.add(elements);
    }
    return ans;
  }

  /**
   * <p> 还是官方的方法好
   * <p> 方法一：广度优先遍历
   * <p> 复杂度分析
   *
   * <p> 时间复杂度：O(N)O(N)，其中 NN 为二叉树的节点数。每个节点会且仅会被遍历一次。
   *
   * <p> 空间复杂度：O(N)O(N)。我们需要维护存储节点的队列和存储节点值的双端队列，空间复杂度为 O(N)O(N)。
   *
   * @param root
   * @return
   */
  public List<List<Integer>> zigzagLevelOrder_2(TreeNode root) {
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    nodeQueue.offer(root);
    boolean isOrderLeft = true;

    while (!nodeQueue.isEmpty()) {
      Deque<Integer> levelList = new LinkedList<Integer>();
      int size = nodeQueue.size();
      for (int i = 0; i < size; ++i) {
        TreeNode curNode = nodeQueue.poll();
        if (isOrderLeft) {
          levelList.offerLast(curNode.val);
        } else {
          levelList.offerFirst(curNode.val);
        }
        if (curNode.left != null) {
          nodeQueue.offer(curNode.left);
        }
        if (curNode.right != null) {
          nodeQueue.offer(curNode.right);
        }
      }
      ans.add(new LinkedList<Integer>(levelList));
      isOrderLeft = !isOrderLeft;
    }

    return ans;
  }
}
