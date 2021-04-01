package org.leetcode.shunxu.ch950;

import java.util.Stack;
import org.TreeNode;

/**
 * <p>938. 二叉搜索树的范围和
 *
 * <p>给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * <p>输出：32
 *
 * <p>示例 2：
 *
 * <p>输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * <p>输出：23
 *
 *
 *
 * <p>提示：
 *
 * <p>    树中节点数目在范围 [1, 2 *<p>104] 内
 * <p>    1 <= Node.val <= 105
 * <p>    1 <= low <= high <= 105
 * <p>    所有 Node.val 互不相同
 *
 * <p>通过次数46,430
 * <p>提交次数59,506
 * <p>@author: wangrui
 * <p>@date: 2021/4/1
 */
public class Ch938RangeSumOfBst {

  int ans = 0;

  /**
   * <p> 复杂度分析
   *
   * <p>     时间复杂度：O(N)，其中 N 是树中的节点数目。
   *
   * <p>     空间复杂度：O(H)，其中 H 是树的高度。
   *
   * @param root
   * @param L
   * @param R
   * @return
   */
  public int rangeSumBST(TreeNode root, int L, int R) {
    dfs(root, L, R);
    return ans;
  }

  public void dfs(TreeNode node, int L, int R) {
    if (node != null) {
      if (L <= node.val && node.val <= R) {
        ans += node.val;
      }
      if (L < node.val) {
        dfs(node.left, L, R);
      }
      if (node.val < R) {
        dfs(node.right, L, R);
      }
    }
  }


  public int rangeSumBST_2(TreeNode root, int L, int R) {
    int ans = 0;
    Stack<TreeNode> stack = new Stack();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node != null) {
        if (L <= node.val && node.val <= R) {
          ans += node.val;
        }
        if (L < node.val) {
          stack.push(node.left);
        }
        if (node.val < R) {
          stack.push(node.right);
        }
      }
    }
    return ans;
  }


}
