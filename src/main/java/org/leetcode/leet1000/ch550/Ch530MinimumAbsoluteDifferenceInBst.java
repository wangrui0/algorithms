package org.leetcode.leet1000.ch550;

import org.TreeNode;

/**
 * <p>530. 二叉搜索树的最小绝对差(中序遍历为非递减的)
 * <p>给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * <p>示例：
 *
 * <p>输入：
 *
 * <p>  1
 * <p>    \
 * <p>    3
 * <p>   /
 * <p>  2
 *
 * <p>输出：
 * <p>1
 *
 * <p>解释：
 * <p> 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 *
 * <p>提示：
 *
 * <p>树中至少有 2 个节点。
 * <p>本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 * <p>通过次数57,925提交次数94,941
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 贡献者
 * @Author: shenpei
 * @Date: 2021/3/15 8:19 下午
 */
public class Ch530MinimumAbsoluteDifferenceInBst {
    int pre;
    int ans;

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(n)，其中 n 为二叉搜索树节点的个数。每个节点在中序遍历中都会被访问一次且只会被访问一次，因此总时间复杂度为 O(n)。
     *
     * <p>空间复杂度：O(n)。递归函数的空间复杂度取决于递归的栈深度，而栈深度在二叉搜索树为一条链的情况下会达到 O(n) 级别。
     *
     * <p>作者：LeetCode-Solution
     * <p>链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/solution/er-cha-sou-suo-shu-de-zui-xiao-jue-dui-chai-by-lee/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
