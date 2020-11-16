package org.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.leetcode.TreeNode;

/**
 * <p>       1
 * <p>      / \
 * <p>     2   3
 * <p>    / \ / \
 * <p>   4  5 6  7
 * <p>  /    \    \
 * <p> 8      9   10
 * @author: wangrui
 * @date: 2020/11/16
 */
public class Ch001ChengXuDFS {
  public static List<TreeNode> chengXu(TreeNode treeNode) {

    if (treeNode == null) {
      return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList();
    queue.offer(treeNode);

    List<TreeNode> result = new ArrayList<>();

    while (!queue.isEmpty()) {

      int size = queue.size();

      while (size > 0) {

        TreeNode poll = queue.poll();
        result.add(poll);

        if (poll.left != null) {
          queue.offer(poll.left);
        }

        if (poll.right != null) {
          queue.offer(poll.right);
        }
        size--;
      }
    }
    return result;
  }
}
