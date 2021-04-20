package org.leetcode.shunxu.leet500.ch150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>199. 二叉树的右视图
 * <p>给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * <p>示例:
 *
 * <p>输入: [1,2,3,null,5,null,4]
 * <p>输出: [1, 3, 4]
 * <p>解释:
 *
 * <p>   1            <---
 * <p> /   \
 * <p>2     3         <---
 * <p> \     \
 * <p>  5     4       <---
 * <p>通过次数93,044提交次数143,174
 * <p>贡献者
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch199BinaryTreeRightSideView {

  /**
   * <p>复杂度分析
   *
   * <p>    时间复杂度 : O(n)。深度优先搜索最多访问每个结点一次，因此是线性复杂度。
   *
   * <p>    空间复杂度 : O(n)。最坏情况下，栈内会包含接近树高度的结点数量，占用 O(n) 的空间。
   * <p>      1
   * <p>    /  \
   * <p>   2    3
   * <p>  / \   / \
   * <p> 2   5 6   4
   * <p>           /\
   * <p>          2  5
   *
   * @param root
   * @return
   */
  public List<Integer> rightSideView(TreeNode root) {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int max_depth = -1;

    Stack<TreeNode> nodeStack = new Stack<TreeNode>();
    Stack<Integer> depthStack = new Stack<Integer>();
    nodeStack.push(root);
    depthStack.push(0);

    while (!nodeStack.isEmpty()) {
      TreeNode node = nodeStack.pop();
      int depth = depthStack.pop();

      if (node != null) {
        // 维护二叉树的最大深度
        max_depth = Math.max(max_depth, depth);

        // 如果不存在对应深度的节点我们才插入
        if (!rightmostValueAtDepth.containsKey(depth)) {
          rightmostValueAtDepth.put(depth, node.val);
        }

        nodeStack.push(node.left);
        nodeStack.push(node.right);
        depthStack.push(depth + 1);
        depthStack.push(depth + 1);
      }
    }

    List<Integer> rightView = new ArrayList<Integer>();
    for (int depth = 0; depth <= max_depth; depth++) {
      rightView.add(rightmostValueAtDepth.get(depth));
    }

    return rightView;
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度 : O(n)。 每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为线性。
   *
   * <p>   空间复杂度 : O(n)。每个节点最多进队列一次，所以队列长度最大不不超过 n，所以这里的空间代价为 O(n)。
   *
   * @param root
   * @return
   */
  public List<Integer> rightSideView2(TreeNode root) {
    Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
    int max_depth = -1;

    Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
    Queue<Integer> depthQueue = new LinkedList<Integer>();
    nodeQueue.add(root);
    depthQueue.add(0);

    while (!nodeQueue.isEmpty()) {
      TreeNode node = nodeQueue.remove();
      int depth = depthQueue.remove();

      if (node != null) {
        // 维护二叉树的最大深度
        max_depth = Math.max(max_depth, depth);

        // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
        rightmostValueAtDepth.put(depth, node.val);

        nodeQueue.add(node.left);
        nodeQueue.add(node.right);
        depthQueue.add(depth + 1);
        depthQueue.add(depth + 1);
      }
    }

    List<Integer> rightView = new ArrayList<Integer>();
    for (int depth = 0; depth <= max_depth; depth++) {
      rightView.add(rightmostValueAtDepth.get(depth));
    }

    return rightView;
  }
}

