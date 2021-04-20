package org.leetcode.shunxu.leet1000.ch600;

import org.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * <p>590. N 叉树的后序遍历
 *
 * <p>给定一个 N 叉树，返回其节点值的 后序遍历 。
 *
 * <p>N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 *
 * <p>进阶：
 *
 * <p>递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：root = [1,null,3,2,4,null,5,6]
 * <p>输出：[5,6,3,2,4,1]
 *
 * <p>示例 2：
 *
 * <p>输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * <p>输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *
 *
 *
 * <p>提示：
 *
 * <p>    N 叉树的高度小于或等于 1000
 * <p>    节点总数在范围 [0, 10^4] 内
 *
 * <p>通过次数49,268
 * <p>提交次数65,271
 * <p>@author: wangrui
 * <p>@date: 2021/3/17
 * <p>https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class Ch590NAryTreePostorderTraversal {

    List<Integer> list = new ArrayList<>();

    /**
     * <p>递归的方式：
     * <p>复杂度分析
     * <p>时间复杂度：O(N)
     * <p>空间复杂度：O(N)
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        dfs(root);
        return list;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            dfs(node);
        }
        list.add(root.val);
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> output = new LinkedList<>();

        if (root == null) {
            return output;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            output.addFirst(pop.val);
            if (pop.children == null) {
                continue;
            }
            List<Node> children = pop.children;
            for (int i = 0; i < children.size(); i++) {
                stack.add(children.get(i));
            }
        }
        return output;
    }

    /**
     * <p>复杂度分析
     *
     * <p>时间复杂度：时间复杂度：O(M)，其中 M 是 N 叉树中的节点个数。每个节点只会入栈和出栈各一次。
     *
     * <p>空间复杂度：O(M)。在最坏的情况下，这棵 N 叉树只有 2 层，所有第 2 层的节点都是根节点的孩子。将根节点推出栈后，需要将这些节点都放入栈，
     * <p>共有 M−1 个节点，因此栈的大小为 O(M)。
     *
     * <p>作者：LeetCode
     * <p> 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/solution/ncha-shu-de-hou-xu-bian-li-by-leetcode/
     * <p>来源：力扣（LeetCode）
     * <p>著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public List<Integer> postorder3(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }
}
