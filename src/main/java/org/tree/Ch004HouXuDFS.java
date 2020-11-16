package org.tree;

import java.util.ArrayList;
import java.util.List;
import org.leetcode.TreeNode;

/**
 * 后序的规则就是  左子树-->右子树--->根结点
 * <p>       1
 * <p>      / \
 * <p>     2   3
 * <p>    / \ / \
 * <p>   4  5 6  7
 * <p>  /    \    \
 * <p> 8      9   10
 * <p>
 * <p>后序结果：
 * <p>8 4 9  5 2 6 10 7 3 1
 * 从上面的代码中可以看到，树的前中后序遍历代码结构基本相同，
 * <p>
 * 差距只要在何时输出根值，前序遍历一遍历到节点时，先输出根值，
 * <p>
 * 中序是遍历完左子节点，后序是最后才输出
 *
 * @author: wangrui
 * @date: 2020/11/16
 */
public class Ch004HouXuDFS {

  static List<TreeNode> result = new ArrayList<>();

  static TreeNode treeNode1;

  static {
    treeNode1 = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);
    TreeNode treeNode8 = new TreeNode(8);
    TreeNode treeNode9 = new TreeNode(9);
    TreeNode treeNode10 = new TreeNode(10);

    treeNode1.left = treeNode2;
    treeNode1.right = treeNode3;
    treeNode2.left = treeNode4;
    treeNode2.right = treeNode5;
    treeNode3.left = treeNode6;
    treeNode3.right = treeNode7;
    treeNode4.left = treeNode8;
    treeNode5.right = treeNode9;
    treeNode7.right = treeNode10;
  }

  public static void main(String[] args) {

    List<TreeNode> treeNodes = houXu(treeNode1);
    for (TreeNode treeNode : treeNodes) {
      System.out.println(treeNode.val);
    }
  }

  public static List<TreeNode> houXu(TreeNode treeNode) {
    if (treeNode == null) {
      return null;
    }
    houXu(treeNode.left);

    houXu(treeNode.right);

    result.add(treeNode);

    return result;
  }
}
