package org.company.meituan.all.week01.done;

import org.TreeNode;

/**
 * <p>226. 翻转二叉树
 *
 * <p>翻转一棵二叉树。
 *
 * <p>示例：
 *
 * <p>输入：
 *
 * <p>     4
 * <p>   /   \
 * <p>  2     7
 * <p> / \   / \
 * <p>1   3 6   9
 *
 * <p>输出：
 *
 * <p>     4
 * <p>   /   \
 * <p>  7     2
 * <p> / \   / \
 * <p>9   6 3   1
 *
 * <p>备注:
 * <p>这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * <p>    谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * <p>通过次数232,015
 * <p>提交次数296,081
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>@author: wangrui
 * <p>@date: 2021/5/10
 */
public class NCh037_226_InvertBinaryTree翻转二叉树 {

  /**
   * 仔细想想： 其实就是,每科树的左右子树进行调换，重复进行这么做
   *
   * @param root
   * @return
   */
  public TreeNode invertTree_self(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = root.left;
    root.left = invertTree_self(root.right);
    root.right = invertTree_self(left);
    return root;
  }

  //官方

  /**
   * <p> 复杂度分析
   *
   * <p> 时间复杂度：O(N)O(N)，其中 NN 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
   *
   * <p> 空间复杂度：O(N)O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。在平均情况下，二叉树的高度与节点个数为对数关系，即 O(\log N)O(logN)。而在最坏情况下，树形成链状，空间复杂度为
   * O(N)O(N)。
   *
   * @param root
   * @return
   */
  public TreeNode invertTree_1(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode left = invertTree_1(root.left);
    TreeNode right = invertTree_1(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

}
