package org.leetcode.leet500.ch300;

import org.TreeNode;

/**
 * <p>给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * <p> 注意：
 *
 * <p> 给定的目标值 target 是一个浮点数
 * <p> 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 * <p> 示例：
 *
 * <p> 输入: root = [4,2,5,1,3]，目标值 target = 3.714286
 *
 * <p>     4
 * <p>    / \
 * <p>   2   5
 * <p>  / \
 * <p> 1   3
 *
 * <p> 输出: 4
 *
 * @author: wangrui
 * @date: 2021/2/18
 */
public class Ch0270ClosestValue {

  /**
   *  本题的难以处理的点是：目标值为浮点数
   *
   *   如果知道这么一个前提就好求解了：两个不同数据类型相加减，较短长度的会自动上升到和另一个一样长度的类型。
   *
   *   例如：int 类型的 a 减去 double 类型的 b，会先把 a 上升为 double，然后再相减，返回 double 的结果。
   *
   *   看到二叉树就得想到树的遍历有两种：迭代和递归。
   *
   *   本题是二叉搜索树，每一个根节点都大于它的左子节点并且小于它的右子结点（如果存在子结点的话）。
   *
   *   定义变量 closest 表示当前最接近的值，curVal 表示遍历到的节点的值，从根节点开始遍历：
   *
   *   1、如果 curVal - target 的绝对值小于 closest - target 的绝对值，说明 curVal 更接近，于是更新 closest = curVal；否则保持原样；
   *
   *   2、接着遍历子树，看是否有更接近的值。如果 target < root.val ，则去遍历左子树，反之遍历右子树。
   * @param root
   * @param target
   * @return
   */
  public int closestValue(TreeNode root, double target) {
    int closest = root.val;
    int curVal;
    while (root != null) {
      curVal = root.val;
      closest = Math.abs(curVal - target) < Math.abs(closest - target) ? curVal : closest;
      root = target < root.val ? root.left : root.right;
    }
    return closest;
  }
}
