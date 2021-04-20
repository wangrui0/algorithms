package org.leetcode.shunxu.leet1000.ch600;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;
import org.Node;

/**
 * <p>559. N 叉树的最大深度
 * <p>给定一个 N 叉树，找到其最大深度。
 *
 * <p>最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * <p>N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *
 *
 * <p>示例 1：
 *
 *
 *
 * <p>输入：root = [1,null,3,2,4,null,5,6]
 * <p>输出：3
 * <p>示例 2：
 *
 *
 *
 *
 * <p>输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * <p>输出：5
 *
 *
 * <p>提示：
 *
 * <p>树的深度不会超过 1000 。
 * <p>树的节点数目位于 [0, 104] 之间。
 * <p>通过次数44,849提交次数62,644
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/15 8:07 下午
 */
public class Ch559MaximumDepthOfNAryTree {

  /**
   * slef
   *
   * @param root
   * @return
   */
  public int maxDepth(Node root) {
    if (root == null) {
      return 0;
    }
    Queue<Pair<Node, Integer>> queue = new LinkedList<Pair<Node, Integer>>();
    queue.add(new Pair(root, 1));
    int depth = 0;
    while (!queue.isEmpty()) {
      Pair<Node, Integer> poll = queue.poll();
      root = poll.getKey();
      int val = poll.getValue();
      if (root != null) {
        depth = Math.max(depth, val);
        for (Node node : root.children) {
          queue.add(new Pair(node, val + 1));
        }
      }
    }
    return depth;
  }

  /**
   * <p>复杂度分析
   *
   * <p> 时间复杂度：每个节点遍历一次，所以时间复杂度是O(N)，其中 N 为节点数。
   *
   * <p> 空间复杂度：最坏情况下, 树完全非平衡，
   * <p>例如 每个节点有且仅有一个孩子节点，递归调用会发生 N 次（等于树的深度），所以存储调用栈需要 O(N)。
   * <p>但是在最好情况下（树完全平衡），树的高度为 log(N)。
   * <p>所以在此情况下空间复杂度为 O(log(N))。
   *
   * @param root
   * @return
   */
  public int maxDepth2(Node root) {
    if (root == null) {
      return 0;
    } else if (root.children.isEmpty()) {
      return 1;
    } else {
      List<Integer> heights = new LinkedList<>();
      for (Node item : root.children) {
        heights.add(maxDepth(item));
      }
      return Collections.max(heights) + 1;
    }
  }

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(N)。
   * <p>   空间复杂度：O(N)。
   *
   * @param root
   * @return
   */
  public int maxDepth3(Node root) {
    Queue<Pair<Node, Integer>> queue = new LinkedList<>();
    if (root != null) {
      queue.add(new Pair(root, 1));
    }

    int depth = 0;
    while (!queue.isEmpty()) {
      Pair<Node, Integer> current = queue.poll();
      root = current.getKey();
      int currentDepth = current.getValue();
      if (root != null) {
        depth = Math.max(depth, currentDepth);
        for (Node c : root.children) {
          queue.add(new Pair(c, currentDepth + 1));
        }
      }
    }
    return depth;
  }
}

