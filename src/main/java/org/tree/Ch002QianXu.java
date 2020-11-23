package org.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.leetcode.TreeNode;

/**
 * 前序的规则就是根结点 ---> 左子树 ---> 右子树.
 * <p>       1
 * <p>      / \
 * <p>     2   3
 * <p>    / \ / \
 * <p>   4  5 6  7
 * <p>  /    \    \
 * <p> 8      9   10
 * <p>
 * <p>前序结果：
 * <p>1 2 4 8 5 9 3 6 7 10
 *
 * @author: wangrui
 * @date: 2020/11/16
 */
public class Ch002QianXu {
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

    List<TreeNode> treeNodes = qianXu(treeNode1);
    for (TreeNode treeNode : treeNodes) {
      System.out.println(treeNode.val);
    }
  }
  /**
   * 非递归的前序。我们利用栈的性质替代递归，因为递归有时候在效率方面不是令人满意的。 利用栈，我们知道到栈的顺序为后进先出。那么顺序如何添加？递归是左递归，右递归。但是利用栈要相反，因为如果左进栈、右进栈会出现以下后果：
   *
   * @param treeNode
   * @return
   */
  public static List<TreeNode> qianXu(TreeNode treeNode) {
    List<TreeNode> result = new ArrayList<>();
    if (treeNode == null) {
      return result;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(treeNode);

    while (!stack.isEmpty()) {
      TreeNode pop = stack.pop();
      result.add(pop);

      if (pop.right != null) {
        stack.push(pop.right);
      }

      if (pop.left != null) {
        stack.push(pop.left);
      }

    }
    return result;
  }

}
