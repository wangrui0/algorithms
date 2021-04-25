package org.leetcode.leet1000.ch800;


import org.TreeNode;

/**
 * <p>783. 二叉搜索树节点最小距离
 *
 * <p>给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入: root = [4,2,6,1,3,null,null]
 * <p>输出: 1
 * <p>解释:
 * <p>注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * <p>给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 * <p>          4
 * <p>        /   \
 * <p>      2      6
 * <p>     / \
 * <p>    1   3
 *
 * <p>最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 *
 *
 * <p>注意：
 *
 * <p>    二叉树的大小范围在 2 到 100。
 * <p>    二叉树总是有效的，每个节点的值都是整数，且不重复。
 * <p>    本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * <p>通过次数26,328
 * <p>提交次数46,733
 * <p>https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>@author: wangrui
 * <p>@date: 2021/3/26
 */
public class Ch783MinimumDistanceBetweenBstNodes {

  int pre;
  int ans;

  /**
   * <p>复杂度分析
   *
   * <p>   时间复杂度：O(n)，其中 n 为二叉搜索树节点的个数。每个节点在中序遍历中都会被访问一次且只会被访问一次，因此总时间复杂度为 O(n)。
   *
   * <p> 空间复杂度：O(n)。递归函数的空间复杂度取决于递归的栈深度，而栈深度在二叉搜索树为一条链的情况下会达到 O(n) 级别。
   *
   * @param root
   * @return
   */
  public int getMinimumDifference(TreeNode root) {
    ans = Integer.MAX_VALUE;
    pre = -1;
    dfs(root);
    return ans;
  }

  public void dfs(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root.left);
    if (pre == -1) {
      pre = root.val;
    } else {
      ans = Math.min(ans, root.val - pre);
      pre = root.val;
    }
    dfs(root.right);
  }
}
