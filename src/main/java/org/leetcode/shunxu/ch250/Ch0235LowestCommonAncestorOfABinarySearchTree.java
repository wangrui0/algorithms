package org.leetcode.shunxu.ch250;

import org.leetcode.TreeNode;

/**
 * <p> 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p> 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * <p> 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>        6
 * <p>       / \
 * <p>      2   8
 * <p>     /\  /\
 * <p>    0 4 7  9
 * <p>     /\
 * <p>    3  5
 * <p> 示例 1:
 *
 * <p> 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <p> 输出: 6
 * <p> 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * <p> 示例 2:
 *
 * <p> 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <p> 输出: 2
 * <p> 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 *
 *
 * <p> 说明:
 *
 * <p>     所有节点的值都是唯一的。
 * <p>     p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * <p> 通过次数119,936
 * <p> 提交次数181,729
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2021/1/27
 */
public class Ch0235LowestCommonAncestorOfABinarySearchTree {


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (p.val < ancestor.val && q.val < ancestor.val) {
        ancestor = ancestor.left;
      } else if (p.val > ancestor.val && q.val > ancestor.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }
    return ancestor;
  }

  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestor = root;
    while (true) {
      if (p.val < ancestor.val && q.val < ancestor.val) {
        ancestor = ancestor.left;
      } else if (p.val > ancestor.val && q.val > ancestor.val) {
        ancestor = ancestor.right;
      } else {
        break;
      }
    }
    return ancestor;
  }
}
