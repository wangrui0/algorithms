package org.leetcode.shunxu.ch600;

import org.TreeNode;

/**
 * <p>
 * <p> 563. 二叉树的坡度
 * <p>
 * <p> 给定一个二叉树，计算 整个树 的坡度 。
 * <p>
 * <p> 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，
 * <p>左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 * <p>
 * <p> 整个树 的坡度就是其所有节点的坡度之和。
 * <p>
 * <p>
 * <p>
 * <p> 示例 1：
 * <p>
 * <p> 输入：root = [1,2,3]
 * <p> 输出：1
 * <p> 解释：
 * <p> 节点 2 的坡度：|0-0| = 0（没有子节点）
 * <p> 节点 3 的坡度：|0-0| = 0（没有子节点）
 * <p> 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * <p> 坡度总和：0 + 0 + 1 = 1
 * <p>
 * <p> 示例 2：
 * <p>
 * <p> 输入：root = [4,2,9,3,5,null,7]
 * <p> 输出：15
 * <p> 解释：
 * <p> 节点 3 的坡度：|0-0| = 0（没有子节点）
 * <p> 节点 5 的坡度：|0-0| = 0（没有子节点）
 * <p> 节点 7 的坡度：|0-0| = 0（没有子节点）
 * <p> 节点 2 的坡度：|3-5| = 2（左子树就是左子节点，所以和是 3 ；右子树就是右子节点，所以和是 5 ）
 * <p> 节点 9 的坡度：|0-7| = 7（没有左子树，所以和是 0 ；右子树正好是右子节点，所以和是 7 ）
 * <p> 节点 4 的坡度：|(3+5+2)-(9+7)| = |10-16| = 6（左子树值为 3、5 和 2 ，和是 10 ；右子树值为 9 和 7 ，和是 16 ）
 * <p> 坡度总和：0 + 0 + 0 + 2 + 7 + 6 = 15
 * <p>
 * <p> 示例 3：
 * <p>
 * <p> 输入：root = [21,7,14,1,1,2,2,3,3]
 * <p> 输出：9
 * <p>
 * <p>
 * <p>
 * <p> 提示：
 * <p>
 * <p>     树中节点数目的范围在 [0, 104] 内
 * <p>     -1000 <= Node.val <= 1000
 * <p>
 *
 * <p> 通过次数24,522
 * <p> 提交次数41,672
 * <p> 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/binary-tree-tilt/
 * <p> @author: wangrui
 * <p> @date: 2021/3/17
 */
public class Ch563BinaryTreeTilt {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }

    /**
     * 递归函数 traverse，在任何结点调用该函数，都会返回当前结点下面（包括其自身）的结点和
     *
     * @param root
     * @return
     */
    public int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = traverse(root.left);
        int right = traverse(root.right);
        tilt += Math.abs(left - right);

        return left + right + root.val;
    }

}
