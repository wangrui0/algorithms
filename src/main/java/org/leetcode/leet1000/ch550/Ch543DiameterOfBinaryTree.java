package org.leetcode.leet1000.ch550;

import org.TreeNode;

/**
 * <p>543. 二叉树的直径
 * <p>给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>示例 :
 * <p>给定二叉树
 *
 * <p>           1
 * <p>          / \
 * <p>         2   3
 * <p>        / \
 * <p>       4   5
 * <p> 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 *
 *
 *
 * <p> 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *git
 * <p> 通过次数98,755提交次数188,416
 * <p> https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * @Author: shenpei
 * @Date: 2021/3/15 8:09 下午
 */
public class Ch543DiameterOfBinaryTree {
    int ans;

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N)，其中 N 为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
     *
     * <p>空间复杂度：O(Height)，其中 Height 为二叉树的高度。由于递归函数在递归过程中需要为每一层递归函数分配栈空间，所以这里需要额外的空间且该空间取决于递归的深度，
     * <p>而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，所以所需空间复杂度为O(Height) 。
     *
     * <p>作者：LeetCode-Solution
     * <p>链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }

}
