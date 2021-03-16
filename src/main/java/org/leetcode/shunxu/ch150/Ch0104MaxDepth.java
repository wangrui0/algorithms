package org.leetcode.shunxu.ch150;

import java.util.LinkedList;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * <p>     3
 * <p>    / \
 * <p>   9  20
 * <p>     /  \
 * <p>    15   7
 * <p> 返回它的最大深度 3 。
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/14
 */
public class Ch0104MaxDepth {
  /**
   * <p>
   * 方法一：递归
   * <p>
   * 思路与算法
   * <p>
   * 如果我们知道了左子树和右子树的最大深度 l 和 r，那么该二叉树的最大深度即为
   * <p>
   * max(l,r)+1
   * <p>
   * 而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，
   * <p>
   * 然后在 O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出。
   * <p>
   * =====================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。每个节点在递归中只被遍历一次。
   * <p>
   * 空间复杂度：O(height)，其中 height 表示二叉树的高度。递归函数需要栈空间，而栈空间取决于递归的深度，因此空间复杂度等价于二叉树的高度。
   * <p>
   *
   * @param root
   * @return
   */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int leftHeight = maxDepth(root.left);
      int rightHeight = maxDepth(root.right);
      return Math.max(leftHeight, rightHeight) + 1;
    }
  }

  /**
   * 方法二：广度优先搜索
   * <p>
   * 思路与算法
   * <p>
   * 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。
   * <p>
   * 每次拓展下一层的时候，不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
   * <p>
   * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，最后我们用一个变量
   * <p>
   * ans 来维护拓展的次数，该二叉树的最大深度即为 ans。
   * <p>
   * ==============================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(n)，其中 n 为二叉树的节点个数。与方法一同样的分析，每个节点只会被访问一次。
   * <p>
   * 空间复杂度：此方法空间的消耗取决于队列存储的元素数量，其在最坏情况下会达到 O(n)。
   *
   * @param root
   * @return
   */
  public int maxDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
  }
}
