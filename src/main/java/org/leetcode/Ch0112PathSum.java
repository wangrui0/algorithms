package org.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p> 定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * <p> 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * <p> 示例: 
 * <p> 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * <p>               5
 * <p>              / \
 * <p>             4   8
 * <p>            /   / \
 * <p>           11  13  4
 * <p>          /  \      \
 * <p>         7    2      1
 * <p> 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/path-sum
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/11/27
 */
public class Ch0112PathSum {

  /**
   * 方法一：广度优先搜索
   * <p>
   * 思路及算法
   * <p>
   * 首先我们可以想到使用广度优先搜索的方式，记录从根节点到当前节点的路径和，以防止重复计算。
   * <p>
   * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
   * <p>
   * =======================================================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
   * <p>
   * 空间复杂度：O(N)，其中 N 是树的节点数。空间复杂度主要取决于队列的开销，队列中的元素个数不会超过树的节点数。
   * <p>
   *
   * @param root
   * @param sum
   * @return
   */
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    Queue<TreeNode> queNode = new LinkedList<TreeNode>();
    Queue<Integer> queVal = new LinkedList<Integer>();
    queNode.offer(root);
    queVal.offer(root.val);
    while (!queNode.isEmpty()) {
      TreeNode now = queNode.poll();
      int temp = queVal.poll();
      if (now.left == null && now.right == null) {
        if (temp == sum) {
          return true;
        }
        continue;
      }
      if (now.left != null) {
        queNode.offer(now.left);
        queVal.offer(now.left.val + temp);
      }
      if (now.right != null) {
        queNode.offer(now.right);
        queVal.offer(now.right.val + temp);
      }
    }
    return false;
  }

  /**
   * 方法二：递归
   * <p>
   * 思路及算法
   * <p>
   * 观察要求我们完成的函数，我们可以归纳出它的功能：询问是否存在从当前节点 root 到叶子节点的路径，满足其路径和为 sum。
   * <p>
   * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
   * <p>
   * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可（因为路径和已经确定，就是当前节点的值，我们只需要判断该路径和是否满足条件）。
   * <p>
   * 若当前节点不是叶子节点，我们只需要递归地询问它的子节点是否能满足条件即可。
   * <p>
   * ====================================================================
   * <p>
   * 复杂度分析
   * <p>
   * 时间复杂度：O(N)，其中 N 是树的节点数。对每个节点访问一次。
   * <p>
   * 空间复杂度：O(H)，其中 H 是树的高度。空间复杂度主要取决于递归时栈空间的开销，最坏情况下，树呈现链状，空间复杂度为 O(N)。
   * <p>
   * 平均情况下树的高度与节点数的对数正相关，空间复杂度为 O(logN)。
   * <p>
   *
   * @param root
   * @param sum
   * @return
   */
  public boolean hasPathSum2(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }
    return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
  }

  public boolean hasPathSum3(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.val == sum;
    }
    return hasPathSum3(root.left, sum - root.val) || hasPathSum3(root.right, sum - root.val);
  }

  public boolean hasPathSum4(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> queueValue = new LinkedList<>();
    queue.offer(root);
    queueValue.offer(root.val);
    while (!queue.isEmpty()) {

      TreeNode poll = queue.poll();
      Integer pollValue = queueValue.poll();

      if (poll.left == null && poll.right == null) {
        if (pollValue == sum) {
          return true;
        }
        continue;
      } else if (poll.left != null) {
        queue.offer(poll.left);
        queueValue.offer(poll.left.val+pollValue);
      } else {
        queue.offer(poll.right);
        queueValue.offer(poll.right.val+pollValue);
      }
    }
    return false;
  }

}
