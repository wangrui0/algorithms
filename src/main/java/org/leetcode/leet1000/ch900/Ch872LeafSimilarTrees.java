package org.leetcode.leet1000.ch900;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.TreeNode;

/**
 * <p>872. 叶子相似的树
 *
 * <p>请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * <p>举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * <p>如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * <p>如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * <p>输出：true
 *
 * <p>示例 2：
 *
 * <p>输入：root1 = [1], root2 = [1]
 * <p>输出：true
 *
 * <p>示例 3：
 *
 * <p>输入：root1 = [1], root2 = [2]
 * <p>输出：false
 *
 * <p>示例 4：
 *
 * <p>输入：root1 = [1,2], root2 = [2,2]
 * <p>输出：true
 *
 * <p>示例 5：
 *
 * <p>输入：root1 = [1,2,3], root2 = [1,3,2]
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    给定的两棵树可能会有 1 到 200 个结点。
 * <p>    给定的两棵树上的值介于 0 到 200 之间。
 * <p> https://leetcode-cn.com/problems/leaf-similar-trees/
 * <p>通过次数24,171
 * <p>提交次数38,569
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/23
 */
public class Ch872LeafSimilarTrees {

  /**
   * <p> 复杂度分析
   *
   * <p>   时间复杂度：O(T1​+T2​)，其中 T1,T2​ 是给定的树的长度。
   *
   * <p>    空间复杂度：O(T1​+T2​)，存储叶值所使用的空间。
   *
   * @param root1
   * @param root2
   * @return
   */
  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> leaves1 = new ArrayList();
    List<Integer> leaves2 = new ArrayList();
    dfs(root1, leaves1);
    dfs(root2, leaves2);
    return leaves1.equals(leaves2);
  }

  public void dfs(TreeNode node, List<Integer> leafValues) {
    if (node != null) {
      if (node.left == null && node.right == null) {
        leafValues.add(node.val);
      }
      dfs(node.left, leafValues);
      dfs(node.right, leafValues);
    }
  }

  /**
   * 程序遍历是不行的。要采用深度遍历
   * @param node
   * @param leafValues
   */
  //[3,5,1,6,2,9,8,null,null,7,4]
  //[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
  public void dfs2(TreeNode node, List<Integer> leafValues) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      TreeNode poll = queue.poll();
      if (poll == null) {
        continue;
      }
      if (poll.left == null && poll.right == null) {
        leafValues.add(poll.val);
      }
      queue.add(poll.left);
      queue.add(poll.right);
    }
  }
}


