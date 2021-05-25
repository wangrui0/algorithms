package org.company.meituan.all.week02.done;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import org.TreeNode;

/**
 * <p>199. 二叉树的右视图
 *
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
 *
 * <p>通过次数108,734
 * <p>提交次数167,534
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * <p>@author: wangrui
 * <p>@date: 2021/5/14
 */
public class NCh060_199BinaryTreeRightSideView二叉树的右视图 {
  /**
   * <p>深度优先遍历
   * <p>主要思路是从图中一个未访问的顶点 V 开始，沿着一条路一直走到底，然后从这条路尽头的节点回退到上一个节点，再从另一条路开始走到底...，不
   * <p>断递归重复此过程，直到所有的顶点都遍历完成，它的特点是不撞南墙不回头，先走完一条路，再换一条路继续走。
   * <p>实际上不管是前序遍历，还是中序遍历，亦或是后序遍历，都属于深度优先遍历。
   */
/**
 *  <p>广度优先遍历
 *  <p>广度优先遍历，指的是从图的一个未遍历的节点出发，先遍历这个节点的相邻节点，再依次遍历每个相邻节点的相邻节点。
 *  <p>上文所述树的广度优先遍历动图如下，每个节点的值即为它们的遍历顺序。所以广度优先遍历也叫层序遍历，
 */
  /**
   * <p>方法一：深度优先搜索
   * <p>复杂度分析
   *
   * <p>   时间复杂度 : O(n)。深度优先搜索最多访问每个结点一次，因此是线性复杂度。
   *
   * <p> 空间复杂度 : O(n)。最坏情况下，栈内会包含接近树高度的结点数量，占用 O(n) 的空间。
   * 仔细分析一下，这个不属于前中后序遍历，重分利用了栈的特性
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
   * 方法二：广度优先
   * <p>复杂度分析
   *
   * <p>   时间复杂度 :O(n)。 每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为线性。
   *
   * <p>  空间复杂度 : O(n)。每个节点最多进队列一次，所以队列长度最大不不超过 nnn，所以这里的空间代价为 O(n)O(n)O(n)。
   *
   * @param root
   * @return
   */
  public List<Integer> rightSideView_2(TreeNode root) {
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

  public List<Integer> rightSideView_3(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    Deque<Integer> stackDepth = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();
    stack.push(root);
    stackDepth.push(0);
    while (!stack.isEmpty()) {
      TreeNode treeNode = stack.pop();
      Integer depth = stackDepth.pop();
      if (treeNode != null) {
        if (!map.containsKey(depth)) {
          map.put(depth, treeNode.val);
        }
        stack.push(treeNode.left);
        stackDepth.push(depth + 1);
        stack.push(treeNode.right);
        stackDepth.push(depth + 1);
      }
    }
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < map.size(); i++) {
      ans.add(map.get(i));
    }
    return ans;
  }


}
