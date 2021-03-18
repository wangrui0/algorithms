package org.leetcode.shunxu.ch650;

import org.TreeNode;

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
    public String tree2str(TreeNode t) {
        return null;
    }
}
