package org.leetcode.leet500.ch250;

import org.TreeNode;

/**
 * <p> 226. 翻转二叉树
 *
 * <p> 翻转一棵二叉树。
 *
 * <p> 示例：
 *
 * <p> 输入：
 *
 * <p>      4
 * <p>    /   \
 * <p>   2     7
 * <p>  / \   / \
 * <p> 1   3 6   9
 *
 * <p> 输出：
 *
 * <p>      4
 * <p>    /   \
 * <p>   7     2
 * <p>  / \   / \
 * <p> 9   6 3   1
 *
 * <p> 备注:
 * <p> 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * <p>     谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * <p> 通过次数181,922
 * <p> 提交次数233,586
 * <p> 在真实的面试中遇到过这道题？ https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author: wangrui
 * @date: 2021/1/25
 */
public class Ch0226InvertBinaryTree {


  /**
   * 时间复杂度：O(N)，其中 N 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
   * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(log⁡N)O(\log N)O(logN)。而在最坏情况下，树形成链状，空间复杂度为 O(N)。
   *
   * 作者：LeetCode-Solution
   * 链接：https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode-solution/
   * 来源：力扣（LeetCode）
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   * @param root
   * @return
   */
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left
    ;
    return root;
  }

}
