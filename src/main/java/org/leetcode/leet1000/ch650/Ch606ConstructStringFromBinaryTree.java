package org.leetcode.leet1000.ch650;

import org.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * <p> 606. 根据二叉树创建字符串
 * <p> 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * <p> 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 * <p> 示例 1:
 *
 * <p> 输入: 二叉树: [1,2,3,4]
 * <p>        1
 * <p>      /   \
 * <p>     2     3
 * <p>    /
 * <p>   4
 *
 * <p> 输出: "1(2(4))(3)"
 *
 * <p> 解释: 原本将是“1(2(4)())(3())”，
 * <p> 在你省略所有不必要的空括号对之后，
 * <p> 它将是“1(2(4))(3)”。
 * <p> 示例 2:
 *
 * <p> 输入: 二叉树: [1,2,3,null,4]
 * <p>        1
 * <p>      /   \
 * <p>     2     3
 * <p>      \
 * <p>       4
 *
 * <p> 输出: "1(2()(4))(3)"
 *
 * <p> 解释: 和第一个示例相似，
 * <p> 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 * <p> 通过次数22,511提交次数40,313
 * <p> 在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 *
 * @Author: shenpei
 * @Date: 2021/3/17 10:22 下午
 */
public class Ch606ConstructStringFromBinaryTree {
    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N)，其中 N 是二叉树中的节点数目。
     *
     * <p>空间复杂度：O(N)，在最坏情况下，会递归 N 层，需要 O(N) 的栈空间。
     *
     * <p>作者：LeetCode
     * <p>链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chuan-by-leetc/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }

        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：O(N)，其中 NN 是二叉树中的节点数目。
     *
     * <p>空间复杂度：O(N)，在最坏情况下，栈中会存放 NN 个节点。
     *
     * @param t
     * @return
     */
    public String tree2str2(TreeNode t) {
        if (t == null)
            return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }
}
