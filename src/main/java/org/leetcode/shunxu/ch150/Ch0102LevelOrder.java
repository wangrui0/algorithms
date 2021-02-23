package org.leetcode.shunxu.ch150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.leetcode.TreeNode;

/**
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 示例：
 * <p>
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * <p>     3
 * <p>    / \
 * <p>   9  20
 * <p>     /  \
 * <p>    15   7
 * <p> 返回其层次遍历结果：
 * <p> [
 * <p>   [3],
 * <p>   [9,20],
 * <p>   [15,7]
 * <p> ]
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 *
 * @author: wangrui
 * @date: 2020/11/14
 */
public class Ch0102LevelOrder {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> list = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode treeNode = queue.poll();
        list.add(treeNode.val);
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
      result.add(list);


    }
    return result;
  }

  /**
   * 方法一：广度优先搜索
   * <p>
   * 思路和算法
   * <p>
   * 我们可以用广度优先搜索解决这个问题。
   * <p>
   * 我们可以想到最朴素的方法是用一个二元组 (node, level) 来表示状态，它表示某个节点和它所在的层数，每个新进队列的节点的 level 值都是父亲节点的 level 值加一。最后根据每个点的 level
   * <p>
   * 对点进行分类，分类的时候我们可以利用哈希表，维护一个以 level 为键，对应节点值组成的数组为值，广度优先搜索结束以后按键 level 从小到大取出所有值，组成答案返回即可。
   * <p>
   * 考虑如何优化空间开销：如何不用哈希映射，并且只用一个变量 node 表示状态，实现这个功能呢？
   * <p>
   * 我们可以用一种巧妙的方法修改 BFS：
   * <p>
   * 首先根元素入队
   * <p>
   * 当队列不为空的时候
   * <p>
   * 求当前队列的长度 s_i
   * <p>
   * 依次从队列中取 s_i 个元素进行拓展，然后进入下一次迭代
   * <p>
   * 它和 BFS 的区别在于 BFS 每次只取一个元素拓展，而这里每次取 s_i 个元素。在上述过程中的第 i次迭代就得到了二叉树的第 i 层的 s_i 个元素。
   * <p>
   * 为什么这么做是对的呢？我们观察这个算法，可以归纳出这样的循环不变式：第 i 次迭代前，队列中的所有元素就是第 i 层的所有元素，并且按照从左向右的顺序排列。证明它的三条性质（你也可以把它理解成数学归纳法）：
   * <p>
   * 初始化：i=1 的时候，队列里面只有 root，是唯一的层数为 1 的元素，因为只有一个元素，所以也显然满足「从左向右排列」；
   * <p>
   * 保持：如果 i=k 时性质成立，即第 k 轮中出队 s_k​ 的元素是第 k 层的所有元素，并且顺序从左到右。因为对树进行 BFS 的时候由低 k 层的点拓展出的点一定也只能是 k+1
   * <p>
   * 层的点，并且 k+1 层的点只能由第 k 层的点拓展到，所以由这 s_k​ 个点能拓展到下一层所有的 s_k +1 个点。又因为队列的先进先出（FIFO）特性，既然第
   * <p>
   * kkk 层的点的出队顺序是从左向右，那么第 k+1 层也一定是从左向右。至此，我们已经可以通过数学归纳法证明循环不变式的正确性。
   * <p>
   * 终止：因为该循环不变式是正确的，所以按照这个方法迭代之后每次迭代得到的也就是当前层的层次遍历结果。至此，我们证明了算法是正确的。
   * <p>
   * =========================================
   * <p>
   * 复杂度分析
   * <p>
   * 记树上所有节点的个数为 n。
   * <p>
   * 时间复杂度：每个点进队出队各一次，故渐进时间复杂度为 O(n)。
   * <p>
   * 空间复杂度：队列中元素的个数不超过 n 个，故渐进空间复杂度为 O(n)。
   * <p>
   *
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
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
