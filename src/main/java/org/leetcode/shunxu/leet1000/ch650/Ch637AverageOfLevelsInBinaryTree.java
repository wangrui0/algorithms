package org.leetcode.shunxu.leet1000.ch650;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>637. 二叉树的层平均值
 * <p>给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：
 * <p>    3
 * <p>   / \
 * <p>  9  20
 * <p>   /  \
 * <p>   15   7
 * <p>输出：[3, 14.5, 11]
 * <p> 解释：
 * <p>第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 *
 * <p>提示：
 *
 * <p> 节点值的范围在32位有符号整数范围内。
 * <p>https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:29 下午
 */
public class Ch637AverageOfLevelsInBinaryTree {

  /**
   * <P>复杂度分析
   *
   * <P>  时间复杂度：O(n)，其中 n 是二叉树中的节点个数。
   * <P>  深度优先搜索需要对每个节点访问一次，对于每个节点，维护两个数组的时间复杂度都是 O(1)，因此深度优先搜索的时间复杂度是 O(n)。
   * <P>  遍历结束之后计算每层的平均值的时间复杂度是 O(h)，其中 h 是二叉树的高度，任何情况下都满足 h≤n。
   * <P> 因此总时间复杂度是 O(n)。
   *
   * <P>空间复杂度：O(n)，其中 n 是二叉树中的节点个数。空间复杂度取决于两个数组的大小和递归调用的层数，两个数组的大小都等于二叉树的高度，递归调用的层数不会超过二叉树的高度，最坏情况下，二叉树的高度等于节点个数。
   *
   * <P>作者：LeetCode-Solution
   * <P>链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/er-cha-shu-de-ceng-ping-jun-zhi-by-leetcode-soluti/
   * <P>来源：力扣（LeetCode）
   * <P>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<Double> averageOfLevels(TreeNode root) {
    List<Integer> counts = new ArrayList<Integer>();
    List<Double> sums = new ArrayList<Double>();
    dfs(root, 0, counts, sums);
    List<Double> averages = new ArrayList<Double>();
    int size = sums.size();
    for (int i = 0; i < size; i++) {
      averages.add(sums.get(i) / counts.get(i));
    }
    return averages;
  }

  public void dfs(TreeNode root, int level, List<Integer> counts, List<Double> sums) {
    if (root == null) {
      return;
    }
    if (level < sums.size()) {
      sums.set(level, sums.get(level) + root.val);
      counts.set(level, counts.get(level) + 1);
    } else {
      sums.add(1.0 * root.val);
      counts.add(1);
    }
    dfs(root.left, level + 1, counts, sums);
    dfs(root.right, level + 1, counts, sums);
  }

  /**
   * <P>复杂度分析
   *
   * <P>    时间复杂度：O(n)，其中 n 是二叉树中的节点个数。
   * <P> 广度优先搜索需要对每个节点访问一次，时间复杂度是 O(n)。
   * <P>需要对二叉树的每一层计算平均值，时间复杂度是 O(h)，其中 h 是二叉树的高度，任何情况下都满足 h≤n。
   * <P>因此总时间复杂度是 O(n)。
   *
   * <P>空间复杂度：O(n)，其中 nnn 是二叉树中的节点个数。空间复杂度取决于队列开销，队列中的节点个数不会超过 n。
   *
   * <P>作者：LeetCode-Solution
   * <P>链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/solution/er-cha-shu-de-ceng-ping-jun-zhi-by-leetcode-soluti/
   * <P>来源：力扣（LeetCode）
   * <P>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param root
   * @return
   */
  public List<Double> averageOfLevels2(TreeNode root) {
    List<Double> averages = new ArrayList<Double>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      double sum = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        TreeNode left = node.left, right = node.right;
        if (left != null) {
          queue.offer(left);
        }
        if (right != null) {
          queue.offer(right);
        }
      }
      averages.add(sum / size);
    }
    return averages;
  }
}

