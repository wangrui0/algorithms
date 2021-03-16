package org.leetcode.shunxu.ch550;

import org.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p> 501. 二叉搜索树中的众数
 *
 * <p>给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * <p>假定 BST 有如下定义：
 *
 * <p>    结点左子树中所含结点的值小于等于当前结点的值
 * <p>   结点右子树中所含结点的值大于等于当前结点的值
 * <p>   左子树和右子树都是二叉搜索树
 *
 * <p>例如：
 * <p>给定 BST [1,null,2,2],
 *
 * <p>    1
 * <p>     \
 * <p>      2
 * <p>     /
 * <p>    2
 *
 * <p> 返回[2].
 *
 * <p>提示：如果众数超过1个，不需考虑输出顺序
 *
 * <p>进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>通过次数49,134
 * <p>提交次数98,156
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * @author: wangrui
 * @date: 2021/3/12
 */
public class Ch501FindModeInBinarySearchTree {

    List<Integer> answer = new ArrayList<Integer>();
    int base, count, maxCount;

    /**
     * <p>复杂度分析
     * <p>时间复杂度：O(n)。即遍历这棵树的复杂度。
     * <p>空间复杂度：O(n)。即递归的栈空间的空间代价。
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void dfs(TreeNode o) {
        if (o == null) {
            return;
        }
        dfs(o.left);
        update(o.val);
        dfs(o.right);
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

    //=====中序遍历=======
    public void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.val);
        inOrderTraversal(node.right);
    }

    List<Integer> mList2 = new ArrayList<>();
    int curent2 = 0;//表示当前节点的值
    int count2 = 0;//表示当前节点的数量
    int maxCount2 = 0;//最大的重复数量

    public int[] findMode2(TreeNode root) {
        inOrderTraversal2(root);
        int[] res = new int[mList2.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList2.size(); i++) {
            res[i] = mList2.get(i);
        }
        return res;
    }

    //递归方式
    public void inOrderTraversal2(TreeNode node) {
        //终止条件判断
        if (node == null)
            return;
        //遍历左子树
        inOrderTraversal(node.left);

        //下面是对当前节点的一些逻辑操作
        int nodeValue = node.val;
        if (nodeValue == curent2) {
            //如果节点值等于curent，count就加1
            count2++;
        } else {
            //否则，就表示遇到了一个新的值，curent和count都要
            //重新赋值
            curent2 = nodeValue;
            count2 = 1;
        }
        if (count2 == maxCount2) {
            //如果count == maxCount，就把当前节点加入到集合中
            mList2.add(nodeValue);
        } else if (count2 > maxCount2) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后
            //把当前节点的值加入到集合中
            mList2.clear();
            mList2.add(nodeValue);
            maxCount2 = count2;
        }

        //遍历右子树
        inOrderTraversal2(node.right);
    }
    //======中序遍历非递归======
    public void inOrderTraversal3(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                System.out.println(tree.val);
                tree = tree.right;
            }
        }
    }

    List<Integer> mList4 = new ArrayList<>();
    int curent4 = 0;
    int count4 = 0;
    int maxCount4 = 0;

    public int[] findMode4(TreeNode root) {
        inOrderTraversal4(root);
        int[] res = new int[mList4.size()];
        //把集合list转化为数组
        for (int i = 0; i < mList4.size(); i++) {
            res[i] = mList4.get(i);
        }
        return res;
    }

    //非递归方式
    public void inOrderTraversal4(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        while (tree != null || !stack.isEmpty()) {
            while (tree != null) {
                stack.push(tree);
                tree = tree.left;
            }
            if (!stack.isEmpty()) {
                tree = stack.pop();
                int nodeValue = tree.val;
                if (nodeValue == curent4) {
                    //如果节点值等于curent，count就加1
                    count4++;
                } else {
                    //否则，就表示遇到了一个新的值，curent和count都要
                    //重新赋值
                    curent4 = nodeValue;
                    count4 = 1;
                }
                if (count4 == maxCount4) {
                    //如果count == maxCount，就把当前节点加入到集合中
                    mList4.add(nodeValue);
                } else if (count4 > maxCount4) {
                    //否则，当前节点的值重复量是最多的，直接把list清空，然后
                    //把当前节点的值加入到集合中
                    mList4.clear();
                    mList4.add(nodeValue);
                    maxCount4 = count4;
                }
                tree = tree.right;
            }
        }
    }
}