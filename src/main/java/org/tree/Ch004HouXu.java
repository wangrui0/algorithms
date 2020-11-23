package org.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
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
public class Ch004HouXu {

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

    List<TreeNode> result = new ArrayList<>();
    if (treeNode == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    Map<TreeNode, Integer> map = new HashMap<>();

    while (!stack.isEmpty() || treeNode != null) {
      if (treeNode != null) {
        stack.push(treeNode);
        map.put(treeNode, 1);
        treeNode = treeNode.left;
      } else {
        treeNode = stack.peek();
        if (map.get(treeNode) == 2) {
          stack.pop();
          result.add(treeNode);
          treeNode = null;
        } else {
          map.put(treeNode,2);
          treeNode=treeNode.right;
        }
      }
    }
    return result;
  }


  public static List<TreeNode> houXu2(TreeNode treeNode) {
    List<TreeNode> result = new ArrayList<>();

    Stack<TreeNode> q1 = new Stack();
    Stack<TreeNode> q2 = new Stack();
    if (treeNode == null) {
      return result;
    }
    if (treeNode != null) {
      q1.push(treeNode);
    }
    while (!q1.isEmpty()) {
      TreeNode t1 = q1.pop();
      q2.push(t1);
      if (t1.left != null) {
        q1.push(t1.left);
      }
      if (t1.right != null) {
        q1.push(t1.right);
      }
    }
    while (!q2.isEmpty()) {
      TreeNode t1 = q2.pop();
//        System.out.print(t1.value + " ");
    }
    return result;
  }
}
