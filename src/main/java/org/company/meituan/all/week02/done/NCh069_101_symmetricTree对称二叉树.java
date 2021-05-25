package org.company.meituan.all.week02.done;

import java.util.LinkedList;
import org.TreeNode;

/**
 * <p>101. 对称二叉树
 * <p>给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 * <p>例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * <p>    1
 * <p>   / \
 * <p>  2   2
 * <p> / \ / \
 * <p>3  4 4  3
 *
 *
 * <p>但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * <p>    1
 * <p>   / \
 * <p>  2   2
 * <p>   \   \
 * <p>   3    3
 *
 *
 * <p>进阶：
 *
 * <p>你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>https://leetcode-cn.com/problems/symmetric-tree/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:34 下午
 */
public class NCh069_101_symmetricTree对称二叉树 {

  public static void main(String[] args) {
//    TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
//        new TreeNode(2, new TreeNode(4), new TreeNode(3)));
//    System.out.println(isSymmetric(treeNode));
  }

 /* public static boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    boolean lFlag = isSymmetric(root.left);
    boolean rFlag = isSymmetric(root.right);
    if (root.left == null && root.right != null || root.right == null && root.left != null) {
      return false;
    } else if (root.left == null && root.right == null && lFlag && rFlag) {
      return true;
    } else if (root.left.val == root.right.val && lFlag && rFlag) {
      return true;
    } else {
      return false;
    }
  }*/

  /**
   * 递归实现
   *
   * @param root
   * @return
   */
  public boolean isSymmetric_1(TreeNode root) {
    if (root == null) {
      return true;
    }
    //调用递归函数，比较左节点，右节点
    return dfs(root.left, root.right);
  }

  boolean dfs(TreeNode left, TreeNode right) {
    //递归的终止条件是两个节点都为空
    //或者两个节点中有一个为空
    //或者两个节点的值不相等
    if (left == null && right == null) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (left.val != right.val) {
      return false;
    }
    //再递归的比较 左节点的左孩子 和 右节点的右孩子
    //以及比较  左节点的右孩子 和 右节点的左孩子
    return dfs(left.left, right.right) && dfs(left.right, right.left);
  }

  /**
   * 队列实现 实现
   *
   * @param root
   * @return
   */
  public boolean isSymmetric_2(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return true;
    }
    //用队列保存节点
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    //将根节点的左右孩子放到队列中
    queue.add(root.left);
    queue.add(root.right);
    while (queue.size() > 0) {
      //从队列中取出两个节点，再比较这两个节点
      TreeNode left = queue.removeFirst();
      TreeNode right = queue.removeFirst();
      //如果两个节点都为空就继续循环，两者有一个为空就返回false
      if (left == null && right == null) {
        continue;
      }
      if (left == null || right == null) {
        return false;
      }
      if (left.val != right.val) {
        return false;
      }
      //将左节点的左孩子， 右节点的右孩子放入队列
      queue.add(left.left);
      queue.add(right.right);
      //将左节点的右孩子，右节点的左孩子放入队列
      queue.add(left.right);
      queue.add(right.left);
    }

    return true;
  }
}
