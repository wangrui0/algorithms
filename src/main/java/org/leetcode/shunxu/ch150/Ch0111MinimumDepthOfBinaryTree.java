package org.leetcode.shunxu.ch150;

import java.util.LinkedList;
import java.util.Queue;
import org.leetcode.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/26
 */
public class Ch0111MinimumDepthOfBinaryTree {

  public static void main(String[] args) {

  }

  /**
   * 方法一：深度优先搜索
   * <p>
   * 思路及解法
   * <p>
   * 首先可以想到使用深度优先搜索的方法，遍历整棵树，记录最小深度。
   * <p>
   * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题。
   * <p>
   * =====================================================
   * <p>
   * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
   * <p>
   * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
   * <p>
   * 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
   * <p>
   *
   * @param root
   * @return
   */
  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    int min_depth = Integer.MAX_VALUE;
    if (root.left != null) {
      min_depth = Math.min(minDepth(root.left), min_depth);
    }
    if (root.right != null) {
      min_depth = Math.min(minDepth(root.right), min_depth);
    }

    return min_depth + 1;
  }

  class QueueNode {

    TreeNode node;

    public int depth;

    public QueueNode(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }
  }

  /**
   * 方法二：广度优先搜索
   * <p>
   * 思路及解法
   * <p>
   * 同样，我们可以想到使用广度优先搜索的方法，遍历整棵树。
   * <p>
   * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
   * <p>
   * ========================================================== 复杂度分析
   * <p>
   * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
   * <p>
   * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
   * <p>
   *
   * @param root
   * @return
   */
  public int minDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<QueueNode> queue = new LinkedList<QueueNode>();
    queue.offer(new QueueNode(root, 1));
    while (!queue.isEmpty()) {
      QueueNode nodeDepth = queue.poll();
      TreeNode node = nodeDepth.node;
      int depth = nodeDepth.depth;
      if (node.left == null && node.right == null) {
        return depth;
      }
      if (node.left != null) {
        queue.offer(new QueueNode(node.left, depth + 1));
      }
      if (node.right != null) {
        queue.offer(new QueueNode(node.right, depth + 1));
      }
    }

    return 0;
  }

  /**
   * 广度优先遍历
   *
   * @param root
   * @return
   */
  public int minDepth3(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<QueueNode> treeNodes = new LinkedList<>();
    treeNodes.offer(new QueueNode(root, 1));
    while (!treeNodes.isEmpty()) {
      QueueNode poll = treeNodes.poll();
      int depth = poll.depth;
      TreeNode node = poll.node;
      if (node.left == null && node.right == null) {
        return depth;
      }
      if (node.left != null) {
        treeNodes.offer(new QueueNode(node.left, depth + 1));
      }

      if (node.right != null) {
        treeNodes.offer(new QueueNode(node.right, depth + 1));
      }
    }
    return 0;
  }
}
