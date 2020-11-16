package org.tree;

import java.util.ArrayList;
import java.util.List;
import org.leetcode.TreeNode;

/**
 * 中序的规则就是  左子树-->根结点 ---> 右子树.
 * <p>       1
 * <p>      / \
 * <p>     2   3
 * <p>    / \ / \
 * <p>   4  5 6  7
 * <p>  /    \    \
 * <p> 8      9   10
 * <p>
 * <p>前序结果：
 * <p>8 4 2 5 9 1 6 3 7 10
 *
 * @author: wangrui
 * @date: 2020/11/16
 */
public class Ch003ZhongXuDFS {

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

    List<TreeNode> treeNodes = zhongXu(treeNode1);
    for (TreeNode treeNode : treeNodes) {
      System.out.println(treeNode.val);
    }
  }

  public static List<TreeNode> zhongXu(TreeNode treeNode) {
    if (treeNode == null) {
      return null;
    }
    zhongXu(treeNode.left);

    result.add(treeNode);

    zhongXu(treeNode.right);

    return result;
  }

}
