package org.leetcode.shunxu.ch700;

import org.TreeNode;

/**
 * <p>671. 二叉树中第二小的节点
 * <p>给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * <p>更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * <p>给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 *
 *
 * <p>示例 1：
 *
 *
 * <p>输入：root = [2,2,5,null,null,5,7]
 * <p>输出：5
 * <p>解释：最小的值是 2 ，第二小的值是 5 。
 * <p>示例 2：
 *
 *
 * <p>输入：root = [2,2,2]
 * <p>输出：-1
 * <p>解释：最小的值是 2, 但是不存在第二小的值。
 *
 *
 * <p>提示：
 *
 * <p>树中节点数目在范围 [1, 25] 内
 * <p>1 <= Node.val <= 231 - 1
 * <p>对于树中每个节点 root.val == min(root.left.val, root.right.val)
 * <p>通过次数22,418提交次数48,452
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/18 11:24 下午
 */
public class NCh671SecondMinimumNodeInABinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        return 1;
    }
}
